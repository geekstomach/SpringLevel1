package repositories;


import entities.Product;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsRepository {
    private List<Product> products;

    public ProductsRepository() {
      products = new ArrayList<>();
      products.add(new Product(1L,"Taburet1",BigDecimal.valueOf(Math.random()*100)));
      products.add(new Product(2L,"Taburet2",BigDecimal.valueOf(Math.random()*100)));
      products.add(new Product(3L,"Taburet3",BigDecimal.valueOf(Math.random()*100)));
      products.add(new Product(4L,"Taburet4",BigDecimal.valueOf(Math.random()*100)));

  }



    public Product findProductById(Long id) {
        for (Product p: products
             ) {
if (p.getId().equals(id))return p;
        }
        return null;
    }
    public List<Product> showAllProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
    this.products.add(product);
    }
}