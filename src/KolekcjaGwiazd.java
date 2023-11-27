import java.util.ArrayList;
import java.util.List;

interface KolekcjaGwiazd {
     void dodajGwiazde(String nazwa, String nazwaKatalogowa, String deklinacja, String rektascensja,
                      double obserwowanaWielkoscGwiazdowa, double odlegloscWLatachSwietlnych,
                      String gwiazdozbior, String polkula, double temperatura, double masa);

    List<Gwiazda> usunGwiazde(String nazwaKatalogowa);

    void wyswietlGwiazdy();
}