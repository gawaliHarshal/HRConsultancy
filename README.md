# HR Consultancy Web Application

A Java-based recruitment management system that streamlines the hiring process by connecting job seekers with recruiters. The application follows the **MVC (Model-View-Controller)** architecture and provides separate modules for candidates and administrators.

## Features

### Candidate Module
- Candidate Registration
- Secure Login (BCrypt Password Hashing)
- Browse Available Jobs
- Apply for Jobs
- View Applied Jobs
- Session-based Authentication
- Contact HR via Contact Form

### Admin Module
- Admin Login
- Dashboard with Statistics
- Manage Jobs (Add, Update, Delete, View)
- Manage Services (Add, Update, Delete, View)
- View Registered Candidates
- View Job Applications
- View Contact Messages
- Secure Logout

## Tech Stack

### Backend
- Java
- Java Servlets
- JDBC

### Frontend
- JSP
- HTML5
- CSS3

### Database
- MySQL

### Build Tool
- Maven

### Server
- Apache Tomcat 10

### Security
- BCrypt Password Hashing
- Session Management

## Project Architecture

The project follows the **MVC Architecture**.

```
Presentation Layer (JSP, HTML, CSS)
            ↓
Controller Layer (Servlets)
            ↓
DAO Layer (JDBC)
            ↓
MySQL Database
```

## Project Structure

```
HRConsultancy
│
├── src/main/java
│   ├── controller
│   ├── dao
│   ├── model
│   └── util
│
├── src/main/webapp
│   ├── assets
│   │   ├── css
│   │   ├── images
│   │   └── js
│   └── views
│       ├── admin
│       ├── candidate
│       └── common
│
├── pom.xml
└── README.md
```

## Database Tables

- admin
- candidates
- jobs
- job_applications
- services
- contact_messages

## Installation

### Clone Repository

```bash
git clone https://github.com/your-username/HRConsultancy.git
```

### Open Project

Import the project as an **Existing Maven Project** in Eclipse.

### Configure Database

Create a MySQL database:

```sql
CREATE DATABASE hr_consultancy;
```

Update the database credentials in:

```
DBConnection.java
```

Example:

```java
private static final String URL = "jdbc:mysql://localhost:3306/hr_consultancy";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

### Install Dependencies

```bash
mvn clean install
```

### Deploy

Deploy the generated WAR file on **Apache Tomcat 10**.

## Future Enhancements

- Resume Upload
- Email Notifications
- Interview Scheduling
- Advanced Job Search & Filters
- Multi-Admin Support
- Cloud Database Integration
- Cloud Deployment
- REST API Integration

## Learning Outcomes

- Java Web Development
- MVC Architecture
- JDBC Database Connectivity
- Session Management
- Authentication & Authorization
- Maven Dependency Management
- Apache Tomcat Deployment
- CRUD Operations
- Secure Password Hashing using BCrypt

## Author

**Harshal Gawali**

GitHub: https://github.com/your-username
