package no.hvl.dat102.uke11.Oppgave4;

import java.util.Arrays;
import java.util.HashSet;


public class main {

    public static void main (String[] args) {

        int antElement = 100000;

        HashSet<Integer> set = new HashSet<>();
        Integer[] tabell = new Integer[antElement];

        int tall = 376;

        for (int i = 0; i < antElement; i++) {

            set.add(tall);
            tabell[i] = tall;
            tall = (tall + 45713) % 1000000;
        }

        Arrays.sort(tabell);

        TestHashSet.testHashSet(set);
        TestBinarySearch.testBinarySearch(tabell);


    }
}
