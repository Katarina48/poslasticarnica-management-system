# Pastry Shop Management System (Java Client-Server Application)

A multi-tier desktop software system for managing daily operations in a pastry shop, developed in Java using a client-server architecture.

## Architecture & Technologies
* **Language:** Java (JDK)
* **Architecture:** Client-Server (`Poslasticarnica_KLIJENT`, `Poslasticarnica_SERVER`, `Poslasticarnica_ZAJEDNICKI`)
* **GUI:** Java Swing
* **Networking & Concurrency:** Java Sockets (`ServerSocket` / `Socket`) & Multithreading (handling concurrent client requests)
* **Database:** MySQL (`mysql-connector-j-9.7.0`) via JDBC
* **Reporting:** JasperReports / Jaspersoft Studio
* **Testing:** JUnit

## Project Structure
* `Poslasticarnica_KLIJENT/` – Swing user interface, client controllers, and server communication logic
* `Poslasticarnica_SERVER/` – Multi-threaded socket server, business logic (System Operations), and JDBC database broker
* `Poslasticarnica_ZAJEDNICKI/` – Shared domain model classes, transfer objects (`Request`/`Response`), and operation constants
* `database/poslasticarnica_baza.sql` – MySQL database schema and initial dataset
* `lib/` – External JAR dependencies (MySQL Connector/J)

## Setup & Running Instructions

### 1. Database Setup
1. Open your MySQL client (e.g., SQLyog, MySQL Workbench, or phpMyAdmin).
2. Import and execute `database/poslasticarnica_baza.sql` to create the database and populate tables.
3. Verify database connection credentials in the server's DB configuration file (default: `root` / empty password on `localhost:3306`).

### 2. Running the Application
1. Open all three projects (`Poslasticarnica_ZAJEDNICKI`, `Poslasticarnica_SERVER`, `Poslasticarnica_KLIJENT`) in **NetBeans**.
2. Ensure `Poslasticarnica_ZAJEDNICKI` and `lib/mysql-connector-j-9.7.0.jar` are properly linked in the project libraries if needed.
3. Build and run **Poslasticarnica_SERVER** first and start the server via the server GUI.
4. Build and run **Poslasticarnica_KLIJENT** to log in and use the application.