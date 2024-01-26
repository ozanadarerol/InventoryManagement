import java.util.*;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Remove Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Save Inventory to File");
            System.out.println("6. Load Inventory from File");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            int id;

            switch (choice) {
                case 1:
                    inventory.addProduct(promptForProduct(scanner));
                    break;
                case 2:
                    System.out.print("Enter product ID to update stock: ");
                    id = scanner.nextInt();
                    System.out.print("Enter new stock count: ");
                    int stock = scanner.nextInt();
                    inventory.updateStock(id, stock);
                    break;
                case 3:
                    System.out.print("Enter product ID to remove: ");
                    id = scanner.nextInt();
                    inventory.removeProduct(id);
                    break;
                case 4:
                    inventory.displayInventory();
                    break;
                case 5:
                    inventory.saveToFile("inventory.txt");
                    break;
                case 6:
                    inventory.loadFromFile("inventory.txt");
                    break;
                case 7:
                    System.out.println("Exiting Inventory Management System.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Product promptForProduct(Scanner scanner) {
        int id;
        double price;
        int stock;
        String name;

        while (true) {
            System.out.print("Enter product ID: ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("You should enter an integer.");
                scanner.nextLine();
            }
        }

        System.out.print("Enter product name: ");
        name = scanner.nextLine();

        while (true) {
            System.out.print("Enter product price: ");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                scanner.nextLine();
                break;
            } else {
                System.out.println("You should enter a number for the price.");
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.print("Enter stock count: ");
            if (scanner.hasNextInt()) {
                stock = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("You should enter an integer for the stock count.");
                scanner.nextLine();
            }
        }

        return new Product(id, name, price, stock);
    }

}
