package ba.unsa.etf.rpr;

public class Drzava {


    int ID;
    String Naziv;
    int glavni_grad;


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

    public int getGlavni_grad() {
        return glavni_grad;
    }

    public void setGlavni_grad(int glavni_grad) {
        this.glavni_grad = glavni_grad;
    }

    public void setGlavniGrad(Grad sarajevo) {
    }

    @Override
    public String toString() {
        return
                "ID=" + ID +
                ", Naziv='" + Naziv + '\'' +
                ", glavni_grad=" + glavni_grad ;
    }
}
