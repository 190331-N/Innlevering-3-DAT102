package no.hvl.dat102.uke11.Oppgave4;

import java.util.HashSet;
import java.util.Random;

public class TestHashSet {

    public static void testHashSet(HashSet<Integer> set) {
        Random rand = new Random();

        long start = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            int tall = rand.nextInt(1000000);
            set.contains(tall);
        }

        long slutt = System.nanoTime();

        System.out.println("HashSet søketid: " + (slutt - start) + " ns");
    }
}