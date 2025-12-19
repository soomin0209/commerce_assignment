import java.util.ArrayList;
import java.util.List;

public class Category {

    // 속성
    private String categoryName;
    private List<Product> products = new ArrayList<>();

    // 생성자
    public Category(String categoryName, List<Product> products) {
        this.categoryName = categoryName;
        this.products = new ArrayList<>(products);  // 복사본 저장
    }

    // Getter
    public String getCategoryName() {
        return categoryName;
    }

    // 캡슐화를 위해 복사본 반환
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}
