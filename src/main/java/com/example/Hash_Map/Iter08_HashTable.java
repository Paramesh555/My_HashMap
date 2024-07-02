package com.example.Hash_Map;

public class Iter08_HashTable<K,V> extends Iter07_HashTable<K,V>{
    @Override
    protected V get0(K key, int bucket, Object candidate) {
        if(candidate == null) return null;

        return get1(key,bucket);
    }

    protected V get1(K key, int bucket) {
        throw new UnsupportedOperationException("Implement me");
    }
}
