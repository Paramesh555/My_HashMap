package com.example.Hash_Map;

public class Iter10_HashTable<K,V> extends Iter09_HashTable<K,V>{

    @Override
    protected V put2(K key, V value, int bucket) {
        //this is hash collision case
        while(keys[bucket] != null){//may run infinity times
            bucket +=1;
            bucket%= keys.length;//when bucket is out of bound
        }
        return putInsertion(key,value,bucket);

    }
}
