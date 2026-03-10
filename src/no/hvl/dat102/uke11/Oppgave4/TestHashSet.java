package no.hvl.dat102.uke11.Oppgave4;

import java.util.HashSet;
import java.util.Random;

public class TestHashSet {

    public static void testHashSet(HashSet<Integer> set,  Integer[] soketal) {

        int funn = 0;
        long start = System.nanoTime();

        for (int i = 0; i < soketal.length; i++) {
            if (set.contains(soketal[i])) {
                funn++;
            }
        }


        long slutt = System.nanoTime();

        System.out.println("HashSet søketid: " + (slutt - start) + " ns");
        System.out.println("HashSet fann: " + funn + " tall");
    }
}