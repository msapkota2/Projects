	//Preprocessor directives
#include <iostream> //Required for console I/O
#include <fstream>   //Required for file for input and output
#include<iomanip>   //Required for formating output 
#include <string>	//Required for declaring the variables in string
#include <string.h>	//Required for old functions like strcpy

using namespace std;
	//declare class
class StudentClass
{
	// Access Specifier
public:
	StudentClass();	//Default Constructor
	void prefix(string,int,string,int);	//add course description
	void grade(string,float);	//add gradings info
	void semesterCode(string,int,string);	//add semesters info
	void newStudent(string,string,string);	//add students info
	void completedCourse(string, string, string, int, string, string);	//add completed courses info
	void coursesList(string,int,string,int);	//list total courses
	void gradeList(string,float);	//list gradings 
	void semList(string,int,string);	//list semesters
	void StudentList(string,string,string);	//list students
	void allCourses(string, string, string, int, string, string);	//list all completed courses
	void transcript();	//print transcript
	void sort(StudentClass [], int, string); //sorting
private:
	string coursePrefix;
	int courseNumber;
	string courseTitle;
	int creditHrs;
	string gradeType;
	float gradePoint;
	string semCode;
	int yearNumber;
	string semDesc;
	string lName;
	string fName;
	string phoneNumber;
};
//*****************************************************************************************************
StudentClass::StudentClass()
{
		// Given:    the objects used
		// TASK:     to set the starting values as 0
		// RETURNS:  the value 0
	int creditHrs = 0;
	int courseNumber = 0;
	float gradePoint = 0;
	int yearNumber = 0;
}
//*********************************Main Function*******************************************************
int main()
{
		//declare required variables
	string coursePrefix;
	int courseNumber=0;
	string courseTitle;
	int creditHrs=0;
	string gradeType;
	float gradePoint=0;
	string semCode;
	int yearNumber=0;
	string semDesc;
	string lName;
	string fName;
	string phoneNumber;
		//declare commands
	string command1;
	string command2;
		//create objects
	StudentClass info;
	StudentClass printInfo;
	StudentClass stud[200];
		//call the data files
	ifstream infile1("studentPrefix.txt");
	ifstream infile2("studentGrade.txt");
	ifstream infile3("studentSem.txt");
	ifstream infile4("studentList.txt");
	ifstream infile5("studentCom.txt");
	cout << "Enter 'a' for add, 'l' for list,'t' for printing transcript, and"
		 <<" 'q' for quit!!" << endl;

	cout << ">>>";
		//get input
	cin >> command1;
		//if else for input and output of the program
	if (command1 == "a")
	{	
			//input the command 2
		cin >> command2;
		if (command2 == "c")
				//call prefix function to add
			info.prefix(coursePrefix, courseNumber, courseTitle, creditHrs);
		else if (command2 == "g")
				//call grade function to add
			info.grade(gradeType, gradePoint);
		else if (command2 == "m")
				//call semester function info to add
			info.semesterCode(semCode, yearNumber, semDesc);
		else if (command2 == "s")
				//call student function to add
			info.newStudent(lName, fName, phoneNumber);
		else if (command2 == "t")
				//call completed courses to add
			info.completedCourse(lName, fName, coursePrefix, courseNumber, gradeType, semCode);
		else
		{
			//warining for entering other letters than command2
			cout << "To add, enter letter 'c' for adding course description, 'g' for grade" << endl <<
				"'m' for semester, 's' for new student, 't' for completion of the course." << endl<<endl;
			main();
		}

	}

	else if (command1 == "l")
	{
		//input the command 2
		cin >> command2;
		if (command2 == "c")
				//list the courses info
			info.coursesList(coursePrefix, courseNumber, courseTitle, creditHrs);
		else if (command2 == "g")
				//list gradings info
			info.gradeList(gradeType, gradePoint);
		else if (command2 == "m")
				//list semesters info
			info.semList(semCode, yearNumber, semDesc);
		else if (command2 == "s")
				//list students info
			info.StudentList(lName, fName, phoneNumber);
		else if (command2 == "t")
				//list all courses info
			info.allCourses(lName, fName, coursePrefix, courseNumber, gradeType, semCode);

	}
	else if (command1 == "t")
	{
		for (int i = 0; i < 100; i++) //sort the records then print
			printInfo.sort(stud,yearNumber,semCode);
			//print the transcript of the student
			printInfo.transcript();

	}
		//exit the program
	else if (command1=="q")
		cout<<"Program Closed!"<<endl;
	return 0;
}
//*****************************************************************************************************
void StudentClass::prefix(string coursePrefix,int courseNumber,string courseTitle,int creditHrs)
{
		// Recieves: call from the object    
		// TASK:     to add the courses information
		// RETURNS:  return courses info

		//infile and outfile the data
	ifstream infile1("studentPrefix.txt", ios::in);
	ofstream outfile1("studentPrefix.txt", ios::app);
	cin >> coursePrefix;
	cin >> courseNumber;
	cin >> courseTitle;
	cin >> creditHrs;
	outfile1 << coursePrefix << " " << courseNumber << " " << courseTitle << " " << creditHrs << endl;
	infile1.close();
		//return to main function
	main();
}
//*****************************************************************************************************
void StudentClass::grade(string gradeType,float gradePoint)
{
		// Recieves: call from the object    
		// TASK:     to add the gradings information
		// RETURNS:  return gradings info

		//infile and outfile the data
	ifstream infile2("studentGrade.txt", ios::in);
	ofstream outfile2("studentGrade.txt", ios::app);
	cin >> gradeType;
	cin >> gradePoint;
	outfile2 << gradeType << " " << gradePoint << endl;
	infile2.close();
		//return to main function
	main();
}
//*****************************************************************************************************
void StudentClass::semesterCode(string semCode,int yearNumber,string semDesc)
{
		// Recieves: call from the object    
		// TASK:     to add the semesters information
		// RETURNS:  return semesters info

		//infile and outfile the data
	ifstream infile3("studentSem.txt", ios::in);
	ofstream outfile3("studentSem.txt", ios::app);
	cin >> semCode;
	cin >> yearNumber;
	cin >> semDesc;
	outfile3 << semCode << " " << yearNumber << " " << semDesc << endl;
	infile3.close();
		//return to main function
	main();
}

void StudentClass::newStudent(string lName,string fName,string phoneNumber)
{
		// Recieves: call from the object    
		// TASK:     to add the students information
		// RETURNS:  return students info

		//infile and outfile the data
	ifstream infile4("studentList.txt", ios::in);
	ofstream outfile4("studentList.txt", ios::app);
	cin >>lName;
	cin >> fName;
	cin >> phoneNumber;
	outfile4 << lName << " " << fName << " " << phoneNumber << endl;
	infile4.close();
		//return to main function
	main();
}
//*****************************************************************************************************
void StudentClass::completedCourse(string lName,string fName,string coursePrefix,int courseNumber,
									string gradeType,string semCode)
{
		// Recieves: call from the object    
		// TASK:     to add the completedcourses information
		// RETURNS:  return completed_courses info

		//infile and outfile the data
	ifstream infile5("studentCom.txt", ios::in);
	ofstream outfile5("studentCom.txt", ios::app);
	cin >> lName;
	cin >> fName;
	cin >> coursePrefix;
	cin >> courseNumber;
	cin >> gradeType;
	cin >> semCode;
	outfile5 << lName << " " << fName << " " << coursePrefix<<" "<<courseNumber<<" "<<gradeType
			 <<" "<<semCode<<endl;
	infile5.close();
	//return to main function
	main();
}
//*****************************************************************************************************
void StudentClass::coursesList(string coursePrefix,int courseNumber,string courseTitle,int creditHrs)
{
		// Recieves: call from the object    
		// TASK:     to list the courses information
		// RETURNS:  return list of courses

		//fetch the data
	ifstream infile1("studentPrefix.txt",ios::in);
	while (infile1 >> coursePrefix >> courseNumber >> courseTitle >> creditHrs)
	{
		cout << coursePrefix << " " << courseNumber << " " << courseTitle << " " << creditHrs<<endl;
	}
	infile1.close();
		//return to main function
	main();
}
//*****************************************************************************************************
void StudentClass::gradeList(string gradeType,float gradePoint)
{
		// Recieves: call from the object    
		// TASK:     to list the gradings information
		// RETURNS:  return list of gradings

		//fetch the data
	ifstream infile2("studentGrade.txt", ios::in);
	while (infile2>> gradeType >> gradePoint)
	{
		cout << gradeType << " " << gradePoint<<endl;
	}
	infile2.close();
	//return to main function
	main();

}
//*****************************************************************************************************
void StudentClass::semList(string semCode,int yearNumber,string semDesc)
{
		// Recieves: call from the object    
		// TASK:     to list the semester information
		// RETURNS:  return semester info

		//fetch the data from the file
	ifstream infile3("studentSem.txt");
	while (infile3 >> semCode>>yearNumber>>semDesc)
		cout << semCode << " " << yearNumber << " " << semDesc << endl;
	infile3.close();
		//return to main function
	main();
}
//*****************************************************************************************************
void StudentClass::StudentList(string lName,string fName,string phoneNumber)
{
		// Recieves: call from the object    
		// TASK:     to list the student information
		// RETURNS:  return student info
		
		//fetch the data from the file
	ifstream infile4("studentList.txt");
	while (infile4 >> lName>>fName>>phoneNumber)
	{
		cout << lName << " " << fName << " " << phoneNumber << endl;
	}
	infile4.close();
		//return to main function
	main();
}
//*****************************************************************************************************
void StudentClass::allCourses(string lName, string fName,string coursePrefix, int courseNumber,
							  string gradeType,string semCode)
{
		// Recieves: call from the object    
		// TASK:     to add the completed courses information
		// RETURNS:  return completed courses info

		//fetch the data from the saved file
	ifstream infile5("studentCom.txt");
	while (infile5 >> lName>> fName>>coursePrefix>>courseNumber>>gradeType>>semCode)
	{
		cout << lName << " " << fName << " " << coursePrefix << " " << courseNumber << " " << gradeType 
			 <<" "<< semCode <<endl;
	}
	infile5.close();
		//return to main function
	main();
}
//*****************************************************************************************************
void StudentClass::transcript()
{
		// Recieves: call from the object    
		// TASK:     to print the student transcript
		// RETURNS:  return the transcript of the requested student

		//fetch all the input data
	ifstream infile1("studentPrefix.txt");
	ifstream infile2("studentGrade.txt");
	ifstream infile3("studentSem.txt");
	ifstream infile4("studentList.txt");
	ifstream infile5("studentCom.txt");

	string lastname;
	string firstname;

	float gpaTotal = 0;
	float creditTotal = 0;
	int gradePointTotal = 0;
		//declare strings to compare from other files
	string coursePrefixFin;
	string gradeTypeFin;
	string semCodeFin;
		//get the last and first name of the student
	cin >> lastname >> firstname;
		//loop starts
	while (infile5 >> lName >> fName >> coursePrefixFin >> courseNumber >> gradeTypeFin >> semCodeFin)
	{
			//infile3 for pulling semester info
		infile3 >> semCode >> yearNumber >> semDesc;
			//reset the total Grade
		float totalGrade = 0;
			//compare the last and first name of the student from the input data
		if (lastname.compare(lName) == 0 && firstname.compare(fName) == 0)
		{
			if (semCodeFin.compare(semCode) == 0)
			{
				cout << "=================== Semester:" << semDesc << " " << yearNumber
					<< "===================" << endl;
			}
				//infile1 for pulling courses information
			infile1 >> coursePrefix >> courseNumber >> courseTitle >> creditHrs;
				//total credits
			creditTotal += creditHrs;
			if (gradeTypeFin == "A") totalGrade = 4 * creditHrs;
			else if (gradeTypeFin == "B") totalGrade = creditHrs * 3;
			else if (gradeTypeFin == "C") totalGrade = creditHrs * 2;
			else if (gradeTypeFin == "D") totalGrade = creditHrs * 1;
			else if (gradeTypeFin == "F") totalGrade = creditHrs * 0;
			else if (gradeTypeFin == "B+") totalGrade = creditHrs * 3.5;
				//output the course info
			cout << coursePrefixFin << courseNumber << "    " << courseTitle
				<< "(" << creditHrs << ")" << " " << gradeTypeFin << endl;
		}
		gradePointTotal += totalGrade;
	}
		gpaTotal = (gradePointTotal) / creditTotal;
		if (creditTotal == 0)
		{
			cout << "The Student is not matched with the information from the data files."
				 <<endl<<endl;
		}
		else
		{
			cout << "	STUDENT HOURS COMPLETED: " << creditTotal << endl;
			cout << "	STUDENT GPA: " << gpaTotal << endl << endl;
		}
		//return to main function
	main();
}
//*****************************************************************************************************
void StudentClass::sort(StudentClass list[], int yearNumber, string semCode)
{
		// Receives – semester year  
		// Task -  to sort the records in ascending order of their year number 
		//Returns- sorted records
	for (int M = 0; M < yearNumber; M++)
	{
		for (int N = M + 1; N < yearNumber; N++)
		{
			if (list[N].yearNumber < list[M].yearNumber)
			{
				swap(list[M], list[N]);
			}
		}
	}
}
//***************************The END*******************************************************************
