package michelinstarreview;

import java.util.ArrayList;

public abstract class UgostiteljskiObjekat {

    private String naziv;
    private double prosecnaOcena;
    private int brMichelinZvezda;
    private ArrayList<String> recenzije;

    public UgostiteljskiObjekat(String naziv, double prosecnaOcena, int brMichelinZvezda, ArrayList<String> recenzije) {
        this.naziv = naziv;
        if (prosecnaOcena >= 1 && prosecnaOcena <= 5) {
            this.prosecnaOcena = prosecnaOcena;
        } else {
            throw new IllegalArgumentException("Prosecna ocena ne moze biti izvan 1 i 5!");
        }
        if (brMichelinZvezda >= 0 && brMichelinZvezda <= 3) {
            this.brMichelinZvezda = brMichelinZvezda;
        } else {
            throw new IllegalArgumentException("Broj zvezda ne moze biti izvan 0 i 3!");
        }
        this.recenzije = recenzije;
    }

    public UgostiteljskiObjekat(String naziv, double prosecnaOcena, int brMichelinZvezda) {
        this.naziv = naziv;
        if (prosecnaOcena >= 1 && prosecnaOcena <= 5) {
            this.prosecnaOcena = prosecnaOcena;
        } else {
            throw new IllegalArgumentException("Prosecna ocena ne moze biti izvan 1 i 5!");
        }
        if (brMichelinZvezda >= 0 && brMichelinZvezda <= 3) {
            this.brMichelinZvezda = brMichelinZvezda;
        } else {
            throw new IllegalArgumentException("Broj zvezda ne moze biti izvan 0 i 3!");
        }
        this.recenzije = new ArrayList<>();
    }

    public UgostiteljskiObjekat(String naziv, double prosecnaOcena) {
        this.naziv = naziv;
        if (prosecnaOcena >= 1 && prosecnaOcena <= 5) {
            this.prosecnaOcena = prosecnaOcena;
        } else {
            throw new IllegalArgumentException("Prosecna ocena ne moze biti izvan 1 i 5!");
        }
        this.brMichelinZvezda = 0;
        this.recenzije = new ArrayList<>();
    }

    public UgostiteljskiObjekat(String naziv) {
        this.naziv = naziv;
        this.prosecnaOcena = 3;
        this.brMichelinZvezda = 0;
        this.recenzije = new ArrayList<>();
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getProsecnaOcena() {
        return prosecnaOcena;
    }

    public void setProsecnaOcena(double prosecnaOcena) {
        if (prosecnaOcena >= 1 && prosecnaOcena <= 5) {
            this.prosecnaOcena = prosecnaOcena;
        } else {
            throw new IllegalArgumentException("Prosecna ocena ne moze biti izvan 1 i 5!");
        }
    }

    public int getBrMichelinZvezda() {
        return brMichelinZvezda;
    }

    public void setBrMichelinZvezda(int brMichelinZvezda) {
        if (brMichelinZvezda >= 0 && brMichelinZvezda <= 3) {
            this.brMichelinZvezda = brMichelinZvezda;
        } else {
            throw new IllegalArgumentException("Broj zvezda ne moze biti izvan 0 i 3!");
        }
    }

    public ArrayList<String> getRecenzije() {
        return recenzije;
    }

    public void setRecenzije(ArrayList<String> recenzije) {
        this.recenzije = recenzije;
    }

    public void dodajRecenziju(String s) {
        recenzije.add(s);
    }

    public void obrisiRecenziju(String s) {
        recenzije.remove(s);
    }

    public void dodajViseOcena(ArrayList<Double> ocene) {
        double suma = 0;
        int brojac = 0;
        for (Double o : ocene) {
            suma += o;
            brojac++;
        }
        double prosek = suma / brojac;
        setProsecnaOcena((getProsecnaOcena() + prosek) / 2);
        azurirajZvezdu();
    }

    public abstract void dodajOcenu(double ocena);

    public abstract void azurirajZvezdu();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ----- ").append(naziv).append(" -----\n");
        sb.append(" ***** ").append(brMichelinZvezda).append(" *****\n");
        sb.append("\n");
        sb.append("Prosecna ocena: ").append(prosecnaOcena).append("\n");
        sb.append("Recenzije:\n");
        for (String s : recenzije) {
            sb.append(s).append("\n");
        }
        return sb.toString();
    }
}
