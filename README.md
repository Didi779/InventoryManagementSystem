Inventory Management System Using Java
# Inventory Management System

This Java program implements a simple Inventory Management System that allows users to add, remove, update product quantities, display the current inventory, and save the inventory to a file. The inventory and product data are stored using Java Serialization.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your machine.

### How to Run

1. Clone the repository to your local machine.

    ```bash
    git clone https://github.com/Didi779/inventory-management-system-java.git
    ```

2. Navigate to the project directory.

    ```bash
    cd inventory-management-system-java
    ```

3. Compile the Java program.

    ```bash
    javac inventorymanagementsystem/*.java
    ```

4. Run the program.

    ```bash
    java inventorymanagementsystem.InventoryManagementSystem
    ```

5. Follow the on-screen instructions to interact with the Inventory Management System.

## Description

The Inventory Management System allows users to perform the following actions:

1. **Add Product**: Add a new product to the inventory, providing details such as ID, name, quantity, and price.
2. **Remove Product**: Remove a product from the inventory based on its ID.
3. **Update Product Quantity**: Update the quantity of a product in the inventory.
4. **Display Inventory**: View the current inventory, including product details.
5. **Save and Exit**: Save the current inventory to a file and exit the program.

## Usage

- Enter the corresponding numbers to perform actions in the CLI menu.
- Follow the prompts to add, remove, update product quantities, display the inventory, and save changes.

## Serialization

The program uses Java Serialization to store and retrieve inventory data. The inventory is saved to a file named `inventory.ser`.

## Contributing

If you would like to contribute to this project, please follow the standard GitHub fork and pull request process. Feel free to open issues for bug reports, feature requests, or general feedback.



