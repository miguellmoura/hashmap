package com.edu.pucpr;

public abstract class HashTable {

    String[] table;
    Integer collisions;
    Integer tableCapacity;
    Integer size;

    public HashTable() {
        this.collisions = 0;
        this.size = 0;
        this.tableCapacity = 32;
        this.table = new String[this.tableCapacity];
    }

    public abstract Integer hashFunction(String name);

    public void put(String name) {
        Float FATOR_DE_CARGA = 0.85F;
        if (this.size >= FATOR_DE_CARGA * this.tableCapacity) {
            this.resizeTable();
        }

        int value = this.hashFunction(name);
        while (this.table[value] != null) {
            this.collisions++;
            value = (value + 1) % this.tableCapacity;
        }

        this.table[value] = name;
        this.size++;
    }

    public long get (String nome) {

        long searchStartTime = System.nanoTime();

        Integer value = this.hashFunction(nome);

        while (!table[value].equals(nome)) {
            if (value == table.length - 1) {
                System.out.println("Nome não encontrado!");
                break;
            } else {
                value += 1;
            }
        }

        long searchEndTime = System.nanoTime();

        long searchTime = searchEndTime - searchStartTime;

        return searchTime;
    }

    private void resizeTable() {
        this.tableCapacity = (int) Math.floor(this.tableCapacity * 1.1);
        String[] oldTable = this.table;
        this.table = new String[this.tableCapacity];
        this.size = 0;
        this.collisions = 0;

        for (String name : oldTable) {
            if (name != null) {
                this.put(name);
            }
        }
    }


    public String remove(String name, Integer value) {
        this.table[value] = null;
        this.size--;
        return name;
    }
}
