package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import net.sf.jasperreports.engine.JRException;


import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class Viewer {
    public TextField Grad;
    public TextField Drzava;
    public Button DodajGrad;
    public Button DodajDrzava;
    GeografijaDAO model ;
    public Viewer () {

        model = GeografijaDAO.getInstance();
    }

    public Viewer(GeografijaDAO model) {
        this.model=model;
    }

    public void Grad(KeyEvent keyEvent) {
        Grad= (TextField) keyEvent.getTarget();
        String grad = Grad.getText();

    }

    public void dodajEngleski (ActionEvent actionEvent) throws IOException {
       Main.load(Locale.forLanguageTag("en"));
    }

    public void dodajBosanski (ActionEvent actionEvent) throws IOException {
       Main.load(Locale.forLanguageTag("bs"));
    }

    public void dodajFrancuski (ActionEvent actionEvent) throws IOException {
        Main.load(Locale.forLanguageTag("fr"));
    }
    public  void dodajNjemacki (ActionEvent actionEvent) throws IOException {
        Main.load(Locale.forLanguageTag("de"));

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

    public void save(ActionEvent actionEvent) {


        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);








    }
}
