import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Gwiazda gwiazda1 = new Gwiazda("ELO2137", "12°34'56\"", "1h23m45s",10.2, 5.6,
                 "Gwiazdozbior1", "PN", 3000, 2.5);
        Gwiazda gwiazda2 = new Gwiazda("HEJ0420", "45°30'15\"", "3h15m20s",25.7, 2.8,
                 "Gwiazdozbior1", "PN", 4000, 3.8);
        Gwiazda gwiazda3 = new Gwiazda("WOW0420", "40°30'15\"", "2h15m20s",14.7, 3.8,
                "Gwiazdozbior1", "PN", 2800, 1.1);

        Gwiazda gwiazda = new Gwiazda();
        /*gwiazda.dodajGwiazdeDoBazy(gwiazda1);
        gwiazda.dodajGwiazdeDoBazy(gwiazda2);*/
        gwiazda.dodajGwiazdeDoBazy(gwiazda3);
       //gwiazda.usunGwiazdeZBazy(gwiazda1);
      //gwiazda.usunGwiazdeZBazy(gwiazda2);
        //gwiazda.wyswietlGwiazdy();

       // gwiazda.wyswietlGwiazdy(gwiazdy);
    }


    }

