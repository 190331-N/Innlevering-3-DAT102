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
        if (annenMengde == null) {
            throw new IllegalArgumentException("annenMengde er null");
        }

        TabellMengde<T> resultat = new TabellMengde<>();

        // legg inn alle fra denne mengden
        for (int i = 0; i < antall; i++) {
            resultat.leggTil(tabell[i]);
        }

        // legg inn alle fra annenMengde
        T[] tab2 = annenMengde.tilTabell();
        for (int i = 0; i < annenMengde.antallElementer(); i++) {
            resultat.leggTil(tab2[i]);
        }

        return resultat;
    }

    @Override
    public MengdeADT minus(MengdeADT<T> annenMengde) {
        if (annenMengde == null) {
            throw new IllegalArgumentException("annenMengde er null");
        }

        TabellMengde<T> resultat = new TabellMengde<>();

        for (int i = 0; i < antall; i++) {
            if (!annenMengde.inneholder(tabell[i])) {
                resultat.leggTil(tabell[i]);
            }
        }

        return resultat;
    }

    @Override
    public void leggTil(T element) {
        if (element == null) throw new IllegalArgumentException("element er null");
        if (inneholder(element)) return;
        if (antall == tabell.length) utvid();
        tabell[antall++] = element;

    }

    @Override
    public void leggTilAlleFra(MengdeADT<T>annenMengde) {
        if (annenMengde == null) {
            throw new IllegalArgumentException("annenMengde er null");
        }

        T[] tab2 = annenMengde.tilTabell();
        for (int i = 0; i < annenMengde.antallElementer(); i++) {
            leggTil(tab2[i]);
        }
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
        return Arrays.copyOf(tabell, antall);
    }

    @Override
    public int antallElementer() {
        return antall;
    }

    private void utvid() {
        tabell = Arrays.copyOf(tabell, tabell.length * 2);
    }
}