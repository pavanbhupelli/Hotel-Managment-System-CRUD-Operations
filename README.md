# Hotel Management System – CRUD Operations

This project is a simple **Hotel Management System** built in **Java** to demonstrate clean layering and **CRUD (Create, Read, Update, Delete)** operations.  
It follows an MVC-style architecture using separate packages for controllers, services, DAOs, models, and utilities.

---

## 🎯 Objective

To manage hotel-related data (such as rooms, customers, bookings, etc.) using a structured Java application that separates responsibilities into clear layers and demonstrates how CRUD operations can be implemented in a real-world style project.

---

## ✅ Features

- Add new hotel entities (e.g., rooms, customers, bookings)
- View existing records
- Update existing details
- Delete records safely
- Layered architecture:
  - `Controller` – Handles user actions and coordinates the flow
  - `Service` – Contains business logic
  - `DAO` – Handles data access and persistence
  - `Model` – Represents data objects/entities
  - `Util` – Utility/support classes (e.g., common helpers)

> Note: Exact entities depend on how you use/extend the project (rooms, staff, bookings, etc.).

---

## 🏗️ Project Structure

```text
Hotel-Managment-System-CRUD-Operations/
├── Controller/    # Controllers to handle operations and flow
├── service/       # Business logic layer
├── dao/           # Data Access Objects (CRUD with data source)
├── model/         # POJO/Entity classes (Room, Customer, etc.)
├── util/          # Utility classes (helpers, common functions)
└── README.md      # Project documentation
