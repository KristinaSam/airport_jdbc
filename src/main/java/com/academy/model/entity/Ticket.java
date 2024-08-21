package com.academy.model.entity;

import lombok.Data;

@Data
public class Ticket {
    private int id;
    private String status;
    private int user_id;
    private int airplane_route_id;
}
