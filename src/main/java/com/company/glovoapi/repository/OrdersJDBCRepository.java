package com.company.glovoapi.repository;

import com.company.glovoapi.dto.order.Order;
import com.company.glovoapi.repository.mappers.OrdersRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrdersJDBCRepository {
    private final String SAVE_NEW_ORDER = "INSERT INTO orders (date, cost) VALUES (?, ?)";
    private final String UPDATE_ORDER_BY_ID = "UPDATE orders SET date = ?, cost = ? WHERE id = ";
    private final String GET_ALL_ORDERS = "SELECT * FROM orders";
    private final String GET_ORDER_BY_ID = "SELECT * FROM orders WHERE id = ";
    private final String DELETE_ORDER_BY_ID = "DELETE FROM orders WHERE id = ";

    private final JdbcTemplate jdbcTemplate;

    public void saveOrder(Order newOrder) {
        jdbcTemplate.update(SAVE_NEW_ORDER, newOrder.getDate(), newOrder.getCost());
    }

    public void updateById(Integer orderId, Order updatedOrderData) {
        jdbcTemplate.update(UPDATE_ORDER_BY_ID + orderId, updatedOrderData.getDate(), updatedOrderData.getCost());
    }

    public List<Order> getAllOrders() {
        return jdbcTemplate.query(GET_ALL_ORDERS, new OrdersRowMapper());
    }

    public Order getById(Integer orderId) {
        return jdbcTemplate.queryForObject(GET_ORDER_BY_ID + orderId, new OrdersRowMapper());
    }

    public void deleteById(Integer orderId) {
        jdbcTemplate.update(DELETE_ORDER_BY_ID + orderId);
    }
}
