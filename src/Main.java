import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 전자제품
        List<Product> electronics = new ArrayList<>();
        electronics.add(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 50));
        electronics.add(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 50));
        electronics.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 50));
        electronics.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 0));

        // 의류
        List<Product> clothes = new ArrayList<>();

        // 식품
        List<Product> foods = new ArrayList<>();

        List<Category> categories = new ArrayList<>();
        categories.add(new Category("전자제품", electronics));
        categories.add(new Category("의류", clothes));
        categories.add(new Category("식품", foods));

        Customer customer = new Customer("Soomin", "soomin_0209@naver.com");
        CommerceSystem commerceSystem = new CommerceSystem(categories, customer);
        commerceSystem.start();
    }
}