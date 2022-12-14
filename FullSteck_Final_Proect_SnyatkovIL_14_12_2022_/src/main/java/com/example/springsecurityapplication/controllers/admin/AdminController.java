package com.example.springsecurityapplication.controllers.admin;

import com.example.springsecurityapplication.models.*;
import com.example.springsecurityapplication.repositories.*;
import com.example.springsecurityapplication.services.OrderService;
import com.example.springsecurityapplication.services.PersonService;
import com.example.springsecurityapplication.services.ProductService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/admin")
//@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')") // or или and // разграничение ролей на основе аннотаций
public class AdminController {

    @Value("${upload.path}")
    private String uploadPath;

    private final ProductService productService;

    private final CategoryRepository categoryRepository;

    private final OrderService orderService;

    private final CartRepository cartRepository;

//    private final OrderRepository orderRepository;

    private final OrderShapkiRepository orderShapkiRepository;

    private final OrderStrokiRepository orderStrokiRepository;  //findByProductId

    private final StatusesRepository statusesRepository;

    private final PersonService personService;

    private final PersonRepository personRepository;

    private final RolesRepository rolesRepository;


//
//    @Autowired
//    public AdminController(ProductService productService) {
//        this.productService = productService;
//    }

    @Autowired
    public AdminController(ProductService productService, CategoryRepository categoryRepository, OrderService orderService, CartRepository cartRepository, OrderShapkiRepository orderShapkiRepository, OrderStrokiRepository orderStrokiRepository, StatusesRepository statusesRepository, PersonService personService, PersonRepository personRepository, RolesRepository rolesRepository) {
        this.productService = productService;
        this.categoryRepository = categoryRepository;
        this.orderService = orderService;
        this.cartRepository = cartRepository;
        this.orderShapkiRepository = orderShapkiRepository;
        this.orderStrokiRepository = orderStrokiRepository;
        this.statusesRepository = statusesRepository;
        this.personService = personService;
        this.personRepository = personRepository;
        this.rolesRepository = rolesRepository;
    }

    //    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')") // or или and // разграничение ролей на основе аннотаций
    @GetMapping("")////  /admin
    public String admin(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "admin/admin";
    }

    ///////////////////////// product  ///////////////////////
    ///////////////////////// product  ///////////////////////
    ///////////////////////// product  ///////////////////////

    //// http://localhost:8202/admin/product/add
    // Метод по отображению страницы с возможностью добавления товаров
    @GetMapping("/product/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        ////model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("category", categoryRepository.findById_Otbor(3));
        return "/product/addProduct";
    }

//    public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, @RequestParam("file_one") MultipartFile file_one, @RequestParam("file_two")MultipartFile file_two, @RequestParam("file_three")MultipartFile file_three, @RequestParam("file_four")MultipartFile file_four, @RequestParam("file_five") MultipartFile file_five) throws IOException

// Метод по добавлению продукта в БД через сервис->репозиторий
    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,
                             @RequestParam("file_one") MultipartFile file_one,
                             @RequestParam("file_two")MultipartFile file_two,
                             @RequestParam("file_three")MultipartFile file_three,
                             @RequestParam("file_four")MultipartFile file_four,
                             @RequestParam("file_five") MultipartFile file_five) throws IOException
    {
        if(bindingResult.hasErrors())
        {
            return "product/addProduct";
        }

        if(file_one != null)
        {
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            if(file_one.getOriginalFilename().length() > 0) {
                String uuidFile = UUID.randomUUID().toString();
                String resultFileName = uuidFile + "__" + file_one.getOriginalFilename();
                file_one.transferTo(new File(uploadPath + "/" + resultFileName));
                Image image = new Image();
                image.setProduct(product);
                image.setFileName(resultFileName);
                product.addImageToProduct(image);
            }
        }

        if(file_two != null)
        {
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            if(file_two.getOriginalFilename().length() > 0) {
                String uuidFile = UUID.randomUUID().toString();
                String resultFileName = uuidFile + "__" + file_two.getOriginalFilename();
                file_two.transferTo(new File(uploadPath + "/" + resultFileName));
                Image image = new Image();
                image.setProduct(product);
                image.setFileName(resultFileName);
                product.addImageToProduct(image);
            }
        }

        if(file_three != null)
        {
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            if(file_three.getOriginalFilename().length() > 0) {
                String uuidFile = UUID.randomUUID().toString();
                String resultFileName = uuidFile + "__" + file_three.getOriginalFilename();
                file_three.transferTo(new File(uploadPath + "/" + resultFileName));
                Image image = new Image();
                image.setProduct(product);
                image.setFileName(resultFileName);
                product.addImageToProduct(image);
            }
        }

        if(file_four != null)
        {
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            if(file_four.getOriginalFilename().length() > 0) {
                String uuidFile = UUID.randomUUID().toString();
                String resultFileName = uuidFile + "__" + file_four.getOriginalFilename();
                file_four.transferTo(new File(uploadPath + "/" + resultFileName));
                Image image = new Image();
                image.setProduct(product);
                image.setFileName(resultFileName);
                product.addImageToProduct(image);
            }
        }

        if(file_five != null)
        {
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            if(file_five.getOriginalFilename().length() > 0) {
                String uuidFile = UUID.randomUUID().toString();
                String resultFileName = uuidFile + "__" + file_five.getOriginalFilename();
                file_five.transferTo(new File(uploadPath + "/" + resultFileName));
                Image image = new Image();
                image.setProduct(product);
                image.setFileName(resultFileName);
                product.addImageToProduct(image);
            }
        }

        productService.saveProduct(product);
        return "redirect:/admin";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id){
        System.out.println(id);
        List<Image> imageList_to_del =  productService.getProductId(id).getImageList();
        int imageList_to_del_size = imageList_to_del.size();
        System.out.println("imageList_to_del_size = " + imageList_to_del_size);
        System.out.println("imageList_to_del = " + imageList_to_del);

        System.out.println("orderStrokiRepository.findByProductId(id).size() = " + orderStrokiRepository.findByProductId(id).size());
        System.out.println("cartRepository.findByProductId(id).size() = " + cartRepository.findByProductId(id).size());
        if(orderStrokiRepository.findByProductId(id).size()==0 & cartRepository.findByProductId(id).size()==0) {
            System.out.println("2 orderStrokiRepository.findByProductId(id).size() = " + orderStrokiRepository.findByProductId(id).size());
            System.out.println("2 cartRepository.findByProductId(id).size() = " + cartRepository.findByProductId(id).size());
            if (imageList_to_del.size() > 0) {
                for (Image image_to_del : imageList_to_del) {
                    System.out.println(image_to_del.getId());
                    System.out.println(image_to_del.getFileName());
                    System.out.println(image_to_del.getProduct().getTitle());
                    File file_to_del = new File(uploadPath + "/" + image_to_del.getFileName());
                    System.out.println("file_to_del = " + file_to_del);
//                file_to_del.delete();
                    if (file_to_del.isFile()) {
                        file_to_del.delete();
                    } else {
                        System.out.println("Неудалось удалить файл, т.к.его нет в каталоге:  " + file_to_del.getPath());
                    }
                }
            }
        }
        else{
            ///////Message msg = ne {
            ///////}
            ////JOptionPane.showMessageDialog(null, "Не удалось удалить товар, вероятно он находится в корзине или в заказе", "Ошибка удаления", JOptionPane.INFORMATION_MESSAGE);
//            Alert alert = new Alert(AlertType.INFORMATION);
//            alert.setTitle(titleBar);
//            alert.setHeaderText(headerMessage);
//            alert.setContentText(infoMessage);
//            alert.showAndWait();

        }
        if(orderStrokiRepository.findByProductId(id).size()==0 & cartRepository.findByProductId(id).size()==0) {

            productService.deleteProduct(id, imageList_to_del);
        }
        return "redirect:/admin";
    }

    // Метод по отображению страницы с возможностью редактирования товаров
    @GetMapping("/product/edit/{id}")
    public String editProduct(Model model, @PathVariable("id") int id){
        model.addAttribute("product", productService.getProductId(id));
        ////model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("category", categoryRepository.findById_Otbor(3));


        List<Image> imageList =  productService.getProductId(id).getImageList();

        String dir_files = "file:///" + uploadPath + '/';

//        for(Image name_image : imageList){
//            System.out.println(dir_files + name_image.getFileName());
//        }
        System.out.println("------------------");

        model.addAttribute("imageList_size", imageList.size());

        if (imageList.size() >=1) {
            Image image_1 = (Image) imageList.get(0);
            String prm_file1 = dir_files + image_1.getFileName();
            System.out.println("name_image_1 = " + image_1);
            System.out.println("prm_file1 = " + prm_file1);

            File file_one = new File(dir_files, image_1.getFileName());
            System.out.println("file_one.exists() = " + file_one.exists());
            System.out.println("file_one.isFile() = " + file_one.isFile());
            System.out.println("file_one.isFile() = " + file_one.isFile());

//            model.addAttribute("file_one", file_one);
            model.addAttribute("prm_file1", prm_file1);
            model.addAttribute("name_image_1", image_1.getFileName());
        }

        if (imageList.size() >=2) {
            Image image_2 = (Image) imageList.get(1);
            String prm_file2 = dir_files + image_2.getFileName();
            System.out.println("name_image_2 = " + image_2);
            System.out.println("prm_file2 = " + prm_file2);

            File file_two = new File(dir_files, image_2.getFileName());
            System.out.println("file_two = " + file_two);

//            model.addAttribute("file_two", file_two);
            model.addAttribute("prm_file2", prm_file2);
            model.addAttribute("name_image_2", image_2.getFileName());
        }

        if (imageList.size() >=3) {
            Image image_3 = (Image) imageList.get(2);
            String prm_file3 = dir_files + image_3.getFileName();
            System.out.println("name_image_3 = " + image_3);
            System.out.println("prm_file3 = " + prm_file3);

            File file_three = new File(dir_files, image_3.getFileName());
            System.out.println("file_three = " + file_three);

//            model.addAttribute("file_three", file_three);
            model.addAttribute("prm_file3", prm_file3);
            model.addAttribute("name_image_3", image_3.getFileName());
        }

        if (imageList.size() >=4) {
            Image image_4 = (Image) imageList.get(3);
            String prm_file4 = dir_files + image_4.getFileName();
            System.out.println("name_image_4 = " + image_4);
            System.out.println("prm_file4 = " + prm_file4);

            File file_four = new File(dir_files, image_4.getFileName());
            System.out.println("file_four = " + file_four);

//            model.addAttribute("file_four", file_four);
            model.addAttribute("prm_file4", prm_file4);
            model.addAttribute("name_image_4", image_4.getFileName());
        }

        if (imageList.size() >=5) {
            Image image_5 = (Image) imageList.get(4);
            String prm_file5 = dir_files + image_5.getFileName();
            System.out.println("name_image_5 = " + image_5);
            System.out.println("prm_file5 = " + prm_file5);

            File file_five = new File(dir_files, image_5.getFileName());
            System.out.println("file_five = " + file_five);

//            model.addAttribute("file_five", file_five);
            model.addAttribute("prm_file5", prm_file5);
            model.addAttribute("name_image_5", image_5.getFileName());
        }

        ////System.out.println("------------------");
        ////Path imagesPath_1 = Paths.get(dir_files + name_image_1.getFileName());
        ////File image_1 = Files.find(imagesPath_1, );
        ////Image image_1 = Files.find(Path imagesPath_1);

//        System.out.println("------------------");
//        System.out.println(imagesPath_1);

        ////file_one = Path(dir_files + name_image_1.getFileName(), );

        ////imageList.forEach(System.out.println(put_file + imageList.getClass()));
        ////imageList.forEach(System.out::println);

//////        for (List<Image> imageList : prm_image)
//////             {}
////
//
//        Image put_file = imageList.get(0);
//        System.out.println("put_file = " + put_file);
//
//        ////file_one = put_file;
////
//////        Path path = Paths.get("/path/to/the/file.txt");
//////        String name = "file.txt";
//////        String originalFileName = "file.txt";

        return "product/editProduct";
    }

    // Метод по редактированию товара
    @PostMapping("/product/edit/{id}")
    public String editProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, @PathVariable("id") int id,
                              ////////@ModelAttribute("imageList_size") int imageList_size,
                              @RequestParam("file_one") MultipartFile file_one,
                              @RequestParam("file_two")MultipartFile file_two,
                              @RequestParam("file_three")MultipartFile file_three,
                              @RequestParam("file_four")MultipartFile file_four,
                              @RequestParam("file_five") MultipartFile file_five) throws IOException {
    ////public String editProduct(@ModelAttribute("product") Product product, @PathVariable("id") int id){

        int prm_SetOn = 1;

        if(bindingResult.hasErrors())
        {
            return "product/editProduct";
        }

        List<Image> imageList =  productService.getProductId(id).getImageList();
        int imageList_size = imageList.size();
        System.out.println("imageList_size = " + imageList_size);

        String name_image_1 = "";
        String name_image_2 = "";
        String name_image_3 = "";
        String name_image_4 = "";
        String name_image_5 = "";
        if (imageList_size >=1) {
            Image image_1 = (Image) imageList.get(0);
            name_image_1 = image_1.getFileName();
        }
        if (imageList_size >=2) {
            Image image_2 = (Image) imageList.get(1);
            name_image_2 = image_2.getFileName();
        }
        if (imageList_size >=3) {
            Image image_3 = (Image) imageList.get(2);
            name_image_3 = image_3.getFileName();
        }
        if (imageList_size >=4) {
            Image image_4 = (Image) imageList.get(3);
            name_image_4 = image_4.getFileName();
        }
        if (imageList_size >=5) {
            Image image_5 = (Image) imageList.get(4);
            name_image_5 = image_5.getFileName();
        }

        List<Image> imageList_to_del = new ArrayList<>();
        System.out.println("imageList_to_del.size() = " + imageList_to_del.size());
        List<Image> imageList_to_add = new ArrayList<>();
        System.out.println("imageList_to_add.size() = " + imageList_to_add.size());
        List<Image> imageList_ald_to_upd = new ArrayList<>();
        System.out.println("imageList_ald_to_upd.size() = " + imageList_ald_to_upd.size());
        List<String> imageNameList_new_to_reald = new ArrayList<>();
        System.out.println("imageNameList_new_to_reald.size() = " + imageNameList_new_to_reald.size());

        List<String> fileNameList_to_del = new ArrayList<>();
        System.out.println("fileNameList_to_del.size() = " + fileNameList_to_del.size());
        List<String> fileNameList_to_add = new ArrayList<>();
        System.out.println("fileNameList_to_add.size() = " + fileNameList_to_add.size());


        if(file_one != null)
        {
            System.out.println("name_image_1 = " + name_image_1);
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            /////////////////imageList_to_del.add((Image) imageList.get(0));
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "__" + file_one.getOriginalFilename();
            System.out.println("file_one.getOriginalFilename() = " + file_one.getOriginalFilename());
            System.out.println("file_one.getOriginalFilename().length() = " + file_one.getOriginalFilename().length());
            System.out.println("name_image_1 = " + name_image_1);
//            System.out.println(name_image_1.equals(file_one.getOriginalFilename()));
//            System.out.println(resultFileName.equals(imageList.get(0).getFileName()));
            ////if(!resultFileName.equals(imageList.get(0).getFileName())) {
            int tek_id_image_v_imgList_ = 0;
            if(file_one.getOriginalFilename().length() > 0){
                if (imageList_size > tek_id_image_v_imgList_) {
                    System.out.println(resultFileName.equals(imageList.get(tek_id_image_v_imgList_).getFileName()));

                    imageList_ald_to_upd.add((Image) imageList.get(tek_id_image_v_imgList_));

                    imageList_to_del.add((Image) imageList.get(tek_id_image_v_imgList_));
                    fileNameList_to_del.add(uploadPath + "/" + imageList.get(tek_id_image_v_imgList_).getFileName());
                }
                Image image = new Image();
                image.setProduct(product);
                image.setFileName(resultFileName);
                if (imageList_size > tek_id_image_v_imgList_) {
                    imageNameList_new_to_reald.add(resultFileName);
                }

                if(prm_SetOn != 0){
                    if (imageList_size < tek_id_image_v_imgList_ + 1){
                        product.addImageToProduct(image);
                    }
                }
            }
            else{
                if (imageList_size > tek_id_image_v_imgList_) {
                    String file_name_1 = imageList.get(tek_id_image_v_imgList_).getFileName();
                }
                ////file_one.transferTo(new File(uploadPath + "/" + file_name_1));
                if(prm_SetOn != 0) {
                    ////product.addImageToProduct(imageList.get(tek_id_image_v_imgList_));
                }
            }
        }

        if(file_two != null)
        {
            System.out.println("name_image_2 = " + name_image_2);
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            /////////////////imageList_to_del.add((Image) imageList.get(1));
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "__" + file_two.getOriginalFilename();
            System.out.println("file_two.getOriginalFilename() = " + file_two.getOriginalFilename());
            System.out.println("file_two.getOriginalFilename().length() = " + file_two.getOriginalFilename().length());
            System.out.println("name_image_2 = " + name_image_2);
            System.out.println(name_image_2.equals(file_two.getOriginalFilename()));
            ////if(!resultFileName.equals(imageList.get(1).getFileName())) {
            int tek_id_image_v_imgList_ = 1;
            if(file_two.getOriginalFilename().length() > 0){
                if (imageList_size > tek_id_image_v_imgList_) {
                    System.out.println(resultFileName.equals(imageList.get(tek_id_image_v_imgList_).getFileName()));

                    imageList_ald_to_upd.add((Image) imageList.get(tek_id_image_v_imgList_));

                    imageList_to_del.add((Image) imageList.get(tek_id_image_v_imgList_));
                    fileNameList_to_del.add(uploadPath + "/" + imageList.get(tek_id_image_v_imgList_).getFileName());
                }

                file_two.transferTo(new File(uploadPath + "/" + resultFileName));
                Image image = new Image();
                image.setProduct(product);
                image.setFileName(resultFileName);
                if (imageList_size > tek_id_image_v_imgList_) {
                    imageNameList_new_to_reald.add(resultFileName);
                }

                if(prm_SetOn != 0){
                    if (imageList_size < tek_id_image_v_imgList_ + 1){
                        product.addImageToProduct(image);
                    }
                }
            }
            else{
                if (imageList_size > tek_id_image_v_imgList_) {
                    String file_name_2 = imageList.get(tek_id_image_v_imgList_).getFileName();
                }
                ////file_two.transferTo(new File(uploadPath + "/" + file_name_2));
                if(prm_SetOn != 0) {
                    ////product.addImageToProduct(imageList.get(1));
                }
            }
//            product.addImageToProduct(image);
        }

        if(file_three != null)
        {
            System.out.println("name_image_3 = " + name_image_3);
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            /////////////////imageList_to_del.add((Image) imageList.get(2));
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "__" + file_three.getOriginalFilename();
            System.out.println("file_three.getOriginalFilename() = " + file_three.getOriginalFilename());
            System.out.println("file_three.getOriginalFilename().length() = " + file_three.getOriginalFilename().length());
            System.out.println("name_image_3 = " + name_image_3);
            System.out.println(name_image_3.equals(file_three.getOriginalFilename()));
            ////if(!resultFileName.equals(imageList.get(2).getFileName())) {
            int tek_id_image_v_imgList_ = 2;
            if(file_three.getOriginalFilename().length() > 0){
                if (imageList_size > tek_id_image_v_imgList_) {
                    System.out.println(resultFileName.equals(imageList.get(tek_id_image_v_imgList_).getFileName()));

                    imageList_ald_to_upd.add((Image) imageList.get(tek_id_image_v_imgList_));

                    imageList_to_del.add((Image) imageList.get(tek_id_image_v_imgList_));
                    fileNameList_to_del.add(uploadPath + "/" + imageList.get(tek_id_image_v_imgList_).getFileName());
                }

                file_three.transferTo(new File(uploadPath + "/" + resultFileName));
                Image image = new Image();
                image.setProduct(product);
                image.setFileName(resultFileName);
                if (imageList_size > tek_id_image_v_imgList_) {
                    imageNameList_new_to_reald.add(resultFileName);
                }

                if(prm_SetOn != 0){
                    if (imageList_size < tek_id_image_v_imgList_ + 1){
                        product.addImageToProduct(image);
                    }
                }
            }
            else{
                if (imageList_size > tek_id_image_v_imgList_) {
                    String file_name_3 = imageList.get(tek_id_image_v_imgList_).getFileName();
                }
                ////file_three.transferTo(new File(uploadPath + "/" + file_name_3));
                if(prm_SetOn != 0) {
                    ////product.addImageToProduct(imageList.get(2));
                }
            }
//            product.addImageToProduct(image);
        }

        if(file_four != null)
        {
            System.out.println("name_image_4 = " + name_image_4);
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            /////////////////imageList_to_del.add((Image) imageList.get(3));
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "__" + file_four.getOriginalFilename();
            System.out.println("file_four.getOriginalFilename() = " + file_four.getOriginalFilename());
            System.out.println("file_four.getOriginalFilename().length() = " + file_four.getOriginalFilename().length());
            System.out.println("name_image_4 = " + name_image_4);
            System.out.println(name_image_4.equals(file_four.getOriginalFilename()));
            ////if(!resultFileName.equals(imageList.get(3).getFileName())) {
            int tek_id_image_v_imgList_ = 3;
            if(file_four.getOriginalFilename().length() > 0){
                if (imageList_size > tek_id_image_v_imgList_) {
                    System.out.println(resultFileName.equals(imageList.get(tek_id_image_v_imgList_).getFileName()));

                    imageList_ald_to_upd.add((Image) imageList.get(tek_id_image_v_imgList_));

                    imageList_to_del.add((Image) imageList.get(tek_id_image_v_imgList_));
                    fileNameList_to_del.add(uploadPath + "/" + imageList.get(tek_id_image_v_imgList_).getFileName());
                }

                file_four.transferTo(new File(uploadPath + "/" + resultFileName));
                Image image = new Image();
                image.setProduct(product);
                image.setFileName(resultFileName);
                if (imageList_size > tek_id_image_v_imgList_) {
                    imageNameList_new_to_reald.add(resultFileName);
                }

                if(prm_SetOn != 0){
                    if (imageList_size < tek_id_image_v_imgList_ + 1){
                        product.addImageToProduct(image);
                    }
                }
            }
            else{
                if (imageList_size > tek_id_image_v_imgList_) {
                    String file_name_4 = imageList.get(tek_id_image_v_imgList_).getFileName();
                }
                ////file_four.transferTo(new File(uploadPath + "/" + file_name_4));
                if(prm_SetOn != 0) {
                    ////product.addImageToProduct(imageList.get(3));
                }
            }
            ////product.addImageToProduct(image);

        }

        if(file_five != null)
        {
            System.out.println("name_image_5 = " + name_image_5);
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "__" + file_five.getOriginalFilename();
            System.out.println("file_five.getOriginalFilename() = " + file_five.getOriginalFilename());
            System.out.println("file_five.getOriginalFilename().length() = " + file_five.getOriginalFilename().length());
            System.out.println("name_image_5 = " + name_image_5);
            System.out.println(name_image_5.equals(file_five.getOriginalFilename()));
            ////if(!resultFileName.equals(imageList.get(4).getFileName())){
            int tek_id_image_v_imgList_ = 4;
            if(file_five.getOriginalFilename().length() > 0){
                if (imageList_size > tek_id_image_v_imgList_) {
                    System.out.println(resultFileName.equals(imageList.get(tek_id_image_v_imgList_).getFileName()));

                    imageList_ald_to_upd.add((Image) imageList.get(tek_id_image_v_imgList_));

                    imageList_to_del.add((Image) imageList.get(tek_id_image_v_imgList_));
                    fileNameList_to_del.add(uploadPath + "/" + imageList.get(tek_id_image_v_imgList_).getFileName());
                }

                file_five.transferTo(new File(uploadPath + "/" + resultFileName));
                Image image = new Image();
                image.setProduct(product);
                image.setFileName(resultFileName);
                if (imageList_size > tek_id_image_v_imgList_) {
                    imageNameList_new_to_reald.add(resultFileName);
                }

                if(prm_SetOn != 0){
                    if (imageList_size < tek_id_image_v_imgList_ + 1){
                        product.addImageToProduct(image);
                    }
                }
            }
            else{
                if (imageList_size > tek_id_image_v_imgList_) {
                    String file_name_5 = imageList.get(tek_id_image_v_imgList_).getFileName();
                }
                ////file_five.transferTo(new File(uploadPath + "/" + file_name_5));
                if(prm_SetOn != 0) {
                    ////product.addImageToProduct(imageList.get(4));
                }
            }
//            ///////////////////product.addImageToProduct(image);
        }

        System.out.println(imageList_to_del);
        System.out.println(imageList_to_del.size());
////        System.out.println(imageList_to_del.get(0).getFileName());
        if(imageList_to_del.size() > 0){
            for(Image file_image : imageList_to_del){
                System.out.println(file_image.getId());
                System.out.println(file_image.getFileName());
                System.out.println(file_image.getProduct());
                File file_to_del = new File(uploadPath + "/" + file_image.getFileName());
                if(file_to_del.isFile()) {
                    file_to_del.delete();
                }else{
                    System.out.println("Неудалось удалить файл, т.к.его нет в каталоге:  " + file_to_del.getPath());
                }
            }
        }

        System.out.println("imageNameList_new_to_reald = " + imageNameList_new_to_reald);
        System.out.println("imageNameList_new_to_reald.size() = " + imageNameList_new_to_reald.size());

        System.out.println("imageNameList_new_to_reald = " + imageNameList_new_to_reald);
        System.out.println("imageNameList_new_to_reald.size() = " + imageNameList_new_to_reald.size());

//        productService.updateProduct(id, product, imageList_to_del, imageList_to_add, imageList, uploadPath, prm_SetOn);

        productService.updateProduct(id, product, imageList_ald_to_upd, imageNameList_new_to_reald);

//        System.out.println(imageList_to_del);
//        System.out.println(imageList_to_del.size());
//////        System.out.println(imageList_to_del.get(0).getFileName());
//        if(imageList_to_del.size() > 0){
//            for(Image file_image : imageList_to_del){
//                System.out.println(file_image.getId());
//                System.out.println(file_image.getFileName());
//                System.out.println(file_image.getProduct());
//                File file_to_del = new File(uploadPath + "/" + file_image.getFileName());
//                file_to_del.delete();
//            }
//        }

//        if(imageList_ald_to_upd.size() > 0 & imageNameList_new_to_reald.size() > 0){
//            System.out.println("imageList_ald_to_upd.size() > 0 & imageNameList_new_to_reald.size() > 0 = " + (imageList_ald_to_upd.size() > 0 & imageNameList_new_to_reald.size() > 0));
//            if(imageList_ald_to_upd.size() == imageNameList_new_to_reald.size()){
//                System.out.println("imageList_ald_to_upd.size() == imageNameList_new_to_reald.size() = " + (imageList_ald_to_upd.size() == imageNameList_new_to_reald.size()));
//                productService.updateProduct(id, product, imageList_ald_to_upd, imageNameList_new_to_reald);
////                int i = 0;
////                for(Image image_ald_to_upd : imageList_ald_to_upd){
////                    System.out.println("Image image_ald_to_upd : imageList_ald_to_upd");
////                    String imageName_new_to_reald = imageNameList_new_to_reald.get(i);
////                    System.out.println("imageName_new_to_reald = " + imageName_new_to_reald);
////                    image_ald_to_upd.setFileName(imageName_new_to_reald);
////                    i++;
////                }
//            }
//        }
        for(String fileName_to_del : fileNameList_to_del){
            File file_to_del = new File(fileName_to_del);
            if(prm_SetOn != 0) {
                if(file_to_del.isFile()) {
//                    /////////file_to_del.delete();
                }
            }
        }

        return "redirect:/admin";
    }

    ///////////////////////// istoriyaZakazov  ///////////////////////
    ///////////////////////// istoriyaZakazov  ///////////////////////
    ///////////////////////// istoriyaZakazov  ///////////////////////

    @GetMapping("/istoriyaZakazov")
    public String ordersAdmin(Model model){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
//        List<Order> orderList = orderRepository.findByPerson(personDetails.getPerson());
//        model.addAttribute("orders", orderList);
//        System.out.println("search = xxx" );
//        List<OrderShapki> orderList = orderService.getAllOrders();
        //model.addAttribute("orders", orderService.getAllOrders());
        //model.addAttribute("orders", orderService.getAllOrders_findAndGroupByNumberAndDateSumPrise());
        ////model.addAttribute("orders", orderRepository.findAndGroupByNumberAndDateSumPrise());

//        List<Order> orderList = orderRepository.findAll();
//        model.addAttribute("orders", orderList);

        List<OrderShapki> orderShapkiList = orderShapkiRepository.findAll();
        model.addAttribute("ordersShapki", orderShapkiList);

//        List<Status> listStatus = new ArrayList<>();
//        for (Status status : Arrays.asList(Status.Принят, Status.Оформлен, Status.Оплачен, Status.Подготовлен, Status.В_ПУТИ, Status.Ожидает, Status.Получен)) {
//            listStatus.add(status);
//        }
//        model.addAttribute("orderStatuses", listStatus);
//        System.out.println("listStatus = " + listStatus);
//        model.addAttribute("statusOrder", statusesRepository.findAll());

        return "/admin/istoriyaZakazov";
    }

    @PostMapping("/istoriyaZakazov")
    public String orderSearch(@RequestParam("order_search") String order_search, Model model) {
        System.out.println("order_search = " + order_search);
        System.out.println("order_search.toLowerCase() = " + order_search.toLowerCase());
        System.out.println("order_search.length() = " + order_search.length());
//        System.out.println("findByNumberThanEqual = " + orderRepository.findByNumberThanEqual(order_search.toLowerCase()));
//        model.addAttribute("search_orders", orderRepository.findByNumberThanEqual(order_search.toLowerCase()));
//        model.addAttribute("orders", orderService.getAllOrders());
//        model.addAttribute("value_search_order", order_search);

//        List<OrderShapki> search_ordersShapkiList = orderShapkiRepository.findByNumberThanEqual(order_search.toLowerCase());
//        List<OrderShapki> search_ordersShapkiList = orderShapkiRepository.findByNumber(order_search.toLowerCase());
        List<OrderShapki> search_ordersShapkiList_000 = orderShapkiRepository.findByNumberContainingIgnoreCase(order_search.toLowerCase());
        System.out.println("search_ordersShapkiList_000 = " + search_ordersShapkiList_000);
        System.out.println("search_ordersShapkiList_000.size() = " + search_ordersShapkiList_000.size());
        model.addAttribute("search_ordersShapkiList_000", search_ordersShapkiList_000);

//        List<OrderShapki> search_ordersShapkiList = orderShapkiRepository.findByOrderNumberThanEqual(order_search.toLowerCase());
        List<OrderShapki> search_ordersShapkiList = orderShapkiRepository.findByOrderNumberThanEqual(order_search.toLowerCase());
        System.out.println("search_ordersShapkiList = " + search_ordersShapkiList);
        System.out.println("search_ordersShapkiList.size() = " + search_ordersShapkiList.size());
        model.addAttribute("search_ordersShapkiList", search_ordersShapkiList);

        List<OrderShapki> orderShapkiList = orderShapkiRepository.findAll();
        model.addAttribute("ordersShapki", orderShapkiList);

//        model.addAttribute("statusOrder", statusesRepository.findAll());
        model.addAttribute("value_search_order", order_search);
        return "admin/istoriyaZakazov";
    }

    // Метод по отображению страницы с информацией о заказе
    @GetMapping("/order/info/{id}")
    public String infoOrderAdmin(Model model, @PathVariable("id") int id){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        ////////List<Order> orderList = orderRepository.findByPerson(personDetails.getPerson());
        ////////model.addAttribute("orders", orderList);

        System.out.println("infoOrderAdmin_id = " + id);

        Optional<OrderShapki> orderShapka = orderShapkiRepository.findById(id);
        model.addAttribute("orderShapka", orderShapka);

        List<OrderStroki> orderStrokiList = orderShapka.get().getOrderStrokiList();
        model.addAttribute("orderStrokiList", orderStrokiList);

        model.addAttribute("statusOrder", statusesRepository.findAll());

        return "/admin/infoOrderAdmin";
    }

    // Метод по удалению заказа
    @PostMapping("/order/delete/{id}")
    public String deleteOrderAdmin(Model model, @PathVariable("id") int id){
        orderShapkiRepository.deleteById(id);
//        orderRepository.deleteById(id);
        return "redirect:/admin/istoriyaZakazov";
    }

    // Метод по отображению страницы с возможностью редактирования заказа
    @GetMapping("/order/edit/{id}")
    public String editOrderAdmin(Model model, @PathVariable("id") int id){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();, @ModelAttribute("statusOrder") Statuses statusOrder
//        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        ////////List<Order> orderList = orderRepository.findByPerson(personDetails.getPerson());
        ////////model.addAttribute("orders", orderList);

        System.out.println("editOrderAdmin_id = " + id);

        Optional<OrderShapki> orderShapka = orderShapkiRepository.findById(id);
        model.addAttribute("orderShapka", orderShapka);



        System.out.println("orderShapka person = " + orderShapka.get().getPerson().getLogin());

//        Optional<Person> person = personRepository.findById(orderShapka.get().getPerson().getId());
//        model.addAttribute("person", person);
//        ////Optional<Person> person = personRepository.findById(orderShapka.get().getPerson().getId());
//        List<Person> person = new ArrayList<>();
//        person.add(orderShapka.get().getPerson().getId(), orderShapka.get().getPerson());
//        model.addAttribute("person", personDetails.getPerson());

        //////Optional<Person>  findById(int id);
        model.addAttribute("person_id", personRepository.findById(orderShapka.get().getPerson().getId()));
        model.addAttribute("person", personRepository.findById(orderShapka.get().getPerson().getId()).get());
//        model.addAttribute("personList", personRepository.findAll();

        List<OrderStroki> orderStrokiList = orderShapka.get().getOrderStrokiList();
        model.addAttribute("orderStrokiList", orderStrokiList);

        model.addAttribute("statusOrderList", statusesRepository.findAll());
//        model.addAttribute("status", Status.values());

        return "/admin/editOrderAdmin";
    }

    // Метод по редактированию заказа
    @PostMapping("/order/edit/{id}")
    public String editOrderAdmin(@ModelAttribute("orderShapka") OrderShapki orderShapka, @PathVariable("id") int id) throws IOException {
        ///////OrderShapki orderShapka_ald = orderShapkiRepository.findById(id);, @ModelAttribute("status") Status status, status, @ModelAttribute("statusOrder") Statuses statusOrder
//        System.out.println("1 orderShapka = " + orderShapka);, statusOrder
//        System.out.println("1 id = " + id);
//        System.out.println("1 statusOrder = " + statusOrder);
//        System.out.println("1 status = " + status);
        orderService.updateOrder(id, orderShapka);
        return "redirect:/admin/istoriyaZakazov";
    }

    ///////////////////////// USERS  ///////////////////////
    ///////////////////////// USERS  ///////////////////////
    ///////////////////////// USERS  ///////////////////////

    @GetMapping("/users")
    public String usersAdmin(Model model){

        List<Person> PersonList = personRepository.findAll();
        model.addAttribute("users", PersonList);

        return "/admin/users";
    }

    // Метод по отображению страницы с информацией о пользователе
    @GetMapping("/user/info/{id}")
    public String infoUserAdmin(Model model, @PathVariable("id") int id){

        System.out.println("infoUserAdmin_id = " + id);

        Optional<Person> person = personRepository.findById(id);
        model.addAttribute("user", person);

        return "/admin/infoUserAdmin";
    }

    // Метод по отображению страницы с возможностью редактирования пользователя
    @GetMapping("/user/edit/{id}")
    public String editUserAdmin(Model model, @PathVariable("id") int id){

        System.out.println("editUserAdmin_id = " + id);

        Optional<Person> person = personRepository.findById(id);
        model.addAttribute("user", person);

        System.out.println("user person = " + person.get().getLogin());

        //////Optional<Person>  findById(int id);
        model.addAttribute("person_id", personRepository.findById(person.get().getId()));
        model.addAttribute("person", personRepository.findById(person.get().getId()).get());
//        model.addAttribute("personList", personRepository.findAll();

        model.addAttribute("rolesList", rolesRepository.findAll());
//        model.addAttribute("status", Status.values());

        return "/admin/editUserAdmin";
    }

    // Метод по редактированию пользователя
    @PostMapping("/user/edit/{id}")
    public String editUserAdmin(@ModelAttribute("user") Person person, @PathVariable("id") int id, @ModelAttribute("role") String roleName) throws IOException {
        personService.updateUser(id, person, roleName);
        return "redirect:/admin/users";
    }
    // Метод по удалению пользователя
    @PostMapping("/user/delete/{id}")
    public String deleteUserAdmin(Model model, @PathVariable("id") int id){
        personService.deleteById(id);
//        orderRepository.deleteById(id);
        return "redirect:/admin/users";
    }

}
