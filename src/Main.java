import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Gwiazda> gwiazdy = new ArrayList<>();

        Gwiazda ALF1234 = new Gwiazda("ALF1234","alfa Orionis","12°34'56.78\"","05h36m24s",-5.0,10.5,"Orion","PN",5000,0.5);
        Gwiazda BET5678 = new Gwiazda();


        BET5678.dodajGwiazde("BET5678","beta Ursae Majoris","45°18'32.10\"","09h47m31s",-4.5,8.2,"Wielka Niedźwiedzica","PN",5100,1.0);



        // Tworzenie obiektu Wyszukiwarka
        WyszukiwarkaGwiazd wyszukiwarka = new WyszukiwarkaGwiazd(gwiazdy);

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
