# Inventory Management System Documentation

## Overview
This project aims to develop a robust Inventory Management System using Spring Boot, MySQL Database, and Hibernate ORM. The system allows users to manage inventory records efficiently, including creating, updating, retrieving, and deleting inventory details, suppliers, and transactions.

## Features
- *Inventory Item Management*: CRUD operations for managing inventory items including creation, updating, retrieval, and deletion.
- *Supplier Management*: Ability to add, update, and delete suppliers, along with listing all items provided by a specific supplier.
- *Transaction Management*: Recording transactions related to inventory items, managing stock levels, and listing all transactions for a specific item.

## Class Diagram
![InventoryClassDiagram](https://github.com/nullHawk/Inventory/assets/140995666/2f998ed4-9410-4e6b-bfa1-f4c4c4af84ba)

## Models
1. *Item*: Represents an inventory item with fields such as Item ID, name, quantity, supplier, and price.
2. *Supplier*: Represents a supplier with fields like supplier ID, name, contact information, and description.
3. *Transaction*: Represents a transaction with fields such as transaction ID, item ID, transaction type, quantity, and transaction date.

## Implementation Details
- *RESTful API Architecture*: Utilized Spring Boot framework to implement a RESTful API architecture, providing endpoints for various operations.
- *MySQL Database*: Integrated MySQL database for storing inventory data.
- *Hibernate ORM*: Utilized Hibernate ORM for database interaction to simplify CRUD operations and ensure data integrity.
- *Cardinality Rules*: Established appropriate cardinality rules between the models to maintain data consistency.
- *Logging*: Implemented logging for each CRUD operation to aid in debugging and monitoring system usage.

## Setup Instructions
1. *Clone the Repository*: Clone the project repository from [Inventory] (https://github.com/nullHawk/Inventory).
2. *Database Configuration*: Configure MySQL database connection details in application.properties.
3. *Run Application*: Run the Spring Boot application.
4. *Access API Endpoints*: Access various API endpoints for managing inventory, suppliers, and transactions.

## API Endpoints

> Item Controller
- GET /item: Retrieve all items.
- GET /item/{id}: Retrieve item by ID.
- POST /item: Create a new item.
- PUT /item/{id}: Update an existing item.
- DELETE /item/{id}: Delete an item by ID.

> Supplier Controller
- GET /supplier: Retrieve all suppliers.
- GET /supplier/{id}: Retrieve supplier by ID.
- POST /supplier: Create a new supplier.
- PUT /supplier/{id}: Update an existing supplier.
- DELETE /supplier/{id}: Delete a supplier by ID.

> Transaction Controller
- GET /transaction: Retrieve all transactions.
- GET /transaction/{id}: Retrieve transaction by ID.
- POST /transaction: Create a new transaction.
- PUT /transaction/{id}: Update an existing transaction.
- DELETE /transaction/{id}: Delete a transaction by ID.

## Contributors
- [Suryansh Shakya](https://github.com/nullHawk)
- [Srujan Dharma](https://github.com/srujan0404)
- [Harshini reddy](https://github.com/Harshinireddy05/)
- [Venkatesh Alampally](https://github.com/Venki1402)
- [Dev Mhrn_](https://github.com/DevMhrn)
- [Ayaan Khan](https://github.com/ayaankhan28)


## Contact
For any inquiries or support, please contact [nullhawk](suryanshsinghshakya1@gmail.com).

---

This documentation provides an overview of the Inventory Management System, including its features, implementation details, setup instructions, API endpoints, contributors, license, and contact information. For detailed technical documentation, please refer to the project's source code and comments.

