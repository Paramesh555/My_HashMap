package com.example.Hash_Map;

public class Iter17_HashTable<K,V> extends Iter16_HashTable<K,V> {
    //adding remove method but the problem is i need to rehash every time after remove method

    protected V remove(K key){

        int bucket = bucket(key);
        while(true){
            var existing = keys[bucket];
            if(existing == null) return null;
            if(key.equals(existing)){
                var temp =  (V)values[bucket];
                keys[bucket] = null;
                values[bucket] = null;
                size--;
                if(keys.length > 4 && size <= 0.25* keys.length){
                    rehash("decrease");
                }else{
                    rehash("do magic");
                }
                return temp;
            }

            bucket = (bucket+1)% keys.length;

        }

    }
}
