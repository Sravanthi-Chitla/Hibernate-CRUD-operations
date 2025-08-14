# Hibernate CRUD Operations

A simple Java project demonstrating **Create, Read, Update, Delete (CRUD)** operations using **Hibernate ORM** with **PostgreSQL**.

---

## 📌 Overview
This project uses Hibernate's annotation-based mapping to interact with a PostgreSQL database.  
It contains a `Student` entity and a `Main` class that performs all CRUD operations in sequence.

---

## 🛠 Tech Stack
- **Java** (JDK 17 or later)
- **Hibernate ORM** (6.x)
- **PostgreSQL**
- **Maven** (Dependency Management)

---

## 📂 Project Structure
src/          
└── main/               
├── java/          
│ └── com/         
│ └── hibernate/           
│ ├── Main.java # Contains CRUD methods          
│ └── Student.java # Entity class             
└── resources/                        
└── hibernate.cfg.xml # Hibernate configuration                         
pom.xml # Maven dependencies            
