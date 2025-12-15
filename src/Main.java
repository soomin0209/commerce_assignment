import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
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

        while (true) {
            System.out.print("입력: ");

            try {
                int num = sc.nextInt();
                switch (num) {
                    case 1:
                        System.out.println(products.get(0));
                        break;
                    case 2:
                        System.out.println(products.get(1));
                        break;
                    case 3:
                        System.out.println(products.get(2));
                        break;
                    case 4:
                        System.out.println(products.get(3));
                        break;
                    case 0:
                        System.out.println("커머스 플랫폼을 종료합니다.");
                        return;
                    default:
                        System.out.println("다시 입력해주세요.");
                }
            } catch (Exception e) {
                System.out.println("다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }
}