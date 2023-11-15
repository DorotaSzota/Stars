import java.util.ArrayList;
import java.util.List;

public class Gwiazda implements IKolekcjaGwiazd {

    private List<Gwiazda> gwiazdyList = new ArrayList<>();
    private String nazwa;
    private String nazwaKatalogowa;
    private String deklinacja;
    private String rektascensja;
    private double obserwowanaWielkoscGwiazdowa;
    private double absolutnaWielkoscGwiazdowa;
    private double odlegloscWLatachSwietlnych;
    private String gwiazdozbior;
    private String polkula;
    private double temperatura;
    private double masa;

    public Gwiazda(String nazwa, String nazwaKatalogowa, String deklinacja, String rektascensja,
                   double obserwowanaWielkoscGwiazdowa, double odlegloscWLatachSwietlnych,
                   String gwiazdozbior, String polkula, double temperatura, double masa) {
        if (nazwa.matches("[A-Z]{3}\\d{4}")) {
            this.nazwa = nazwa;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa nazwa gwiazdy.");
        }

        this.nazwaKatalogowa = nazwaKatalogowa;
        this.deklinacja = deklinacja;
        this.rektascensja = rektascensja;

        if (obserwowanaWielkoscGwiazdowa >= -26.74 && obserwowanaWielkoscGwiazdowa <= 15.00) {
            this.obserwowanaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa wartość obserwowanej wielkości gwiazdowej.");
        }

        this.odlegloscWLatachSwietlnych = odlegloscWLatachSwietlnych;
        this.gwiazdozbior = gwiazdozbior;

        if (polkula.equals("PN") || polkula.equals("PD")) {
            this.polkula = polkula;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa wartość półkuli.");
        }

        if (temperatura >= 2000) {
            this.temperatura = temperatura;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa temperatura gwiazdy.");
        }

        if (masa >= 0.1 && masa <= 50) {
            this.masa = masa;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa masa gwiazdy.");}

        // Obliczanie absolutnej wielkości gwiazdowej
        this.absolutnaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa - 5 * (Math.log10(odlegloscWLatachSwietlnych) - 1) + 5;
    }
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


    //GETTERS & SETTERS
    public String getNazwaKatalogowa() {
        return nazwaKatalogowa;
    }

    public void setNazwaKatalogowa(String nazwaKatalogowa) {
        this.nazwaKatalogowa = nazwaKatalogowa;
    }

    public String getDeklinacja() {
        return deklinacja;
    }

    public void setDeklinacja(String deklinacja) {
        this.deklinacja = deklinacja;
    }

    public String getRektascensja() {
        return rektascensja;
    }

    public void setRektascensja(String rektascensja) {
        this.rektascensja = rektascensja;
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

    public double getOdlegloscWLatachSwietlnych() {
        return odlegloscWLatachSwietlnych;
    }

    public void setOdlegloscWLatachSwietlnych(double odlegloscWLatachSwietlnych) {
        this.odlegloscWLatachSwietlnych = odlegloscWLatachSwietlnych;
        // ponowne obliczenie absolutnej wielkości gwiazdowej przy zmianie odległości
        this.absolutnaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa - 5 * (Math.log10(odlegloscWLatachSwietlnych) - 1) + 5;
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
            throw new IllegalArgumentException("Nieprawidłowa wartość półkuli.");
        }
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        if (temperatura >= 2000) {
            this.temperatura = temperatura;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa temperatura gwiazdy.");
        }
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        if (masa >= 0.1 && masa <= 50) {
            this.masa = masa;
        } else {
            throw new IllegalArgumentException("Nieprawidłowa masa gwiazdy."); }
    }

    //IMPLEMENTACJA INTERFEJSU
    @Override
    public void dodajGwiazde(String nazwa, String nazwaKatalogowa, String deklinacja, String rektascensja,
                             double obserwowanaWielkoscGwiazdowa, double odlegloscWLatachSwietlnych,
                             String gwiazdozbior, String polkula, double temperatura, double masa) {
        // Sprawdzenie czy istnieje gwiazda o podanej nazwie katalogowej
        for (Gwiazda gwiazda : gwiazdyList) {
            if (gwiazda.getNazwaKatalogowa().equals(nazwaKatalogowa)) {
                throw new IllegalArgumentException("Gwiazda o podanej nazwie katalogowej już istnieje.");
            }
        }

        // Dodanie nowej gwiazdy
        Gwiazda nowaGwiazda = new Gwiazda(nazwa, nazwaKatalogowa, deklinacja, rektascensja,
                obserwowanaWielkoscGwiazdowa, odlegloscWLatachSwietlnych, gwiazdozbior, polkula, temperatura, masa);
        gwiazdyList.add(nowaGwiazda);

        // Aktualizacja nazw katalogowych pozostałych gwiazd w tym samym gwiazdozbiorze
        for (Gwiazda gwiazda : gwiazdyList) {
            if (gwiazda != nowaGwiazda && gwiazda.getGwiazdozbior().equals(gwiazdozbior)) {
                gwiazda.setNazwaKatalogowa("gamma " + gwiazdozbior);
            }
        }
    }

    @Override
    public void usunGwiazde(String nazwaKatalogowa) {
        Gwiazda gwiazdaToRemove = null;

        // Znajdź gwiazdę do usunięcia
        for (Gwiazda gwiazda : gwiazdyList) {
            if (gwiazda.getNazwaKatalogowa().equals(nazwaKatalogowa)) {
                gwiazdaToRemove = gwiazda;
                break;
            }
        }

        // Usuń gwiazdę
        if (gwiazdaToRemove != null) {
            gwiazdyList.remove(gwiazdaToRemove);

            // Aktualizacja nazw katalogowych pozostałych gwiazd w tym samym gwiazdozbiorze
            for (Gwiazda gwiazda : gwiazdyList) {
                if (gwiazda.getGwiazdozbior().equals(gwiazdaToRemove.getGwiazdozbior())) {
                    gwiazda.setNazwaKatalogowa("beta " + gwiazdaToRemove.getGwiazdozbior());
                }
            }
        }
    }

    @Override
    public void modyfikujGwiazde(String nazwaKatalogowa, String nowaNazwa, String nowaNazwaKatalogowa,
                                 String nowaDeklinacja, String nowaRektascensja, double nowaObserwowanaWielkoscGwiazdowa,
                                 double nowaOdlegloscWLatachSwietlnych, String nowyGwiazdozbior, String nowaPolkula,
                                 double nowaTemperatura, double nowaMasa) {
        // Znajdź gwiazdę do modyfikacji
        for (Gwiazda gwiazda : gwiazdyList) {
            if (gwiazda.getNazwaKatalogowa().equals(nazwaKatalogowa)) {
                gwiazda.setNazwa(nowaNazwa);
                gwiazda.setNazwaKatalogowa(nowaNazwaKatalogowa);
                gwiazda.setDeklinacja(nowaDeklinacja);
                gwiazda.setRektascensja(nowaRektascensja);
                gwiazda.setObserwowanaWielkoscGwiazdowa(nowaObserwowanaWielkoscGwiazdowa);
                gwiazda.setOdlegloscWLatachSwietlnych(nowaOdlegloscWLatachSwietlnych);
                gwiazda.setGwiazdozbior(nowyGwiazdozbior);
                gwiazda.setPolkula(nowaPolkula);
                gwiazda.setTemperatura(nowaTemperatura);
                gwiazda.setMasa(nowaMasa);

                // Aktualizacja nazw katalogowych pozostałych gwiazd w tym samym gwiazdozbiorze
                for (Gwiazda pozostalaGwiazda : gwiazdyList) {
                    if (pozostalaGwiazda != gwiazda && pozostalaGwiazda.getGwiazdozbior().equals(gwiazda.getGwiazdozbior())) {
                        pozostalaGwiazda.setNazwaKatalogowa("gamma " + gwiazda.getGwiazdozbior());
                    }
                }

                break;
            }
        }
    }

    @Override
    public void wyswietlGwiazdy() {
        for (Gwiazda gwiazda : gwiazdyList) {
            System.out.println("Nazwa: " + gwiazda.getNazwa());
            System.out.println("Nazwa Katalogowa: " + gwiazda.getNazwaKatalogowa());
            System.out.println("Deklinacja: " + gwiazda.getDeklinacja());
            System.out.println("Rektascensja: " + gwiazda.getRektascensja());
            System.out.println("Obserwowana Wielkość Gwiazdowa: " + gwiazda.getObserwowanaWielkoscGwiazdowa());
            System.out.println("Absolutna Wielkość Gwiazdowa: " + gwiazda.getAbsolutnaWielkoscGwiazdowa());
            System.out.println("Odległość w Latach Świetlnych: " + gwiazda.getOdlegloscWLatachSwietlnych());
            System.out.println("Gwiazdozbiór: " + gwiazda.getGwiazdozbior());
            System.out.println("Półkula: " + gwiazda.getPolkula());
            System.out.println("Temperatura: " + gwiazda.getTemperatura());
            System.out.println("Masa: " + gwiazda.getMasa());
            System.out.println("--------------");
        }
    }
}





