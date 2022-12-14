package com.example.springsecurityapplication.repositories;

//import com.example.springsecurityapplication.models.Order;
import com.example.springsecurityapplication.models.OrderShapki;
import com.example.springsecurityapplication.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderShapkiRepository extends JpaRepository<OrderShapki, Integer> {

    List<OrderShapki> findByPerson(Person person);

    Optional<OrderShapki> findById(int id);

//    List<OrderShapki> findByNumberContainingIgnoreCase(String number);

    List<OrderShapki> findByNumberContainingIgnoreCase(String orderNumber);

    ////////@Query(value = "select distinct on (number) number, date_time, person_id, status from order_shapki where ((lower(number) LIKE '%?1')) ORDER BY number, date_time, person_id, status", nativeQuery = true)
    @Query(value = "select * from order_shapki where (lower(number) LIKE '%?1')", nativeQuery = true)
    List<OrderShapki> findByNumberThanEqual(String number);

//    @Query(value = "select * from order_shapki where (lower(number) LIKE '%?1')", nativeQuery = true)
//    List<OrderShapki> findByNumber(String number);


    ////////@Query(value = "select distinct on (number) number, date_time, person_id, status from order_shapki where ((lower(number) LIKE '%?1')) ORDER BY number, date_time, person_id, status", nativeQuery = true)
    @Query(value = "select * from order_shapki where (lower(order_number) LIKE '%?1')", nativeQuery = true)
    List<OrderShapki> findByOrderNumberThanEqual(String orderNumber);

//    @Query(value = "select * from order_shapki where (lower(order_number) LIKE '%?1')", nativeQuery = true)
//    List<OrderShapki> findByOrderNumber(String orderNumber);

    @Query(value = "select id, order_number, date_time, price_total, person_id, status_order_id from order_shapki where person_id=?1", nativeQuery = true)
    List findAllOrderByPersonId(int person_id);





}
