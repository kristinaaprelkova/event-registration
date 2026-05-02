# Event Registration System

Full-stack application for managing events and user registrations.

---

## 📌 Overview

This application allows an admin to create events and users to register for them.
It is built as a simple event management system with a clear separation between backend and frontend.

---

## 🛠 Tech Stack

* **Backend:** Spring Boot (Java)
* **Frontend:** Vue (planned)
* **Database:** PostgreSQL
* **Build Tool:** Gradle

---

## ✨ Features

### Admin

* Login with email and password
* Create new events (name, date, max participants)

### Users

* View list of events
* Register for events
* Provide first name, last name and personal code

---

## 🚀 How to Run

### 1. Clone the repository

```bash
git clone https://github.com/kristinaaprelkova/event-registration.git
cd event-registration
```

---

### 2. Setup PostgreSQL

Create a database:

```sql
CREATE DATABASE eventdb;
```

---

### 3. Configure backend

Open:

```text
backend/src/main/resources/application.properties
```

Add your PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/eventdb
spring.datasource.username=postgres
spring.datasource.password=student123

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

---

### 4. Run backend

```bash
cd backend
./gradlew bootRun
```

Backend will start at:

```text
http://localhost:8080
```

---

### 5. Run frontend (optional)

```bash
cd frontend
npm install
npm run dev
```

Frontend will start at:

```text
http://localhost:5173
```

---

## 📁 Project Structure

```
event-registration/
├── backend/   # Spring Boot application
├── frontend/  # Vue application (in progress)
```

---

## 📄 Notes

* Frontend part is under development
* This project is created as a practical assignment

---

## 👩‍💻 Author

Kristina Aprelkova
