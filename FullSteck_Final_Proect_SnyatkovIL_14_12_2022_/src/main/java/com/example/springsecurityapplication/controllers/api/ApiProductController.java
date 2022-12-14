package com.example.springsecurityapplication.controllers.api;

import com.example.springsecurityapplication.models.Category;
import com.example.springsecurityapplication.models.Product;
import com.example.springsecurityapplication.repositories.CategoryRepository;
import com.example.springsecurityapplication.repositories.ProductRepository;
import com.example.springsecurityapplication.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

////@CrossOrigin(origins = "http://localhost:3901")
@RestController
@RequestMapping("/api")
public class ApiProductController {
    private final ProductRepository productRepository;
    private final ProductService productService;

    private final CategoryRepository categoryRepository;


    public ApiProductController(ProductRepository productRepository, ProductService productService, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }


    // Данный метод API позволяет узнать информацию об api
    ////@ResponseBody используем  //@RestController
    @GetMapping("/all/info")
    public String getinfoApi(){
        return "Данное API предназначено для работы с товарами";
    }

    ////// http://localhost:8202/api/all/products
    @GetMapping("/all/products")
    public List getProducts(){
//        return productService.getAllProduct(); // С помощью библиотеки Jackson конвертируем эти объекты в JSON
//        return productRepository.findAll(); // С помощью библиотеки Jackson конвертируем эти объекты в JSON
//        return productRepository.findByAll_VibKolonki(); // С помощью библиотеки Jackson конвертируем эти объекты в JSON

        return productRepository.findByAll_VibKolonki(); // С помощью библиотеки Jackson конвертируем эти объекты в JSON
    }

    ////// http://localhost:8202/api/all/product/search/
    @GetMapping("/all/product/search/{id}")
    public List getProductId(@PathVariable("id") int id){
        ////List rezt = productRepository.findByAll_VibKolonkiById(id);
        return productRepository.findiById_VibKolonk(id);
        //////return productRepository.findById(id);
    }

//    @GetMapping("/product/delete/{id}")
//    public String deleteProductId(@PathVariable("id") int id){
//        productRepository.deleteById(id);
//        return "Товар успешно удален";
//    }

//    @GetMapping("/product/add")
//    public String addProduct(@RequestParam("name") String name, @RequestParam("price") float price){
//        Product newProduct = new Product(name, price);
//        productRepository.save(newProduct);
//        return "Товар успешно добавлен";
//    }
//

    @GetMapping("/all/categories")
    public List getCategories(){
//        return productService.getAllProduct(); // С помощью библиотеки Jackson конвертируем эти объекты в JSON
//        return productRepository.findAll(); // С помощью библиотеки Jackson конвертируем эти объекты в JSON
        return categoryRepository.findAll(); // С помощью библиотеки Jackson конвертируем эти объекты в JSON
    }

//    @GetMapping("/all/orders")
//    public List getOrders(){
////        return productService.getAllProduct(); // С помощью библиотеки Jackson конвертируем эти объекты в JSON
////        return productRepository.findAll(); // С помощью библиотеки Jackson конвертируем эти объекты в JSON
//        return categoryRepository.findAll(); // С помощью библиотеки Jackson конвертируем эти объекты в JSON
//    }

//    @GetMapping("/orders")
//    public List<Product> getProducts(){
//        return productService.getAllProduct(); // С помощью библиотеки Jackson конвертируем эти объекты в JSON
////        return productRepository.findAll(); // С помощью библиотеки Jackson конвертируем эти объекты в JSON
//    }

}
