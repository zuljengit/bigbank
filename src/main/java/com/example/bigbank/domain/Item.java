package com.example.bigbank.domain;

public class Item {

    private String id;
    private String name;
    private Number cost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getCost() {
        return cost;
    }

    public void setCost(Number cost) {
        this.cost = cost;
    }
}
