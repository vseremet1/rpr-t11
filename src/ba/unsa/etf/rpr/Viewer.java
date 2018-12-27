package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import net.sf.jasperreports.engine.JRException;

public class Viewer {
    public TextField Grad;
    public TextField Drzava;
    public Button DodajGrad;
    public Button DodajDrzava;
    GeografijaDAO model ;
    public Viewer () {

    }

    public Viewer(GeografijaDAO model) {
        this.model=model;
    }

    public void Grad(KeyEvent keyEvent) {
        Grad= (TextField) keyEvent.getTarget();
        String grad = Grad.getText();



    }

    public void Drzava(KeyEvent keyEvent) {
    }

    public void dodajGrad(ActionEvent actionEvent) {
    }

    public void dodajDrzavu(ActionEvent actionEvent) {
    }

    public void stampajKnjige(ActionEvent actionEvent) {

        try {
            new GradoviReport().showReport(GeografijaDAO.getInstance().getConnection());
        } catch (JRException e1) {
            e1.printStackTrace();
        }
    }
}
