import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Gwiazda gwiazda1 = new Gwiazda("ELO2137", "12°34'56\"", "1h23m45s", 5.6,
                10.2, "Gwiazdozbior1", "PN", 3000, 2.5);
        Gwiazda gwiazda2 = new Gwiazda("HEJ0420", "-45°30'15\"", "3h15m20s", 2.8,
                25.7, "Gwiazdozbior1", "PN", 4000, 3.8);

        Gwiazda gwiazda = new Gwiazda();
        //gwiazda.dodajGwiazdeDoBazy(gwiazda1);
        //gwiazda.dodajGwiazdeDoBazy(gwiazda2);
        gwiazda.wyswietlGwiazdy();

       // gwiazda.wyswietlGwiazdy(gwiazdy);
    }


    }

