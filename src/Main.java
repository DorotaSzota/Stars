import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Tworzenie listy gwiazd
        List<Gwiazda> gwiazdy = new ArrayList<>();

        // Dodawanie gwiazd do listy (tu użyj wcześniej podanych przykładowych gwiazd)

        // Tworzenie obiektu Wyszukiwarka
        Wyszukiwarka wyszukiwarka = new Wyszukiwarka(gwiazdy);

        // Przykłady użycia metod wyszukiwania
        List<Gwiazda> gwiazdyWGwiazdozbiorze = wyszukiwarka.wyszukajWGwiazdozbiorze("Orion");
        List<Gwiazda> gwiazdyWOdleglosci = wyszukiwarka.wyszukajWOdleglosci(15.0);
        List<Gwiazda> gwiazdyWTemperaturze = wyszukiwarka.wyszukajWTemperaturze(5500, 6000);
        List<Gwiazda> gwiazdyWWielkosciGwiazdowej = wyszukiwarka.wyszukajWWielkosciGwiazdowej(-2.0, 0.0);
        List<Gwiazda> gwiazdyWPolkuli = wyszukiwarka.wyszukajWPolkuli("PN");
        List<Gwiazda> potencjalneSupernowe = wyszukiwarka.wyszukajPotencjalneSupernowe();

        // Zapisywanie i wczytywanie danych z pliku
        wyszukiwarka.zapiszDoPliku("gwiazdy.dat");
        wyszukiwarka.wczytajZPliku("gwiazdy.dat");
    }
}
