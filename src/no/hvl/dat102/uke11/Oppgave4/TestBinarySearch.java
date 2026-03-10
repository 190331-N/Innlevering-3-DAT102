package no.hvl.dat102.uke11.Oppgave4;

import java.util.Arrays;

public class TestBinarySearch {

    public static void testBinarySearch(Integer[] tabell) {
        long start = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            int tall = (int) (Math.random() * 1000000);
            Arrays.binarySearch(tabell, tall);
        }

        long slutt = System.nanoTime();

        System.out.println("Binærsøk søketid: " + (slutt - start) + " ns");
    }
}