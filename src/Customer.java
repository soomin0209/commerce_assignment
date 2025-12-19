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
    // 캡슐화를 위해 복사본 반환
    public List<Cart> getCart() {
        return new ArrayList<>(cart);
    }

    // Setter
    // 캡슐화를 위해 방어적 복사
    public void setCart(List<Cart> cart) {
        this.cart = new ArrayList<>(cart);
    }

    public void addToCart(Product product) {
        // 장바구니에 있는 상품인지 확인
        for (Cart cartItem : cart) {
            if (cartItem.getProduct().equals(product)) {
                cartItem.increaseQuantity();    // 수량 +1
                return;
            }
        }
        // 없으면 새로 추가
        cart.add(new Cart(product, 1));
    }

    public void removeFromCart(Product product) {
        cart.removeIf(cartItem -> cartItem.getProduct().equals(product));
    }
}
