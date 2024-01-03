import java.util.ArrayList;
import java.util.List;

interface KolekcjaGwiazd {
     void dodajGwiazde(List<Gwiazda> lista,Gwiazda obj);

    void usunGwiazde(List<Gwiazda> gwiazdyList, String nazwaKatalogowa);

    void wyswietlGwiazdy(List<Gwiazda> gwiazdyList);
}