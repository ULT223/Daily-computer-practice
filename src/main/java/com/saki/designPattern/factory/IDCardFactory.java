package com.saki.designPattern.factory;

import com.saki.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory{

    private List<String> owners = new ArrayList<>();

    @Override
    public Product createProduct(String owner) {
        IDCard idCard = new IDCard(owner);
        return idCard;
    }

    @Override
    public void registerProduct(Product product) {
        owners.add(((IDCard) product).getOwner());
    }
}
