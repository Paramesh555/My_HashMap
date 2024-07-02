package com.example.Hash_Map;

public class Iter07_HashTable<K,V> extends Iter06_HashTable<K,V>{

    @Override
    protected V put1(K key, V value, int bucket, Object existing) {
        if(existing.equals(key)){
            return putReplace(key,value,bucket);
        }
       return put2(key,value,bucket);
    }

    protected V put2(K key, V value, int bucket) {
        throw new UnsupportedOperationException("Implement me");
    }

    @SuppressWarnings("unchecked")
    protected V putReplace(K key, V value, int bucket) {
        var oldValue = (V)values[bucket];
        values[bucket] = value;
        return oldValue;
    }
}
