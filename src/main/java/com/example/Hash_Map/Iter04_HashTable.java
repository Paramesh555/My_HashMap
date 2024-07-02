package com.example.Hash_Map;

import java.util.Objects;

public class Iter04_HashTable<K,V> extends Iter03_HashTable<K,V>{
    @SuppressWarnings("uncheked")
    protected V get(K key){
        Objects.requireNonNull(key,"key is null");
        var bucket = bucket(key);
        var candidate =keys[bucket];
        if(key.equals(candidate))//to ensure the key is same
            return (V)values[bucket];
        return get0(key,bucket,candidate);
    }

    protected V get0(K key, int bucket, Object candidate) {
        throw new UnsupportedOperationException("Implement me");
    }
}
