//W bazie mozliwe jest wyszukiwanie obiektów na podstawie nastepujacych
//        kryteriów:
//        wyszukaj wszystkie gwiazdy w gwiazdozbiorze;
//        wyszukaj gwiazdy znajdujace sie w odległosci x parseków od Ziemii
//        (nalezy uwzglednic iz obiekt gwiazdowy opisany jest przy pomocy lat
//        swietlnych);
//        wyszukaj gwiazdy o temperaturze w zadanym przedziale;
//        wyszukaj gwiazdy o wielkosci gwiazdowej w zadanym przedziale;
//        wyszukaj gwiazdy z półkuli północnej / południowej;
//        wyszukaj potencjalne supernowe. Supernowe to gwiazdy, których
//        masa przekracza tzw. granice Chandrasekhara, która wynosi 1.44
//        masy Słonca.
//        Wszystkie dane powinny zostac zapisane w pliku obiektowym.
//        Poszczególne elementy projektu powinny byc zrealizowane jako funkcje,
//        lub metody klasy.

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Wyszukiwarka {
    private List<Gwiazda> gwiazdy;

    public Wyszukiwarka(List<Gwiazda> gwiazdy) {
        this.gwiazdy = gwiazdy;
    }

    public List<Gwiazda> wyszukajWGwiazdozbiorze(String gwiazdozbior) {
        List<Gwiazda> wyniki = new ArrayList<>();
        for (Gwiazda gwiazda : gwiazdy) {
            if (gwiazda.getGwiazdozbior().equalsIgnoreCase(gwiazdozbior)) {
                wyniki.add(gwiazda);
            }
        }
        return wyniki;
    }

    public List<Gwiazda> wyszukajWOdleglosci(double odlegloscWLatachSwietlnych) {
        List<Gwiazda> wyniki = new ArrayList<>();
        for (Gwiazda gwiazda : gwiazdy) {
            if (gwiazda.getOdlegloscWLatachSwietlnych() <= odlegloscWLatachSwietlnych) {
                wyniki.add(gwiazda);
            }
        }
        return wyniki;
    }

    public List<Gwiazda> wyszukajWGwiazdozbiorzeIOdleglosci(String gwiazdozbior, double odlegloscWLatachSwietlnych) {
        List<Gwiazda> wyniki = new ArrayList<>();
        for (Gwiazda gwiazda : gwiazdy) {
            if (gwiazda.getGwiazdozbior().equalsIgnoreCase(gwiazdozbior)
                    && gwiazda.getOdlegloscWLatachSwietlnych() <= odlegloscWLatachSwietlnych) {
                wyniki.add(gwiazda);
            }
        }
        return wyniki;
    }

    public List<Gwiazda> wyszukajWTemperaturze(double minTemperatura, double maxTemperatura) {
        List<Gwiazda> wyniki = new ArrayList<>();
        for (Gwiazda gwiazda : gwiazdy) {
            if (gwiazda.getTemperatura() >= minTemperatura && gwiazda.getTemperatura() <= maxTemperatura) {
                wyniki.add(gwiazda);
            }
        }
        return wyniki;
    }

    public List<Gwiazda> wyszukajWWielkosciGwiazdowej(double minWielkosc, double maxWielkosc) {
        List<Gwiazda> wyniki = new ArrayList<>();
        for (Gwiazda gwiazda : gwiazdy) {
            if (gwiazda.getObserwowanaWielkoscGwiazdowa() >= minWielkosc
                    && gwiazda.getObserwowanaWielkoscGwiazdowa() <= maxWielkosc) {
                wyniki.add(gwiazda);
            }
        }
        return wyniki;
    }

    public List<Gwiazda> wyszukajWPolkuli(String polkula) {
        List<Gwiazda> wyniki = new ArrayList<>();
        for (Gwiazda gwiazda : gwiazdy) {
            if (gwiazda.getPolkula().equalsIgnoreCase(polkula)) {
                wyniki.add(gwiazda);
            }
        }
        return wyniki;
    }

    public List<Gwiazda> wyszukajPotencjalneSupernowe() {
        List<Gwiazda> wyniki = new ArrayList<>();
        for (Gwiazda gwiazda : gwiazdy) {
            if (gwiazda.getMasa() > 1.44) {
                wyniki.add(gwiazda);
            }
        }
        return wyniki;
    }

    public void zapiszDoPliku(String nazwaPliku) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nazwaPliku))) {
            outputStream.writeObject(gwiazdy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void wczytajZPliku(String nazwaPliku) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nazwaPliku))) {
            gwiazdy = (List<Gwiazda>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

