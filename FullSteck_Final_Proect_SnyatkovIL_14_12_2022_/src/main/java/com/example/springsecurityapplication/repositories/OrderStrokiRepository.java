package com.example.springsecurityapplication.repositories;

import com.example.springsecurityapplication.models.OrderStroki;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderStrokiRepository extends JpaRepository<OrderStroki, Integer> {

    Optional<OrderStroki> findById(int id);

    @Query(value = "select * from order_stroki where product_id=?1", nativeQuery = true)
    List<OrderStroki> findByProductId(int Product_id);





}
