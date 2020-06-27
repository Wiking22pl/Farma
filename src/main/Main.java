package main;

import animals.Animal;
import animals.AnimalCount;
import animals.AnimalSpecies;
import farms.Farm;
import plants.Planted;
import plants.Seeds;
import plants.PlantSpecies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final Double STARTING_MONEY = 20000.;
    public static final Double WIN_HECTARS = 20.;
    public static final Integer WIN_ANIMALS_SPECIES = 5;
    public static final Integer WIN_PLANTS_SPECIES = 5;
    public static final Double WIN_WEEKS_OF_FOOD = 52.;


    public static String TakeInputFromKeyboard() throws IOException {

        String x = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                char c = (char) br.read();
                if (c == 13 || c == 10 || c == 9 || c == 32) {   //10 i 13 ==> enter  32 ==> spacja   9 ==> tab
                    break;
                } else {
                    x += c;
                }
            }

        } catch (IOException e) {
            System.out.println("Ej no, nieładnie jest psuć program złymi inputami ty hujtaju >:(");
        }

        return x;
        //       System.out.println(x);
    }


    public static void main(String[] args) throws IOException {


        while (true) {

//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            //Informacje o grze
            System.out.println("Farma");
            System.out.println("Zaczynasz gre jako farmer z " + STARTING_MONEY + " pieniędzy, a twoim celem jest:\n "
                    + "W jak najmniejszej liczbie tur osiągnij status rolnika doskonałego, który posiada co najmniej 20 hektarów, 5 różnych gatunków zwierząt hodowlanych, 5 różnych gatunków upraw, jedzenie dla wszystkich swoich zwierząt na rok. \n");
            System.out.println("Aby rozpocząć gre napisz begin, aby wyjść z programu napisz end");
            System.out.println("Pamiętaj aby po wpisaniu każdej komendy wcisnąc enter");

            //Wczytaj informacje z klawiatury
            String menu = TakeInputFromKeyboard();


            //Proste menu obsługiwane z klawiatury
            switch (menu) {
                case "begin":
                    Game();
                    break;

                case "end":
                    System.exit(0);

                default:
                    System.out.println("Nieprawidłowa komenda");
                    System.out.println();

            }

        }
    }

    public static void Game() throws IOException {

        Double money = STARTING_MONEY;
        List<Animal> animals = new ArrayList<>();
        List<AnimalCount> breeding = new ArrayList<>();    //Przypisać do niej wszystkie gatunki zwierząt w ilości 0
        List<PlantSpecies> seeds = new ArrayList<>();
        List<Planted> planted = new ArrayList<>();
        List<Seeds> storage = new ArrayList<>();     //Przypisać do niej wszystkie gatunki rośliń w ilości 0
        List<Farm> farms = new ArrayList<>();

        Double AnimalCapacity;       // => suma ilości budynków na naszych farmach *5 lub 10

//        System.out.println("Debug Gra");

        for (int year = 1; year <= 20; year++) {

            //Wyświetl informacje o nowym
            //Statystyki?

            for (int week = 1; week <= 52; ) {

                //Nowy tydzień

                //Maintnance:   (chyba lepiej aby był po while)

//                rośliny rosną
//                ponosisz koszty ochrony roślin przed szkodnikami
                for (Planted value : planted) {
                    value.age++;
                    money -= value.amount * value.species.costPests;
                }

//                zwierzęta przybierają na masie
                for (Animal value : animals) {
                    value.age++;
                    if (value.age <= value.species.adultTime) {
                        value.weight += value.species.weightGrowth;
                    }
//                jeżeli masz kury/krowy/owce dostajesz pieniądze za jajka albo mleko

//                zwierzęta wcinają paszę, jeśli masz dla nich odłożone plony to w pierwszej kolejności ze stodoły, jeżeli nie to musisz je kupić.
                    //Pasza i karma mają stałą cene
                }

//                istnieje pewna, niewielka szansa, że zwierzęta się rozmnożą jeżeli posiada więcej niż jedno
                for (AnimalCount value : breeding) {
                    for (int pair = value.adultAmount / 2; pair > 0; pair--) {
                        if (Maintnance.RandomizeBool(value.species.breedChance)) {
                            animals.add(new Animal(value.species));
//                            System.out.println();
                        }
                    }
                }

//               Jeżeli skończą się pieniądze:
//                zwierzęta zaczynają chudnąć
//                w każdym tygodniu istnieje niewielkie ryzyko, że robaki zjedzą plony na polach

                //Wyświetl informacje o tygodniu

                MAIN_LOOP:
                while (true) {


                    //Wyświetl informacje o naszym statusie
                    //Lista zwierząt i roślin

                    //Wyświetl dostępne opcje
                    System.out.println();

                    //Wczytaj opcje z klawiatury

                    String a = TakeInputFromKeyboard();

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

    public static void Win() {


        System.exit(0);
    }


}
