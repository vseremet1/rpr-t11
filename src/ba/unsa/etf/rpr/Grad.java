package ba.unsa.etf.rpr;

public class Grad {

    int ID;
    String Naziv;
    int broj_stanovnika;
    Drzava d;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public int getBroj_stanovnika() {
        return broj_stanovnika;
    }

    public void setBroj_stanovnika(int broj_stanovnika) {
        this.broj_stanovnika = broj_stanovnika;
    }

    public ba.unsa.etf.rpr.Drzava getDrzava() {
        return d;
    }

    public void setD(Drzava d) {
        this.d = d;
    }


    public void setBrojStanovnika(int i) {
    }

    public void setDrzava(Drzava francuska) {
    }

    public int getBrojStanovnika() {
        return broj_stanovnika;
    }
}
