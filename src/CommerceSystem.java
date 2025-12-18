import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    // 속성
    private List<Category> categories = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private Customer customer;
    private boolean returnToMain = false;

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
                int categoryChoice = sc.nextInt();
                int checkCartIndex = categories.size() + 1;
                int cancelOrderIndex = categories.size() + 2;
                int administratorModeIndex = categories.size() + 3;

                if (categoryChoice == 0) {
                    System.out.println("\n커머스 플랫폼을 종료합니다.");
                    return;
                } else if (categoryChoice == (checkCartIndex)){
                    if (customer.getCart().isEmpty()) {
                        System.out.println("\n다시 입력해주세요");
                        continue;
                    } else {
                        checkCart();
                        continue;
                    }
                } else if (categoryChoice == (cancelOrderIndex)) {
                    if (customer.getCart().isEmpty()) {
                        System.out.println("\n다시 입력해주세요");
                        continue;
                    } else {
                        cancelOrder();
                        continue;
                    }
                } else if (categoryChoice == (administratorModeIndex)) {
                    administratorMode();
                    continue;
                } else if (categoryChoice < 1 || categoryChoice > categories.size()) {
                    System.out.println("\n다시 입력해주세요.");
                    continue;
                }
                Category selectedCategory = categories.get(categoryChoice - 1);
                productList(selectedCategory);
            } catch (Exception e) {
                System.out.println("\n다시 입력해주세요.");
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
        System.out.println((categoryIndex + 2) + ". 관리자 모드");
        System.out.println("0. 종료");
        if(!customer.getCart().isEmpty()) {
            System.out.println("\n[ 주문 관리 ]");
            System.out.println((categoryIndex) + ". 장바구니 확인");
            System.out.println((categoryIndex + 1) + ". 주문 취소");
        }
        System.out.print("입력: ");
    }

    // 관리자 모드 메서드
    public void administratorMode() {
        int loginFailCount = 0;

        while (true) {
            System.out.print("\n관리자 비밀번호를 입력해주세요: ");
            String adminPw = sc.next();
            if (adminPw.equals("admin123")) {
                while (true) {
                    System.out.println("\n[ 관리자 모드 ]");
                    System.out.println("1. 상품 추가");
                    System.out.println("2. 상품 수정");
                    System.out.println("3. 상품 삭제");
                    System.out.println("4. 전체 상품 현황");
                    System.out.println("0. 메인으로 돌아가기");
                    System.out.print("입력: ");
                    try {
                        int adminMenuChoice = sc.nextInt();

                        if (adminMenuChoice == 0) {
                            return;
                        } else if (adminMenuChoice == 1) {
                            addProduct();
                        } else if (adminMenuChoice == 2) {
                            updateProduct();
                        } else if (adminMenuChoice == 3) {
                            deleteProduct();
                        } else if (adminMenuChoice == 4) {
                            viewAllProductsStatus();
                            if (returnToMain) {
                                returnToMain = false;
                                return;
                            }
                        } else {
                            System.out.println("\n다시 입력해주세요.");
                        }
                    } catch (Exception e) {
                        System.out.println("\n다시 입력해주세요.");
                        sc.nextLine();
                    }
                }
            } else {
                loginFailCount++;
                if (loginFailCount < 3) {
                    System.out.println("\n비밀번호가 일치하지 않습니다.");
                    System.out.println("3회 이상 실패 시 메인으로 돌아갑니다. (" + loginFailCount + "/3)");
                } else {
                    System.out.println("\n비밀번호를 3회 이상 잘못 입력하였습니다.");
                    System.out.println("메인으로 돌아갑니다.");
                    return;
                }
            }
        }
    }

    // 카테고리 별 상품 목록 메서드
    public void productList(Category category) {
        List<Product> products = category.getProducts();

        while (true) {
            System.out.println("\n[ " + category.getCategoryName() + " 카테고리 ]");
            int productIndex = 1;
            for (Product product : products) {
                System.out.println(productIndex + ". " + product.toStringWithoutStock());
                productIndex++;
            }
            System.out.println("0. 뒤로가기");
            System.out.print("입력: ");
            try {
                int productChoice = sc.nextInt();

                if (productChoice == 0) {
                    break;
                } else if (productChoice < 1 || productChoice > products.size()) {
                    System.out.println("\n다시 입력해주세요.");
                    continue;
                }
                addProductToCart(products.get(productChoice - 1));
                break;
            } catch (Exception e) {
                System.out.println("\n다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }

    // 장바구니 추가 메서드
    public void addProductToCart(Product product) {
        System.out.println("\n[ 선택한 상품 ]");
        System.out.println(product);
        while (true){
            System.out.println("\n위 상품을 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인       2. 취소");
            System.out.print("입력: ");
            try {
                int addToCartChoice = sc.nextInt();
                if (addToCartChoice == 1) {
                    if (product.getStock() == 0) {
                        System.out.println("\n" + product.getProductName() + "의 재고가 부족합니다.");
                        return;
                    }
                    customer.addToCart(product);
                    System.out.println("\n" + product.getProductName() + "이(가) 장바구니에 추가되었습니다.");
                    break;
                } else if (addToCartChoice == 2) {
                    System.out.println("\n취소하였습니다.");
                    break;
                } else {
                    System.out.println("\n다시 입력해주세요.");
                }
            } catch (Exception e) {
                System.out.println("\n다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }

    // 장바구니 확인 메서드
    public void checkCart() {
        System.out.println("\n[ 장바구니 내역 ]");
        for (Cart cartItem : customer.getCart()) {
            System.out.println(cartItem);
        }
        System.out.println("\n[ 총 주문 금액 ]");
        int totalPrice = 0;
        for (Cart cartItem : customer.getCart()) {
            totalPrice += (cartItem.getProduct().getPrice() * cartItem.getQuantity());
        }
        System.out.printf("%,d원\n", totalPrice);
        while (true) {
            System.out.println("\n위 상품들을 주문하시겠습니까?");
            System.out.println("1. 주문 확정    2. 메인으로 돌아가기");
            System.out.print("입력: ");
            try {
                int confirmOrderChoice = sc.nextInt();

                if (confirmOrderChoice == 1) {
                    confirmOrder();
                    break;
                } else if (confirmOrderChoice == 2) {
                    break;
                } else {
                    System.out.println("\n다시 입력해주세요.");
                }
            } catch (Exception e) {
                System.out.println("\n다시 입력해주세요.");
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
    public void confirmOrder() {
        while (true) {
            System.out.println("\n고객 등급을 입력해주세요.");
            Grade[] grades = Grade.values();
            int gradeIndex = 1;
            for (Grade grade : grades) {
                System.out.printf("%d. %-8s : %2d%% 할인\n", gradeIndex, grade.name(), grade.getDiscountPercent());
                gradeIndex++;
            }
            System.out.print("입력: ");
            try {
                int gradeChoice = sc.nextInt();
                if (gradeChoice >= 1 && gradeChoice <= grades.length) {
                    Grade selectedGrade = grades[gradeChoice - 1];
                    int totalPrice = 0;
                    for (Cart cartItem : customer.getCart()) {
                        totalPrice += (cartItem.getProduct().getPrice() * cartItem.getQuantity());
                    }
                    int discountedPrice = selectedGrade.discount(totalPrice);   // 할인 금액
                    int discountedTotalPrice = totalPrice - discountedPrice;    // 최종 금액
                    System.out.println("\n주문이 완료되었습니다!");
                    System.out.printf("할인 전 금액: %,d원\n", totalPrice);
                    System.out.printf("%s 등급 할인(%d%%): -%,d원\n", selectedGrade.name(), selectedGrade.getDiscountPercent(), discountedPrice);
                    System.out.printf("최종 결제 금액: %,d원\n", discountedTotalPrice);
                    for (Cart cartItem : customer.getCart()) {
                        Product product = cartItem.getProduct();
                        int quantity = cartItem.getQuantity();
                        System.out.println(product.getProductName() + " 재고가 " +
                                product.getStock() + " → " + (product.getStock() - quantity) + "개로 업데이트 되었습니다.");
                        product.setStock(product.getStock() - quantity);
                    }
                    customer.setCart(new ArrayList<>());
                    break;
                } else {
                    System.out.println("\n다시 입력해주세요.");
                }
            } catch (Exception e) {
                System.out.println("\n다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }

    // 상품 추가 메서드
    public void addProduct() {
        while (true) {
            System.out.println("\n어느 카테고리에 상품을 추가하시겠습니까?");
            int categoryIndex = 1;
            for (Category category : categories) {
                System.out.println(categoryIndex + ". " + category.getCategoryName());
                categoryIndex++;
            }
            System.out.print("입력: ");
            try {
                int adminCategoryChoice = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기
                if (adminCategoryChoice < 1 || adminCategoryChoice > categories.size()) {
                    System.out.println("\n다시 입력해주세요.");
                    continue;
                }
                Category selectedCategory = categories.get(adminCategoryChoice - 1);
                System.out.println("\n[ " + selectedCategory.getCategoryName() + " 카테고리에 상품 추가 ]");
                System.out.print("상품명을 입력해주세요: ");
                String newProductName = sc.nextLine();
                for (Category category : categories) {
                    for (Product product : category.getProducts()) {
                        if (product.getProductName().equals(newProductName)) {
                            System.out.println("\n이미 동일한 상품이 존재합니다.");
                            return;
                        }
                    }
                }
                int newProductPrice = 0;
                while (true) {
                    System.out.print("가격을 입력해주세요: ");
                    try {
                        newProductPrice = sc.nextInt();
                        sc.nextLine(); // 버퍼 비우기
                        break;
                    } catch (Exception e) {
                        System.out.println("\n다시 입력해주세요.\n");
                        sc.nextLine();
                    }
                }
                System.out.print("상품 설명을 입력해주세요: ");
                String newProductDescription = sc.nextLine();
                int newProductStock = 0;
                while (true) {
                    System.out.print("재고수량을 입력해주세요: ");
                    try {
                        newProductStock = sc.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("\n다시 입력해주세요.\n");
                        sc.nextLine();
                    }
                }
                System.out.printf("\n%-15s | %,10d원 | %-20s | %3d개", newProductName, newProductPrice, newProductDescription, newProductStock);
                System.out.println("\n위 정보로 상품을 추가하시겠습니까?");
                System.out.println("1. 확인   2. 취소");
                while (true) {
                    System.out.print("입력: ");
                    try {
                        int confirmAddProductChoice = sc.nextInt();
                        if (confirmAddProductChoice == 1) {
                            Product newProduct = new Product(newProductName, newProductPrice, newProductDescription, newProductStock);
                            selectedCategory.getProducts().add(newProduct);
                            System.out.println("\n상품이 성공적으로 추가되었습니다!");
                            break;
                        } else if (confirmAddProductChoice == 2) {
                            System.out.println("\n취소하였습니다.");
                            break;
                        } else {
                            System.out.println("\n다시 입력해주세요.");
                        }
                    } catch (Exception e) {
                        System.out.println("\n다시 입력해주세요.");
                        sc.nextLine();
                    }
                }
                return;
            } catch (Exception e) {
                System.out.println("\n다시 입력해주세요.");
                sc.nextLine();
            }
        }
    }

    // 상품 수정 메서드
    public void updateProduct() {
        System.out.print("\n수정할 상품명을 입력해주세요: ");
        sc.nextLine(); // 버퍼 비우기
        String updateProductName = sc.nextLine();
        for (Category category : categories) {
            for (Product product : category.getProducts()) {
                if (product.getProductName().equals(updateProductName)) {
                    System.out.println("현재 상품 정보: " + product);
                    while (true) {
                        System.out.println("\n수정할 항목을 선택해주세요: ");
                        System.out.println("1. 가격");
                        System.out.println("2. 설명");
                        System.out.println("3. 재고수량");
                        System.out.print("입력: ");
                        try {
                            int updateItemChoice = sc.nextInt();
                            if (updateItemChoice == 1) {
                                System.out.printf("\n현재 가격: %,d원\n", product.getPrice());
                                while (true) {
                                    System.out.print("새로운 가격을 입력해주세요: ");
                                    try {
                                        int newProductPrice = sc.nextInt();
                                        System.out.printf("\n%s의 가격이 %,d원 → %,d원으로 수정되었습니다.\n",
                                                product.getProductName(), product.getPrice(), newProductPrice);
                                        product.setPrice(newProductPrice);
                                        return;
                                    }catch (Exception e) {
                                        System.out.println("\n다시 입력해주세요.\n");
                                        sc.nextLine();
                                    }
                                }
                            } else if (updateItemChoice == 2) {
                                System.out.println("\n현재 설명 : " + product.getDescription());
                                System.out.print("새로운 설명을 입력해주세요: ");
                                sc.nextLine();  // 버퍼 지우기
                                String newProductDescription = sc.nextLine();
                                System.out.printf("\n%s의 설명이 '%s' → '%s'(으)로 수정되었습니다.\n",
                                        product.getProductName(), product.getDescription(), newProductDescription);
                                product.setDescription(newProductDescription);
                                return;
                            } else if (updateItemChoice == 3) {
                                System.out.println("\n현재 재고수량: " + product.getStock() + "개");
                                while (true) {
                                    System.out.print("새로운 재고수량을 입력해주세요: ");
                                    try {
                                        int newProductStock = sc.nextInt();
                                        System.out.printf("\n%s의 재고수량이 %d개 → %d개로 수정되었습니다.\n",
                                                product.getProductName(), product.getStock(), newProductStock);
                                        product.setStock(newProductStock);
                                        return;
                                    }catch (Exception e) {
                                        System.out.println("\n다시 입력해주세요.\n");
                                        sc.nextLine();
                                    }
                                }
                            } else {
                                System.out.println("\n다시 입력해주세요.");
                            }
                        }catch (Exception e) {
                            System.out.println("\n다시 입력해주세요.");
                            sc.nextLine();
                        }
                    }
                }
            }
        }
        System.out.println("\n해당 상품이 존재하지 않습니다.");
    }

    public void deleteProduct() {
        System.out.print("\n삭제할 상품명을 입력해주세요: ");
        sc.nextLine(); // 버퍼 지우기
        String deleteProductName = sc.nextLine();
        for (Category category : categories) {
            for (Product product : category.getProducts()) {
                if (product.getProductName().equals(deleteProductName)) {
                    System.out.println("\n현재 상품 정보: " + product);
                    while (true) {
                        System.out.println("\n위 상품을 정말 삭제하시겠습니까?");
                        System.out.println("1. 확인   2. 취소");
                        System.out.print("입력: ");
                        try {
                            int confirmDeleteProductChoice = sc.nextInt();

                            if (confirmDeleteProductChoice == 1) {
                                System.out.println("\n" + product.getProductName() + "이(가) 성공적으로 삭제되었습니다!");
                                category.getProducts().remove(product);
                                customer.getCart().removeIf(cartItem -> cartItem.getProduct().equals(product)); // 장바구니에서도 삭제
                                return;
                            } else if (confirmDeleteProductChoice == 2) {
                                System.out.println("\n취소하였습니다.");
                                return;
                            } else {
                                System.out.println("\n다시 입력해주세요.");
                            }
                        } catch (Exception e) {
                            System.out.println("\n다시 입력해주세요.");
                            sc.nextLine();
                        }
                    }
                }
            }
        }
        System.out.println("\n해당 상품이 존재하지 않습니다.");
    }

    public void viewAllProductsStatus() {
        System.out.println("\n[ 전체 상품 현황 ]");
        for (Category category : categories){
            List<Product> products = category.getProducts();
            System.out.println("=== " + category.getCategoryName() + " ===");
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.println();
        }
        while (true) {
            System.out.println("1. 관리자 메뉴로 돌아가기");
            System.out.println("2. 메인으로 돌아가기");
            System.out.print("입력: ");
            try {
                int backChoice = sc.nextInt();
                if (backChoice == 1) {
                    return;
                } else if (backChoice == 2) {
                    returnToMain = true;
                    return;
                } else {
                    System.out.println("\n다시 입력해주세요.\n");
                }
            } catch (Exception e) {
                System.out.println("\n다시 입력해주세요.\n");
                sc.nextLine();
            }
        }
    }
}
