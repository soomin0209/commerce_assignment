import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    // 속성
    private List<Category> categories = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private Customer customer;

    // 생성자
    public CommerceSystem(List<Category> categories, Customer customer) {
        this.categories = categories;
        this.customer = customer;
    }

    // 기능
    public void start() {
        while (true) {
            System.out.println("\n[ 실시간 커머스 플랫폼 메인 ]");
            int categoryIndex = 1;
            for (Category category : categories) {
                System.out.println(categoryIndex + ". " + category.getCategoryName());
                categoryIndex++;
            }
            System.out.println("0. 종료");
            if(!customer.getCart().isEmpty()) {
                System.out.println("\n[ 주문 관리 ]");
                System.out.println((categoryIndex) + ". 장바구니 확인");
                System.out.println((categoryIndex + 1) + ". 주문 취소");
            }
            System.out.print("입력: ");

            try {
                int categoryNum = sc.nextInt();

                if (categoryNum == 0) {
                    System.out.println("\n커머스 플랫폼을 종료합니다.");
                    return;
                } else if (categoryNum == (categoryIndex)){
                    if (customer.getCart().isEmpty()) {
                        System.out.println("다시 입력해주세요");
                        continue;
                    } else {
                        System.out.println("장바구니 확인 !!!!");
                        continue;
                    }
                } else if (categoryNum == (categoryIndex + 1)) {
                    if (customer.getCart().isEmpty()) {
                        System.out.println("다시 입력해주세요");
                        continue;
                    } else {
                        System.out.println("주문 취소 !!!!");
                        continue;
                    }
                }else if (categoryNum < 1 || categoryNum > categories.size()) {
                    System.out.println("다시 입력해주세요.");
                    continue;
                }

                Category selectCategory = categories.get(categoryNum - 1);
                List<Product> products = selectCategory.getProducts();

                while (true) {
                    System.out.println("\n[ " + selectCategory.getCategoryName() + " 카테고리 ]");
                    int productIndex = 1;
                    for (Product product : products) {
                        System.out.println(productIndex + ". " + product);
                        productIndex++;
                    }
                    System.out.println("0. 뒤로가기");
                    System.out.print("입력: ");

                    try {
                        int productNum = sc.nextInt();

                        if (productNum == 0) {
                            break;
                        } else if (productNum < 1 || productNum > products.size()) {
                            System.out.println("다시 입력해주세요.");
                            continue;
                        }
                        System.out.println("\n[ " + products.get(productNum - 1) + " ]");
                        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
                        System.out.println("1. 확인       2. 취소");
                        System.out.print("입력: ");
                        try {
                            int cartNum = sc.nextInt();

                            if (cartNum == 1) {
                                if (products.get(productNum - 1).getStock() == 0) {
                                    System.out.println("\n" + products.get(productNum - 1).getProductName() + "의 재고가 부족합니다.");
                                    break;
                                }
                                customer.addToCart(products.get(productNum - 1));
                                System.out.println("\n" + products.get(productNum - 1).getProductName() + "이(가) 장바구니에 추가되었습니다.");
                                break;
                            } else if (cartNum == 2) {
                                System.out.println("\n취소하였습니다.");
                                break;
                            } else {
                                System.out.println("다시 입력해주세요.");
                                sc.nextLine();
                            }
                        } catch (Exception e) {
                            System.out.println("다시 입력해주세요.");
                            sc.nextLine();
                        }
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
