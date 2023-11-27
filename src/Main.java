import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Gwiazda> gwiazdy = new ArrayList<>();
        Gwiazda ALF1234 = new Gwiazda("BET5678","beta Orionis","12°34'56.78\"","05h36m24s",-5.0,10.5,"Orion","PN",5000,0.5);
        Gwiazda BET5678 = new Gwiazda("ALF1234","alfa Orionis","12°34'56.78\"","05h36m24s",-5.0,10.5,"Orion","PN",5000,0.5);

        ALF1234.dodajGwiazde(gwiazdy,ALF1234);
        BET5678.dodajGwiazde(gwiazdy,BET5678);

        gwiazdy.get(0).wyswietlGwiazdy(gwiazdy); //get(0) - pierwszy element listy


    }
}
