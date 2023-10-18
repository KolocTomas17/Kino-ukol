package com.company;

import java.util.ArrayList;


public class Hall {
    private int numbersOfHall;
    private int numbersOfLine;
    private int numbersOfSeats;
    private ArrayList<String> movies;
    private Boolean backUp3d;

    /**
     *
     * @param numbersOfHall - počet sálů
     * @param numbersOfLine - počet řad v sálu
     * @param numbersOfSeats - počet míst v sálu
     * @param backUp3d - podpora 3D
     */
    public Hall(int numbersOfHall, int numbersOfLine, int numbersOfSeats, Boolean backUp3d) {
        this.numbersOfHall = numbersOfHall;
        this.numbersOfLine = numbersOfLine;
        this.numbersOfSeats = numbersOfSeats;
        this.movies = new ArrayList<>();
        this.backUp3d = backUp3d;
    }

    public int getNumbersOfHall() {
        return numbersOfHall;
    }

    public void setNumbersOfHall(int numbersOfHall) {
        this.numbersOfHall = numbersOfHall;
    }

    public int getNumbersOfLine() {
        return numbersOfLine;
    }

    public void setNumbersOfLine(int numbersOfLine) {
        this.numbersOfLine = numbersOfLine;
    }

    public int getNumbersOfSeats() {
        return numbersOfSeats;
    }

    public void setNumbersOfSeats(int numbersOfSeats) {
        this.numbersOfSeats = numbersOfSeats;
    }

    public ArrayList<String> getMovies() {
        return movies;
    }

    public void setMovies(String films) {
        movies.add(films);
    }

    public Boolean getBackUp3d() {
        return backUp3d;
    }

    public void setBackUp3d(Boolean backUp3d) {
        this.backUp3d = backUp3d;
    }

    public void rezervovatKreslo(String popisKresla) throws Chyba {
        int rad, cisloKresla;
        try {
            rad = popisKresla.charAt(0) - 'A' + 1;
            cisloKresla = Integer.parseInt(popisKresla.substring(1));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new Chyba("Neplatný popis křesla.");
        }

        if (rad < 1 || rad > numbersOfLine || cisloKresla < 1 || cisloKresla > numbersOfSeats) {

            throw new Chyba("Nevhodný výběr křesla.");
        }
    }
}
