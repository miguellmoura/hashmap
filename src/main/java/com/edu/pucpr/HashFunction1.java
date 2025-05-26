package com.edu.pucpr;

public class HashFunction1 extends HashTable {

    @Override
    public Integer hashFunction(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash += name.charAt(i) * (i + 1);
        }
        return hash % 32;
    }

    public HashFunction1 () {

    }
}
