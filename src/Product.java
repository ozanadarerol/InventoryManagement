public class Product {
    private final int id;
    private final String name;
    private final double price;
    private int stock;

    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name + "', price=" + price + ", stock=" + stock;
    }
}
