package com.org.model;

import jakarta.persistence.Id;

public class Item {
    @Id
    private long id;

    private String name;
    private double price;

}
