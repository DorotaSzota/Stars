import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Gwiazda gwiazda1 = new Gwiazda("ELO2137", "PN","12°34'56\"", "1h23m45s",10.2, 0.5,
                "Gwiazdozbior1", 3000, 2.5);
        Gwiazda gwiazda2 = new Gwiazda("HEJ0420", "PN","45°30'15\"", "3h15m20s",-21.7, 11,
                "Gwiazdozbior1",  4000, 3.8);
        Gwiazda gwiazda3 = new Gwiazda("WOW0420", "PN", "40°30'15\"", "2h15m20s",14.7, 13,
                "Gwiazdozbior1",  2800, 1.99);
        Gwiazda gwiazda4 = new Gwiazda("GWI0001", "PN","10°30'15\"", "7h15m20s",9.03, 25,
                "Gwiazdozbior1",  4500, 5.1);
        Gwiazda gwiazda5 = new Gwiazda("GWI0002","PD", "-13°30'15\"", "2h15m20s",5.7, 0.9,
                "Gwiazdozbior2",  2800, 2.1);

        Gwiazda gwiazda = new Gwiazda();
//        gwiazda.dodajGwiazdeDoBazy(gwiazda1);
//        gwiazda.dodajGwiazdeDoBazy(gwiazda2);
//        gwiazda.dodajGwiazdeDoBazy(gwiazda3);
//        gwiazda.dodajGwiazdeDoBazy(gwiazda4);
//        gwiazda.dodajGwiazdeDoBazy(gwiazda5);


//        gwiazda.usunGwiazdeZBazy(gwiazda1);
//        gwiazda.usunGwiazdeZBazy(gwiazda2);
        gwiazda.usunGwiazdeZBazy(gwiazda3);
//        gwiazda.usunGwiazdeZBazy(gwiazda4);
//        gwiazda.usunGwiazdeZBazy(gwiazda5);


        gwiazda.wyswietlGwiazdy();


    }


}