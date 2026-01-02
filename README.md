# 📌 Job Tracker Application

A simple and user-friendly **Job Application Tracking System** built using **Spring Boot, Thymeleaf, MySQL, and Bootstrap**.  
This application helps users track their job applications, interview progress, offers, and rejections in one place.

---

## 🚀 Features

- ➕ Add new job applications  
- ✏️ Edit existing job details  
- ❌ Delete job entries  
- 🔍 Filter jobs by:
  - Company name
  - Job status (Applied, Interview, Offer, Rejected)
- 📊 Dashboard summary:
  - Total jobs applied
  - In-progress applications
  - Offers count
  - Rejected count
- 🗓 Automatically sets applied date if not provided
- 📱 Responsive UI using Bootstrap

---

## 🛠 Tech Stack

### Backend
- Java 21
- Spring Boot 4
- Spring Data JPA
- Hibernate
- MySQL

### Frontend
- Thymeleaf
- Bootstrap 5

### Tools
- Maven
- Git & GitHub
- IntelliJ / Eclipse / VS Code

---
## 🗂 Project Structure

JobTracker
│
├── Controller
│ └── JobApplicationController.java
│
├── Model
│ └── JobApplication.java
│
├── Repository
│ └── JobApplicationRepository.java
│
├── Enums
│ └── JobStatus.java
│
├── resources
│ ├── templates
│ │ ├── jobs.html
│ │ ├── add-job.html
│ │ └── edit-job.html
│ └── application.properties
│
└── JobTrackerApplication.java

