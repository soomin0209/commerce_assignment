public class Cart {

    // 속성
    private Product product;
    private int quantity;

    // 생성자
    public Cart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getter
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // 수량 증가 메서드
    public void increaseQuantity() {
        this.quantity++;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %,10d원 | %3d개",
                product.getProductName(), product.getPrice(), quantity);
    }
}
