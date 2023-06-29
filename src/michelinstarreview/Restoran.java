package michelinstarreview;

import java.util.ArrayList;

public class Restoran extends UgostiteljskiObjekat {

    private int brojSlobodnihStolova;

    public Restoran(String naziv, double presecnaOcena, int brMichelinZvezda, ArrayList<String> recenzije, int brojSlobodnihStolova) {
        super(naziv, presecnaOcena, brMichelinZvezda, recenzije);
        if (brojSlobodnihStolova >= 0) {
            this.brojSlobodnihStolova = brojSlobodnihStolova;
        } else {
            throw new IllegalArgumentException("Broj  slobodnih stolova ne moze biti negativan broj");
        }
    }

    public Restoran(String naziv, double presecnaOcena, int brMichelinZvezda, int brojSlobodnihStolova) {
        super(naziv, presecnaOcena, brMichelinZvezda);
        if (brojSlobodnihStolova >= 0) {
            this.brojSlobodnihStolova = brojSlobodnihStolova;
        } else {
            throw new IllegalArgumentException("Broj  slobodnih stolova ne moze biti negativan broj");
        }
    }

    public Restoran(String naziv, double presecnaOcena, int brojSlobodnihStolova) {
        super(naziv, presecnaOcena);
        if (brojSlobodnihStolova >= 0) {
            this.brojSlobodnihStolova = brojSlobodnihStolova;
        } else {
            throw new IllegalArgumentException("Broj  slobodnih stolova ne moze biti negativan broj");
        }
    }

    public Restoran(String naziv, int brojSlobodnihStolova) {
        super(naziv);
        if (brojSlobodnihStolova >= 0) {
            this.brojSlobodnihStolova = brojSlobodnihStolova;
        } else {
            throw new IllegalArgumentException("Broj  slobodnih stolova ne moze biti negativan broj");
        }
    }

    public Restoran(String naziv) {
        super(naziv);
        this.brojSlobodnihStolova = 25;
    }

    public int getBrojSlobodnihStolova() {
        return brojSlobodnihStolova;
    }

    public void setBrojSlobodnihStolova(int brojSlobodnihStolova) {
        if (brojSlobodnihStolova >= 0) {
            this.brojSlobodnihStolova = brojSlobodnihStolova;
        } else {
            throw new IllegalArgumentException("Broj  slobodnih stolova ne moze biti negativan broj");
        }
    }

    public boolean imaLiSlobodnihStolova() {
        return brojSlobodnihStolova > 0;
    }

    public void oslobodiSto() {
        brojSlobodnihStolova++;
    }

    public void oslobodiSto(int x) {
        brojSlobodnihStolova = brojSlobodnihStolova + x;
    }

    public void zaokupiSto() {
        if (brojSlobodnihStolova > 0) {
            brojSlobodnihStolova -= 1;
        } else {
            throw new IllegalArgumentException("Broj  slobodnih stolova ne moze biti negativan broj");
        }
    }

    public void zaokupiSto(int x) {
        while (getBrojSlobodnihStolova() > 0 && x > 0) {
            brojSlobodnihStolova--;
            x--;
        }
    }

    @Override
    public void dodajOcenu(double ocena) {
        if (ocena >= 1 && ocena <= 5) {
            if (ocena >= 4.5 || ocena <= 2.0) {
                if (ocena >= getProsecnaOcena()) {
                    ocena -= 0.3;
                    setProsecnaOcena((getProsecnaOcena() + ocena) / 2);
                } else {
                    setProsecnaOcena((getProsecnaOcena() + ocena) / 2);
                }
                azurirajZvezdu();
            } else {
                if (ocena >= getProsecnaOcena()) {
                    ocena -= 0.3;
                    setProsecnaOcena((getProsecnaOcena() + ocena) / 2);
                } else {
                    setProsecnaOcena((getProsecnaOcena() + ocena) / 2);
                }
            }

        }
    }

    @Override
    public void azurirajZvezdu() {
        if (getProsecnaOcena() > 4.5) {
            setBrMichelinZvezda(getBrMichelinZvezda() + 2);
        } else if (getProsecnaOcena() > 3.5) {              //ako "ispod" u tekstu zadatka ima ekskluzivno znacenje za 4.5, 3.5 vrednosti,
            setBrMichelinZvezda(getBrMichelinZvezda() + 1); //uracunati to u ovu metodu, ja sam pretpostavio da "ispod" znaci da je inkluzivno!
        } else if (getProsecnaOcena() > 3.0) {
            setBrMichelinZvezda(getBrMichelinZvezda() - 1);
        } else {
            setBrMichelinZvezda(getBrMichelinZvezda() - 2);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------\n");
        sb.append(" Restoran\n");
        sb.append("---------------------\n");
        sb.append(super.toString());
        return sb.toString();
    }
}
