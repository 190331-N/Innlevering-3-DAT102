package no.hvl.dat102.uke10.Oppgave4;

import no.hvl.dat102.uke10.Oppgave4.ADT.MengdeADT;
import no.hvl.dat102.uke10.Oppgave4.IMPL.JavaSetToMengde;

public class JavaSetToMengdeTest extends MengdeADTTest {

    @Override
    protected MengdeADT<Integer> nyMengde() {
        return new JavaSetToMengde<>();
    }
}