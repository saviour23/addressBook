# AddressBook


# SpringBoot Application with REST


## How to Run Application

Build the project by maven command ** mvn clean install**. This command will generte the jar file inside target folder. Copy this jar to some location and then start the application by running following command:
**java -jar addressbook-0.0.1-SNAPSHOT.jar**
Command will start the tomcat server and expose the API's on port _8080_

# Exposed API's

1.**To retrieve all contacts for specific AddressBook in sorted order, sorted by FullName.**

@GET
http://localhost:8080/addressbook/Friends

http://localhost:8080/addressbook/Office

2.**To Retrieve All Unique Contacts in all AddressBooks**

@GET

http://localhost:8080/addressbook/all

3.**To Add Contacts**

@POST

http://localhost:8080/addressbook/{addressbookname}
Payload:
```
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
```
