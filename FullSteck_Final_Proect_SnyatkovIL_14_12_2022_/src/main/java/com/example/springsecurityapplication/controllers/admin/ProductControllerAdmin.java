package com.example.springsecurityapplication.controllers.admin;

import com.example.springsecurityapplication.repositories.ProductRepository;
import com.example.springsecurityapplication.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/product")
public class ProductControllerAdmin {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @Autowired
    public ProductControllerAdmin(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }


    //    @GetMapping("/product")
//    public String products(){
//        return "product/product";
//    }

    @GetMapping("")
    public String getAllProduct(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "product/product";
    }

    @GetMapping("/info/{id}")
    public String infoUser(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getProductId(id));
        return "product/infoProduct";
    }

    @PostMapping("/search")
    public String productSearch(@RequestParam("search") String search, @RequestParam("ot") String ot, @RequestParam("do") String Do, @RequestParam(value = "price", required = false, defaultValue = "")String price, @RequestParam(value = "contact", required = false, defaultValue = "")String contact, Model model) {
//        if (!ot.isEmpty() & !Do.isEmpty())
//        {
//            if(!price.isEmpty())
//            {
//                if(price.equals("sorted_by_ascending_price"))
//                {
//                    if(contact.equals("furniture")){
//                        model.addAttribute("search_product", productRepository.findByTitleAndCategoryOrderByOtDoPriceAsc(search.toLowerCase(), Float.parseFloat(ot), Float.parseFloat(Do), 1));
//                    }
//                    else if(contact.equals("appliances")){
//                        model.addAttribute("search_product", productRepository.findByTitleAndCategoryOrderByOtDoPriceAsc(search.toLowerCase(), Float.parseFloat(ot), Float.parseFloat(Do), 2));
//                    }
//                    else if(contact.equals("clothes")){
//                        model.addAttribute("search_product", productRepository.findByTitleAndCategoryOrderByOtDoPriceAsc(search.toLowerCase(), Float.parseFloat(ot), Float.parseFloat(Do), 3));
//                    }
//                    else if(contact.equals("processors")){
//                        model.addAttribute("search_product", productRepository.findByTitleAndCategoryOrderByOtDoPriceAsc(search.toLowerCase(), Float.parseFloat(ot), Float.parseFloat(Do), 4));
//                    }
//                }
//                else if (price.equals("sorted_by_descending_price"))
//                {
//                    if(!contact.isEmpty())
//                    {
//                        if(contact.equals("furniture")){
//                            model.addAttribute("search_product", productRepository.findByTitleAndCategoryOrderByOtDoPriceDesc(search.toLowerCase(), Float.parseFloat(ot), Float.parseFloat(Do), 1));
//                        }
//                        else if(contact.equals("appliances")){
//                            model.addAttribute("search_product", productRepository.findByTitleAndCategoryOrderByOtDoPriceDesc(search.toLowerCase(), Float.parseFloat(ot), Float.parseFloat(Do), 2));
//                        }
//                        else if(contact.equals("clothes")){
//                            model.addAttribute("search_product", productRepository.findByTitleAndCategoryOrderByOtDoPriceDesc(search.toLowerCase(), Float.parseFloat(ot), Float.parseFloat(Do), 3));
//                        }
//                        else if(contact.equals("processors")){
//                            model.addAttribute("search_product", productRepository.findByTitleAndCategoryOrderByOtDoPriceDesc(search.toLowerCase(), Float.parseFloat(ot), Float.parseFloat(Do), 4));
//                        }
//                    }
//                }
//            }
//            else {
//                model.addAttribute("search_product", productRepository.findByTitleAndPriceGreaterThanEqualAndPriceLessThanEqual(search, Float.parseFloat(ot), Float.parseFloat(Do)));
//            }
//        }
//        else
        if(!price.isEmpty() & search.isEmpty())
        {
            if(ot.isEmpty() & Do.isEmpty())
            {
                System.out.println("ot.isEmpty() & Do.isEmpty()");
                System.out.println("contact = " + contact);
                if(price.equals("sorted_by_ascending_price"))
                {
                    System.out.println("sorted_by_ascending_price");
                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByCategoryOrderByPriceAsc(1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByCategoryOrderByPriceAsc(2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByCategoryOrderByPriceAsc(3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByCategoryOrderByPriceAsc(4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("!price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.findOrderByPriceAsc());
                    }
                }
                else if (price.equals("sorted_by_descending_price"))
                {
                    System.out.println("sorted_by_descending_price");
                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByCategoryOrderByPriceDesc(1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByCategoryOrderByPriceDesc(2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByCategoryOrderByPriceDesc(3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByCategoryOrderByPriceDesc(4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("!price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.findOrderByPriceDesc());
                    }
                }
            }
            if(!ot.isEmpty() & Do.isEmpty())
            {
                System.out.println("!ot.isEmpty() & Do.isEmpty()");
                System.out.println("contact = " + contact);
                if(price.equals("sorted_by_ascending_price"))
                {
                    System.out.println("sorted_by_ascending_price");
                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndOtOrderByPriceAsc(Float.parseFloat(ot),1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndOtOrderByPriceAsc(Float.parseFloat(ot),2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndOtOrderByPriceAsc(Float.parseFloat(ot),3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndOtOrderByPriceAsc(Float.parseFloat(ot),4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("!price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.findOtOrderByPriceAsc(Float.parseFloat(ot)));
                    }
                }
                else if (price.equals("sorted_by_descending_price"))
                {
                    System.out.println("sorted_by_descending_price");
                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndOtOrderByPriceDesc(Float.parseFloat(ot),1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndOtOrderByPriceDesc(Float.parseFloat(ot),2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndOtOrderByPriceDesc(Float.parseFloat(ot),3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndOtOrderByPriceDesc(Float.parseFloat(ot),4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("!price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.findOtOrderByPriceDesc(Float.parseFloat(ot)));
                    }
                }
            }
            if(ot.isEmpty() & !Do.isEmpty())
            {
                System.out.println("!ot.isEmpty() & Do.isEmpty()");
                System.out.println("contact = " + contact);
                if(price.equals("sorted_by_ascending_price"))
                {
                    System.out.println("sorted_by_ascending_price");
                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndDoOrderByPriceAsc(Float.parseFloat(Do),1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndDoOrderByPriceAsc(Float.parseFloat(Do),2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndDoOrderByPriceAsc(Float.parseFloat(Do),3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndDoOrderByPriceAsc(Float.parseFloat(Do),4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("!price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.findDoOrderByPriceAsc(Float.parseFloat(Do)));
                    }
                }
                else if (price.equals("sorted_by_descending_price"))
                {
                    System.out.println("sorted_by_descending_price");
                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndDoOrderByPriceDesc(Float.parseFloat(Do),1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndDoOrderByPriceDesc(Float.parseFloat(Do),2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndDoOrderByPriceDesc(Float.parseFloat(Do),3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndDoOrderByPriceDesc(Float.parseFloat(Do),4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("!price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.findDoOrderByPriceDesc(Float.parseFloat(Do)));
                    }
                }
            }
        }
        else
        if(price.isEmpty() & search.isEmpty())
        {
            if(ot.isEmpty() & Do.isEmpty())
            {
                System.out.println("ot.isEmpty() & Do.isEmpty()");
                System.out.println("contact = " + contact);

                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByCategory(1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByCategory(2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByCategory(3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByCategory(4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.find());
                    }
            }
            if(!ot.isEmpty() & Do.isEmpty())
            {
                System.out.println("!ot.isEmpty() & Do.isEmpty()");
                System.out.println("contact = " + contact);

                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndOt(Float.parseFloat(ot),1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndOt(Float.parseFloat(ot),2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndOt(Float.parseFloat(ot),3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndOt(Float.parseFloat(ot),4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.findOt(Float.parseFloat(ot)));
                    }
            }
            if(ot.isEmpty() & !Do.isEmpty())
            {
                System.out.println("!ot.isEmpty() & Do.isEmpty()");
                System.out.println("contact = " + contact);

                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndDo(Float.parseFloat(Do),1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndDo(Float.parseFloat(Do),2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndDo(Float.parseFloat(Do),3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByCategoryAndDo(Float.parseFloat(Do),4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.findDo(Float.parseFloat(Do)));
                    }
            }
        }
        ///////////////----------
        ///////////////----------
        ///////////////----------

        ///////////////----------
        ///////////////----------
        ///////////////----------
        else
        if(!search.isEmpty() & !price.isEmpty())
        {
            if(ot.isEmpty() & Do.isEmpty())
            {
                System.out.println("ot.isEmpty() & Do.isEmpty()");
                System.out.println("contact = " + contact);
                if(price.equals("sorted_by_ascending_price"))
                {
                    System.out.println("sorted_by_ascending_price");
                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryOrderByPriceAsc(search.toLowerCase(), 1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryOrderByPriceAsc(search.toLowerCase(), 2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryOrderByPriceAsc(search.toLowerCase(), 3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryOrderByPriceAsc(search.toLowerCase(), 4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("!price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.findByTitleAndOrderByPriceAsc(search.toLowerCase()));
                    }
                }
                else if (price.equals("sorted_by_descending_price"))
                {
                    System.out.println("sorted_by_descending_price");
                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryOrderByPriceDesc(search.toLowerCase(), 1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryOrderByPriceDesc(search.toLowerCase(), 2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryOrderByPriceDesc(search.toLowerCase(), 3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryOrderByPriceDesc(search.toLowerCase(), 4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("!price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.findByTitleAndOrderByPriceDesc(search.toLowerCase()));
                    }
                }
            }
            if(!ot.isEmpty() & Do.isEmpty())
            {
                System.out.println("!ot.isEmpty() & Do.isEmpty()");
                System.out.println("contact = " + contact);
                if(price.equals("sorted_by_ascending_price"))
                {
                    System.out.println("sorted_by_ascending_price");
                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndOtOrderByPriceAsc(search.toLowerCase(), Float.parseFloat(ot),1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndOtOrderByPriceAsc(search.toLowerCase(), Float.parseFloat(ot),2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndOtOrderByPriceAsc(search.toLowerCase(), Float.parseFloat(ot),3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndOtOrderByPriceAsc(search.toLowerCase(), Float.parseFloat(ot),4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("!price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.findByTitleAndOtOrderByPriceAsc(search.toLowerCase(), Float.parseFloat(ot)));
                    }
                }
                else if (price.equals("sorted_by_descending_price"))
                {
                    System.out.println("sorted_by_descending_price");
                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndOtOrderByPriceDesc(search.toLowerCase(), Float.parseFloat(ot),1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndOtOrderByPriceDesc(search.toLowerCase(), Float.parseFloat(ot),2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndOtOrderByPriceDesc(search.toLowerCase(), Float.parseFloat(ot),3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndOtOrderByPriceDesc(search.toLowerCase(), Float.parseFloat(ot),4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("!price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.findByTitleAndOtOrderByPriceDesc(search.toLowerCase(), Float.parseFloat(ot)));
                    }
                }
            }
            if(ot.isEmpty() & !Do.isEmpty())
            {
                System.out.println("!ot.isEmpty() & Do.isEmpty()");
                System.out.println("contact = " + contact);
                if(price.equals("sorted_by_ascending_price"))
                {
                    System.out.println("sorted_by_ascending_price");
                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndDoOrderByPriceAsc(search.toLowerCase(), Float.parseFloat(Do),1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndDoOrderByPriceAsc(search.toLowerCase(), Float.parseFloat(Do),2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndDoOrderByPriceAsc(search.toLowerCase(), Float.parseFloat(Do),3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndDoOrderByPriceAsc(search.toLowerCase(), Float.parseFloat(Do),4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("!price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.findByTitleAndDoOrderByPriceAsc(search.toLowerCase(), Float.parseFloat(Do)));
                    }
                }
                else if (price.equals("sorted_by_descending_price"))
                {
                    System.out.println("sorted_by_descending_price");
                    if(contact.equals("furniture")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndDoOrderByPriceDesc(search.toLowerCase(), Float.parseFloat(Do),1));
                    }
                    else if(contact.equals("appliances")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndDoOrderByPriceDesc(search.toLowerCase(), Float.parseFloat(Do),2));
                    }
                    else if(contact.equals("clothes")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndDoOrderByPriceDesc(search.toLowerCase(), Float.parseFloat(Do),3));
                    }
                    else if(contact.equals("processors")){
                        model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndDoOrderByPriceDesc(search.toLowerCase(), Float.parseFloat(Do),4));
                    }
                    else if(contact.isEmpty())
                    {
                        System.out.println("!price.isEmpty() && contact.isEmpty()");
                        model.addAttribute("search_product", productRepository.findByTitleAndDoOrderByPriceDesc(search.toLowerCase(), Float.parseFloat(Do)));
                    }
                }
            }
        }
        else
        if(!search.isEmpty() & price.isEmpty())
        {
            System.out.println("search = " + search);
            if(ot.isEmpty() & Do.isEmpty())
            {
                System.out.println("ot.isEmpty() & Do.isEmpty()");
                System.out.println("contact = " + contact);

                if(contact.equals("furniture")){
                    model.addAttribute("search_product", productRepository.findByTitleAndByCategory(search.toLowerCase(), 1));
                }
                else if(contact.equals("appliances")){
                    model.addAttribute("search_product", productRepository.findByTitleAndByCategory(search.toLowerCase(), 2));
                }
                else if(contact.equals("clothes")){
                    model.addAttribute("search_product", productRepository.findByTitleAndByCategory(search.toLowerCase(), 3));
                }
                else if(contact.equals("processors")){
                    model.addAttribute("search_product", productRepository.findByTitleAndByCategory(search.toLowerCase(), 4));
                }
                else if(contact.isEmpty())
                {
                    System.out.println("price.isEmpty() && contact.isEmpty()    findByTitleAnd");
                    model.addAttribute("search_product", productRepository.findByTitleAnd(search.toLowerCase()));
                }
            }
            if(!ot.isEmpty() & Do.isEmpty())
            {
                System.out.println("!ot.isEmpty() & Do.isEmpty()");
                System.out.println("contact = " + contact);

                if(contact.equals("furniture")){
                    model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndOt(search.toLowerCase(), Float.parseFloat(ot),1));
                }
                else if(contact.equals("appliances")){
                    model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndOt(search.toLowerCase(), Float.parseFloat(ot),2));
                }
                else if(contact.equals("clothes")){
                    model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndOt(search.toLowerCase(), Float.parseFloat(ot),3));
                }
                else if(contact.equals("processors")){
                    model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndOt(search.toLowerCase(), Float.parseFloat(ot),4));
                }
                else if(contact.isEmpty())
                {
                    System.out.println("price.isEmpty() && contact.isEmpty()    findByTitleAndOt");
                    model.addAttribute("search_product", productRepository.findByTitleAndOt(search.toLowerCase(), Float.parseFloat(ot)));
                }
            }
            if(ot.isEmpty() & !Do.isEmpty())
            {
                System.out.println("!ot.isEmpty() & Do.isEmpty()");
                System.out.println("contact = " + contact);

                if(contact.equals("furniture")){
                    model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndDo(search.toLowerCase(), Float.parseFloat(Do),1));
                }
                else if(contact.equals("appliances")){
                    model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndDo(search.toLowerCase(), Float.parseFloat(Do),2));
                }
                else if(contact.equals("clothes")){
                    model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndDo(search.toLowerCase(), Float.parseFloat(Do),3));
                }
                else if(contact.equals("processors")){
                    model.addAttribute("search_product", productRepository.findByTitleAndByCategoryAndDo(search.toLowerCase(), Float.parseFloat(Do),4));
                }
                else if(contact.isEmpty())
                {
                    System.out.println("price.isEmpty() && contact.isEmpty()     findByTitleAndDo");
                    model.addAttribute("search_product", productRepository.findByTitleAndDo(search.toLowerCase(), Float.parseFloat(Do)));
                }
            }
        }
        else
        {
            System.out.println("!search.isEmpty() только");
            model.addAttribute("search_product", productRepository.findByTitleContainingIgnoreCase(search.toLowerCase()));
        }

        model.addAttribute("value_search", search);
        model.addAttribute("value_price_ot", ot);
        model.addAttribute("value_price_do", Do);
        model.addAttribute("products", productService.getAllProduct());

        //model.addAttribute("price", price);
        //model.addAttribute("contact", contact);

        return "/product/productAdmin";

    }
}
