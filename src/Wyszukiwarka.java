import java.util.List;

public interface Wyszukiwarka {
    List<Gwiazda> wyszukajWGwiazdozbiorze(String gwiazdozbior);

    List<Gwiazda> wyszukajWOdleglosci(double odlegloscWLatachSwietlnych);

    List<Gwiazda> wyszukajWGwiazdozbiorzeIOdleglosci(String gwiazdozbior, double odlegloscWLatachSwietlnych);

    List<Gwiazda> wyszukajWTemperaturze(double minTemperatura, double maxTemperatura);

    List<Gwiazda> wyszukajWWielkosciGwiazdowej(double minWielkosc, double maxWielkosc);

    List<Gwiazda> wyszukajWPolkuli(String polkula);

    List<Gwiazda> wyszukajPotencjalneSupernowe();

    void zapiszDoPliku(String nazwaPliku);

    void wczytajZPliku(String nazwaPliku);
}