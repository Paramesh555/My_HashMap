package com.example.Hash_Map;

public class Iter11_HashTable<K,V> extends Iter10_HashTable<K,V>{
    @Override
    protected final V put2(K key, V value, int bucket) {
        while(keys[bucket] != null){//may run infinity times
            bucket +=1;
            bucket%= keys.length;//when bucket is out of bound
            if(key.equals(keys[bucket])){
                return putReplace(key,value,bucket);
            }
        }
        return putInsertion(key,value,bucket);
    }
}
