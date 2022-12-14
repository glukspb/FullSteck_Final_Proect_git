package com.example.springsecurityapplication.services;

import com.example.springsecurityapplication.models.Image;
import com.example.springsecurityapplication.models.Product;
import com.example.springsecurityapplication.repositories.ImageRepository;
import com.example.springsecurityapplication.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    private final ImageRepository imageRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ImageRepository imageRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

//    public ProductService() {
//    }

    // Данный метод позволяет вернуть все товары
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    // Данный метод позволяет вернуть все товары
    public List<Product> getAllProductDlyaApi(){
        return productRepository.findAll();
    }

    // Данный метод позволяет вернуть товар по Id
    public Product getProductId(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    // Данный метод позволяет сохранить товар
    @Transactional
    public void saveProduct(Product product){
        productRepository.save(product);
    }

    // Данный метод позволяет изменить/обновить данные товара по id
    @Transactional
    ////public void updateProduct(int id, Product product, List<Image> imageList_to_del, List<Image> imageList_to_add, List<Image> imageList, String uploadPath, int prm_SetOn){
    public void updateProduct(int id, Product product, List<Image> imageList_ald_to_upd, List<String> imageNameList_new_to_reald){
        product.setId(id);
        LocalDateTime dateTime = LocalDateTime.now();
        product.setDateTime(dateTime);
        int i = 0;
        for(Image image_ald_to_upd : imageList_ald_to_upd){
            System.out.println("Image image_ald_to_upd 2 : imageList_ald_to_upd");
            String imageName_new_to_reald = imageNameList_new_to_reald.get(i);
            System.out.println("imageName_new_to_reald 2 = " + imageName_new_to_reald);
            image_ald_to_upd.setFileName(imageName_new_to_reald);
            i++;
        }
//        if(imageList_to_del.size() > 0){
//            for(Image file_image_to_del : imageList_to_del){
//                int id_image_to_del = file_image_to_del.getId();
//                File file_to_del = new File(uploadPath + "/" + file_image_to_del.getFileName());
//                if(prm_SetOn != 0) {
//                    if(file_to_del.isFile()) {
//                        for (Image file_image : imageList){
//
//                            int id_image = file_image.getId();
//                            if(id_image == id_image_to_del){
//                                ////file_image.setFileName(file_image_to_del.getFileName());
//                            }
//                        }
//                        ////file_to_del.delete();
//                    }
//                }
//            }
//        }
        productRepository.save(product);
    }

    //Данный метод позволяет удалить товар по id
    @Transactional
    public void deleteProduct(int id, List<Image> imageList_to_del){
//        for(Image image_to_del : imageList_to_del){
//            System.out.println("Image image_to_del (deleteProduct) : image_to_del" + image_to_del.getFileName());
//            imageRepository.deleteById(image_to_del.getId());
//        }
        productRepository.deleteById(id);
    }
}
