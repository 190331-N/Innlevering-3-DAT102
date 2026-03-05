package no.hvl.dat102.uke10.Oppgave4;

public class LenketMengde<T> implements MengdeADT<T>{

    public class Node<T> {

        T data;
        Node<T> neste = null;

        public Node(T data) {
            this.data = data;
            this.neste = null;
        }
    }
    private Node<T> forste;
    private int antall;

    @Override
    public boolean erTom() {
        return forste == null;
    }

    @Override
    public boolean inneholder(T element) {
        if (erTom()){
            return false;
        }
        while (forste!= null){
            if (forste.data.equals(element)){
                return true;
            }
            forste = forste.neste;
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        if(erTom()){
            return false;
        }
        while (forste != null){
            if (annenMengde.inneholder(forste.data)){
                return true;
            }
            forste = forste.neste;
        }

        return false;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if(erTom()){
            return false;
        }
        while (forste != null){
            if (annenMengde.inneholder(forste.data)){
                return true;
            }
            forste = forste.neste;
        }
        return false;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        if(erTom()){
            return false;
        }
        while (forste != null){
            if (annenMengde.inneholder(forste.data)){
                return false;
            }
            forste = forste.neste;
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public void leggTil(T element) {

    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {

    }

    @Override
    public T fjern(T element) {
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
}
