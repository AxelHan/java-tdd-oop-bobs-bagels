package com.booleanuk.core;

import java.util.HashMap;

public class Bagel {
    private HashMap<String, Filling> fillings;
    private String name;
    private double price;
    private String variant;
    private Inventory inventory;

    public Bagel(String id, String[] fillings){
        this(id);
        for (String fillingId : fillings){
            if(inventory.isFilling(fillingId)){
                this.fillings.put(fillingId, new Filling(fillingId));
            }
        }
    }
    public Bagel(String id){
        this.name = "Bagel";
        switch (id) {
            case "BGLO" -> {
                this.variant = "Onion";
                this.price = 0.49;
            }
            case "BGLP" -> {
                this.variant = "Plain";
                this.price = 0.39;
            }
            case "BGLE" -> {
                this.variant = "Everything";
                this.price = 0.49;
            }
            case "BGLS" -> {
                this.variant = "Sesame";
                this.price = 0.49;
            }
            default -> throw new IllegalStateException("Unexpected value: " + id);
        }
    }

    public double getPrice() {
        return price;
    }

    public HashMap<String, Filling> getFillings() {
        return fillings;
    }

    public String getName() {
        return name;
    }

    public String getVariant() {
        return variant;
    }
}