package no.hvl.dat102.uke10.Oppgave4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TabellMengdeTest {
    private MengdeADT<Integer> m;
    private MengdeADT<Integer> a;
    private MengdeADT<Integer> b;
    private MengdeADT<Integer> c;

    @BeforeEach
    void setup() {
        m = new TabellMengde<>();
        a = new TabellMengde<>();
        b = new TabellMengde<>();
        c = new TabellMengde<>();
    }

    @Test
    void nyMengdeErTom() {
        assertTrue(m.erTom());
        assertEquals(0, m.antallElementer());
    }
    @Test
    void leggTilOgInneholder() {
        m.leggTil(10);
        m.leggTil(20);

        assertFalse(m.erTom());
        assertTrue(m.inneholder(10));
        assertTrue(m.inneholder(20));
        assertFalse(m.inneholder(30));
        assertEquals(2, m.antallElementer());
    }
    @Test
    void leggTilSkalIkkeGiDuplikater() {
        m.leggTil(10);
        m.leggTil(10);
        m.leggTil(10);

        assertEquals(1, m.antallElementer());
        assertTrue(m.inneholder(10));
    }

    @Test
    void fjernSkalFjerne() {
        m.leggTil(1);
        m.leggTil(2);
        m.leggTil(3);
        m.fjern(2);

        assertFalse(m.inneholder(2));
        assertEquals(2, m.antallElementer());
    }
    @Test
    void unionSkalGiAlle() {
        a.leggTil(1);
        a.leggTil(2);
        b.leggTil(2);
        b.leggTil(3);

        MengdeADT<Integer> u = a.union(b);

        assertTrue(u.inneholder(1));
        assertTrue(u.inneholder(2));
        assertTrue(u.inneholder(3));
        assertEquals(3, u.antallElementer());
    }
    @Test
    void snittSkalGiFelles() {
        a.leggTil(1);
        a.leggTil(2);
        a.leggTil(3);
        b.leggTil(2);
        b.leggTil(4);

        MengdeADT<Integer> s = a.snitt(b);

        assertTrue(s.inneholder(2));
        assertFalse(s.inneholder(1));
        assertFalse(s.inneholder(3));
        assertFalse(s.inneholder(4));
        assertEquals(1,s.antallElementer());
    }
    @Test
    void erLik_erDisjunkt_erDelMengde() {
        a.leggTil(1);
        a.leggTil(2);
        b.leggTil(2);
        b.leggTil(1);
        c.leggTil(3);

        assertTrue(a.erLik(b));
        assertTrue(a.erDelmengdeAv(b));
        assertTrue(a.erDisjunkt(c));
        assertFalse(a.erDisjunkt(b));
    }
    @Test
    void minusSkalFjerneElementer() {
        a.leggTil(1);
        a.leggTil(2);
        a.leggTil(3);
        b.leggTil(2);

        MengdeADT<Integer> m = a.minus(b);

        assertTrue(m.inneholder(1));
        assertTrue(m.inneholder(3));
        assertFalse(m.inneholder(2));
        assertEquals(2,m.antallElementer());
    }
    @Test
    void leggTilAlleFraSkalLeggeTilAlle() {
        a.leggTil(1);
        a.leggTil(2);
        b.leggTil(2);
        b.leggTil(3);
        a.leggTilAlleFra(b);

        assertTrue(a.inneholder(1));
        assertTrue(a.inneholder(2));
        assertTrue(a.inneholder(3));
        assertEquals(3, a.antallElementer());
    }
    @Test
    void tilTabellSkalReturnereAlleElementer() {
        m.leggTil(1);
        m.leggTil(2);
        m.leggTil(3);

        Integer[] tabell = m.tilTabell();
        assertEquals(3, tabell.length);
        boolean har1 = false, har2 = false, har3 = false;

        for (Integer i : tabell) {
            if (i == 1) har1 = true;
            if (i == 2) har2 = true;
            if (i == 3) har3 = true;
        }
        assertTrue(har1 && har2 && har3);
    }
    }
