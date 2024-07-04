package com.example.Hash_Map;

public class Iter16_HashTable<K,V> extends Iter15_HashTable<K,V> {
    //implement containsKey method
    protected final boolean containsKey(K key){
        int bucket = bucket(key);


        while(true){
            var existing = keys[bucket];
            if(existing == null) return false;
            if(key.equals(existing)) return true;
            bucket = (bucket+1)%keys.length;
        }


    }
}
