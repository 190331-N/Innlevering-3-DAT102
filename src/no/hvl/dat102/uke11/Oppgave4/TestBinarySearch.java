package no.hvl.dat102.uke11.Oppgave4;

import java.util.Arrays;

public class TestBinarySearch {

    public static void testBinarySearch(Integer[] tabell, Integer[] soketal) {

        int funn = 0;
        long start = System.nanoTime();

        for (int i = 0; i < soketal.length; i++) {
            if (Arrays.binarySearch(tabell, soketal[i]) >= 0) {
                funn++;
            }
        }

        long slutt = System.nanoTime();

        System.out.println("Binærsøk søketid: " + (slutt - start) + " ns");
        System.out.println("Binærsøk fann: " + funn + " tall");
    }
}