import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private List<Product> products = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // 생성자
    public CommerceSystem(List<Product> products) {
        this.products = products;
    }

    // 기능
    public void start() {
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
