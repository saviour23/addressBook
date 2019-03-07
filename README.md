# AddressBook


# SpringBoot Application with REST


## How to Run Application

Build the project by maven command ** mvn clean install**. This command will generte the jar file inside target folder. Copy this jar to some location and then start the application by running following command:
**java -jar addressbook-0.0.1-SNAPSHOT.jar**
Command will start the tomcat server and expose the API's on port _8080_

# Exposed API's

1.**Add Contact**

@POST

http://localhost:8080/addressbook/contacts/addcontact

Use **payload** as below:-
```
{
        "id": "33",
        "name": "Neeraj Negi",
        "telephone": [
            {
                "mobileNumber": "12345"
            },
            {
                "mobileNumber": "123"
            }
        ]
    }
```
2.**Get Contact by ID**

@GET

http://localhost:8080/addressbook/contacts/1

3.**Get All Contacts**

@GET

http://localhost:8080/addressbook/contacts


4.**Delete Contact by ID**

@DELETE

http://localhost:8080/addressbook/contacts/1

5.**Find ALL AddressBook for Contact by Name**

@GET

http://localhost:8080/addressbook/contacts/all/1


