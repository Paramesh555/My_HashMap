package com.example.Hash_Map;

import java.util.HashMap;

public class Iter15_HashTable<K,V> extends Iter14_HashTable<K,V>{
    @Override
    protected final int bucket(Object key) {//how any number divided by power of 10 we can easily say reminder same for computer but with 2
        var hc = key.hashCode();

        var mask = keys.length - 1;

        return hc & mask;
    }

    HashMap<Integer,String> map = new HashMap<>();
}
