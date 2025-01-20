package com.saki.designPattern.factory;

import com.saki.entity.Product;

public class IDCard extends Product {

    private String owner;

    IDCard(String owner) {
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡");
    }

    public String getOwner() {
        return owner;
    }
}
