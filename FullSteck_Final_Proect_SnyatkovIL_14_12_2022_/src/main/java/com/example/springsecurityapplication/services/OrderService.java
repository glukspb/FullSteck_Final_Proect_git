package com.example.springsecurityapplication.services;

import com.example.springsecurityapplication.models.OrderShapki;
//import com.example.springsecurityapplication.repositories.OrderRepository;
import com.example.springsecurityapplication.repositories.OrderShapkiRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
//    private final OrderRepository orderRepository;
    private final OrderShapkiRepository orderShapkiRepository;

    public OrderService(OrderShapkiRepository orderShapkiRepository) {
        this.orderShapkiRepository = orderShapkiRepository;
    }

//    // Данный метод позволяет вернуть все заказы
//    public List<Order> getAllOrders(){
//        return orderRepository.findAll();
//    }
//
//    // Данный метод позволяет вернуть заказ по Id
//    public Order getOrderId(int id) {
//        Optional<Order> optionalOrder = orderRepository.findById(id);
//        return optionalOrder.orElse(null);
//    }

    // Данный метод позволяет вернуть все шапки заказов2
    public List<OrderShapki> getAllOrderShapki(){
        return orderShapkiRepository.findAll();
    }

    // Данный метод позволяет вернуть шапку заказа2 по Id
    public OrderShapki getOrderShapkiById(int id) {
        Optional<OrderShapki> optionalOrderShapki = orderShapkiRepository.findById(id);
        return optionalOrderShapki.orElse(null);
    }

    // Данный метод позволяет вернуть ВСЕ заказы с просуммированной суммой и сгруппированные по номеру (number), дате (без времени), покупателю
//    public List<OrderShapki> getAllOrders_findAndGroupByNumberAndDateSumPrise() {
//        ////Optional<Order> optionalOrder = orderRepository.findAndGroupByNumberAndDateSumPrise();
//
//        System.out.println("============================={{{{{{");
////        List<OtborOrder> optionalOtborOrder = orderRepository.findAndGroupByNumberAndDateSumPrise();
////        ////List optionalOtborOrder = orderRepository.findAndGroupByNumberAndDateSumPrise();
////        System.out.println("=============================");
////        System.out.println("optionalOtborOrder = " + optionalOtborOrder);
////        int i;
////        for (i=0; i<optionalOtborOrder.size(); i++)
////        {
////            System.out.println(optionalOtborOrder.get(i));
////        }
////        System.out.println("=============================");
////        System.out.println("orderRepository.findAndGroupByNumberAndDateSumPrise() = " + orderRepository.findAndGroupByNumberAndDateSumPrise());
//        System.out.println("=============================}}}}}}");
//        //////return orderRepository.findAndGroupByNumberAndDateSumPrise();
//
//        return optionalOtborOrder;
//    }

//    // Данный метод позволяет вернуть заказ по Id
//    public Order getOrder_findByTitleThanEqual(String number) {
//        Optional<Order> searchOrder = orderRepository.findByTitleThanEqual(number);
//        return optionalOrder.orElse(null);
//    }

    // Данный метод позволяет изменить/обновить данные заказа по id
    @Transactional
    public void updateOrder(int id, OrderShapki orderShapka){
//        orderShapkiRepository.findById(id);, Status status, Statuses statusOrder
//        orderShapka.setPerson(orderShapka.getPerson());
//        System.out.println("2 orderShapka = " + orderShapka);
//        System.out.println("2 id = " + id);
//        System.out.println("2 statusOrder = " + statusOrder);
//        System.out.println("2 status = " + status);
//
//        OrderShapki orderShapka_old = getOrderShapkiById(id);
        orderShapka.setId(id);
//        orderShapka.setCount(orderShapka_old.getCount());
//        orderShapka.setDateTime(orderShapka_old.getDateTime());
//        orderShapka.setNumber(orderShapka_old.getNumber());
//        orderShapka.setPriceTotal(orderShapka_old.getPriceTotal());
//        orderShapka.setStatus(orderShapka_old.getStatus());
//        orderShapka.setPerson(orderShapka_old.getPerson());
//        orderShapka.setStatusOrder(statusOrder);
//
//        System.out.println("3 orderShapka = " + orderShapka);
//        System.out.println("3 id = " + id);
//        System.out.println("3 statusOrder = " + statusOrder);
//        System.out.println("3 status = " + orderShapka_old.getStatus());

        orderShapkiRepository.save(orderShapka);
    }


}
