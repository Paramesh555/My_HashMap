package com.example.Hash_Map;

public class Iter03_HashTable<K,V> extends Iter02_HashTable<K,V>{

    protected Object[] keys = new Object[4];
    protected Object[] values = new Object[4];

    protected int bucket(Object key){
        var hc = key.hashCode();//this will produce unique values for different output it is basically derived from memory address of the object
        //sometime above value can be negative
        return hc% keys.length;

    }


    @Override
    protected V put0(K key, V value) {
        int bucket = bucket(key);
        var existing = keys[bucket];//var variable type inference.This means the compiler will infer the type of the variable based on the type of the expression on the right-hand side.

        if(existing == null){
            //new mapping
            return putInsertion(key,value,bucket);
        }
        return put1(key,value,bucket,existing);
    }

    protected V put1(K key, V value, int bucket, Object existing) {
        throw new UnsupportedOperationException("Implement me");
    }


    protected V putInsertion(K key, V value, int bucket) {
        keys[bucket] = key;
        values[bucket] = value;
        size++;
        return null;
    }
}
