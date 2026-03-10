package no.hvl.dat102.uke10.Oppgave4.IMPL;

import no.hvl.dat102.uke10.Oppgave4.ADT.MengdeADT;

import java.util.Set;
import java.util.HashSet;

public class JavaSetToMengde<T> implements MengdeADT<T> {

    private Set<T> set;

    public JavaSetToMengde(){
        set = new HashSet<>();
    }

    @Override
    public boolean erTom() {
        return set.isEmpty();
    }

    @Override
    public boolean inneholder(T element) {
        if (set.contains(element)){
            return true;
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for (T element : set){
            if (!annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if (set.size() != annenMengde.antallElementer()){
            return false;
        }
        for (T element : set){
            if (!annenMengde.inneholder(element)) {
            return false;
            }
        }
        return true;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (T element : set){
            if (annenMengde.inneholder(element)) {
                return false;
            }
        }
        return true;

    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        LenketMengde<T> nyMengde = new LenketMengde<>();

        for (T element : set){
            if (annenMengde.inneholder(element)){
                nyMengde.leggTil(element);
            }
        }
        return nyMengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        LenketMengde<T> nyMengde = new LenketMengde<>();

        nyMengde.leggTilAlleFra(annenMengde);
        for (T element : set){
            if (!annenMengde.inneholder(element)){
                nyMengde.leggTil(element);
            }
        }
        return nyMengde;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        LenketMengde<T> nyMengde = new LenketMengde<>();

        for (T element : set){
            if (!annenMengde.inneholder(element)){
                nyMengde.leggTil(element);
            }
        }
        return nyMengde;
    }

    @Override
    public void leggTil(T element) {
        set.add(element);

    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        T[] tab = (T[]) annenMengde.tilTabell();

        for (int i = 0; i < tab.length; i++) {
            set.add(tab[i]);
        }
    }

    @Override
    public T fjern(T element) {
        if (set.remove(element)) {
            return element;
        }
        return null;
    }

    @Override
    public T[] tilTabell() {
        T[] tab = (T[]) new Object[set.size()];
        int i = 0;
        for (T element : set){
            tab[i] = element;
            i++;
        }
        return tab;
    }

    @Override
    public int antallElementer() {
        return set.size();
    }
}
