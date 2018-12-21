package ba.unsa.etf.rpr;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static String ispisiGradove() throws SQLException {
        GeografijaDAO gd = (GeografijaDAO) GeografijaDAO.getInstance();
        ArrayList<Grad> gradovi = gd.gradovi();

        String string = null;

        for (int i = 0; i < gradovi.size(); i++) {
            string += gradovi.get(i).getNaziv();
        }
        return string;
    }

    public static void main(String[] args) throws SQLException {


        Connection connection = null;
        try {
            connection = GeografijaDAO.getConnection();
            if (connection != null) {
                System.out.println("OK");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Gradovi su:\n" + ispisiGradove());
        glavniGrad();

    }

    private static void glavniGrad() {
        System.out.println("Unesite ime drzave: ");
        Scanner ulaz = new Scanner(System.in);

        String drz = ulaz.nextLine();

    }
}
