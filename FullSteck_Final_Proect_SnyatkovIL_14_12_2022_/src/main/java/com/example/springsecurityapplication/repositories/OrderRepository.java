package com.example.springsecurityapplication.repositories;

//import com.example.springsecurityapplication.models.Order;
import com.example.springsecurityapplication.models.OrderShapki;
import com.example.springsecurityapplication.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
//public interface OrderRepository extends JpaRepository<Order, Integer> {
//    List<Order> findByPerson(Person person);
//    Optional<Order> findById(int id);
//
//    List<Order> findByNumberContainingIgnoreCase(String number);
//
//    ////////@Query(value = "select * from orders where ((lower(number) LIKE '%?1'))", nativeQuery = true)
//    @Query(value = "select distinct on (number) number, date_time, person_id, status from orders where ((lower(number) LIKE '%?1')) ORDER BY number, date_time, person_id, status", nativeQuery = true)
//    List<Order> findByNumberThanEqual(String number);
//
//    @Query(value = "select distinct on (number) number, date_time, person_id, status from orders ORDER BY number, date_time, person_id, status", nativeQuery = true)
//    List<Order> findAndGroupByNumber(String number);
//
//    //// выбирает ВСЕ заказы с просуммированной суммой и сгруппированные по номеру (number), дате (без времени), покупателю
////    @Query(value = "select number, status, person_id, sum(price) as sum_price, CAST (date_time AS DATE) from orders GROUP BY number, status, person_id, CAST (date_time AS DATE)", nativeQuery = true)
//    @Query(value = "select number from orders GROUP BY number", nativeQuery = true)
//    ////List findAndGroupByNumberAndDateSumPrise();
//    List<OrderShapki> findAndGroupByNumberAndDateSumPrise();
//
//}
