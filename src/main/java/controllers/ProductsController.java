package controllers;


import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import services.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public void setStudentsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    // http://localhost:8189/app/products/showForm
    @RequestMapping(params = "/form", method = RequestMethod.GET)
    public String getForm(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product-form";//что именно мы здесь возвращаем
    }

    @RequestMapping(params = "/form", method = RequestMethod.POST)
    public String create(Product product, BindingResult bindingResult){
        if (!bindingResult.hasErrors()){
            productsService.addProductToRepository(product);
        }
        return "product-form";
    }
    // http://localhost:8189/app/products/getStudentById?id=20
    @RequestMapping(path="/getStudentById", method=RequestMethod.GET)
    @ResponseBody
    public Product getStudentById(@RequestParam Long id) {
        Product product = productsService.getProductById(id);
        return product;
    }

}
