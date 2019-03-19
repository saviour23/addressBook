Steps to Build and Run:-

1) Build the application with command "mvn clean install"
2) addressbook-0.0.1-SNAPSHOT.jar will be created in target folder
3) run the jar file with following command "java -jar addressbook-0.0.1-SNAPSHOT.jar"
4) Spring Boot application is launched with  test data pre populated.
5) Application Persist All records in file "AddressBook.ser"

TestData:-

1) Two Address books are preloaded 
	a) Friends (6 records)
	c) Office  (5 records)
2) Each address book has few contacts including 3 common contacts.



API's :-

1) To retrieve all contacts for specific AddressBook in sorted order, sorted by FullName.

	GET   http://localhost:8080/addressbook/Friends

	GET   http://localhost:8080/addressbook/Office

2) To Retrieve All Unique Contacts in all AddressBooks.

	GET http://localhost:8080/addressbook/all

3) To Add Contacts

	POST http://localhost:8080/addressbook/all
	Payload:-
		{
		    "name": {
		      "firstName": "Neeraj10",
		      "lastName": "Negi"
		    },
		    "telephone": [
		      {
		        "mobileNumber": "0123456789"
		      },
		      {
		        "mobileNumber": "3456723456"
		      }
		    ]
		  }

