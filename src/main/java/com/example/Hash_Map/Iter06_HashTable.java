package com.example.Hash_Map;

public class Iter06_HashTable<K,V> extends Iter05_HashTable<K,V>{

    @Override
    protected int bucket(Object key) {
        var hc = key.hashCode();
        return Math.floorMod(hc, keys.length);
    }
}
