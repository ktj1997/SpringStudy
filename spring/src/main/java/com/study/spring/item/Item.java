package com.study.spring.item;

public class Item {

    private Long id;

    private String itemName;

    private int price;

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public Item(Long id, String itemName, int price) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
    }
}
