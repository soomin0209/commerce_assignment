import java.util.ArrayList;
import java.util.List;

public class Customer {

    // 속성
    private String customerName;
    private String email;
    private String grade;
    private List<Product> cart = new ArrayList<>();

    // 생성자
    public Customer(String customerName, String email, String grade) {
        this.customerName = customerName;
        this.email = email;
        this.grade = grade;
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

    public List<Product> getCart() {
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

    public void addToCart(Product product) {
        cart.add(product);
    }
}
