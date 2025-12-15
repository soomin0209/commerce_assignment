import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        CommerceSystem commerceSystem = new CommerceSystem(products);

        Product galaxy = new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 50);
        Product iphone = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 50);
        Product macbook = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 50);
        Product airpods = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 50);

        products.add(galaxy);
        products.add(iphone);
        products.add(macbook);
        products.add(airpods);

        commerceSystem.start();
    }
}