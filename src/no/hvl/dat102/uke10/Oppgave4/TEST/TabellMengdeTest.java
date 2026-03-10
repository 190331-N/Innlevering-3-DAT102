package no.hvl.dat102.uke10.Oppgave4;

import no.hvl.dat102.uke10.Oppgave4.ADT.MengdeADT;
import no.hvl.dat102.uke10.Oppgave4.IMPL.TabellMengde;

public class TabellMengdeTest extends MengdeADTTest {

    @Override
    protected MengdeADT<Integer> nyMengde() {
        return new TabellMengde<>();
    }
}