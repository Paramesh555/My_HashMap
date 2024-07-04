package com.example.Hash_Map;

public class Iter14_HashTable<K,V> extends Iter13_HashTable<K,V>{
    @Override
    protected final V putInsertion(K key, V value, int bucket) {
        V result = super.putInsertion(key, value, bucket);

        if (size >= 0.75*keys.length) {
            rehash("increase");
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    protected void rehash(String type) {
        var capacity = keys.length;
        if(type.equals("increase"))
             capacity = keys.length << 1;
        else if (type.equals("decrease")) {
            capacity = keys.length >> 1;
        }

        if (capacity < 0) {//when exceeds the 32 bit it is start giving negative no's.
            throw new OutOfMemoryError();
        }

        var oldKeys = keys;

        var oldValues = values;

        keys = new Object[capacity];

        values = new Object[capacity];



        size = 0;

        for (int i = 0; i < oldKeys.length; i++) {
            var key = oldKeys[i];

            if (key == null) {
                continue;
            }

            var value = oldValues[i];

            put0((K) key, (V) value);
        }
    }
}
