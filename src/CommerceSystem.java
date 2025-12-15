import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private List<Category> categories = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

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
                switch (categoryNum) {
                    case 1:
                        List<Product> electronics = categories.get(0).getProducts();

                        System.out.println(categories.get(0).getCategoryName() + " 카테고리");
                        int productIndex = 1;
                        for (Product electronic : electronics) {
                            System.out.println(productIndex + ". " + electronic);
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
                                switch (productNum) {
                                    case 1:
                                        System.out.println(electronics.get(0));
                                        break;
                                    case 2:
                                        System.out.println(electronics.get(1));
                                        break;
                                    case 3:
                                        System.out.println(electronics.get(2));
                                        break;
                                    case 4:
                                        System.out.println(electronics.get(3));
                                        break;
                                    default:
                                        System.out.println("다시 입력해주세요.");
                                }
                            } catch (Exception e) {
                                System.out.println("다시 입력해주세요.");
                                sc.nextLine();
                            }
                        }
                        break;
                    case 2:
                        System.out.println(categories.get(1));
                        break;
                    case 3:
                        System.out.println(categories.get(2));
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
