package no.hvl.dat102.uke10.Oppgave4.IMPL;

import no.hvl.dat102.uke10.Oppgave4.ADT.MengdeADT;

public class HobbyMatchMain {
    public static double match(Person a, Person b) {

        MengdeADT<String> hobbyA = a.getHobbyer();
        MengdeADT<String> hobbyB = b.getHobbyer();

        MengdeADT<String> felles = hobbyA.snitt(hobbyB);
        MengdeADT<String> kunA = hobbyA.minus(hobbyB);
        MengdeADT<String> kunB = hobbyB.minus(hobbyA);
        MengdeADT<String> totalt = hobbyA.union(hobbyB);

        double antallFelles = felles.antallElementer();
        double antallKunA = kunA.antallElementer();
        double antallKunB = kunB.antallElementer();
        double antallTotalt = totalt.antallElementer();

        return antallFelles - (antallKunA + antallKunB) / antallTotalt;
     }


    public static void main(String[] args) {

        Person arne = new Person("Arne",
                "jakt", "sykling", "venner", "data");

        Person berit = new Person("Berit",
                "data", "sykling", "film", "venner");

        Person ole = new Person("Ole",
                "jakt", "fiske", "friluft");

        System.out.println("Match Arne-Berir: " + match(arne, berit));
        System.out.println("Match Arne-Ole: " + match(arne, ole));
        System.out.println("Match Berit-Ole: " + match(berit, ole));
    }


}
