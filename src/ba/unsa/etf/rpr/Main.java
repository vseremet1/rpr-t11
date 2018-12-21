package ba.unsa.etf.rpr;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static String ispisiGradove() throws SQLException {
        GeografijaDAO gd =GeografijaDAO.getInstance();

        ArrayList<Grad> gradovi = gd.gradovi();

        String string = "";

        for (int i = 0; i < gradovi.size(); i++) {
            string += gradovi.get(i).getNaziv();
        }
        return string;
    }

    public static void main(String[] args) throws SQLException {

        GeografijaDAO dao = GeografijaDAO.getInstance();

        System.out.println("Gradovi su:\n" + ispisiGradove());
        glavniGrad();

    }

    private static void glavniGrad() {
        System.out.println("Unesite ime drzave: ");
        Scanner ulaz = new Scanner(System.in);

        String drz = ulaz.nextLine();

    }
}
