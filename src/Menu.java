import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

public class Menu {
    public static void main(String[] args) {

        String sciezka = "jdbc:sqlite:./GwiazdaDB.db";
        int wybor;

        try (Connection connection = DriverManager.getConnection(sciezka)) {
            WyszukiwarkaGwiazd wyszukiwarka = new WyszukiwarkaGwiazd(connection);
            Scanner scanner = new Scanner(System.in);

            do {
                System.out.println("Witaj w programie Wyszukiwarka Gwiazd!");
                System.out.println("Wybierz opcję:");
                System.out.println("1. Wyszukaj wszystkie nazwy w danym gwiazdozbiorze");
                System.out.println("2. Wyszukaj gwiazdy po odległości od Ziemi");
                System.out.println("3. Wyszukaj gwiazdy po temperarturze");
                System.out.println("4. Wyszukaj gwiazdę po wielkości gwiazdowej");
                System.out.println("5. Wyszukaj gwiazdę po półkuli");
                System.out.println("6. Wyszukaj potencjalne supernowe");
                System.out.println("7. Wyświetl wszystkie gwiazdy");
                System.out.println("8. Dodaj gwiazdę");
                System.out.println("9. Usuń gwiazdę");
                System.out.println("0. Wyjdź z programu");

                System.out.print("Wybierz opcję: ");
                wybor = scanner.nextInt();
                scanner.nextLine();

                switch (wybor) {
                    case 1:
                        System.out.println("Wyszukaj wszystkie nazwy w danym gwiazdozbiorze.");
                        System.out.println("Podaj nazwę gwiazdozbioru:");
                        String nazwaGwiazdozbioru = scanner.next();
                        wyszukiwarka.wyszukajWGwiazdozbiorze(nazwaGwiazdozbioru);
                        break;
                    case 2:
                        System.out.println("Wyszukaj gwiazdy po odległości od Ziemi.\nPodaj odległość od Ziemi w parsekach:");
                        double odlegloscWParsekach = scanner.nextDouble();
                        wyszukiwarka.wyszukajWedlugOdleglosci(odlegloscWParsekach);
                        break;
                    case 3:
                        System.out.println("Wyszukaj gwiazdy po temperaturze.\nPodaj temperaturę minimalną i maksymalną:");
                        double minTemperatura = scanner.nextDouble();
                        double maxTemperatura = scanner.nextDouble();
                        wyszukiwarka.wyszukajWedlugTemperatury(minTemperatura, maxTemperatura);
                        break;
                    case 4:
                        System.out.println("Wyszukaj gwiazdę po wielkości gwiazdowej.\nPodaj wielkość minimalną i maksymalną:");
                        double minWielkosc = scanner.nextDouble();
                        double maxWielkosc = scanner.nextDouble();
                        wyszukiwarka.wyszukajWedlugWielkosciGwiazdowej(minWielkosc, maxWielkosc);
                        break;
                    case 5:
                        System.out.println("Wyszukaj gwiazdę po półkuli.\nPodaj PN lub PD:");
                        String ktoraPolkula = scanner.next();
                        wyszukiwarka.wyszukajWedlugPolkuli(ktoraPolkula);
                        break;
                    case 6:
                        System.out.println("Wyszukaj potencjalne supernowe.");
                        wyszukiwarka.wyszukajlPotencjalneSupernowe();
                        break;
                    case 7:
                        System.out.println("Wyświetl wszystkie gwiazdy.");
                        Gwiazda gwiazda = new Gwiazda();
                        gwiazda.wyswietlGwiazdy();
                        break;
                    case 8:
                        System.out.println("Dodaj gwiazdę.");
                        System.out.println("Podaj nazwę gwiazdy:");
                        String nazwaGwiazdy = scanner.next();
                        System.out.println("Podaj półkulę (PN lub PD):");
                        String polkula = scanner.next();
                        System.out.println("Podaj deklinację:");
                        String deklinacja = scanner.next();
                        System.out.println("Podaj rektascensję:");
                        String rektascensja = scanner.next();
                        System.out.println("Podaj obserwowaną wielkość gwiazdową:");
                        double obserwowanaWielkosc = scanner.nextDouble();
                        System.out.println("Podaj odległość w latach świetlnych:");
                        double odlegloscWLatach = scanner.nextDouble();
                        System.out.println("Podaj gwiazdozbiór:");
                        String gwiazdozbior = scanner.next();
                        System.out.println("Podaj temperaturę:");
                        double temperatura = scanner.nextDouble();
                        System.out.println("Podaj masę:");
                        double masa = scanner.nextDouble();
                        break;
                    case 9: //działa
                        System.out.println("Usuń gwiazdę.");
                        System.out.println("Podaj nazwę gwiazdy do usunięcia:");
                        String nazwaDoUsuniecia = scanner.next();
                        Gwiazda gwiazdaDoUsuniecia = new Gwiazda();
                        gwiazdaDoUsuniecia.setNazwa(nazwaDoUsuniecia);
                        gwiazdaDoUsuniecia.usunGwiazdeZBazy(gwiazdaDoUsuniecia);
                        break;
                    case 0: //działa
                        System.out.println("Wyjdź z programu.");
                        if (connection != null) {
                            try {
                                connection.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    default:
                        System.out.println("Nieprawidłowy wybór. Wybierz z przedziału 0-9.");
                        break;
                }

            } while (wybor != 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
