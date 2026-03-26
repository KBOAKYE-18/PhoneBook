#  Phonebook App (Java + Maven)

This is a simple **Phonebook Application** built using **Java** and managed with **Maven**.  
The application stores and retrieves contact data using a **JSON file** as its storage backend.

---

##  Features

- Add, view, and manage contacts
- Data stored locally in a JSON file
- Built using Java and Maven

---

##  Prerequisites

Before running this project, ensure you have the following installed:

- Java (JDK 8 or higher)
- Maven

---

## Installing Maven
Run the following commands on the command line based on your OS to install maven
Make sure you are connected to wifi

###  Windows (using winget)
Run `winget install Apache.Maven`

### LINUX(UBUNTU OR DEBIAN)
`sudo apt update` followed by `sudo apt install maven`

### macOS
`brew install maven`

Run `maven -v` to check if maven is installed

## Runnning The Program
To run the program you simply type
`mvn compile` followed by `mvn exec:java`

## Folder Structure
The java source code can be founded within the nested folder in src/main/java/com/example/app and then src/main/java/com/example/phonebook which helps separate into different packages.

The pom.xml contains the maven configuration for building the project.

The contacts.json contains the contact information stored.


