package com.example.springsecurityapplication.controllers.api;

import com.example.springsecurityapplication.repositories.OrderShapkiRepository;
import com.example.springsecurityapplication.repositories.StatusesRepository;
import com.example.springsecurityapplication.services.PersonService;
import com.example.springsecurityapplication.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

////@CrossOrigin(origins = "http://localhost:3901")
@RestController
@RequestMapping("/api")
public class ApiAuthenticationController {
    private final PersonValidator personValidator;
    private final PersonService personService;

    @Autowired
    public ApiAuthenticationController(PersonValidator personValidator, PersonService personService) {
        this.personValidator = personValidator;
        this.personService = personService;
    }

//    ////// http://localhost:8202/api/all/orders/by_person/
//    @GetMapping("/all/orders/by_person/{id}")
//    public List getOrderShapkiByPersonId(@PathVariable("id") int person_id){
//        List orderShapkiList = orderShapkiRepository.findAllOrderByPersonId(person_id);
//        return orderShapkiList; // С помощью библиотеки Jackson конвертируем эти объекты в JSON
////        return productRepository.findAll(); // С помощью библиотеки Jackson конвертируем эти объекты в JSON
//    }

//    ////   http://localhost:3901/api/authentication/login
//    @PostMapping("authentication/login")
//    public String postAuthentication(@ModelAttribute("login") String login, @ModelAttribute("login") String login){
//        return  "Всё ок";
//    }



}
