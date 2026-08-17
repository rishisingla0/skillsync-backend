# SkillSync

> **Enterprise Skill Tracking & Project Management System**

SkillSync is a backend-focused application designed to manage **users, skills, and projects** in a structured system. The project is being developed using **Java and Spring Boot**, with a focus on building a clean backend architecture, REST APIs, database integration, and real-world business logic.

The project is also being developed as a practical learning project to strengthen backend development concepts and gradually introduce more advanced Spring Boot features.

---

## 🚀 Project Overview

SkillSync aims to provide a platform where users can:

* Create and manage their profiles
* Add and manage skills
* Associate skills with users
* Create and manage projects
* Associate projects with users
* Track the skills involved in projects
* Build relationships between users, skills, and projects

The project will evolve over time as additional backend and full-stack features are implemented.

---

## 🛠️ Tech Stack

### Backend

* **Java 21**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Hibernate**
* **Maven**

### Database

* **MySQL 8**

### Development Tools

* **Visual Studio Code**
* **MySQL Workbench**
* **Postman**
* **Git**
* **GitHub**

### Planned

* Spring Security
* JWT Authentication
* Role-Based Authorization
* React.js frontend
* API documentation with Swagger/OpenAPI
* Testing with JUnit & Mockito

---

## 🏗️ Architecture

SkillSync follows a layered backend architecture:

```text
Client
   │
   ▼
Controller Layer
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
MySQL Database
```

### Layers

**Controller**

* Handles HTTP requests
* Defines REST endpoints
* Validates incoming requests

**Service**

* Contains business logic
* Processes application operations
* Acts as a bridge between controllers and repositories

**Repository**

* Communicates with the database
* Uses Spring Data JPA
* Provides CRUD and custom database operations

**Entity**

* Represents database tables
* Defines relationships between application objects

---

## 📂 Project Structure

```text
skillsync/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── skillsync/
│   │   │           ├── controller/
│   │   │           ├── service/
│   │   │           ├── repository/
│   │   │           ├── entity/
│   │   │           ├── dto/
│   │   │           └── SkillsyncApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

## 📌 Current Features

### User Management

* Create users
* Retrieve users
* Find users by ID
* Check whether an email already exists
* Prevent duplicate users

### Project Management

* Create projects
* Associate projects with users
* Retrieve project information
* Manage project details

### Skill Management

* Create and manage skills
* Assign skills to users
* Associate skills with projects

---

## 🗄️ Database

SkillSync uses **MySQL** as its relational database.

The application uses **JPA/Hibernate** for object-relational mapping, allowing Java entities to be mapped to database tables.

Current core entities include:

```text
User
 ├── Skills
 └── Projects

Project
 └── Skills
```

The database structure will continue to evolve as new functionality is introduced.

---

## 🔌 API

SkillSync exposes RESTful APIs for interacting with the backend.

Example operations:

```text
POST   /api/users
GET    /api/users
GET    /api/users/{id}

POST   /api/projects
GET    /api/projects

POST   /api/skills
GET    /api/skills
```

> API endpoints will be documented and expanded as the project develops.

---

## 🧠 Concepts Practiced

This project is being used to apply real-world backend development concepts including:

* Object-Oriented Programming
* Java Collections
* Exception Handling
* REST API Development
* Spring Boot
* Dependency Injection
* Layered Architecture
* Spring Data JPA
* Hibernate
* Entity Relationships
* DTOs
* Database Design
* CRUD Operations
* HTTP Status Codes
* API Testing
* Git & GitHub

---

## 🔮 Future Roadmap

The long-term goal is to transform SkillSync into a more complete enterprise-style application.

### Phase 1 — Core Backend

* [x] Spring Boot setup
* [x] User entity
* [x] User CRUD APIs
* [x] MySQL integration
* [x] Project management
* [x] Skill management
* [x] User-skill relationships
* [ ] Project-skill relationships
* [ ] Global exception handling
* [ ] DTO-based API architecture
* [ ] Input validation

### Phase 2 — Security

* [ ] Spring Security
* [ ] User authentication
* [ ] JWT authentication
* [ ] Password encryption
* [ ] Role-based authorization

### Phase 3 — Advanced Backend

* [ ] Pagination
* [ ] Sorting & filtering
* [ ] Search functionality
* [ ] Advanced JPA queries
* [ ] Transactions
* [ ] Logging
* [ ] API documentation
* [ ] Unit testing
* [ ] Integration testing

### Phase 4 — Frontend

* [ ] React.js frontend
* [ ] Authentication UI
* [ ] User dashboard
* [ ] Skill management interface
* [ ] Project management interface
* [ ] User profiles

### Phase 5 — Production

* [ ] Docker
* [ ] CI/CD
* [ ] Cloud deployment
* [ ] Production database
* [ ] Monitoring & logging

---

## ▶️ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/rishisingla0/skillsync-backend.git
```

### 2. Open the project

Open the project in your preferred IDE or code editor.

### 3. Configure MySQL

Create a MySQL database and configure the credentials in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/skillsync
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Run the application

Using Maven Wrapper:

**Windows**

```bash
mvnw.cmd spring-boot:run
```

Or:

```bash
./mvnw spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

---

## 🧪 Testing APIs

Postman can be used to test the REST APIs.

Typical workflow:

```text
Client
  ↓
Postman
  ↓
REST API
  ↓
Controller
  ↓
Service
  ↓
Repository
  ↓
MySQL
```

---

## 📈 Project Status

**Current Status:** 🚧 Active Development

SkillSync is continuously being developed with new backend concepts and features being added incrementally.

The primary objective is to build a **production-style Spring Boot backend** while gaining practical experience with modern backend development.

---

## 🎯 Goals

The main goals of SkillSync are:

1. Build a realistic backend application using Java and Spring Boot.
2. Understand how different backend layers work together.
3. Practice designing REST APIs.
4. Gain hands-on experience with relational databases.
5. Implement real-world business logic.
6. Gradually introduce security, testing, and deployment.
7. Eventually connect the backend to a React frontend.

---

## 👨‍💻 Author

**Rishi Singla**

BCA Student | Java Backend Developer in Progress

Focused on:

```text
Java
Spring Boot
Backend Development
REST APIs
MySQL
Data Structures & Algorithms
Full-Stack Development
```

---

## ⭐ Project Philosophy

> **Learn → Build → Break → Debug → Improve**

SkillSync is not just a project. It is a practical journey toward understanding how real-world backend applications are designed, developed, tested, and deployed.

