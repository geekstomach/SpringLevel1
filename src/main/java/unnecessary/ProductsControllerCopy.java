package controllers;


import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping("/showForm")
    public String showSimpleForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-form";
    }

    // http://localhost:8189/app/products/processForm
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        System.out.println(product.getTitle() + " " + product.getCost());
        return "product-form-result";
    }
    
    // http://localhost:8189/app/students/showStudentById?id=5
    @RequestMapping(path="/showStudentById", method= RequestMethod.GET)
    public String showStudentById(Model model, @RequestParam Long id) {
        Product student = studentsService.getStudentById(id);
        model.addAttribute("student", student);
        return "student-form-result";
    }

    // http://localhost:8189/app/students/getStudentById?id=20
    @RequestMapping(path="/getStudentById", method= RequestMethod.GET)
    @ResponseBody
    public Student getStudentById(@RequestParam Long id) {
        Student student = studentsService.getStudentById(id);
        return student;
    }

    // http://localhost:8189/app/students/getStudentById/10
    @RequestMapping(path="/getStudentById/{sid}", method= RequestMethod.GET)
    @ResponseBody
    public Student getStudentByIdFromPath(@PathVariable("sid") Long id) {
        Student student = studentsService.getStudentById(id);
        return student;
    }

    // ну, я уже второй раз прохожу этот курс и у меня возникает ощущение ,
    // что Spring много чего может, но...пока все скрыто в коробке
}
