import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    // 속성
    private List<Category> categories = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // 생성자
    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    // 기능
    public void start() {
        while (true) {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            int categoryIndex = 1;
            for (Category category : categories) {
                System.out.println(categoryIndex + ". " + category.getCategoryName());
                categoryIndex++;
            }
            System.out.println("0. 종료");
            System.out.print("입력: ");

            try {
                int categoryNum = sc.nextInt();

                if (categoryNum == 0) {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    return;
                }
                if (categoryNum < 1 || categoryNum > categories.size()) {
                    System.out.println("다시 입력해주세요.");
                    continue;
                }
                Category selectCategory = categories.get(categoryNum - 1);
                List<Product> products = selectCategory.getProducts();

                System.out.println(selectCategory.getCategoryName() + " 카테고리");
                int productIndex = 1;
                for (Product product : products) {
                    System.out.println(productIndex + ". " + product);
                    productIndex++;
                }
                System.out.println("0. 뒤로가기");

                while (true) {
                    System.out.print("입력: ");

                    try {
                        int productNum = sc.nextInt();

                        if (productNum == 0) {
                            break;
                        }
                        if (productNum < 1 || productNum > products.size()) {
                            System.out.println("다시 입력해주세요.");
                            continue;
                        }
                        System.out.println(products.get(productNum - 1));
                    } catch (Exception e) {
                        System.out.println("다시 입력해주세요.");
                        sc.nextLine();
                    }
                }
            } catch (Exception e) {
                System.out.println("다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }
}
