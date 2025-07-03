# task-7
# Employee Database Application

## Overview
This project is a simple Employee Database Application that connects to a MySQL/PostgreSQL database and performs CRUD (Create, Read, Update, Delete) operations on employee records. The application is built using Java and utilizes JDBC for database connectivity.

## Project Structure
```
employee-db-app
├── src
│   ├── Main.java
│   ├── db
│   │   └── DatabaseConnection.java
│   ├── dao
│   │   └── EmployeeDAO.java
│   ├── model
│   │   └── Employee.java
│   └── util
│       └── DBConfig.java
├── lib
│   └── (JDBC driver jar)
├── README.md
└── pom.xml
```

## Setup Instructions

1. **Database Setup**
   - Create a MySQL/PostgreSQL database named `employee_db`.
   - Create a table named `employees` with the following structure:
     ```sql
     CREATE TABLE employees (
         id INT PRIMARY KEY AUTO_INCREMENT,
         name VARCHAR(100),
         position VARCHAR(100),
         salary DECIMAL(10, 2)
     );
     ```

2. **JDBC Driver**
   - Download the JDBC driver for MySQL or PostgreSQL and place the jar file in the `lib` directory.

3. **Configuration**
   - Update the `DBConfig.java` file with your database connection details (URL, username, password).

4. **Build the Project**
   - Use Maven to build the project. Ensure that the `pom.xml` file includes the necessary dependencies for JDBC.

5. **Run the Application**
   - Execute the `Main.java` file to start the application. Follow the prompts to perform CRUD operations on employee records.

## Usage Guidelines
- The application allows you to add new employees, view existing employee details, update employee information, and delete employees from the database.
- Follow the on-screen instructions to navigate through the application.
