# Nathanael Water Refilling Management System

A Java Swing-based desktop application developed to manage the daily operations and transactions of Nathanael Water Refilling Station.

The system provides centralized customer and product management, order processing, payment handling, transaction monitoring, customer archiving, and report generation using a MySQL database.

## Project Overview

The Nathanael Water Refilling Management System aims to improve the efficiency, accuracy, and organization of the station's daily operations by replacing manual record-keeping with a computerized management system.

The application uses Java Swing for its graphical user interface and MySQL for database management.

## Features and Functionalities

- **Role-Based Login** – Provides separate Admin and Staff access.
- **Dashboard** – Displays customer and product counts, today's transactions, and pending deliveries.
- **Customer Management** – Allows authorized users to add, view, update, search, and archive customer records.
- **Product Management** – Allows the Admin to add, view, and update product information.
- **Order Management** – Supports customer selection, product selection, quantity input, and automatic total calculation.
- **Payment Processing** – Handles Cash and GCash payments, including GCash reference codes and change calculation.
- **Delivery Management** – Allows users to update delivery status through the Dashboard.
- **Archiving** – Allows the Admin to restore archived customer records.
- **Transaction Reports** – Provides access to recorded transaction information.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java | Main programming language |
| Java Swing | Desktop graphical user interface |
| MySQL | Database management |
| XAMPP | Local database server |
| phpMyAdmin | Database administration |
| Apache NetBeans | Development environment |
| Maven | Project and dependency management |
| MySQL Connector/J | Java-to-MySQL connectivity |

## System Requirements

- Apache NetBeans IDE
- Java Development Kit (JDK) compatible with the project's Maven configuration
- XAMPP
- MySQL Connector/J (managed through Maven)
- Web browser for phpMyAdmin

## Database Setup

1. Open the XAMPP Control Panel.
2. Start **Apache** and **MySQL**.
3. Open phpMyAdmin in your browser.
4. Import the `database.sql` file included in this repository.
5. Make sure the database `nathanael_water_refilling` is created successfully.
6. Check the database connection settings in `DBConnection.java`.

Update the database connection credentials if your local MySQL configuration is different.

## How to Run the Project

1. Clone or download this repository.
2. Open Apache NetBeans IDE.
3. Select **File → Open Project**.
4. Locate and open the downloaded `WaterRefillingStation` project folder.
5. Allow Maven to download the required dependencies.
6. Make sure XAMPP MySQL is running and the database has been imported.
7. Check your database connection settings.
8. Build and run the project using NetBeans.

## Project Structure

```text
WaterRefillingStation/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/mycompany/waterrefillingstation/
│       │       ├── LoginFrame.java
│       │       ├── DashboardFrame.java
│       │       ├── CustomerFrame.java
│       │       ├── ProductFrame.java
│       │       ├── OrderPaymentFrame.java
│       │       ├── ArchiveFrame.java
│       │       ├── ReportFrame.java
│       │       ├── DBConnection.java
│       │       └── DAO and user classes
│       │
│       └── resources/
│           └── images/
│
├── database.sql
├── pom.xml
├── README.md
└── .gitignore
```

## User Roles

**Admin**
- Manage customer records.
- Manage product information.
- Process orders and payments.
- Access archived customer records.
- View transaction reports.

**Staff**
- Access the system through Staff login.
- Manage customer records according to system permissions.
- Process orders and payments.
- View transaction information.

## Developers

Developed by:

- Clyde
- Carmela

## Project Purpose

This project was developed as an academic requirement to apply Java programming, Object-Oriented Programming (OOP), database management, and graphical user interface development in a real-world business management scenario.

---

**Project:** Nathanael Water Refilling Management System  
**Platform:** Desktop Application  
**Repository:** GitHub
