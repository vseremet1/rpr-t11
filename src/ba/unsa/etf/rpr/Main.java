package ba.unsa.etf.rpr;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class Main  {


    public static String ispisiGradove() throws SQLException {
        GeografijaDAO gd =GeografijaDAO.getInstance();

        ArrayList<Grad> gradovi = gd.gradovi();

        String string = "";

        for (int i = 0; i < gradovi.size(); i++) {
            string += gradovi.get(i).getNaziv()+ " ";
        }
        return string;
    }


     public void start(Stage primaryStage) throws Exception{

        GeografijaDAO model=GeografijaDAO.getInstance();

        FXMLLoader loader = new FXMLLoader( getClass().getResource("gradovi.fxml" ));
        loader.setController(new Viewer(model));
        Parent root=loader.load();
        primaryStage.setTitle("Gradovi");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    public static void main(String[] args) throws SQLException {
        GeografijaDAO dao = GeografijaDAO.getInstance();
        System.out.println("Gradovi su:\n" + ispisiGradove());
        glavniGrad();
        launch(args);

    }

    private static void glavniGrad() {
        System.out.println("Unesite ime drzave: ");
        Scanner ulaz = new Scanner(System.in);

        String drzava = ulaz.nextLine();

    }
}
