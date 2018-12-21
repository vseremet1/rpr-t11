package ba.unsa.etf.rpr;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class GeografijaDAO {

    private static GeografijaDAO geografija = null; // privatna referenca na vlastitu klasu
    Connection connection = null;

    private GeografijaDAO() throws SQLException   //privatni konstruktor bez parametara
    {


        // treba kreirati konekciju

        File baza = new File("/sqlite(1).db");
        boolean postoji = false;

        if (!postoji) {
            connection = getConnection();
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

        }

        // sve potrebne pripremljene upite

        try {
            PreparedStatement upit1 = (PreparedStatement) connection.prepareStatement("INSERT INTO Grad VALUES (?,?,?)");
            PreparedStatement upit2 = (PreparedStatement) connection.prepareStatement("Insert into Drzava values (?,?,?)");
            PreparedStatement pripremaDrzava = (PreparedStatement) connection.prepareStatement("SELECT * from Drzava where ID= ? AND Naziv=? AND Glavni_grad=?");
            PreparedStatement pripremaGrad = (PreparedStatement) connection.prepareStatement("SELECT * from Grad where Naziv=? AND ID=? AND Drzava=?");


        } catch (SQLException e) {
            e.printStackTrace();
        }


        // ako datoteka baza.db ne postoji treba je popuniti podacima za gradove: Pariz, London, Beč, Manchester i Graz

    }

    private static void initialize() throws SQLException // privatna metoda initialize koja spomenutoj referenci daje vrijednost

    {
        geografija = new GeografijaDAO();

    }

    public static java.sql.Connection getConnection() {
        java.sql.Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:sqlite:sqlite(1).db");

        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }

    public static GeografijaDAO getInstance() throws SQLException //javna metoda getInstance vraća instancu i poziva initialize po potrebi

    {
        initialize();

        return geografija;
    }

    public static void removeInstance() {
    }


    public Grad glavniGrad(String drzava) {
        Grad grad = new Grad();

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


}
