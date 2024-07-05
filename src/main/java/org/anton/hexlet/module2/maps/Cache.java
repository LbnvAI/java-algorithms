package org.anton.hexlet.module2.maps;

import java.util.LinkedHashMap;

public class Cache {
    //**************************************************************************************************************|
    //                                                Cache with limited size                                       |
    //______________________________________________________________________________________________________________|
    //                                           My Solution same as Hexlet Solution                                |
    public Cache(int size) {
        this.data = new LinkedHashMap<>(size, 1);
        this.cacheSize = size;
    }

    LinkedHashMap<String, String> data;
    private int cacheSize = 0;

    public void put(String key, String value) {
        if (data.size() == cacheSize) {
            if (data.containsKey(key)) data.put(key, value);
            else {
                data.remove(data.keySet().iterator().next());
                data.put(key, value);
            }
        } else data.put(key, value);
    }

    public String get(String key) {
        return data.getOrDefault(key, null);
    }
}
