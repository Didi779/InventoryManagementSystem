package inventorymanagementsystem;
import java.io.*;
import java.util.*;






class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int id;
    private final String name;
    private final int quantity;
    private final double price;

    public  Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Quantity: " + quantity + ", Price: $" + price;
    }

        public int getId() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public void setQuantity(int newQuantity) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

 class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;

    private static  List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public static void addProduct(Product product) {
        products.add(product);
    }

    public  void removeProduct(int productId) {
        products.removeIf(product -> product.getId() == productId);
    }

    public static void updateProductQuantity(int productId, int newQuantity) {
        Product product = findProductById(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public static void displayInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public static Product findProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public  void saveInventoryToFile(String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(this);
            System.out.println("Inventory saved to file: " + filename);
        } catch (IOException e) {
        }
    }

    public static Inventory loadInventoryFromFile(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            return (Inventory) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        
        Inventory inventory = new Inventory();

        // Loading inventory from file if it exists
        String filename = "inventory.ser";
        File file = new File(filename);
        if (file.exists()) {
            inventory = Inventory.loadInventoryFromFile(filename);
            System.out.println("Inventory loaded from file.");
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product Quantity");
            System.out.println("4. Display Inventory");
            System.out.println("5. Save and Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    // Adding a new product
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Product Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Product Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    Product  newProduct = new Product(id, name, quantity, price);
                    Inventory.addProduct(newProduct);
                    System.out.println("Product added to inventory.");
                    break;

                case 2:
                    // Removing a product
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    inventory.removeProduct(removeId);
                    System.out.println("Product removed from inventory.");
                    break;

                case 3:
                    // Updating product quantity
                    System.out.print("Enter Product ID to update quantity: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new Quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Inventory.updateProductQuantity(updateId, newQuantity);
                    break;

                case 4:
                    // Displaying inventory
                    System.out.println("\nCurrent Inventory:");
                    Inventory.displayInventory();
                    break;

                case 5:
                    // Save and exit
                    inventory.saveInventoryToFile(filename);
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}


