package com.example.Hash_Map;

public class Iter12_HashTable<K,V> extends Iter11_HashTable<K,V>{
    @Override
    protected final V get1(K key, int bucket) {
        //here because of hash collision we changed the position, while retrieving we need to go to correct position

        while(!key.equals(keys[bucket])){
            if(keys[bucket] == null){
                //remember we are using linear probing
                return null;
            }
            bucket+=1;
            bucket%= keys.length;
        }
        return (V)values[bucket];
    }



}
