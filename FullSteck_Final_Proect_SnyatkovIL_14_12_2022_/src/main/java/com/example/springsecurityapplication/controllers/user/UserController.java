package com.example.springsecurityapplication.controllers.user;

import com.example.springsecurityapplication.enumm.Status;
import com.example.springsecurityapplication.models.*;
import com.example.springsecurityapplication.repositories.CartRepository;
//import com.example.springsecurityapplication.repositories.OrderRepository;
import com.example.springsecurityapplication.repositories.OrderShapkiRepository;
import com.example.springsecurityapplication.repositories.StatusesRepository;
import com.example.springsecurityapplication.security.PersonDetails;
import com.example.springsecurityapplication.services.ProductService;
//////////////////////import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class UserController {

//    private final OrderRepository orderRepository;

    private final OrderShapkiRepository orderShapkiRepository;

    private final CartRepository cartRepository;

    private final ProductService productService;

    private final StatusesRepository statusesRepository;

    @Autowired
    public UserController(OrderShapkiRepository orderShapkiRepository, CartRepository cartRepository, ProductService productService, StatusesRepository statusesRepository){
//        this.orderRepository = orderRepository;
        this.orderShapkiRepository = orderShapkiRepository;
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.statusesRepository = statusesRepository;
    }

    @GetMapping("/index")
    public String index(Model model){

        // Получаем объект аутентификации - > с помощью Spring SecurityContextHolder обращаемся к контексту и на нем вызываем метод аутентификации.
        // Из потока для текущего пользователя мы получаем объект, который был положен в сессию после аутентификации
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        String role = personDetails.getPerson().getRole();
        if(role.equals("ROLE_ADMIN"))
        {
            return "redirect:/admin";
        }
//        System.out.println("ID пользователя: " + personDetails.getPerson().getId());
//        System.out.println("Логин пользователя: " + personDetails.getPerson().getLogin());
//        System.out.println("Пароль пользователя: " + personDetails.getPerson().getPassword());

        model.addAttribute("products", productService.getAllProduct());

        return "user/index";
    }

    @GetMapping("/logout")
    public String logout(){
        return "authentication/login";
    }

//    @GetMapping("/product")
//    public String getAllProduct(Model model){
//        model.addAttribute("products", productService.getAllProduct());
//        return "product/product";
//    }
//
//    @GetMapping("/product/info/{id}")
//    public String infoUser(@PathVariable("id") int id, Model model){
//        model.addAttribute("product", productService.getProductId(id));
//        return "product/infoProduct";
//    }

    @GetMapping("/cart/add/{id}")
    public String addProductInCart(@PathVariable("id") int id, Model model){
        Product product = productService.getProductId(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        int id_person = personDetails.getPerson().getId();
        Cart cart = new Cart(id_person, product.getId());
        cartRepository.save(cart);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cart(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        int id_person = personDetails.getPerson().getId();
        List<Cart> cartList = cartRepository.findByPersonId(id_person);
        List<Product> productsList = new ArrayList<>();
        for (Cart cart: cartList) {
            productsList.add(productService.getProductId(cart.getProductId()));
        }

        float price = 0;
        for (Product product: productsList) {
            price += product.getPrice();
        }
        model.addAttribute("price", price);
        model.addAttribute("cart_product", productsList);
        return "user/cart";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteProductCart(Model model, @PathVariable("id") int id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        int id_person = personDetails.getPerson().getId();
        cartRepository.deleteCartByProductId(id);
        return "redirect:/cart";
    }

    @GetMapping("/order/create")
    public String order(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        int id_person = personDetails.getPerson().getId();
        List<Cart> cartList = cartRepository.findByPersonId(id_person);
        List<Product> productsList = new ArrayList<>();
        if(cartList.size()>0) {
            // Получаем продукты из корзины по id
            for (Cart cart : cartList) {
                productsList.add(productService.getProductId(cart.getProductId()));
            }

            float price = 0;
            for (Product product : productsList) {
                price += product.getPrice();
            }

            String uuid = UUID.randomUUID().toString();
            System.out.println("заказ в номер " + uuid);

            ////Statuses prm_statusOrder = new Statuses();, Status.Получен
            ////int statuses_id = 1;
            Statuses prm_statusOrder = statusesRepository.findByName("Принят");

            OrderShapki newOrderShapki = new OrderShapki(uuid, uuid, personDetails.getPerson(), 1, price, prm_statusOrder);
            for (Product product : productsList) {
                OrderStroki newOrderStroki = new OrderStroki(newOrderShapki, product, 1, product.getPrice());
                newOrderShapki.addOrderStrokiToOrderShapki(newOrderStroki);
                cartRepository.deleteCartByProductId(product.getId());
            }
            orderShapkiRepository.save(newOrderShapki);

//            for (Product product : productsList) {
//                Order newOrder = new Order(uuid, product, personDetails.getPerson(), 1, product.getPrice(), Status.Получен);
//                orderRepository.save(newOrder);
//                cartRepository.deleteCartByProductId(product.getId());
//            }
            return "redirect:/orders";
        }else{
            return "redirect:/cart";
        }
    }

    @GetMapping("/orders")
    public String ordersUser(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

//        List<Order> orderList = orderRepository.findByPerson(personDetails.getPerson());
//        model.addAttribute("orders", orderList);

//        System.out.println("orderList = " + orderList);

        List<OrderShapki> orderShapkiList = orderShapkiRepository.findByPerson(personDetails.getPerson());
        model.addAttribute("ordersShapki", orderShapkiList);

        return "/user/orders";
    }

    @GetMapping("/infoOrder/{id}")
    public String infoOrderUser(Model model, @PathVariable("id") int id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        ////////List<Order> orderList = orderRepository.findByPerson(personDetails.getPerson());
        ////////model.addAttribute("orders", orderList);

        Optional<OrderShapki> orderShapka = orderShapkiRepository.findById(id);
        model.addAttribute("orderShapka", orderShapka);

        List<OrderStroki> orderStrokiList = orderShapka.get().getOrderStrokiList();
        model.addAttribute("orderStrokiList", orderStrokiList);

        return "/user/infoOrder";
    }


}
