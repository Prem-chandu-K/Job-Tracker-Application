# 💼 Job Tracker Application

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-4-brightgreen)
![MySQL](https://img.shields.io/badge/Database-MySQL-blue)
![Thymeleaf](https://img.shields.io/badge/Frontend-Thymeleaf-lightgrey)
![Bootstrap](https://img.shields.io/badge/UI-Bootstrap5-purple)
![Status](https://img.shields.io/badge/Project-Completed-success)

---

## 📌 Overview

A **full-stack Job Application Tracking System** built using **Spring Boot, Thymeleaf, and MySQL** to help users efficiently manage and monitor their job applications.

This project simulates a real-world productivity tool used by job seekers to:

* Track job applications 📄
* Monitor interview progress 🎯
* Manage offers and rejections 📊
* Stay organized throughout the hiring process 🧠

---

## 🎯 Key Objectives

* Build a complete CRUD-based web application
* Manage job application lifecycle efficiently
* Implement filtering and search functionality
* Provide real-time dashboard insights
* Practice full-stack development with Spring Boot

---

## 🏗️ Project Architecture

```text
Client (Browser)
       ↓
Thymeleaf Templates (View Layer)
       ↓
Spring Boot Controller (MVC)
       ↓
Service Layer (Business Logic)
       ↓
Spring Data JPA (Repository)
       ↓
MySQL Database
```

---

## 📂 Project Structure

```text
JobTracker/
│
├── controller/
│   └── JobApplicationController.java
│
├── model/
│   └── JobApplication.java
│
├── repository/
│   └── JobApplicationRepository.java
│
├── service/
│   └── JobApplicationService.java
│
├── enums/
│   └── JobStatus.java
│
├── resources/
│   ├── templates/
│   │   ├── jobs.html
│   │   ├── add-job.html
│   │   ├── edit-job.html
│   │   └── dashboard.html
│   │
│   ├── static/
│   │   └── css/
│   │       └── style.css
│   │
│   └── application.properties
│
├── screenshots/
│   ├── dashboard.png
│   ├── add-job.png
│   └── filtered-jobs.png
│
├── pom.xml
├── README.md
└── JobTrackerApplication.java
```

---

## ⚙️ Features

✔️ Add new job applications

✔️ Edit existing job details

✔️ Delete job entries

✔️ Filter jobs

→ By Company Name  
→ By Job Status  
→ By Location  
→ By Role

✔️ Dashboard Summary

→ Total Applications  
→ Applied Jobs  
→ Interviews Scheduled  
→ Offers Received  
→ Rejected Applications

✔️ Automatic applied date handling

✔️ Clean & responsive UI with Bootstrap 5

✔️ Search and sorting functionality

✔️ MySQL Database Integration using Spring Data JPA

✔️ MVC Architecture Implementation

✔️ Form validation support

---

## 📊 Application Screens

### 📋 Job Management Dashboard

* Displays all job applications in a structured table
* Real-time status tracking
* Quick edit and delete actions

### 🔍 Filtered Job Listings

* Search applications by company name
* Filter by job status and role
* Organized application management

### 📈 Dashboard Insights

* Application status distribution
* Job tracking statistics
* Hiring pipeline overview

---

## 🛠️ Tech Stack

| Category       | Tools Used                          |
| -------------- | ----------------------------------- |
| Backend        | Java 21, Spring Boot 4             |
| ORM            | Spring Data JPA, Hibernate         |
| Frontend       | Thymeleaf, Bootstrap 5             |
| Database       | MySQL                              |
| Build Tool     | Maven                              |
| IDE            | IntelliJ / Eclipse / VS Code       |

---

## 🔐 Configuration

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jobtracker
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.thymeleaf.cache=false
server.port=8080
```

---

## ▶️ How to Run

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/job-tracker.git
cd job-tracker
```

---

### 2️⃣ Configure Database

Create a MySQL database:

```sql
CREATE DATABASE jobtracker;
```

---

### 3️⃣ Install Dependencies

```bash
mvn clean install
```

---

### 4️⃣ Update Credentials

Edit `application.properties` with your MySQL credentials

---

### 5️⃣ Run Application

```bash
mvn spring-boot:run
```

---

### 6️⃣ Open in Browser

```text
http://localhost:8080
```

---

## 📈 Output

* 📋 Job Management Dashboard
* 🔍 Filtered Job Listings
* 📊 Application Status Insights
* 🗄️ Persistent Data Storage in MySQL
* 🎯 Complete Job Tracking Workflow

---

## 🔍 Key Learnings

* Hands-on experience with Spring Boot MVC architecture
* Integration of Thymeleaf with backend
* Working with JPA & Hibernate ORM
* Building responsive UI using Bootstrap
* Implementing real-world CRUD operations
* Database connectivity and persistence handling
* Form handling and validation in Spring Boot
* Full-stack application development workflow

---

## 🚀 Future Enhancements

* 🔐 User Authentication (Login/Register)
* 📧 Email Notifications for interview reminders
* 📊 Advanced analytics & charts
* 🌐 REST API integration
* ☁️ Cloud Deployment (AWS / Render)
* 📱 Mobile responsive enhancements
* 🔎 AI-based resume-job matching
* 📅 Interview scheduling integration

---

## 📬 Connect With Me

<p align="center">
  <a href="https://www.linkedin.com/in/kakarla-prem-chandu-0555a832a" target="_blank" rel="noopener noreferrer">
    <img src="https://img.shields.io/badge/LinkedIn-Visit%20Profile-blue?style=for-the-badge&logo=linkedin" />
  </a>
</p>

---
