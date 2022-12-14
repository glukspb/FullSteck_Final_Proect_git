package com.example.springsecurityapplication.controllers;

import com.example.springsecurityapplication.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ControlerNeRegVhoda {
    private final ProductService productService;

    public ControlerNeRegVhoda(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String getAllProduct_DlyaVseh(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "product/product";
    }

}
