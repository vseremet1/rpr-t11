package ba.unsa.etf.rpr;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class GeografijaDAO {

    private static GeografijaDAO geografija = new GeografijaDAO(); // privatna referenca na vlastitu klasu
    Connection connection = null;

    private GeografijaDAO()   //privatni konstruktor bez parametara
    {
        try
        {

            connection = DriverManager.getConnection("jdbc:sqlite:sqlite(1).db");


            Statement statement = connection.createStatement();
           statement.execute("SELECT * from Grad ");
        }
        catch (Exception e)
        {
            try {
                Statement statement = connection.createStatement();
                statement.execute("CREATE TABLE 'Grad' (\n" +
                        "ID integer primary key,\n" +
                        "Naziv Text\n" +
                        " broj_stanovnika integer,\n" +
                        "  Drzava integer references 'Drzava' (ID)\n" +
                        "\n" +
                        ");\n" +
                        "\n" +
                        "CREATE  TABLE 'Drzava'(\n" +
                        "ID integer primary key,\n" +
                        "  Naziv text,\n" +
                        "  glavni_grad integer references 'Grad' (ID)\n" +
                        "\n" +
                        "\n" +
                        ");\n" +
                        "\n" +
                        "\n" +
                        "\n");

                String grad1 = "INSERT INTO Grad VALUES (1, 'Pariz', 11659260,1)";
                String grad2 = "INSERT INTO Grad VALUES (2, 'London', 11659260,2)";
                String grad3 = "INSERT INTO Grad VALUES (3, 'Beč', 11659260,3)";
                String grad4 = "INSERT INTO Grad VALUES (4, 'Manchester', 11659260,4)";
                String grad5 = "INSERT INTO Grad VALUES (5, 'Graz', 11659260,5)";

                Statement s1 = connection.createStatement();
                Statement s2 = connection.createStatement();
                Statement s3 = connection.createStatement();
                Statement s4 = connection.createStatement();
                Statement s5 = connection.createStatement();


                s1.executeUpdate(grad1);
                s2.executeUpdate(grad2);
                s3.executeUpdate(grad3);
                s4.executeUpdate(grad4);
                s5.executeUpdate(grad5);

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static GeografijaDAO getInstance() throws SQLException //javna metoda getInstance vraća instancu i poziva initialize po potrebi

    {

        return geografija;
    }

    public static void removeInstance() {
    }


    public Grad glavniGrad(String drzava) {
        Grad grad = new Grad();
        // @Language ("SQLite")

        try {
            Statement statement = connection.createStatement();
            String upit = "SELECT * from Grad";
            ResultSet resultSet = statement.executeQuery(upit);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grad;
    }


    public void obrisiDrzavu(String drzava) {


    }


    public ArrayList<Grad> gradovi() {

        ArrayList<Grad> gradovi = new ArrayList<>();

        return gradovi;
    }

    public void dodajGrad(Grad grad) {

    }

    public void dodajDrzavu(Drzava drzava) {

    }

    public void izmjeniDrzavu(Grad grad) {

    }

    public Drzava nadjiDrzavu(String drzava) {
        return null;
    }


    public void izmijeniGrad(Grad bech) {
    }
}
