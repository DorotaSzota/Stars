import java.util.ArrayList;
import java.util.List;

public class Gwiazda implements KolekcjaGwiazd {

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

    //KONSTRUKTOR
    public Gwiazda() {
    }
    public Gwiazda(String nazwa, String deklinacja, String rektascensja,
                   double obserwowanaWielkoscGwiazdowa, double odlegloscWLatachSwietlnych,
                   String gwiazdozbior, String polkula, double temperatura, double masa) {

        this.nazwa = nazwa;
        this.deklinacja = deklinacja;
        this.rektascensja = rektascensja;
        this.obserwowanaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa;
        this.odlegloscWLatachSwietlnych = odlegloscWLatachSwietlnych;
        this.gwiazdozbior = gwiazdozbior;
        generujNazweKatalogowa();

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
    }


    //GETTERS & SETTERS
    public List<Gwiazda> getGwiazdyList() {
        return gwiazdyList;
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
    //nazwy katalogowej nie ma w konstruktorze, bo ona się utworzy automatycznie
    public String getNazwaKatalogowa() {
        return nazwaKatalogowa;
    }

    //DO POPRAWIENIA, czyli implementacja logiki dodawania alf i bet etc.
    public void setNazwaKatalogowa(String nazwaKatalogowa) {
        this.nazwaKatalogowa = nazwaKatalogowa;
    }

    public String getDeklinacja() {
        return deklinacja;
    }

    public void setDeklinacja(String deklinacja) {
        if (deklinacja.matches("-?\\d{1,2}°\\d{1,2}'\\d{1,2}\\.?\\d{0,2}\"")) {
            int stopnie = Integer.parseInt(deklinacja.substring(0, deklinacja.indexOf("°")));
            int minuty = Integer.parseInt(deklinacja.substring(deklinacja.indexOf("°") + 1, deklinacja.indexOf("'")));
            double sekundy = Integer.parseInt(deklinacja.substring(deklinacja.indexOf("'") + 1, deklinacja.indexOf("\"")));
            if ((stopnie > -90 && stopnie < 90 && minuty >= 0 && minuty <= 59 && sekundy >= 0 && sekundy <= 59.99) ||
                    (stopnie == 90 && minuty == 0 && sekundy == 0) || (stopnie == -90 && minuty == 0 && sekundy == 0)) {
                if ((stopnie < 0 && polkula.equals("PD")) || (stopnie >= 0 && polkula.equals("PN"))){
                    this.deklinacja = deklinacja;
                } else {
                    throw new IllegalArgumentException("Nieprawidłowa półkula.");
                }
            } else {
                throw new IllegalArgumentException("Nieprawidłowa wartość deklinacji.");
            }
        } else {
            throw new IllegalArgumentException("Nieprawidłowa wartość deklinacji.");
        }
    }

    public String getRektascensja() {
        return rektascensja;
    }

    public void setRektascensja(String rektascensja) {

        if (rektascensja.matches("\\d{1,2}h\\d{1,2}m\\d{1,2}s")) {
            int godziny = Integer.parseInt(rektascensja.substring(0, rektascensja.indexOf("h")));
            int minuty = Integer.parseInt(rektascensja.substring(rektascensja.indexOf("h") + 1, rektascensja.indexOf("m")));
            int sekundy = Integer.parseInt(rektascensja.substring(rektascensja.indexOf("m") + 1, rektascensja.indexOf("s")));
            if ((godziny >= 0 && godziny <= 23 && minuty >= 0 && minuty <= 59 && sekundy >= 0 && sekundy <= 59) ||
                    (godziny == 24 && minuty == 0 && sekundy == 0)) {
                this.rektascensja = rektascensja;
            } else {
                throw new IllegalArgumentException("Nieprawidłowa wartość rektascensji.");
            }
        } else {
            throw new IllegalArgumentException("Nieprawidłowa wartość rektascensji.");
        }
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

    public void setAbsolutnaWielkoscGwiazdowa(double absolutnaWielkoscGwiazdowa) {
        this.absolutnaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa - 5 * (Math.log10(odlegloscWLatachSwietlnych)) + 5;
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
            throw new IllegalArgumentException("Nieprawidłowa wartość półkuli. Wybierz PN lub PD.");
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

    //może tutaj można zrobić logikę przeszukiwania listy gwiazd i sprawdzania czy nazwa katalogowa już istnieje?
    private void generujNazweKatalogowa() {
        AlfabetGrecki[] alfabet = AlfabetGrecki.values();
        boolean nazwaUnikalna = false;
        int index = 0;

        while (!nazwaUnikalna) {
            if (index >= alfabet.length) {
                this.nazwaKatalogowa = Integer.toString(index);
                nazwaUnikalna = true;
            } else {
                this.nazwaKatalogowa = alfabet[index] + " " + gwiazdozbior;
                if (czyNazwaKatalogowaJuzIstnieje()) {
                    index++;
                } else {
                    nazwaUnikalna = true;
                }
            }
        }
    }

    //IMPLEMENTACJA INTERFEJSU
    @Override
    public void dodajGwiazde(List<Gwiazda> listaGwiazd, Gwiazda nowaGwiazda) {
        for (Gwiazda gwiazda : listaGwiazd) {
            if (gwiazda.getNazwaKatalogowa().equals(nowaGwiazda.getNazwaKatalogowa())) {
                throw new IllegalArgumentException("Gwiazda o podanej nazwie katalogowej już istnieje.");
            }
        }
        listaGwiazd.add(nowaGwiazda);

        //DO POPRAWIENIA
        for (Gwiazda gwiazda : listaGwiazd) {
            if (gwiazda != nowaGwiazda && gwiazda.getGwiazdozbior().equals(nowaGwiazda.getGwiazdozbior())) {
                gwiazda.setNazwaKatalogowa("gamma " + gwiazda.getGwiazdozbior());
            }
        }
    }

    @Override
    public void usunGwiazde(List<Gwiazda> gwiazdyList, String nazwaKatalogowa) {
        Gwiazda gwiazdaToRemove = null;
        for (Gwiazda gwiazda : gwiazdyList) {
            if (gwiazda.getNazwaKatalogowa().equals(nazwaKatalogowa)) {
                gwiazdaToRemove = gwiazda;
                break;
            }
        }
        if (gwiazdaToRemove != null) {
            gwiazdyList.remove(gwiazdaToRemove);

            // Aktualizacja nazw katalogowych pozostałych gwiazd w tym samym gwiazdozbiorze
            //DO POPRAWIENIA
            for (Gwiazda gwiazda : gwiazdyList) {
                if (gwiazda.getGwiazdozbior().equals(gwiazdaToRemove.getGwiazdozbior())) {
                    gwiazda.setNazwaKatalogowa("beta " + gwiazdaToRemove.getGwiazdozbior());
                }
            }
        }

    }

    @Override
    public void wyswietlGwiazdy(List<Gwiazda> gwiazdyList) {
        for (int i = 0; i < gwiazdyList.size(); i++) {
            Gwiazda gwiazda = gwiazdyList.get(i);
            System.out.println("Gwiazda " + (i + 1) + ":");
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





