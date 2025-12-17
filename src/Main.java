import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 전자제품
        List<Product> electronics = new ArrayList<>();
        electronics.add(new Product("MacBook Pro", 2390000, "M5 칩셋 탑재, 성능과 효율 모두 잡은 프로 노트북", 10));
        electronics.add(new Product("iPhone 17", 1290000, "A19 칩셋과 향상된 카메라의 최신 스마트폰", 1));
        electronics.add(new Product("iPad Pro", 1599000, "M5 칩셋과 프로모션 디스플레이를 갖춘 태블릿", 20));
        electronics.add(new Product("AirPods Pro 3", 369000, "인이어 액티브 노이즈 캔슬링 무선 이어폰", 30));

        // 의류
        List<Product> clothes = new ArrayList<>();
        clothes.add(new Product("프리미엄 다운 패딩", 219000, "보온성이 뛰어난 다운 충전재의 겨울 아우터", 50));
        clothes.add(new Product("베이직 후드티", 79000, "탄탄한 원단과 편안한 핏의 데일리 후드티", 50));
        clothes.add(new Product("와이드 데님 팬츠", 99000, "여유로운 핏과 편안한 착용감의 데님 팬츠", 50));

        // 식품
        List<Product> foods = new ArrayList<>();
        foods.add(new Product("한우 등심 1++", 89000, "마블링이 뛰어난 최상급 한우 등심", 5));
        foods.add(new Product("유기농 우유", 4500, "무항생제 원유로 만든 신선한 우유", 20));
        foods.add(new Product("프리미엄 올리브오일", 32000, "저온 압착 방식의 엑스트라 버진 오일", 30));
        foods.add(new Product("벨기에 다크 초콜릿", 12000, "카카오 함량이 높은 깊은 풍미의 초콜릿", 5));
        foods.add(new Product("제주 감귤", 15000, "당도 높은 제주산 신선 감귤", 100));

        List<Category> categories = new ArrayList<>();
        categories.add(new Category("전자제품", electronics));
        categories.add(new Category("의류", clothes));
        categories.add(new Category("식품", foods));

        Customer customer = new Customer("Soomin", "soomin_0209@naver.com");
        CommerceSystem commerceSystem = new CommerceSystem(categories, customer);
        commerceSystem.start();
    }
}