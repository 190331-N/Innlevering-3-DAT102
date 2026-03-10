package no.hvl.dat102.uke10.Oppgave4.TEST;

import no.hvl.dat102.uke10.Oppgave4.ADT.MengdeADT;
import no.hvl.dat102.uke10.Oppgave4.IMPL.LenketMengde;

public class LenketMengdeTest extends MengdeADTTest {

    @Override
    protected MengdeADT<Integer> nyMengde() {
        return new LenketMengde<>();
    }
}