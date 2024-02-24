package com.company.glovoapi.service.order.jpa;

import com.company.glovoapi.dto.order.Order;
import com.company.glovoapi.repository.OrdersJDBCRepository;
import com.company.glovoapi.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrdersJDBCRepository orderJDBCRepository;

    @Override
    public Order getOrderById(Integer orderId) {
        return orderJDBCRepository.getById(orderId);
    }

    public List<Order> getOrders() {
        return orderJDBCRepository.getAllOrders();
    }

    @Override
    public void saveNewOrder(Order newOrder) {
        orderJDBCRepository.saveOrder(newOrder);
    }

    @Override
    public void updateOrder(Integer orderId, Order updatedOrderData) {
        Order result = orderJDBCRepository.getById(orderId);
        result.setDate(updatedOrderData.getDate());
        result.setCost(updatedOrderData.getCost());
        orderJDBCRepository.updateById(orderId, result);
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderJDBCRepository.deleteById(orderId);
    }
}
