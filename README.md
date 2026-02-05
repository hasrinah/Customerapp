

# Customer App (Spring Boot + MySQL)

Simple one-page CRUD web app built with Java Spring Boot:
<img width="952" height="825" alt="image" src="https://github.com/user-attachments/assets/105f1521-1775-42e1-94ff-78b96d00ec6d" />

- Add Customer (Name, Email, Phone)
- View all customers in a table
- Edit / Delete customer records
- Data stored in MySQL

## Requirements
- Java 17
- Maven 3.9+
- MySQL 8

## Database Setup (MySQL)
1) Start MySQL service
2) Create the database:
```sql
CREATE DATABASE IF NOT EXISTS customer_app;
