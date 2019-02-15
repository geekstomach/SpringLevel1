package services;


import entities.Product;
import repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product getProductById(Long id) {
        return productsRepository.findProductById(id);
    }
    
    public void addProductToRepository(Product product) {
        productsRepository.addProduct(product);
    }
}
