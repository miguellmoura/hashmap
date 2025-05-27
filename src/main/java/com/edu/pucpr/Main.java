package com.edu.pucpr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        HashFunction1 hashFunction1 = new HashFunction1();
        HashFunction2 hashFunction2 = new HashFunction2();

        File arquivo = new File("female_names.txt");

        // HASH FUNCTION 1
        Scanner leitor1 = new Scanner(arquivo);

        long startInsert1 = System.nanoTime();

        while (leitor1.hasNextLine()) {
            String name = leitor1.nextLine().trim();

            Integer hash = hashFunction1.hashFunction(name);
            hashFunction1.put(name, hash);
        }

        long endInsert1 = System.nanoTime();
        long totalInsert1 = endInsert1 - startInsert1;

        leitor1.close();

        // HASH FUNCTION 2
        Scanner leitor2 = new Scanner(arquivo);

        long startInsert2 = System.nanoTime();

        while (leitor2.hasNextLine()) {
            String name = leitor2.nextLine().trim();

            Integer hash2 = hashFunction2.hashFunction(name);
            hashFunction2.put(name, hash2);
        }

        long endInsert2 = System.nanoTime();
        long totalInsert2 = endInsert2 - startInsert2;

        leitor2.close();

        System.out.println("\n--- Tabela HashFunction1 ---");
        for (String fname : hashFunction1.table) {
            System.out.println(fname);
        }

        System.out.println("\n--- Tabela HashFunction2 ---");
        for (String fname : hashFunction2.table) {
            System.out.println(fname);
            System.out.println();
        }

        System.out.println("\n--- HashFunction1 ---");
        System.out.println("Colisões: " + hashFunction1.collisions);
        System.out.println("Tempo de inserção: " + totalInsert1 + " ns");

        System.out.println("\n--- HashFunction2 ---");
        System.out.println("Colisões: " + hashFunction2.collisions);
        System.out.println("Tempo de inserção: " + totalInsert2 + " ns");
    }
}