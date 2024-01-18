import java.sql.*;
import java.util.HashSet;
import java.util.List;


public class Gwiazda  {


    private String nazwa;
    private String nazwaKatalogowa;
    private String deklinacja;
    private String rektascensja;
    private double obserwowanaWielkoscGwiazdowa;
    private double odlegloscWLatachSwietlnych;
    private double absolutnaWielkoscGwiazdowa;
    private String gwiazdozbior;
    private String polkula;
    private double temperatura;
    private double masa;
    private static HashSet<String> zajeteLitery = new HashSet<String>();
    private static final String sciezka = "jdbc:sqlite:./GwiazdaDB.db";



    //KONSTRUKTOR
    public Gwiazda() {
    }
    public Gwiazda(String nazwa, String deklinacja, String rektascensja,
                   double obserwowanaWielkoscGwiazdowa, double odlegloscWLatachSwietlnych,
                   String gwiazdozbior, String polkula, double temperatura, double masa) {

        this.nazwa = nazwa;
        this.deklinacja = deklinacja;
        this.rektascensja = rektascensja;
        this.obserwowanaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa;
        this.odlegloscWLatachSwietlnych = odlegloscWLatachSwietlnych;
        this.absolutnaWielkoscGwiazdowa = setAbsolutnaWielkoscGwiazdowa(obserwowanaWielkoscGwiazdowa);
        this.gwiazdozbior = gwiazdozbior;
        this.polkula = (polkula != null) ? polkula : "brak";
        this.temperatura = temperatura;
        this.masa = masa;
        //generujNazweKatalogowa();
    }


    //GETTERS & SETTERS
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        if (nazwa.matches("[A-Z]{3}\\d{4}")) {
            this.nazwa = nazwa;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa nazwa gwiazdy.");
        }
    }
    //nazwy katalogowej nie ma w konstruktorze, bo ona się utworzy automatycznie
    public String getNazwaKatalogowa() {
        return nazwaKatalogowa;
    }

    public void setNazwaKatalogowa(String nazwaKatalogowa) {
        this.nazwaKatalogowa = generujNazweKatalogowa(nazwaKatalogowa);
    }

    public String getDeklinacja() {
        return deklinacja;
    }

    public void setDeklinacja(String deklinacja) {
        if (deklinacja.matches("-?\\d{1,2}°\\d{1,2}'\\d{1,2}\\.?\\d{0,2}\"")) {
            int stopnie = Integer.parseInt(deklinacja.substring(0, deklinacja.indexOf("°")));
            int minuty = Integer.parseInt(deklinacja.substring(deklinacja.indexOf("°") + 1, deklinacja.indexOf("'")));
            double sekundy = Integer.parseInt(deklinacja.substring(deklinacja.indexOf("'") + 1, deklinacja.indexOf("\"")));
            if ((stopnie > -90 && stopnie < 90 && minuty >= 0 && minuty <= 59 && sekundy >= 0 && sekundy <= 59.99) ||
                    (stopnie == 90 && minuty == 0 && sekundy == 0) || (stopnie == -90 && minuty == 0 && sekundy == 0)) {
                if ((stopnie < 0 && (polkula != null && polkula.equals("PD"))) || (stopnie >= 0 && (polkula != null && polkula.equals("PN")))) {
                    this.deklinacja = deklinacja;
                } else {
                    throw new IllegalArgumentException("Nieprawidłowa półkula.");
                }
            } else {
                throw new IllegalArgumentException("Nieprawidłowa wartość deklinacji.");
            }
        } else {
            throw new IllegalArgumentException("Nieprawidłowa wartość deklinacji.");
        }
    }

    public String getRektascensja() {
        return rektascensja;
    }

    public void setRektascensja(String rektascensja) {

        if (rektascensja.matches("\\d{1,2}h\\d{1,2}m\\d{1,2}s")) {
            int godziny = Integer.parseInt(rektascensja.substring(0, rektascensja.indexOf("h")));
            int minuty = Integer.parseInt(rektascensja.substring(rektascensja.indexOf("h") + 1, rektascensja.indexOf("m")));
            int sekundy = Integer.parseInt(rektascensja.substring(rektascensja.indexOf("m") + 1, rektascensja.indexOf("s")));
            if ((godziny >= 0 && godziny <= 23 && minuty >= 0 && minuty <= 59 && sekundy >= 0 && sekundy <= 59) ||
                    (godziny == 24 && minuty == 0 && sekundy == 0)) {
                this.rektascensja = rektascensja;
            } else {
                throw new IllegalArgumentException("Nieprawidłowa wartość rektascensji.");
            }
        } else {
            throw new IllegalArgumentException("Nieprawidłowa wartość rektascensji.");
        }
    }

    public double getObserwowanaWielkoscGwiazdowa() {
        return obserwowanaWielkoscGwiazdowa;
    }

    public void setObserwowanaWielkoscGwiazdowa(double obserwowanaWielkoscGwiazdowa) {
        if (obserwowanaWielkoscGwiazdowa >= -26.74 && obserwowanaWielkoscGwiazdowa <= 15.00) {
            this.obserwowanaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa wartość obserwowanej wielkości gwiazdowej.");
        }
    }

    public double getAbsolutnaWielkoscGwiazdowa() {
        return absolutnaWielkoscGwiazdowa;
    }

    public double setAbsolutnaWielkoscGwiazdowa(double obserwowanaWielkoscGwiazdowa) {
        double odlegloscWParsekach = odlegloscWLatachSwietlnych * 3.26156;
        return absolutnaWielkoscGwiazdowa = (obserwowanaWielkoscGwiazdowa - (5 * (Math.log10(odlegloscWParsekach)))) + 5;

    }

    public double getOdlegloscWLatachSwietlnych() {
        return odlegloscWLatachSwietlnych;
    }

    public void setOdlegloscWLatachSwietlnych(double odlegloscWLatachSwietlnych) {
        this.odlegloscWLatachSwietlnych = odlegloscWLatachSwietlnych;
    }

    public String getGwiazdozbior() {
        return gwiazdozbior;
    }

    public void setGwiazdozbior(String gwiazdozbior) {
        this.gwiazdozbior = gwiazdozbior;
    }

    public String getPolkula() {
        return polkula;
    }

    public void setPolkula(String polkula) {
        if (polkula.equals("PN") || polkula.equals("PD")) {
            this.polkula = polkula;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa wartość półkuli. Wybierz PN lub PD.");
        }
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        if (temperatura >= 2000) {
            this.temperatura = temperatura;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa temperatura gwiazdy. Minimalna temperatura to 2000 C.");
        }
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        double masaSlonca = 1.9891 * Math.pow(10, 30);
        if (masa >= (0.1 * masaSlonca) && masa <= (50 * masaSlonca)) {
            this.masa = masa;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa masa gwiazdy. Min. 0,1 masy Słońca, max. 50 mas Słońca."); }
    }

    private String generujNazweKatalogowa(String gwiazdozbior) {
        String litera = znajdzWolnaLitere();
        return litera + " " + gwiazdozbior;
    }

    private String znajdzWolnaLitere() {
        AlfabetGrecki[] alfabet = AlfabetGrecki.values();
        for (int i = 0; i < alfabet.length; i++) {
            String litera = alfabet[i].toString();
            if (!zajeteLitery.contains(litera)) {
                zajeteLitery.add(litera);
                return litera;
            }
        }
        throw new IllegalStateException("Nie można znaleźć wolnego symbolu w alfabecie greckim.");
    }


    private void aktualizujBazeDanych(Gwiazda gwiazda) {
        try (Connection connection = DriverManager.getConnection(sciezka)) {
            String nazwaKatalogowa = generujNazweKatalogowa(gwiazda.getGwiazdozbior());

            String checkQuery = "SELECT nazwa FROM gwiazdy WHERE nazwa=?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
                checkStatement.setString(1, gwiazda.getNazwa());
                ResultSet resultSet = checkStatement.executeQuery();

                if (resultSet.next()) {
                    // Gwiazda już istnieje w bazie danych, aktualizuj NazwaKatalogowa
                    String updateQuery = "UPDATE gwiazdy SET nazwaKatalogowa=? WHERE nazwa=?";
                    try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                        updateStatement.setString(1, nazwaKatalogowa);
                        updateStatement.setString(2, gwiazda.getNazwa());
                        updateStatement.executeUpdate();
                    }
                } else {
                    String insertQuery = "INSERT INTO gwiazdy VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                        preparedStatement.setString(1, gwiazda.getNazwa());
                        preparedStatement.setString(2, gwiazda.getDeklinacja());
                        preparedStatement.setString(3, gwiazda.getRektascensja());
                        preparedStatement.setDouble(4, gwiazda.getObserwowanaWielkoscGwiazdowa());
                        preparedStatement.setDouble(5, gwiazda.getAbsolutnaWielkoscGwiazdowa());
                        preparedStatement.setDouble(6, gwiazda.getOdlegloscWLatachSwietlnych());
                        preparedStatement.setString(7, gwiazda.getGwiazdozbior());
                        preparedStatement.setString(8, gwiazda.getPolkula());
                        preparedStatement.setDouble(9, gwiazda.getTemperatura());
                        preparedStatement.setDouble(10, gwiazda.getMasa());
                        preparedStatement.setString(11, nazwaKatalogowa);

                        preparedStatement.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dodajGwiazdeDoBazy(Gwiazda nowaGwiazda) {
        aktualizujBazeDanych(nowaGwiazda);
    }

    public void usunGwiazdeZBazy(Gwiazda gwiazdaDoUsuniecia) {
        try (Connection connection = DriverManager.getConnection(sciezka)) {
            String deleteQuery = "DELETE FROM gwiazdy WHERE nazwa=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setString(1, gwiazdaDoUsuniecia.getNazwa());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void wyswietlGwiazdy() {
        try (Connection connection = DriverManager.getConnection(sciezka);
             Statement statement = connection.createStatement()) {

            String selectQuery = "SELECT * FROM gwiazdy";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            int numerGwiazdy = 1;
            while (resultSet.next()) {
                System.out.println("Gwiazda " + numerGwiazdy + ":");
                System.out.println("Nazwa: " + resultSet.getString("nazwa"));
                System.out.println("Nazwa Katalogowa: " + resultSet.getString("nazwaKatalogowa"));
                System.out.println("Deklinacja: " + resultSet.getString("deklinacja"));
                System.out.println("Rektascensja: " + resultSet.getString("rektascensja"));
                System.out.println("Obserwowana Wielkość Gwiazdowa: " + resultSet.getDouble("obserwowanaWielkoscGwiazdowa"));
                System.out.println("Absolutna Wielkość Gwiazdowa: " + resultSet.getDouble("absolutnaWielkoscGwiazdowa"));
                System.out.println("Odległość w Latach Świetlnych: " + resultSet.getDouble("odlegloscWLatachSwietlnych") + " lat świetlnych");
                System.out.println("Gwiazdozbiór: " + resultSet.getString("gwiazdozbior"));
                System.out.println("Półkula: " + resultSet.getString("polkula"));
                System.out.println("Temperatura: " + resultSet.getDouble("temperatura"));
                System.out.println("Masa: " + resultSet.getDouble("masa"));
                System.out.println("--------------");

                numerGwiazdy++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





