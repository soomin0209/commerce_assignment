public class Product {

    private String name;
    private int price;
    private String description;
    private int stock;

    public Product(String name, int price, String description, int stock) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %,10d원 | %-20s",
                name, price, description);
    }
}
