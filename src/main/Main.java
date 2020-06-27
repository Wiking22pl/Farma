package main;

import animals.Animal;
import farms.Farm;
import plants.Planted;
import plants.PlantSpecies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final Number STARTING_MONEY = 20000.;

    public static void main(String[] args) throws IOException {

        String x;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            //Informacje o grze
            System.out.println("Farma");
            System.out.println("Aby rozpocząć napisz 1, aby wyjść z programu napisz 0");
            System.out.println("Pamiętaj aby każdą komende zatwierdzać enterem");

            x = String.valueOf(br.read());

            //Proste menu obsługiwane z klawiatury
            switch (x) {
                case "1": {
                    Gra();
                    break;
                }

//                case '2': {
//                    Pomoc();
//                    inicjalizacja();
//                    break;
//                }

                case "0": {
                    System.exit(0);
                    break;
                }

                default: {
                    System.out.println("Nieprawidłowa komenda");
                    System.out.println();
                    break;
                }
            }

        }
    }

    public static void Gra() {

        Number money = STARTING_MONEY;
        List<Animal> animals = new ArrayList<>();
        List<PlantSpecies> seeds = new ArrayList<>();
        List<Planted> planted = new ArrayList<>();
        List<Farm> farms = new ArrayList<>();

        for (int year = 1; year <= 20; year++) {

            //Wyświetl informacje o roku
            //Statystyki?

            for (int week = 1; week <= 52; ) {

                //Nowy tydzień

                //Maintnance:

//                rośliny rosną, zwierzęta przybierają na masie
//                istnieje pewna, niewielka szansa, że zwierzęta się rozmnożą jeżeli posiada więcej niż jedno
//                ponosisz koszty ochrony roślin przed szkodnikami
//                jeżeli masz kury/krowy/owce dostajesz pieniądze za jajka albo mleko
//                zwierzęta wcinają paszę, jeśli masz dla nich odłożone plony to w pierwszej kolejności ze stodoły, jeżeli nie to musisz je kupić.
//
//               Jeżeli skończą się pieniądze:
//                zwierzęta zaczynają chudnąć
//                w każdym tygodniu istnieje niewielkie ryzyko, że robaki zjedzą plony na polach

                //Wyświetl informacje o tygodniu

                int w = week;

                while (w == week) {


                    //Wyświetl informacje o naszym statusie
                    //Lista zwierząt i roślin

                    //Wyświetl dostępne opcje
                    System.out.println();

                    //Skanerem skanuj input z klawiatury
                    int a = 1;

                    switch (a) {


//                        zakup farmy
//                        zakup/sprzedaż ziemi uprawnej
//                        zakup nowych budynków
//                        zakup zwierząt lub roślin
//                        posadzenie roślin (jeżeli posiadasz sadzonki, które można posadzić w tym okresie)
//                        zbiory roślin (jeżeli masz gotowe do zebrania plony)
//                        sprzedaż roślin lub zwierząt
//                        sprawdzenie stanu zapasów
//                        przejrzenie informacji o posiadanych zwierzętach
//                        przejrzenie informacji o posiadanych sadzonkach i zasadzonych roślinach


                    }
                }

            }
        }
    }


}
