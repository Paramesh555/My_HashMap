package com.example.Hash_Map;

import java.util.Objects;

public final class Key {
    private final String value;
    private final int hash;

    public Key(String value,int hash){
        this.value = value;
        this.hash=hash;
    }

    @Override
    public boolean equals(Object obj) {
        return obj==this || obj instanceof Key that && Objects.equals(value,that.value);
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public String toString() {
        return value;
    }
}
