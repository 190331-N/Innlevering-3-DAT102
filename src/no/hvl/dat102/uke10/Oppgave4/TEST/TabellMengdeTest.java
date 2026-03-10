package no.hvl.dat102.uke10.Oppgave4.TEST;

import no.hvl.dat102.uke10.Oppgave4.ADT.MengdeADT;
import no.hvl.dat102.uke10.Oppgave4.IMPL.TabellMengde;
import no.hvl.dat102.uke10.Oppgave4.TEST.MengdeADTTest;

public class TabellMengdeTest extends MengdeADTTest {

    @Override
    protected MengdeADT<Integer> nyMengde() {
        return new TabellMengde<>();
    }
}