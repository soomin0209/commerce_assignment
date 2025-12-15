public class Product {

    private String productName;
    private int price;
    private String description;
    private int stock;

    public Product(String productName, int price, String description, int stock) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %,10d원 | %-20s",
                productName, price, description);
    }
}
