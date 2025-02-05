package com.saki.javaUtil;

import java.util.Optional;

public class MyOptional {
    public static void main(String[] args) {
        String s = null;
        Optional<String> optional = Optional.ofNullable(s);
        System.out.println(optional.isPresent());
    }
}
