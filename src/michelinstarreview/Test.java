package michelinstarreview;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        Restoran r1 = new Restoran("Neki Restoran", 5.0, 3, 55);
        System.out.println(r1);
        ArrayList<String> recenzije = new ArrayList<>();
        recenzije.add("Ovaj restoran je dobar.");
        recenzije.add("Ukusna je hrana.");
        recenzije.add("Lepa je usluga.");
        Inspektor i1 = new Inspektor(r1);
        String s = "Ovaj restoran je dobar";
        i1.dodajOpis(s);
        System.out.println(r1);
        i1.obrisiOpis(s);
        System.out.println(r1);
        System.out.println(r1.getProsecnaOcena());
        System.out.println("================");
        r1.dodajOcenu(3);
        System.out.println(r1);
        r1.dodajOcenu(2);
        System.out.println(r1);
        r1.dodajOcenu(4.5);
        System.out.println(r1);
        r1.azurirajZvezdu();
        System.out.println(r1);
        ArrayList<Double> ocene = new ArrayList<>();
        ocene.add(1.4);
        ocene.add(2.7);
        ocene.add(4.2);
        r1.dodajViseOcena(ocene);
        System.out.println(r1.getProsecnaOcena());
        System.out.println(r1);
        i1.dodajOcenu(5);
        System.out.println(r1);
        System.out.println();
    }
}
