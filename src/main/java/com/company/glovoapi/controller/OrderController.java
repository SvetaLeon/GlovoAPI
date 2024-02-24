package com.company.glovoapi.controller;

import com.company.glovoapi.controller.response.ApiResponse;
import com.company.glovoapi.dto.order.Order;
import com.company.glovoapi.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping()
    public ApiResponse<List<Order>> getOrders() {
        ApiResponse<List<Order>> response = new ApiResponse<>();
        List<Order> orders = orderService.getOrders();
        if (!CollectionUtils.isEmpty(orders)) {
            response.setSuccess(true);
            response.setData(orders);
        }
        return response;
    }

    @GetMapping("/{orderId}")
    public ApiResponse<Order> getOrderById(@PathVariable Integer orderId) {
        ApiResponse<Order> response = new ApiResponse<>();
        Order result = orderService.getOrderById(orderId);
        if (result != null) {
            response.setSuccess(true);
            response.setData(result);
        }
        return response;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewOrder(@RequestBody Order newOrder) {
        orderService.saveNewOrder(newOrder);
    }

    @PutMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOrderById(@PathVariable Integer orderId, @RequestBody Order newOrder) {
        orderService.updateOrder(orderId, newOrder);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderById(@PathVariable Integer orderId) {
        orderService.deleteOrder(orderId);
    }
}
