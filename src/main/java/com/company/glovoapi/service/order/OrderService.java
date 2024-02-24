package com.company.glovoapi.service.order;

import com.company.glovoapi.dto.order.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Integer orderId);

    List<Order> getOrders();

    void saveNewOrder(Order newOrder);

    void updateOrder(Integer orderId, Order updatedOrderData);

    void deleteOrder(Integer orderId);
}
