package com.ecommerce.insta_mart.entity;

import jakarta.persistence.*;


@Entity
//@Table(name = "Item")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Title")
    private String name;
    private String price;

    public Product(){

    }

    public Product(Long id, String name, String price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPrice(){
        return price;
    }
}
