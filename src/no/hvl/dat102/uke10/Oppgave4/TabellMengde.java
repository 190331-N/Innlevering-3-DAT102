package no.hvl.dat102.uke10.Oppgave4;

public class TabellMengde<T> implements MengdeADT<T>{
    @Override
    public boolean erTom() {
        return false;
    }

    @Override
    public boolean inneholder(Object element) {
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT annenMengde) {
        return false;
    }

    @Override
    public boolean erLik(MengdeADT annenMengde) {
        return false;
    }

    @Override
    public boolean erDisjunkt(MengdeADT annenMengde) {
        return false;
    }

    @Override
    public MengdeADT snitt(MengdeADT annenMengde) {
        return null;
    }

    @Override
    public MengdeADT union(MengdeADT annenMengde) {
        return null;
    }

    @Override
    public MengdeADT minus(MengdeADT annenMengde) {
        return null;
    }

    @Override
    public void leggTil(Object element) {

    }

    @Override
    public void leggTilAlleFra(MengdeADT annenMengde) {

    }

    @Override
    public T fjern(Object element) {
        return null;
    }

    @Override
    public T[] tilTabell() {
        return new T[0];
    }

    @Override
    public int antallElementer() {
        return 0;
    }
}
