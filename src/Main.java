import java.util.ArrayList;
import java.util.List;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        Product galaxy = new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 50);
        Product iphone = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 50);
        Product macbook = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 50);
        Product airpods = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 50);

        products.add(galaxy);
        products.add(iphone);
        products.add(macbook);
        products.add(airpods);

        System.out.println("[ 실시간 커머스 플랫폼 = 전자제품 ]");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
        System.out.println("0. 종료");

    }
}