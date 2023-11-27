import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Gwiazda> gwiazdy = new ArrayList<>();
        Gwiazda PAP0666 = new Gwiazda("BET5678","12°34'56.78\"","05h36m24s",-5.0,10.5,"Orion","PN",5000,0.5);
        Gwiazda HAH2137 = new Gwiazda("ALF1234","12°34'56.78\"","05h36m24s",-5.0,10.5,"Orion","PN",5000,0.5);
        Gwiazda ELO9012 = new Gwiazda("ELO9012","12°34'56.78\"","06h36m24s",-2.0,11.5,"Orion","PN",5500,0.2);

        PAP0666.dodajGwiazde(gwiazdy,PAP0666);
        HAH2137.dodajGwiazde(gwiazdy,HAH2137);
        ELO9012.dodajGwiazde(gwiazdy,ELO9012);

        gwiazdy.get(0).wyswietlGwiazdy(gwiazdy); //get(0) - pierwszy element listy


    }
}
