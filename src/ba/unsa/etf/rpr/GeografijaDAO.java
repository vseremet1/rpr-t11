package ba.unsa.etf.rpr;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class GeografijaDAO {

    private static GeografijaDAO geografija = new GeografijaDAO(); // privatna referenca na vlastitu klasu
    private Connection connection = null;

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
                assert connection != null;
                Statement statement = connection.createStatement();
                statement.execute("CREATE TABLE 'Grad' (\n" +
                        "ID integer primary key,\n" +
                        "Naziv Text,\n" +
                        "broj_stanovnika integer,\n" +
                        "Drzava integer references 'Drzava' (ID)\n" +
                        "\n" +
                        ");\n" +
                        "\n" +
                        "CREATE  TABLE 'Drzava'(\n" +
                        "ID integer primary key,\n" +
                        "Naziv text,\n" +
                        "glavni_grad integer references 'Grad' (ID)\n" +
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

                s1.execute(grad1);
                s2.execute(grad2);
                s3.execute(grad3);
                s4.execute(grad4);
                s5.execute(grad5);

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static GeografijaDAO getInstance()  //javna metoda getInstance vraća instancu i poziva initialize po potrebi

    {
        return geografija;
    }

    public static void removeInstance() {
        geografija=null;
    }

    public Grad glavniGrad(String drzava) {
        Grad grad = new Grad();


        try {
            Statement statement = connection.createStatement();
            String upit = "SELECT * from Grad";
            ResultSet resultSet = statement.executeQuery(upit);
            grad.ID= resultSet.getInt(1);
            grad.Naziv=resultSet.getString(2);
            grad.broj_stanovnika=resultSet.getInt(3);
            grad.drzava = resultSet.getInt(4);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grad;
    }


    public void obrisiDrzavu(String drzava) throws SQLException {

        Statement statement = connection.createStatement();
        String izbrisi = ("DELETE FROM Table WHERE name = " + drzava + ";");
        // brise i gradove ??

        statement.executeQuery(izbrisi);
    }


    public ArrayList<Grad> gradovi() throws SQLException {

        ArrayList<Grad> gradovi = new ArrayList<>();



        Statement statement = connection.createStatement();
        String upitGradovi   = "SELECT * FROM Grad ORDER BY broj_stanovnika DESC" ;
        ResultSet resultSet = statement.executeQuery(upitGradovi);

        while (resultSet.next())
        {
            Grad grad = new Grad();
             grad.setID(resultSet.getInt(1));
            grad.setNaziv(resultSet.getString(2));
            grad.setBroj_stanovnika(resultSet.getInt(3));
            grad.setD(resultSet.getInt(4));
            gradovi.add(grad);
        }

        return gradovi;
    }

    public void dodajGrad(Grad grad) throws SQLException {
        Statement statement = connection.createStatement();
        String g  = grad.toString();
        String upitDodajGrad = ("INSERT INTO Grad VALUES"+g);
        statement.executeQuery(upitDodajGrad);
    }

    public void dodajDrzavu(Drzava drzava) throws SQLException {

        Statement statement = connection.createStatement();
        String g  = drzava.toString();
        String upitDodajDrzavu = ("INSERT INTO Drzava VALUES"+g);
        statement.executeQuery(upitDodajDrzavu);

    }

     public Drzava nadjiDrzavu(String drzava) throws SQLException {

        Statement statement= connection.createStatement();
        String upit = "SELECT * FROM Drzava WHERE Naziv = drzava ";
        ResultSet resultSet = statement.executeQuery(upit);
        Drzava drzava1 = new Drzava();

        if (!resultSet.next()) return null;

        drzava1.setID(resultSet.getInt(1));
        drzava1.setNaziv(resultSet.getString(2));
        drzava1.setGlavni_grad(resultSet.getInt(3));

        return drzava1;

    }

    public void izmijeniGrad(Grad grad) throws SQLException {
        Statement statement = connection.createStatement();
        String g = grad.toString();
        String upit = "UPDATE Grad SET ("+g+")";
         statement.executeQuery(upit);
    }

    public Connection getConnection() {
        return connection;
    }
}
