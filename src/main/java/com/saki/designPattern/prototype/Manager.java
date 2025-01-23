package com.saki.designPattern.prototype;

import java.util.HashMap;

/**
 * 创建具体原型类的管理器
 */
public class Manager {
    private final HashMap<String, Product> showcase = new HashMap<>();
    public void register(String name, Product proto) {
        showcase.put(name, proto);
    }

    public Product create(String protoname) {
        Product p = showcase.get(protoname);
        return p.createClone();
    }
}
