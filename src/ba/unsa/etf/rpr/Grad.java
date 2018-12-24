package ba.unsa.etf.rpr;

public class Grad {

    int ID;
    String Naziv;
    int broj_stanovnika;
    int drzava;

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

    public int getDrzava() {
        return drzava;
    }

    public void setD(int drzava) {
        this.drzava = drzava;
    }


    public void setBrojStanovnika(int i) {
    }

    public void setDrzava(Drzava francuska) {
    }

    public int getBrojStanovnika() {
        return broj_stanovnika;
    }

    @Override
    public String toString() {
        return  "ID=" + ID +
                ", Naziv='" + Naziv + '\'' +
                ", broj_stanovnika=" + broj_stanovnika +
                ", drzava=" + drzava ;
    }
}
