import java.util.ArrayList;
import java.util.List;

interface IKolekcjaGwiazd {
    void dodajGwiazde(String nazwa, String nazwaKatalogowa, String deklinacja, String rektascensja,
                      double obserwowanaWielkoscGwiazdowa, double odlegloscWLatachSwietlnych,
                      String gwiazdozbior, String polkula, double temperatura, double masa);

    void usunGwiazde(String nazwaKatalogowa);

    void modyfikujGwiazde(String nazwaKatalogowa, String nowaNazwa, String nowaNazwaKatalogowa,
                          String nowaDeklinacja, String nowaRektascensja, double nowaObserwowanaWielkoscGwiazdowa,
                          double nowaOdlegloscWLatachSwietlnych, String nowyGwiazdozbior, String nowaPolkula,
                          double nowaTemperatura, double nowaMasa);

    void wyswietlGwiazdy();
}

