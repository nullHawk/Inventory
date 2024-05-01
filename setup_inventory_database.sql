-- Create the database
CREATE DATABASE IF NOT EXISTS Inventory;

-- Create the user
CREATE USER IF NOT EXISTS 'inventoryuser'@'%' IDENTIFIED BY 'YourPasswordHere';

-- Grant privileges to the user for the Inventory database
GRANT ALL PRIVILEGES ON Inventory.* TO 'inventoryuser'@'%';

-- Flush privileges to ensure that MySQL reloads the grant tables
FLUSH PRIVILEGES;
