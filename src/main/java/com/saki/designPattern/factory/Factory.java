package com.saki.designPattern.factory;

import com.saki.entity.Product;

/**
 * 工厂类
 *
 */
public abstract class Factory {
    public Product create(String owner){
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }

    public abstract Product createProduct(String owner);
    public abstract void registerProduct(Product product);
}
