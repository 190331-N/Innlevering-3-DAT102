package no.hvl.dat102.uke11.Oppgave4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class main {

    public static void main (String[] args) {

        int antElement = 100000;
        int antSok = 10000;

        HashSet<Integer> set = new HashSet<>();
        Integer[] tabell = new Integer[antElement];

        int tall = 376;

        for (int i = 0; i < antElement; i++) {

            set.add(tall);
            tabell[i] = tall;
            tall = (tall + 45713) % 1000000;
        }

        Arrays.sort(tabell);

        Arrays.sort(tabell);

        Integer[] soketal = new Integer[antSok];
        Random rand = new Random();

        for (int i = 0; i < antSok; i++) {
            soketal[i] = rand.nextInt(1000000);
        }

        TestHashSet.testHashSet(set,  soketal);
        TestBinarySearch.testBinarySearch(tabell, soketal);


    }
}
