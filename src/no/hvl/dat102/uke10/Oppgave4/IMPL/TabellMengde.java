package no.hvl.dat102.uke10.Oppgave4.IMPL;
import no.hvl.dat102.uke10.Oppgave4.ADT.MengdeADT;

import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T> {

    private T[] tabell;
    private int antall;

    private static int startStorrelse = 10;

    public TabellMengde(){
        tabell = (T[]) new Object[startStorrelse];
        antall = 0;
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public boolean inneholder(T element) {
        if (element == null) return false;
        for (int i = 0; i < antall; i++) {
            if (tabell[i].equals(element)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for (int i = 0; i < antall; i++) {

            if (!annenMengde.inneholder(tabell[i])) {
                return false;
            }

        }

        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if (antall != annenMengde.antallElementer()) {
            return false;
        }

        return this.erDelmengdeAv(annenMengde);
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (int i = 0; i < antall; i++) {

            if (annenMengde.inneholder(tabell[i])) {
                return false;
            }

        }

        return true;
    }

    @Override
    public MengdeADT snitt(MengdeADT<T> annenMengde) {
        if (annenMengde == null) throw new IllegalArgumentException("annenMengde er null");

        TabellMengde<T> resultat = new TabellMengde<>();
        for (int i = 0; i < antall; i++) {
            T e = tabell[i];
            if (annenMengde.inneholder(e)) resultat.leggTil(e);
        }
        return resultat;
    }

    @Override
    public MengdeADT union(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT minus(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public void leggTil(T element) {
        if (element == null) throw new IllegalArgumentException();
        if (inneholder(element)) return;
        if (antall == tabell.length) utvid();
        tabell[antall++] = element;

    }

    @Override
    public void leggTilAlleFra(MengdeADT<T>annenMengde) {

    }

    @Override
    public T fjern(T element) {
        for (int i = 0; i < antall; i++) {

            if (tabell[i].equals(element)) {

                T fjernet = tabell[i];

                tabell[i] = tabell[antall - 1];
                tabell[antall - 1] = null;

                antall--;

                return fjernet;
            }
        }

        return null;
    }

    @Override
    public T[] tilTabell() {
        return null;
    }

    @Override
    public int antallElementer() {
        return antall;
    }

    private void utvid() {
        tabell = Arrays.copyOf(tabell, tabell.length * 2);
    }
}