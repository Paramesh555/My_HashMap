package com.example.Hash_Map;

public class Iter05_HashTable<K,V> extends Iter04_HashTable<K,V>{

    @Override
    protected int bucket(Object key) {
        var hc = key.hashCode();
        return Math.abs(hc)% keys.length;
    }
}
