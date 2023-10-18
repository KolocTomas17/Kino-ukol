package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Films> filmy = new ArrayList<>();

        Films movies1 = new Films("Avatar", 13, "James Cameron", true);
        Films movies2 = new Films("1917", 18, "Ryan Coogler", true);
        Films movies3 = new Films("Joker", 18, "Todd Phillips", true);
        Films movies4 = new Films("Sestra II", 15, "Michael Chaves", false);


        filmy.add(movies1);
        filmy.add(movies2);
        filmy.add(movies3);
        filmy.add(movies4);


        ArrayList<Hall> sal = new ArrayList<>();
        Hall sal1 = new Hall(1, 15, 35, true);
        Hall sal2 = new Hall(2, 10, 20, false);

        sal1.setMovies(movies1.getName());
        sal1.setMovies(movies2.getName());
        sal1.setMovies(movies3.getName());
        sal2.setMovies(movies3.getName());
        sal2.setMovies(movies4.getName());


        List<Hall> saly = new ArrayList<>();
        saly.add(sal1);
        saly.add(sal2);


        System.out.println("Dostupné filmy:");
        for (Films film : filmy) {
            System.out.println(film.getName()+ " - " + film.getAccessibility() + "+");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Vyberte si film podle názvu: ");
        String vybranyFilm = scanner.nextLine();

        Films vybranyFilmObj = null;
        for (Films film : filmy) {
            if (film.getName().equals(vybranyFilm)) {
                vybranyFilmObj = film;
                break;
            }
        }

        if (vybranyFilmObj == null) {
            System.out.println("Vybraný film nebyl nalezen.");
            return;
        }

        System.out.println("Dostupné sály pro film " + vybranyFilmObj.getName() + ":");
        boolean jeSal = false;
        for (Hall s : saly) {
            if (s.getMovies().contains(vybranyFilmObj.getName())) {
                System.out.println("Sál č. " + s.getNumbersOfHall());
                jeSal = true;
            }
        }
        if (!jeSal){
            System.out.println("Omlouváme se ale pro tento film není k dispozici žádný sál.");
            return;
        }

        System.out.print("Vyberte si sál podle čísla: ");
        int vybranySal = scanner.nextInt();

        Hall vybranySalObj = null;
        for (Hall s : saly) {
            if (s.getNumbersOfHall() == vybranySal) {
                vybranySalObj = s;
                break;
            }
        }

        if (vybranySalObj == null) {
            System.out.println("Vybraný sál nebyl nalezen.");
            return;
        }

        System.out.println("Rozložení křesel v sálu č. " + vybranySalObj.getNumbersOfHall() + ":");
        for (int radek = 1; radek <= vybranySalObj.getNumbersOfLine(); radek++) {
            for (int kreslo = 1; kreslo <= vybranySalObj.getNumbersOfSeats(); kreslo++) {
                char rad = (char) (radek + 'A' - 1);
                System.out.print(rad + "" + kreslo + " ");
            }
            System.out.println();
        }


        System.out.print("Vyberte si křeslo podle popisu (např. G4): ");
        String vybraneKreslo = scanner.next();

        try {
            vybranySalObj.rezervovatKreslo(vybraneKreslo);
            System.out.println("Rezervace proběhla úspěšně. Děkujeme za návštěvu!");
        } catch (Chyba e) {
            System.out.println("Chyba: " + e.getMessage());
        }
    }
}

class Chyba extends Exception {
    public Chyba(String message) {
        super(message);
    }
}


