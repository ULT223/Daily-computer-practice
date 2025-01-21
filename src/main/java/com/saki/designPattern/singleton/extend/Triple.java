package com.saki.designPattern.singleton.extend;

import java.util.ArrayList;
import java.util.List;

public class Triple {
    private static List<Triple> list = new ArrayList<>();

    public static Triple getInstance(int id) {
        if (list.size() == 0) {
            list.add(new Triple());
            list.add(new Triple());
            list.add(new Triple());
        }
        return list.get(id);
    }
}
