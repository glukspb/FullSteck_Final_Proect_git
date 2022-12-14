package com.example.springsecurityapplication.repositories;

import com.example.springsecurityapplication.models.Cart;
import com.example.springsecurityapplication.models.OrderStroki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CartRepository  extends JpaRepository<Cart, Integer> {
    // Получаем корзину по id пользователя
    List<Cart> findByPersonId(int id);

    @Query(value = "select * from product_cart where product_id=?1", nativeQuery = true)
    List<Cart> findByProductId(int Product_id);

    void deleteCartByProductId(int id);
}
