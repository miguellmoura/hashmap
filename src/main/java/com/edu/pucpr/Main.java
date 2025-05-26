package com.edu.pucpr;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        HashFunction1 hashFunction1 = new HashFunction1();
        HashFunction2 hashFunction2 = new HashFunction2();
        File arquivo = new File("female_names.txt");

        Scanner leitor = new Scanner(arquivo);

        while (leitor.hasNextLine()) {

            String name = leitor.nextLine();

            // HASH FUNCTION 1
            Integer hash = hashFunction1.hashFunction(name);
            hashFunction1.put(name, hash);

            // HASH FUNCTION 2
            Integer hash2 = hashFunction2.hashFunction(name);
            hashFunction2.put(name, hash2);
        }

        for (String fname : hashFunction1.table) {
            System.out.println(fname);
        }

        for (String fname : hashFunction2.table) {
            System.out.println(fname);
        }

        System.out.println("Colisions of hashFunc1");
        System.out.println(hashFunction1.collisions);
        System.out.println("Colisions of hashFunc2");
        System.out.println(hashFunction2.collisions);
    }
}