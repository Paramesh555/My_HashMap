package com.example.Hash_Map;

import java.util.Objects;

public class Iter02_HashTable<K,V> extends Iter01_HashTable<K,V>{
    public final V put(K key,V value){
        Objects.requireNonNull(key,"key is null");
        Objects.requireNonNull(value,"value is null");

        return put0(key,value);
    }

    protected V put0(K key, V value) {
        throw new UnsupportedOperationException("Implement me");
    }
}
