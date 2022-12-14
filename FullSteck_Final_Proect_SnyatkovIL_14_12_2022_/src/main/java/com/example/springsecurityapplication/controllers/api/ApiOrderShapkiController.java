package com.example.springsecurityapplication.controllers.api;

import com.example.springsecurityapplication.models.OrderShapki;
import com.example.springsecurityapplication.models.Product;
import com.example.springsecurityapplication.repositories.OrderShapkiRepository;
import com.example.springsecurityapplication.repositories.StatusesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3901")
@RestController
@RequestMapping("/api")
public class ApiOrderShapkiController {
    private final OrderShapkiRepository orderShapkiRepository;

    private final StatusesRepository statusesRepository;

    public ApiOrderShapkiController(OrderShapkiRepository orderShapkiRepository, StatusesRepository statusesRepository) {
        this.orderShapkiRepository = orderShapkiRepository;
        this.statusesRepository = statusesRepository;
    }

    ////// http://localhost:8202/api/all/orders/by_person/
    @GetMapping("/all/orders/by_person/{id}")
    public List getOrderShapkiByPersonId(@PathVariable("id") int person_id){
        List orderShapkiList = orderShapkiRepository.findAllOrderByPersonId(person_id);
        return orderShapkiList; // С помощью библиотеки Jackson конвертируем эти объекты в JSON
//        return productRepository.findAll(); // С помощью библиотеки Jackson конвертируем эти объекты в JSON
    }

}
