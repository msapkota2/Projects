//************************************  PROGRAM IDENTIFICATION  ***************************************
//*                                                                                                   *
//*   PROGRAM FILE NAME:  prog3.cpp          ASSIGNMENT #:  3            Grade: _________             *
//*                                                                                                   *
//*   PROGRAM AUTHOR:                                                                                 *
//*                   ___________________________________________________                             *
//*                                     Milan Sapkota                                                 *
//*                                                                                                   *
//*   COURSE #:  CSC 36000 11                              DUE DATE: March 17, 2020                   *
//*                                                                                                   *
//*****************************************************************************************************

//***********************************  PROGRAM DESCRIPTION  *******************************************
//*                                                                                                   *
//*   PROCESS: This program is designed to employ queues to simulate customer processing at a         *
//*            supermarktet. The data consists of arrival time, customer's full name, and processing  *
//*            time. Each customer arrives at the three checkout areas at the appointed time. If a    *
//*            queue is empty, the customer is placed in the queue with the shortest total processing *
//*            time for all customers, and in case if its a tie, lowest numeric value for the queue is*
//*            selected. No processing is done until the customer is at the head of the queue. Once   *
//*            a customer processing time is zero, the customer leaves the queue i.e. removing the    *
//*            customer from the queue. It is then to print the list of customers in order as they    *
//*            entered the queues and another list in order as their processed time.                  *
//*                                                                                                   *
//*   USER DEFINED                                                                                    *
//*    MODULES     : Header – prints the header information in the output file						  *
//*                  IsEmpty - returns true if the queue is empty	                                  *
//*                  IsFull - returns true if the queue is full										  *
//*					 First - returns the first node                                                   *
//*                  Last - returns the last node				                                      *
//*                  QueueCount - returns the number of elements in the queue                         *
//*                  QueueWait - retuns the waiting time											  *
//*					 Add - adds a customer node														  *
//*					 Delete - deletes a customer node												  *
//*					 increaseWait - increases the waiting time										  *
//*					 decreaseWait - decreases the waiting time                                        *
//*                  Footer- prints the footer information in the output file                         *
//*****************************************************************************************************
	//Preprocessor directives
#include <fstream>
#include <iomanip>
#include <iostream>
#include <string>

using namespace std;
	//declare a structure for customer 
struct customerType 
{
	int arrivalTime;
	char name[25];      	       
	int serviceTime;    
	bool queued;            
	customerType* next;         //next customer in the queue
};
//*****************************************************************************************************
	//declare a class
class QueueClass
{	//access specifier
public:
	QueueClass();                    // customer constructor
	bool IsEmpty() {return(count==0);}
	bool IsFull();                   
	customerType* First();           
	customerType* Last();          
	int QueueCount() { return count;}
	int QueueWait() { return wait;}
	void Add(customerType, int&);    
	void Delete(customerType&, int&);
	void increaseWait(int);               
	void decreasingWait(int);              	
private:
	int count;                          
	int wait;                           
	customerType* front;                // points to the front node
	customerType* rear;                 // points to the last node 
};
//*****************************************************************************************************
QueueClass::QueueClass()	//customer constructor
{
		//initialize queue variables
	count,wait = 0;
	front,rear = NULL;
}
//*****************************************************************************************************
bool QueueClass::IsFull()
{
	//returns true if there is no more memory to expand a queue
	//otherwise returns false
	customerType* test;
	test = new (customerType);
	if (test == NULL) {
		delete test;
		cout << "Out of Memory." << endl;
		return true;
	}
	return false;
}
//*****************************************************************************************************
customerType* QueueClass::First() 
{
		//return NULL if the queue is empty
	if (IsEmpty()) 
	{
		return NULL;
	}
	else
	return front;
}
//*****************************************************************************************************
customerType* QueueClass::Last() 
{
		//return NULL if the queue is empty
	if (IsEmpty())
	{
		return NULL;
	}
	return rear;
}
//*****************************************************************************************************
void QueueClass::Add(customerType NewData, int& status)
{
	// Receives - customer data and the status
	// Task - to add the customer data to the checkout queue
	// Returns - updated queue
	status = 1;
	customerType* Newcustomer;
	Newcustomer = new (customerType);
	if (IsFull())
	{
		status = 0;
		return;
	}
	// Copy customer data to the new node
	Newcustomer->arrivalTime = NewData.arrivalTime;
	Newcustomer->serviceTime = NewData.serviceTime;
	strcpy_s(Newcustomer->name, 25, NewData.name);
	Newcustomer->next = NULL;
	if (front == NULL)
	{
		front = Newcustomer;
	}
	else {
		rear->next = Newcustomer;
	}
	//append new customer node
	rear = Newcustomer;
	count++;
	return;
}
//*****************************************************************************************************
void QueueClass::Delete(customerType& ToDelete, int& status) {

	// Receives - customer node to delete
	// Task - to delete the customer from the list
	// Returns - updated queue
	status = 1;
	customerType* temp;
	if (IsEmpty())
	{
		status = 0;
		return;
	}
	ToDelete.arrivalTime = front->arrivalTime;
	ToDelete.serviceTime = front->serviceTime;
	strcpy_s(ToDelete.name, 26, front->name);
	//delete first node from the queue
	temp = front;
	front = front->next;
	delete temp;
	count--;
	return;
}
//*****************************************************************************************************
void QueueClass::increaseWait(int increment)
{
	// Receives - increment value
	// Task - increase the queue wait time by the given value
	// Returns - updated time
	wait = (wait + increment);
}
//*****************************************************************************************************
void QueueClass::decreasingWait(int decrement)
{
	// Receives - decrement value
	// Task - decrease the queue wait time by the given value
	// Returns - updated time
	wait = (wait - decrement);
}
//******************************* END OF THE QUEUE CLASS **********************************************
	//Function prototypes
void Header(ofstream&);
void Footer(ofstream&);
void listCustomers(ifstream&, QueueClass&, int);
void printList(ofstream&, QueueClass, QueueClass);
//*****************************************************************************************************
void listCustomers(ifstream& inputFile, QueueClass& queue, int status)
{
	// Receives - respected queue and the status
	// Task - to load the data from the file
	// Returns - updated queue
	int arrivTime, proccTime;
	char customerName[26];
	customerType newcustomer;
	for (inputFile >> arrivTime; arrivTime != -99; inputFile >> arrivTime)
	{
		// read the data
		inputFile >> ws;
		inputFile.get(customerName, 26);
		inputFile >> proccTime;
		strcpy_s(newcustomer.name, 26, customerName);
		newcustomer.arrivalTime = arrivTime;
		newcustomer.serviceTime = proccTime;
		newcustomer.queued = false;
		queue.Add(newcustomer, status);
	}
}
//*****************************************************************************************************
void printList(ofstream& outfile, QueueClass arrivals, QueueClass departures)
{
	// Receives - arrivals and departures queues
	// Task - to print the lists side by side
	// Returns - outfile of the lists
	outfile << "The order of customer arrival is:      The order of customer departure is:";
	outfile << endl;
	outfile << "================================        ===================================";
	outfile << endl;
	int status = 1;
	int numRecords;
	customerType customer;
	numRecords = arrivals.QueueCount();
	for (int i = 0; i < numRecords; i++)
	{
		//customer from list 1
		arrivals.Delete(customer, status);
		outfile << customer.name;
		outfile << "               |     ";
		// customer on list 2
		departures.Delete(customer, status);
		outfile << customer.name;
		outfile << endl;
	}
	return;
}
//************************************* MAIN **********************************************************
int main()
{
		//initialized required variables
	int status = 1;        //status indicator
	int currentTime = 0;   //beginning time    
	customerType currentcustomer;                          
	customerType departingcustomer;                        
	QueueClass arrivalList;                          
	QueueClass departureList; 
		//Queue lines
	QueueClass line1;                                
	QueueClass line2;                                
	QueueClass line3;   
		//array of checkout lines
	QueueClass checkout[3] = { line1, line2, line3 };  
	int shortest;                                      
	ifstream inputFile("data3.txt");
	ofstream outfile("output.txt");
		// load customer data from the input file
	listCustomers(inputFile, arrivalList, status);
	while (departureList.QueueCount() < arrivalList.QueueCount()) 
	{
		if (arrivalList.First()->arrivalTime == currentTime)
		{
			arrivalList.Delete(currentcustomer, status);
			shortest = 0;                   
			for (int i = 0; i < 3; i++) 
			{		//compare all checkout lines waiting time
				if (checkout[i].QueueWait() < checkout[shortest].QueueWait())
				{
					shortest = i;
				}
			} 
			currentcustomer.queued = true;
				//add customer to shortest checkout line
			checkout[shortest].Add(currentcustomer, status);
				//increment waiting time
			checkout[shortest].increaseWait(currentcustomer.serviceTime);
			arrivalList.Add(currentcustomer, status);
		} 
			// update queues
		for (int i = 0; i < 3; i++) 
		{
			if (!checkout[i].IsEmpty()) 
			{
				if (checkout[i].First()->serviceTime <= 0)
				{
					checkout[i].Delete(departingcustomer, status);
					departureList.Add(departingcustomer, status);
				}
			}
				//update time
			if (!checkout[i].IsEmpty())
			{
				checkout[i].First()->serviceTime--;
				checkout[i].decreasingWait(1);
			}
		} 
		currentTime++;
	}
		//Print header
	Header(outfile);
		//print final output
	printList(outfile, arrivalList, departureList);
	outfile << endl;
		//print footer
	Footer(outfile);
	return 0;
}
//******************************** END OF THE MAIN ****************************************************
//*************************************  FUNCTION HEADER  *********************************************
void Header(ofstream& outfile)
{
	// Receives – the output file
	// Task - Prints the output preamble
	// Returns - Nothing
	outfile << setw(35) << "Milan Sapkota";
	outfile << setw(22) << "CSC 36000";
	outfile << setw(20) << "Section 11" << endl;
	outfile << setw(35) << "Spring 2020";
	outfile << setw(25) << "Assignment #3" << endl;
	outfile << setw(40) << "------------------------------------------- - ";
	outfile << setw(40) << "------------------------------------------ - " << endl << endl;
	return;
}
//*************************************  FUNCTION FOOTER  **********************************************
void Footer(ofstream& outfile)
{
	// Receives – the output file
	// Task - Prints the output salutation
	// Returns - Nothing   outfile << endl;
	outfile << setw(35) << "-------------------------------- - " << endl;
	outfile << setw(35) << " | END OF PROGRAM OUTPUT | " << endl;
	outfile << setw(35) << "-------------------------------- - " << endl;
	return;
}
//*************************************  END OF FUNCTION FOOTER  ***************************************
