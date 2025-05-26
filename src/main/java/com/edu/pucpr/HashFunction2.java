package com.edu.pucpr;

public class HashFunction2 extends HashTable {
    @Override
    public Integer hashFunction(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash += name.charAt(i);
        }
        return hash % 32;
    }
}
