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
    // 시작 메서드
    public void start() {
        while (true) {
            mainMenu();

            try {
                int categoryNum = sc.nextInt();
                int orderManagementNum = categories.size() + 1;

                if (categoryNum == 0) {
                    System.out.println("\n커머스 플랫폼을 종료합니다.");
                    return;
                } else if (categoryNum == (orderManagementNum)){
                    if (customer.getCart().isEmpty()) {
                        System.out.println("다시 입력해주세요");
                        continue;
                    } else {
                        checkCart();
                        continue;
                    }
                } else if (categoryNum == (orderManagementNum + 1)) {
                    if (customer.getCart().isEmpty()) {
                        System.out.println("다시 입력해주세요");
                        continue;
                    } else {
                        cancelOrder();
                        continue;
                    }
                }else if (categoryNum < 1 || categoryNum > categories.size()) {
                    System.out.println("다시 입력해주세요.");
                    continue;
                }
                Category selectCategory = categories.get(categoryNum - 1);
                productList(selectCategory);

            } catch (Exception e) {
                System.out.println("다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }

    // 플랫폼 메인 메서드
    public void mainMenu() {
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
    }

    // 카테고리 별 상품 목록 메서드
    public void productList(Category category) {
        List<Product> products = category.getProducts();

        while (true) {
            System.out.println("\n[ " + category.getCategoryName() + " 카테고리 ]");
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
                addProductToCart(products.get(productNum - 1));
                break;

            } catch (Exception e) {
                System.out.println("다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }

    // 장바구니 추가 메서드
    public void addProductToCart(Product product) {
        System.out.println("\n[ 선택한 상품 ]");
        System.out.println(product);
        System.out.println("\n위 상품을 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
        System.out.print("입력: ");
        while (true){
            try {
                int cartNum = sc.nextInt();

                if (cartNum == 1) {
                    if (product.getStock() == 0) {
                        System.out.println("\n" + product.getProductName() + "의 재고가 부족합니다.");
                        return;
                    }
                    customer.addToCart(product);
                    System.out.println("\n" + product.getProductName() + "이(가) 장바구니에 추가되었습니다.");
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
        }
    }

    // 장바구니 확인 메서드
    public void checkCart() {
        System.out.println("\n[ 장바구니 내역 ]");
        for (Cart cart : customer.getCart()) {
            System.out.println(cart);
        }
        System.out.println("\n[ 총 주문 금액 ]");
        int totalPrice = 0;
        for (Cart cart : customer.getCart()) {
            totalPrice += (cart.getProduct().getPrice() * cart.getQuantity());
        }
        System.out.printf("%,d원\n\n", totalPrice);
        System.out.println("위 상품들을 주문하시겠습니까?");
        System.out.println("1. 주문 확정    2. 메인으로 돌아가기");
        System.out.print("입력: ");
        while (true) {
            try {
                int orderNum = sc.nextInt();

                if (orderNum == 1) {
                    decideOrder();
                    break;
                } else if (orderNum == 2) {
                    break;
                } else {
                    System.out.println("다시 입력해주세요.");
                    sc.nextLine();
                }
            } catch (Exception e) {
                System.out.println("다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }

    // 주문 취소 메서드
    public void cancelOrder() {
        customer.setCart(new ArrayList<>());
        System.out.println("\n주문이 취소되었습니다.");

    }

    // 주문 확정 메서드
    public void decideOrder() {
        // 총 금액 계산 + 재고 수정
        int totalPrice = 0;
        for (Cart cart : customer.getCart()) {
            totalPrice += (cart.getProduct().getPrice() * cart.getQuantity());
        }
        System.out.printf("\n주문이 완료되었습니다! 총 금액: %,d원\n", totalPrice);

        for (Cart cart : customer.getCart()) {
            Product product = cart.getProduct();
            int quantity = cart.getQuantity();
            System.out.println(product.getProductName() + " 재고가 " +
                    product.getStock() + " → " + (product.getStock() - quantity) + "개로 업데이트 되었습니다.");
            product.setStock(product.getStock() - quantity);
        }
        customer.setCart(new ArrayList<>());
    }
}
