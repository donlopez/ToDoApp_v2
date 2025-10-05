# ToDoApp_v2

A simple console-based Java To-Do List application that uses Hibernate ORM with MySQL to perform CRUD operations on tasks.  
This project demonstrates how to integrate Hibernate with a MySQL database using Maven in IntelliJ IDEA.

---

## Overview

The application allows users to manage their daily tasks directly from the console. It connects to a MySQL database (todo_db) using Hibernate, which automatically maps Java objects to database tables.

Users can:
1. Add a new task
2. List all tasks
3. Mark a task as completed
4. Delete a task
5. Exit the program

All data is stored persistently in the MySQL table todo_items.

---

## Technologies Used

- Java 17 or higher
- Hibernate ORM 6.5
- MySQL 8 / 9 (Connector/J)
- Maven
- IntelliJ IDEA

---

## Project Structure

ToDoApp_v2/  
├── src/  
│   └── main/  
│       ├── java/  
│       │   └── todo/  
│       │       ├── Main.java  
│       │       ├── TodoItem.java  
│       │       ├── TodoRepository.java  
│       │       └── HibernateUtil.java  
│       └── resources/  
│           └── hibernate.cfg.xml  
├── pom.xml  
├── .gitignore  
├── LICENSE  
├── README.md  
└── ToDoApp_v2.iml

---

## Database Setup

Before running the application, create the database in MySQL:

CREATE DATABASE todo_db;

---

## Hibernate Configuration

File: src/main/resources/hibernate.cfg.xml

<?xml version="1.0" encoding="utf-8"?>  
<!DOCTYPE hibernate-configuration PUBLIC  
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"  
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">  
<hibernate-configuration>  
    <session-factory>  
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>  
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/todo_db?useSSL=false&amp;allowPublicKeyRetrieval=true</property>  
        <property name="hibernate.connection.username">root</property>  
        <property name="hibernate.connection.password">your_password_here</property>  
        <property name="hibernate.hbm2ddl.auto">update</property>  
        <property name="hibernate.show_sql">true</property>  
        <property name="hibernate.format_sql">true</property>  
        <mapping class="todo.TodoItem"/>  
    </session-factory>  
</hibernate-configuration>  

---

## How to Run

1. Clone this repository:  
   git clone https://github.com/donlopez/ToDoApp_v2.git

2. Open the project in IntelliJ IDEA.

3. Make sure Maven downloads all dependencies.
    - Open the Maven tool window and click “Reload All Maven Projects”.

4. Ensure your MySQL server is running.

5. Update your database credentials in hibernate.cfg.xml.

6. Run the application:  
   mvn clean compile exec:java -Dexec.mainClass="todo.Main"

   or simply click Run in IntelliJ.

---

## Example Console Output

To-Do ready. Database is todo_db

1) Add  2) List  3) Complete  4) Delete  5) Exit  
   Choose: 1  
   Task: Watch Tron on Thursday  
   Saved

1) Add  2) List  3) Complete  4) Delete  5) Exit  
   Choose: 3  
   Id to complete: 3  
   Updated

1) Add  2) List  3) Complete  4) Delete  5) Exit  
   Choose: 4  
   Id to delete: 3  
   Deleted

---

## Features

- Console-based task management
- Hibernate ORM for persistence
- MySQL backend for data storage
- Simple CRUD functionality
- Automatic table creation
- Clean and organized structure

---

## GitHub Notes

Sensitive configuration files like hibernate.cfg.xml are excluded from the repository to protect local credentials.  
The .gitignore file ensures only essential project files are tracked.

---

## Future Enhancements

- Add a JavaFX graphical interface
- Add due dates and priority levels
- Improve input validation
- Enhance connection management

---

## Author

Julio Lopez  
GitHub: https://github.com/donlopez
