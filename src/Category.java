import java.util.ArrayList;
import java.util.List;

public class Category {

    // 속성
    private String categoryName;
    private List<Product> products = new ArrayList<>();

    // 생성자
    public Category(String categoryName, List<Product> products) {
        this.categoryName = categoryName;
        this.products = products;
    }

    // Getter
    public String getCategoryName() {
        return categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }
}
