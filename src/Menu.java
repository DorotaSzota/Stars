import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {
        System.out.println("Witaj w programie Wyszukiwarka Gwiazd!");
        System.out.println("Wybierz opcję:");
        System.out.println("1. Wyszukaj wszystkie nazwy w danym gwiazdozbiorze");
        System.out.println("2. Wyszukaj gwiazdy po odległości od Ziemi");
        System.out.println("3. Wyszukaj gwiazdy po temperarturze");
        System.out.println("4. Wyszukaj gwiazdę po wielkości gwiazdowej");
        System.out.println("5. Wyszukaj gwiazdę po półkuli");
        System.out.println("6. Wyszukaj potencjalne supernowe");
        System.out.println("7. Wyświetl wszystkie gwiazdy");
        System.out.println("8. Dodaj gwiazdę");
        System.out.println("9. Usuń gwiazdę");
        System.out.println("0. Wyjdź z programu");

        Scanner scanner = new Scanner(System.in);
        int wybor = scanner.nextInt();

        switch (wybor) {
            case 1:
                System.out.println("Wyszukaj wszystkie nazwy w danym gwiazdozbiorze.");
                break;
            case 2:
                System.out.println("Wyszukaj gwiazdy po odległości od Ziemi.\nOdległość od Ziemi podaj w parsekach.");
                break;
            case 3:
                System.out.println("Wyszukaj gwiazdy po temperarturze.\nPodaj temperaturę minimalną i maksymalną.");
                break;
            case 4:
                System.out.println("Wyszukaj gwiazdę po wielkości gwiazdowej.\nPodaj wielkość minimalną i maksymalną.");
                break;
            case 5:
                System.out.println("Wyszukaj gwiazdę po półkuli.\nPodaj PN lub PD.");
                break;
            case 6:
                System.out.println("Wyszukaj potencjalne supernowe.");
                break;
            case 7:
                System.out.println("Wyświetl wszystkie gwiazdy.");
                break;
            case 8:
                System.out.println("Dodaj gwiazdę.");
                break;
            case 9:
                System.out.println("Usuń gwiazdę.");
                break;
            case 0:
                System.out.println("Wyjdź z programu.");
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Wybierz z przedziału 0-9.");
                break;
        }
    }
}
