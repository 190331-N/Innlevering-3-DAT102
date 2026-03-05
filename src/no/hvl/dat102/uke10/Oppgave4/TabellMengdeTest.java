package no.hvl.dat102.uke10.Oppgave4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TabellMengdeTest {


    private MengdeADT<Integer> tom;
    private MengdeADT<Integer> a;
    private MengdeADT<Integer> b;

    @BeforeEach
    void setup() {
        tom = new TabellMengde<>();
        a = new TabellMengde<>();
        b = new TabellMengde<>();
    }

    private static <T> Set<T> asSet(T[] arr) {
        return new HashSet<>(Arrays.asList(arr));
    }

@Test
    void nyMengdeSkalVereTom() {

}


}
