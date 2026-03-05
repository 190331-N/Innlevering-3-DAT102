package no.hvl.dat102.uke10.Oppgave4;

public class LenketMengde<T> implements MengdeADT<T>{

    private static class Node<T> {

        T data;
        Node<T> neste = null;

        public Node(T data) {
            this.data = data;
        }
    }
    private Node<T> forste;
    private int antall;
    
    public LenketMengde(){
        forste = null;
        antall = 0;
    }

    @Override
    public boolean erTom() {
        return forste == null;
    }

    @Override
    public boolean inneholder(T element) {
        Node<T> current = forste;

        while (current!= null){
            if (current.data.equals(element)){
                return true;
            }
            current = current.neste;
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        Node<T> current = forste;

        while (current != null){
            if (!(annenMengde.inneholder(current.data))){
                return false;
            }
            current = current.neste;
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        Node<T> current = forste;

        if (antall != annenMengde.antallElementer()){
            return false;
        }
        while (current != null){
            if (!(annenMengde.inneholder(current.data))){
                return false;
            }
            current = current.neste;
        }
        return true;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        Node<T> current = forste;
        while (current != null){
            if (annenMengde.inneholder(current.data)){
                return false;
            }
            current = current.neste;
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        Node<T> current = forste;
        LenketMengde<T> nyMengde = new LenketMengde<>();

        while (current != null){
            if (annenMengde.inneholder(current.data)){
                nyMengde.leggTil(current.data);
            }
            current = current.neste;
        }
        return nyMengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        LenketMengde<T> nyMengde = new LenketMengde<>();
        nyMengde.leggTilAlleFra(this);
        nyMengde.leggTilAlleFra(annenMengde);
        return nyMengde;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        Node<T> current = forste;
        LenketMengde<T> nyMengde = new LenketMengde<>();

        while (current != null){
            if (!annenMengde.inneholder(current.data)){
                nyMengde.leggTil(current.data);
            }
            current = current.neste;
        }
        return nyMengde;
    }

    @Override
    public void leggTil(T element) {
        Node<T> nyNode = new Node<T>(element);

        Node<T> current = forste;
        while (current != null){
            if (current.data.equals(element)){
                return;
            }
            current = current.neste;
        }
        nyNode.neste = forste;
        forste = nyNode;
        antall++;
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        T[] tab = (T[]) annenMengde.tilTabell();

        for (int i = 0; i < tab.length; i++) {
            leggTil(tab[i]);
        }
    }

    @Override
    public T fjern(T element) {
        if (erTom()){
            return null;
        }
        Node<T> forrige = null;
        Node<T> current = forste;
        T temp = null;

        while (current != null){
            if (current.data.equals(element)){
                if (current == forste){
                    temp = forste.data;
                    forste = forste.neste;
                    antall--;
                    return temp;
                }else{
                    temp = current.data;
                    forrige.neste = current.neste;
                    antall--;
                    return temp;
                }
            }
            forrige = current;
            current = current.neste;
        }
        return temp;
    }

    @Override
    public T[] tilTabell() {
        T[] tab = (T[]) new Object[antall];
        Node<T> current = forste;
        int i = 0;

        while (current != null){
            tab[i] = current.data;
            i++;
            current = current.neste;
        }
        return tab;
    }

    @Override
    public int antallElementer() {
        return antall;
    }
}
