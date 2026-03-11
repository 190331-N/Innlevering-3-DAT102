package no.hvl.dat102.uke10.Oppgave4.IMPL;

import no.hvl.dat102.uke10.Oppgave4.ADT.MengdeADT;

public class Person {

    String navn;
    private MengdeADT<String> hobbyer;

    public Person(String navn, String... hobbyer) {
        this.navn = navn;
        this.hobbyer = new LenketMengde<>();

        for (String h : hobbyer) {
            this.hobbyer.leggTil(h);
        }
    }

    public String getNavn() {
        return navn;
    }

    public MengdeADT<String> getHobbyer() {
        return hobbyer;
    }
}
