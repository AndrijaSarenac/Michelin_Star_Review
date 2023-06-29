package michelinstarreview;

public class Inspektor {

    private UgostiteljskiObjekat objekat;

    public Inspektor(UgostiteljskiObjekat objekat) {
        this.objekat = objekat;
    }

    public UgostiteljskiObjekat getObjekat() {
        return objekat;
    }

    public void setObjekat(UgostiteljskiObjekat objekat) {
        this.objekat = objekat;
    }

    public void dodajOpis(String opis) {
        objekat.dodajRecenziju(opis);
    }

    public void obrisiOpis(String opis) {
        objekat.obrisiRecenziju(opis);
    }

    public void dodajOcenu(double ocena) {
        objekat.dodajOcenu(ocena);
    }

    public void dodeliZvezdu() { //ovde nisam siguran sta se trazi
        objekat.azurirajZvezdu(); //druga opcija je objekat.setBrMichelinZvezda ali onda mora (int) argument!
    }

    public String procitajRecenzije() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objekat.getRecenzije().size(); i++) {
            sb.append(i + 1).append(") ").append(objekat.getRecenzije().get(i)).append("\n");
        }
        return sb.toString();
    }

    public String procitajRecenzije(int i) {
        if (i >= 0 && i < objekat.getRecenzije().size()) {
            return objekat.getRecenzije().get(i);
        } else {
            throw new IndexOutOfBoundsException("Ne postoji recenzija na poziciji koju ste uneli!");
        }
    }

    public void zatvoriObjekat() {
        objekat.setProsecnaOcena(1.0);
        objekat.setBrMichelinZvezda(0);
    }

    public static int uporediUgostiteljskeObjekte(UgostiteljskiObjekat o1, UgostiteljskiObjekat o2) {
        if (o1.getBrMichelinZvezda() > o2.getBrMichelinZvezda() || (o1.getBrMichelinZvezda() == o2.getBrMichelinZvezda() && o1.getProsecnaOcena() > o2.getProsecnaOcena()))
            return -1;
        else if (o1.getBrMichelinZvezda() == o2.getBrMichelinZvezda() && o1.getProsecnaOcena() == o2.getProsecnaOcena()) {
            return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ja sam posetio restoran: ").append(objekat);
        return sb.toString();
    }
}
