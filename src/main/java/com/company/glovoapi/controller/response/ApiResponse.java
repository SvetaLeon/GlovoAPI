package com.company.glovoapi.controller.response;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse <D> {
    private boolean success;
    private D data;
    private List<String> messages;
}
