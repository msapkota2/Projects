/*
	Name: Milan Sapkota
	Project 2: principle of database
	Info: A program that connects and interacts with a MYSQL database

*/
	//preprocessor directives
#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
#include <iomanip>
#include <my_global.h>
#include <mysql.h>

#include <conio.h>

using namespace std;
	//sql connection and mysql
MYSQL* conn;
MYSQL mysql;
// reads in a password without echoing it to the screen
string myget_passwd()
{
	string passwd;

	for (;;)
	{
		char ch = 0;
		while (ch == 0)   // Ugh. Microsoft not following standards on getch, so need to keep reading until a new char is typed. 
			ch = _getch();           // get char WITHIOUT echo! (should really be getch(), but MS is not following standrads again.)
		if (ch == 13 || ch == 10) // if done ...
			break;           //  stop reading chars!
		cout << '*';  // dump * to screen
		passwd += ch;   // addd char to password
	}
	cin.sync(); // flush anything else in the buffer (remaining newline)
	cout << endl;  // simulate the enter that the user pressed

	return passwd;
}
//prototypes
void prefix(string, int, string, int, MYSQL*, MYSQL);	//add course description
void grade(string, string, MYSQL*, MYSQL);	//add gradings info
void semesterCode(string, int, string, MYSQL*, MYSQL);	//add semesters info
void newStudent(string, string, string, MYSQL*, MYSQL);	//add students info
void completedCourse(string, string, string, int, string, string, MYSQL*, MYSQL);	//add completed courses info
void coursesList(string, int, string, int, MYSQL*, MYSQL);	//list total courses
void gradeList(string, string, MYSQL*, MYSQL);	//list gradings 
void semList(string, int, string , MYSQL*, MYSQL);	//list semesters
void StudentList(string, string, string, MYSQL*, MYSQL);	//list students
void allCourses(string, string, string, int, string, string, MYSQL*, MYSQL);	//list all completed courses
void transcript(MYSQL*, MYSQL);	//print transcript
void function(MYSQL*, MYSQL);	//all the reuired command function 
void deleteinfo(MYSQL*, MYSQL);	//delete info 
//***************************Main Function*******************************************************************
int main()
{
	// mysql connection and query variables
	MYSQL *conn, // actual mysql connection
		mysql;   // local mysql data
	MYSQL_RES *res; // mysql query results
	MYSQL_ROW row;  // one row of a table (result)

	// strings for mysql hostname, userid, ...
	string db_host;
	string db_user;
	string db_password;
	string db_name;
	string myQuery;
	// set up the client (this machine) to use mysql
	cout << "initializing client DB subsystem ..."; cout.flush();
	mysql_init(&mysql);
	cout << "Done!" << endl;

	// get user credentials and mysql server info
	cout << "Enter MySQL database hostname (or IP adress):";
	cin >> db_host;

	cout << "Enter MySQL database username:";
	cin >> db_user;

	cout << "Enter MySQL database password:";
	db_password=myget_passwd();

	// could also prompt for this, if desired
	db_name=db_user;

	int db_port;
	cout << "Enter database port number:";
	cin >> db_port;

	// go out and connect to the mysql server
	cout << "Connecting to remote DB ..."; cout.flush();
	conn = mysql_real_connect(&mysql, 
		                    db_host.c_str(), db_user.c_str(), db_password.c_str(), db_user.c_str(),
				             db_port,0,0); // last three are usually 0's

	// if we couldn't setup the connection ...
	if (conn==NULL)
	{
		// print out the error message as to why ...
		cout << mysql_error(&mysql) << endl;
		return 1; // ... and exit the program. 
	}
	else
		cout << "DB connection established" << endl;

	cout << "\n				Welcome to the Database of Students!\n\n";
	// now, send mysql our query ...
	int status;
	//create tables;
		//Prefix Table
	myQuery = "create table if not exists prefixTab";
	myQuery += "(coursePrefix varchar(3),courseNumber int,courseTitle varchar(30),creditHrs int,";
	myQuery += "primary key (courseNumber) )";
	status = mysql_query(conn, myQuery.c_str());
	if (status != 0) {
		cout << mysql_error(&mysql) << endl;
		return 1;
	}
		//Grade Table
	myQuery = "create table if not exists gradeTab";
	myQuery += "(gradeType varchar(2),gradePoint decimal,";
	myQuery += "primary key (gradeType) )";
	status = mysql_query(conn, myQuery.c_str());
	if (status != 0) {
		cout << mysql_error(&mysql) << endl;
		return 1;
	}
		//Semester Code Table
	myQuery = "create table if not exists semCodeTab";
	myQuery += "(semCode varchar(4), yearNumber int, semDesc varchar(6),";
	myQuery += "primary key (semCode) )";
	status = mysql_query(conn, myQuery.c_str());
	if (status != 0) {
		cout << mysql_error(&mysql) << endl;
		return 1;
	}
		//new Student Table
	myQuery = "create table if not exists newStudentTab";
	myQuery += "(lname varchar(20), fname varchar(20), phoneNumber varchar(15),";
	myQuery += "primary key (lname,fname) )";
	status = mysql_query(conn, myQuery.c_str());
	if (status != 0) {
		cout << mysql_error(&mysql) << endl;
		return 1;
	}
		//completed Course Table
	myQuery = "create table if not exists completedCourseTab";
	myQuery += "(lname varchar(20), fname varchar(20),coursePrefix varchar(3),courseNumber int, gradeType varchar(2), semCode varchar(4))";
	//myQuery += "primary key (lname,fname) )";
	status = mysql_query(conn, myQuery.c_str());
	if (status != 0) {
		cout << mysql_error(&mysql) << endl;
		return 1;
	}
		//call functions
	function(conn, mysql);
	// get the query result(s)
	res = mysql_store_result(conn);

	// go through each line (row) of the answer table
	for(row=mysql_fetch_row(res);
		row!=NULL;
		row=mysql_fetch_row(res))
	{
		// print out the first 2 colums; they are stored in
		//    an "array-like" manner
		cout << row[0] << "  " << row[1] << endl;
	}

	// clean up the query
	mysql_free_result(res);
	// clean up the connection

	mysql_close(conn);

	return 0;
}
//******************************END OF MAIN FUNCTION*********************************************************
void function(MYSQL* conn, MYSQL mysql)
{
	//declare required variables
	string coursePrefix;
	int courseNumber = 0;
	string courseTitle;
	int creditHrs = 0;
	string gradeType;
	string gradePoint;
	string semCode;
	int yearNumber = 0;
	string semDesc;
	string lName;
	string fName;
	string phoneNumber;
	//int status;
	//declare commands
	string command1;
	string command2;
	cout << "\nEnter 'a' for add, 'l' for list,'t' for printing transcript,'d' for deleting, and"
		<< " 'q' for quit!!" << endl << endl;

	cout << ">>>";
	//get input
	cin >> command1;
	//if else for input and output of the program
	if (command1 == "a")
	{
		//input the command 2
		cin >> command2;
		if (command2 == "c")
		{
			cin >> coursePrefix;
			cin >> courseNumber;
			cin >> courseTitle;
			cin >> creditHrs;
			//call prefix function to add
			prefix(coursePrefix, courseNumber, courseTitle, creditHrs,conn,mysql);
		}
		else if (command2 == "g")
		{
			cin >> gradeType;
			cin >> gradePoint;
			//call grade function to add
			grade(gradeType, gradePoint, conn, mysql);


		}
		else if (command2 == "m")
		{
			cin >> semCode;
			cin >> yearNumber;
			cin >> semDesc;

			//call semester function info to add
			semesterCode(semCode, yearNumber, semDesc,conn,mysql);
		}
		else if (command2 == "s")
		{
			cin >> lName;
			cin >> fName;
			cin >> phoneNumber;
			//call student function to add
			newStudent(lName, fName, phoneNumber,conn,mysql);
		}
		else if (command2 == "t")
		{	
			cin >> lName;
			cin >> fName;
			cin >> coursePrefix;
			cin >> courseNumber;
			cin >> gradeType;
			cin >> semCode;
			//call completed courses to add
			completedCourse(lName, fName, coursePrefix, courseNumber, gradeType, semCode,conn,mysql);
		}
		else
		{
			//warining for entering other letters than command2
			cout << "\nTo add, enter letter 'c' for adding course description, 'g' for grade" << endl <<
				"'m' for semester, 's' for new student, 't' for completion of the course." << endl << endl;
			//functions();
		}

	}

	else if (command1 == "l")
	{
		//input the command 2
		cin >> command2;
		if (command2 == "c")
		{
			//list the courses info
			coursesList(coursePrefix, courseNumber, courseTitle, creditHrs, conn, mysql);
		}
		else if (command2 == "g")
		{
			//list gradings info
			gradeList(gradeType, gradePoint,conn,mysql);
		}
		else if (command2 == "m")
		{
			//list semesters info
			semList(semCode, yearNumber, semDesc,conn,mysql);
		}
		else if (command2 == "s")
		{
			//list students info
			StudentList(lName, fName, phoneNumber,conn,mysql);
		}
		else if (command2 == "t")
		{
			//list all courses info
			allCourses(lName, fName, coursePrefix, courseNumber, gradeType, semCode,conn,mysql);
		}
	}
	else if (command1 == "d")
	{
		deleteinfo(conn, mysql);
	}
	else if (command1 == "t")
	{
		//print the transcript of the student
		transcript(conn,mysql);

	}
	//exit the program
	else if (command1 == "q")
		cout << "Program Closed!" << endl;



}
//***********************************************************************************************************
void prefix(string coursePrefix, int courseNumber, string courseTitle, int creditHrs, MYSQL* conn, MYSQL mysql)
{
	int status = 0;
	MYSQL_RES* res;
	MYSQL_ROW row;
	string myQuery2;

	myQuery2 = "select courseNumber from prefixTab";
	status = mysql_query(conn, myQuery2.c_str());
	if (status != 0)
	{
		cout << "Error while fetching\n";
		cout << mysql_error(&mysql);
	}
	res = mysql_store_result(conn);
	row = mysql_fetch_row(res);
	//mysql_free_result(res);
	if (row != NULL)
	{
		cout << "your inputs inserted";
	}

	myQuery2 = "insert into prefixTab values (";
	myQuery2 += "'" + coursePrefix + "', ";
	myQuery2 +=  to_string(courseNumber)+ ", ";
	myQuery2 += "'" + courseTitle + "', ";
	myQuery2 += to_string(creditHrs)+ ")";

	mysql_query(conn, myQuery2.c_str());
	cout << endl;
	function(conn, mysql);
}
//***********************************************************************************************************
void grade(string gradeType, string gradePoint, MYSQL* conn, MYSQL mysql)
{

	int status=0;
	MYSQL_RES* res;
	MYSQL_ROW row;
	string myQuery2;
	
	myQuery2 = "select gradeType from gradeTab";
	status = mysql_query(conn, myQuery2.c_str());
	if (status != 0)
	{
		cout << "Error while fetching\n";
		cout << mysql_error(&mysql);
	}
	res = mysql_store_result(conn);
	row = mysql_fetch_row(res);
	//mysql_free_result(res);
	if (row != NULL)
	{
		cout << "your inputs inserted";
	}

	myQuery2 = "insert into gradeTab values (";
	myQuery2 += "'"+gradeType+"', ";
	myQuery2+= gradePoint+")";

	mysql_query(conn, myQuery2.c_str());
	cout << endl;
	function(conn, mysql);	
}
//***********************************************************************************************************
void semesterCode(string semCode, int yearNumber, string semDesc, MYSQL* conn, MYSQL mysql)
{
	int status = 0;
	MYSQL_RES* res;
	MYSQL_ROW row;
	string myQuery3;
	myQuery3 = "select semCode from semCodeTab";
	status = mysql_query(conn, myQuery3.c_str());
	if (status != 0)
	{
		cout << "Error while fetching\n";
		cout << mysql_error(&mysql);
	}
	res = mysql_store_result(conn);
	row = mysql_fetch_row(res);
	//mysql_free_result(res);
	if (row != NULL)
	{
		cout << "your inputs inserted";
	}
		myQuery3 = "insert into semCodeTab values (";
		myQuery3 += "'" + semCode + "', ";
		myQuery3 += to_string(yearNumber) + ", ";
		myQuery3 += "'" + semDesc + "')";
		mysql_query(conn, myQuery3.c_str());
		cout << endl;
		function(conn, mysql);
	
}
//***********************************************************************************************************
void newStudent(string lName, string fName, string phoneNumber, MYSQL* conn, MYSQL mysql)
{
	int status = 0;
	MYSQL_RES* res;
	MYSQL_ROW row;
	string myQuery4;
	myQuery4 = "select lName,fName from newStudentTab";
	status = mysql_query(conn, myQuery4.c_str());
	if (status != 0)
	{
		cout << "Error while fetching\n";
		cout << mysql_error(&mysql);
	}
	res = mysql_store_result(conn);
	row = mysql_fetch_row(res);
	//mysql_free_result(res);
	if (row != NULL)
	{
		cout << "your inputs inserted";
	}
	
	myQuery4 = "insert into newStudentTab values (";
	myQuery4 += "'" + lName + "', ";
	myQuery4 += "'" + fName + "', ";
	myQuery4 += "'" + phoneNumber + "')";
	mysql_query(conn, myQuery4.c_str());
	cout << endl;
	function(conn, mysql);
	
}
//***********************************************************************************************************
void completedCourse(string lName, string fName, string coursePrefix, int courseNumber,
	string gradeType, string semCode, MYSQL* conn, MYSQL mysql)
{
	int status = 0;
	MYSQL_RES* res;
	MYSQL_ROW row;
	string myQuery5;
	myQuery5 = "select * from completedCourseTab";
	status = mysql_query(conn, myQuery5.c_str());
	if (status != 0)
	{
		cout << "Error while fetching\n";
		cout << mysql_error(&mysql);
	}
	res = mysql_store_result(conn);
	row = mysql_fetch_row(res);
	//mysql_free_result(res);
	if (row != NULL)
	{
		cout << "your inputs inserted";
	}

	myQuery5 = "insert into completedCourseTab values (";
	myQuery5 += "'" + lName + "', ";
	myQuery5 += "'" + fName + "', ";
	myQuery5 += "'" + coursePrefix + "', ";
	myQuery5 += to_string(courseNumber) + ", ";
	myQuery5 += "'" + gradeType + "', ";
	myQuery5 += "'" + semCode + "')";
	mysql_query(conn, myQuery5.c_str());
	cout << endl;
	function(conn, mysql);

}
//***********************************************************************************************************
void coursesList(string coursePrefix, int courseNumber, string courseTitle, 
	             int creditHrs, MYSQL* conn, MYSQL mysql)
{
	MYSQL_RES* res;
	MYSQL_ROW row;

	int status;
	string myQuery2 = "select * from prefixTab";

	status = mysql_query(conn, myQuery2.c_str());
	// get the query result(s)
	res = mysql_store_result(conn);
	cout << "\nCourse Prefix	Course Number	Course Title	Credit Hours \n";
	// go through each line (row) of the answer table
	for (row = mysql_fetch_row(res);
		row != NULL;
		row = mysql_fetch_row(res))
	{
		// print out the first 2 colums; they are stored in
		//    an "array-like" manner
		cout << row[0] << "		" << row[1] << "		 " << row[2] << "		  " <<row[3]<< endl;
	}

	// clean up the query
	mysql_free_result(res);

	function(conn, mysql);
}
//***********************************************************************************************************
void gradeList(string gradeType, string gradePoint, MYSQL* conn, MYSQL mysql)
{
	MYSQL_RES* res;
	MYSQL_ROW row;

	int status;
	string myQuery2 = "select * from gradeTab";
	
	status = mysql_query(conn, myQuery2.c_str());
	// get the query result(s)
	res = mysql_store_result(conn);
	cout << "\nGrade Type	Grade Point\n";
	// go through each line (row) of the answer table
	for (row = mysql_fetch_row(res);
		row != NULL;
		row = mysql_fetch_row(res))
	{
		// print out the first 2 colums; they are stored in
		//    an "array-like" manner
		cout << row[0] << "		   " << row[1] << endl;
	}

	// clean up the query
	mysql_free_result(res);

	function(conn,mysql);
}
//***********************************************************************************************************
void semList(string semCode, int yearNumber, string semDesc , MYSQL* conn, MYSQL mysql)
{

	MYSQL_RES* res;
	MYSQL_ROW row;

	int status;
	string myQuery3 = "select * from semCodeTab";

	status = mysql_query(conn, myQuery3.c_str());
	// get the query result(s)
	res = mysql_store_result(conn);
	cout << "\nSemester Code		Year Number		Semester Description\n";
	// go through each line (row) of the answer table
	for (row = mysql_fetch_row(res);
		row != NULL;
		row = mysql_fetch_row(res))
	{
		// print out the first 2 colums; they are stored in
		//    an "array-like" manner
		cout << row[0] << "			 " << row[1] << "			 " << row[2] << endl;
	}

	// clean up the query
	mysql_free_result(res);

	function(conn, mysql);
}
//***********************************************************************************************************
void StudentList(string lName, string fName, string phoneNumber, MYSQL* conn, MYSQL mysql)
{
	MYSQL_RES* res;
	MYSQL_ROW row;

	int status;
	string myQuery4 = "select * from newStudentTab";

	status = mysql_query(conn, myQuery4.c_str());
	// get the query result(s)
	res = mysql_store_result(conn);

	cout << "\nLast Name   First Name	 Phone Number\n";
	// go through each line (row) of the answer table
	for (row = mysql_fetch_row(res);
		row != NULL;
		row = mysql_fetch_row(res))
	{
		// print out the first 2 colums; they are stored in
		//    an "array-like" manner
		cout <<setw(7)<< row[0] << "     " <<setw(8)<< row[1] << "	     " << row[2] << endl;
	}

	// clean up the query
	mysql_free_result(res);

	function(conn, mysql);
}
//***********************************************************************************************************
void allCourses(string lName, string fName, string coursePrefix, int courseNumber,
	string gradeType, string semCode, MYSQL* conn, MYSQL mysql)
{
	MYSQL_RES* res;
	MYSQL_ROW row;

	int status;
	string myQuery5 = "select * from completedCourseTab";

	status = mysql_query(conn, myQuery5.c_str());
	// get the query result(s)
	res = mysql_store_result(conn);
	cout << "\nlast Name	First Name		Course Prefix	Course Number	Grade type	Semester Code\n";
	// go through each line (row) of the answer table
	for (row = mysql_fetch_row(res);
		row != NULL;
		row = mysql_fetch_row(res))
	{
		// print out the first 2 colums; they are stored in
		//    an "array-like" manner
		cout <<setw(7)<< row[0] << "		 " << setw(8) << row[1] << "		 " << setw(7) << row[2] 
			 << "	"<< row[3] << setw(7) << "		" << row[4] << endl;
	}

	// clean up the query
	mysql_free_result(res);

	function(conn, mysql);
}
//***********************************************************************************************************
void transcript(MYSQL* conn,MYSQL mysql)
{
	MYSQL_RES* res;
	MYSQL_ROW row;

	int status;
	string lastname;
	string firstname;

	float gpaTotal = 0;
	float creditTotal = 0;
	int gradePointTotal = 0;

	cin >> lastname;
	cin>> firstname;
	string myQueryx;
	myQueryx = "select * from completedCourseTab where lname ='"+lastname+"' and fname='"+firstname+"'";
	myQueryx += "And (select avg(gradePoint) from gradeTab)";
	status = mysql_query(conn, myQueryx.c_str());
	// get the query result(s)
	res = mysql_store_result(conn);

	cout << "\nTranscsript: \n";
	cout << "=============================================================\n";
	cout << setw(20) << "NAME		Courses		Grades"<<endl;
	// go through each line (row) of the answer table
	for (row = mysql_fetch_row(res);
		row != NULL;
		row = mysql_fetch_row(res))
	{
		// print out the first 2 colums; they are stored in
		//    an "array-like" manner
		cout << row[1] << "  " << row[0] << "    " << row[2] <<setw(4)<<"		" << row[4];
	}

	// clean up the query
	mysql_free_result(res);
	cout << endl;
	function(conn, mysql);
}
//***********************************************************************************************************
void deleteinfo(MYSQL* conn, MYSQL mysql)
{
	string lastname;
	string firstname;
	cin >> lastname;
	cin >> firstname;
	int status = 0;
	string myquery = "delete from newStudentTab where lname='"+lastname+"' and fname='"+firstname+"'";
	status = mysql_query(conn, myquery.c_str());
	if (status != 0)
	{
		// ... explain why ...
		cout << mysql_error(&mysql) << endl;
		status = 1;  // ... and exit programs
	}
	else
		cout << "Deleted From newstudnetTab\n";
	 myquery = "delete from completedCourseTab where lname='"+lastname+"' and fname='"+firstname+"'";
	status = mysql_query(conn, myquery.c_str());
	if (status != 0)
	{
		// ... explain why ...
		cout << mysql_error(&mysql) << endl;
		status = 1;  // ... and exit program
	}
	else
		cout << "Deleted From completedCourseTab\n";
	function(conn,mysql);
}
//***************************The END*******************************************************************