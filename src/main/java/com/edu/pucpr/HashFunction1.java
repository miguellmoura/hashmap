package com.edu.pucpr;

public class HashFunction1 extends HashTable {

    @Override
    public Integer hashFunction(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = 31 * hash + name.charAt(i);
        }
        return Math.abs(hash % 32);
    }

    public HashFunction1 () {

    }
}
