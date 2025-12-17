public class Product {

    // 속성
    private String productName;
    private int price;
    private String description;
    private int stock;

    // 생성자
    public Product(String productName, int price, String description, int stock) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    // Getter
    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    // Setter
    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %,10d원 | %-20s | %3d개",
                productName, price, description, stock);
    }

    public String toStringWithoutStock() {
        return String.format("%-15s | %,10d원 | %-20s",
                productName, price, description);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return productName.equals(product.productName);
    }
}
