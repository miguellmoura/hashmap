package com.edu.pucpr;

public class HashFunction2 extends HashTable {
    @Override
    public Integer hashFunction(String name) {
        if (name.isEmpty()) return 0;
        return name.charAt(0) % 32;
    }
}
