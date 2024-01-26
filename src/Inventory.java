import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    private final Map<Integer, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
        System.out.println("Product added: " + product);
    }

    public void updateStock(int productId, int newStock) {
        Product product = products.get(productId);
        if (product != null) {
            product.setStock(newStock);
            System.out.println("Updated product: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void removeProduct(int productId) {
        if (products.remove(productId) != null) {
            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayInventory() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            products.values().forEach(System.out::println);
        }
    }

    public void saveToFile(String fileName) {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (Product product : products.values()) {
                out.println(product.toString());
            }
            System.out.println("Inventory saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving inventory to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");
                int id = Integer.parseInt(parts[0].split("=")[1]);
                String name = parts[1].split("=")[1];
                double price = Double.parseDouble(parts[2].split("=")[1]);
                int stock = Integer.parseInt(parts[3].split("=")[1]);
                products.put(id, new Product(id, name, price, stock));
            }
            System.out.println("Inventory loaded from " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error loading inventory from file: " + e.getMessage());
        }
    }
}