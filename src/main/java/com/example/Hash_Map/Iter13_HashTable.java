package com.example.Hash_Map;

import java.util.Arrays;

public class Iter13_HashTable<K,V> extends Iter12_HashTable<K,V>{
    @Override
    protected V putInsertion(K key, V value, int bucket) {
       V result = super.putInsertion(key,value,bucket);
       if(size == keys.length){
           resize();
       }
       return result;
    }

    private void resize() {
        var newLength = keys.length << 1;
        keys = Arrays.copyOf(keys, newLength);
        values = Arrays.copyOf(values, newLength);
    }
}
