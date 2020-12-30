package com.study.spring.order;

public class Order {
    private Long id;
    private Long memberId;
    private Long itemId;
    private int totalPrice;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Order(Long memberId, Long itemId, int totalPrice) {
        this.memberId = memberId;
        this.itemId = itemId;
        this.totalPrice = totalPrice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long getItemId() {
        return itemId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
