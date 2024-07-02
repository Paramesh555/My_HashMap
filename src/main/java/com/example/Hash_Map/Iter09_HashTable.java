package com.example.Hash_Map;

public class Iter09_HashTable<K,V> extends Iter08_HashTable<K,V>{
    @Override
    public final String toString() {
        var sb = new StringBuilder();

        sb.append(
                """
                +-----+-----+-----+
                | idx | key | val |
                +-----+-----+-----+
                """);
        for(int i=0;i<keys.length;i++){
            var key = keys[i];
            if(key != null){
                var value = values[i];
                sb.append("| %3d | %3s | %3s |\n".formatted(i, key.toString(), value));
            }else{
                sb.append("| %3d |     |     |\n".formatted(i));
            }
        }
        sb.append("+-----+-----+-----+\n");
        return sb.toString();
    }
}
