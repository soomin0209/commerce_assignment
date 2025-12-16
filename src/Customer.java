import java.util.ArrayList;
import java.util.List;

public class Customer {

    // 속성
    private String customerName;
    private String email;
    private String grade;
    private List<Cart> cart = new ArrayList<>();

    // 생성자
    public Customer(String customerName, String email) {
        this.customerName = customerName;
        this.email = email;
        this.grade = "BRONZE";
    }

    // Getter
    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getGrade() {
        return grade;
    }

    public List<Cart> getCart() {
        return cart;
    }

    // Setter
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

    public void addToCart(Product product) {
        // 장바구니에 있는 상품인지 확인
        for (Cart product1 : cart) {
            if (product1.getProduct().equals(product)) {
                product1.increaseQuantity();    // 수량 +1
                return;
            }
        }
        // 없으면 새로 추가
        cart.add(new Cart(product, 1));
    }
}
