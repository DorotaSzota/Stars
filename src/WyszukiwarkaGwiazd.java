import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WyszukiwarkaGwiazd {
    private Connection connection;
    private String sciezka = "jdbc:sqlite:./GwiazdaDB.db";
    public WyszukiwarkaGwiazd(Connection connection) {
        this.connection = connection;
    }

    public void wyszukajWGwiazdozbiorze(String gwiazdozbior) {
        String sql = "SELECT * FROM gwiazdy WHERE gwiazdozbior = ?";
        wyszukajIWyswietl(sql, gwiazdozbior);
    }

    public void wyszukajWedlugOdleglosci(double odlegloscWParskach) {
        double odlegloscWLatachSwietlnych = odlegloscWParskach * 3.26;

        String sql = "SELECT * FROM gwiazdy WHERE odlegloscWLatachSwietlnych <= ?";
        wyszukajIWyswietl(sql, String.valueOf(odlegloscWLatachSwietlnych));
    }

    public void wyszukajWedlugTemperatury(double minTemperatura, double maxTemperatura) {
        String sql = "SELECT * FROM gwiazdy WHERE temperatura BETWEEN ? AND ?";
        wyszukajIWyswietl(sql, String.valueOf(minTemperatura), String.valueOf(maxTemperatura));
    }

    public void wyszukajWedlugWielkosciGwiazdowej(double minWielkosc, double maxWielkosc) {
        String sql = "SELECT * FROM gwiazdy WHERE obserwowanaWielkoscGwiazdowa BETWEEN ? AND ?";
        wyszukajIWyswietl(sql, String.valueOf(minWielkosc), String.valueOf(maxWielkosc));
    }

    public void wyszukajWedlugPolkuli(String polkula) {
        String sql = "SELECT * FROM gwiazdy WHERE polkula = ?";
        wyszukajIWyswietl(sql, polkula);
    }

    public void wyszukajlPotencjalneSupernowe() {
        String sql = "SELECT * FROM gwiazdy WHERE masa > 1.44";
        wyszukajIWyswietl(sql);
    }

    public void wyszukajIWyswietl(String sql, String... parametry) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < parametry.length; i++) {
                statement.setString(i + 1, parametry[i]);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                int numerGwiazdy = 1;
                while (resultSet.next()) {
                    wyswietlDaneGwiazdy(resultSet, numerGwiazdy);
                    numerGwiazdy++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void wyswietlDaneGwiazdy(ResultSet resultSet, int numerGwiazdy) throws SQLException {
        Gwiazda gwiazda = mapujResultSetNaGwiazde(resultSet);
        System.out.println("Gwiazda " + numerGwiazdy + ":");
        System.out.println(gwiazda);
        System.out.println("--------------");
    }

    public Gwiazda mapujResultSetNaGwiazde(ResultSet resultSet) throws SQLException {
        Gwiazda gwiazda = new Gwiazda();
        gwiazda.setNazwa(resultSet.getString("nazwa"));
        gwiazda.setNazwaKatalogowa(resultSet.getString("nazwaKatalogowa"));
        gwiazda.setDeklinacja(resultSet.getString("deklinacja"));
        gwiazda.setRektascensja(resultSet.getString("rektascensja"));
        gwiazda.setObserwowanaWielkoscGwiazdowa(resultSet.getDouble("obserwowanaWielkoscGwiazdowa"));
        gwiazda.setAbsolutnaWielkoscGwiazdowa(resultSet.getDouble("absolutnaWielkoscGwiazdowa"));
        gwiazda.setOdlegloscWLatachSwietlnych(resultSet.getDouble("odlegloscWLatachSwietlnych"));
        gwiazda.setGwiazdozbior(resultSet.getString("gwiazdozbior"));
        gwiazda.setPolkula(resultSet.getString("polkula"));
        gwiazda.setTemperatura(resultSet.getDouble("temperatura"));
        gwiazda.setMasa(resultSet.getDouble("masa"));
        return gwiazda;
    }
}
