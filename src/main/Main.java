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

    //Warunki zwycięstwa
    public static final Double WIN_HECTARS = 20.;
    public static final Integer WIN_ANIMALS_SPECIES = 5;
    public static final Integer WIN_PLANTS_SPECIES = 5;
    public static final Double WIN_WEEKS_OF_FOOD = 52.;

    //Wartość i ilość produktów zwierzęcych
    public static final Double EGG_VALUE = 2.;
    public static final Double EGG_MIN = 5.;
    public static final Double EGG_MAX = 10.;
    public static final Double COW_MILK_VALUE = 5.;
    public static final Double COW_MILK_MIN = 5.;
    public static final Double COW_MILK_MAX = 12.;
    public static final Double SHEEP_MILK_VALUE = 3.;
    public static final Double SHEEP_MILK_MIN = 2.;
    public static final Double SHEEP_MILK_MAX = 6.;

    //Gatunki roślin
    public static List<PlantSpecies> plantsSpecies = new ArrayList<>(); //dodawać od najtańszej do najdroższej
    public static PlantSpecies pszenica = new PlantSpecies("Pszenica",1000.,500.,100.,1000.,20,20,45,1000.);
    public static PlantSpecies ds = new PlantSpecies("Pszenica",1000.,500.,100.,1000.,20,20,45,1000.);
    public static PlantSpecies sagda = new PlantSpecies("Pszenica",1000.,500.,100.,1000.,20,20,45,1000.);
    public static PlantSpecies srfaws = new PlantSpecies("Pszenica",1000.,500.,100.,1000.,20,20,45,1000.);
    public static PlantSpecies egsnggf = new PlantSpecies("Pszenica",1000.,500.,100.,1000.,20,20,45,1000.);

            //add do listy trzeba zrobic w osobnej metodzie
    //Gatunki zwierząt
    public static List<AnimalSpecies> animalSpiecies = new ArrayList<>();
    public static AnimalSpecies kura = new AnimalSpecies(0.5,"Kura",0.2,500.,0.1,5,0.1,0.5,0.1*20, new ArrayList<>());
    public static AnimalSpecies fbsdergfg = new AnimalSpecies(0.5,"Kura",0.2,500.,0.1,5,0.1,0.5,0.1*20, new ArrayList<>());
    public static AnimalSpecies hgswasfdf = new AnimalSpecies(0.5,"Kura",0.2,500.,0.1,5,0.1,0.5,0.1*20, new ArrayList<>());
    public static AnimalSpecies sgdfs = new AnimalSpecies(0.5,"Kura",0.2,500.,0.1,5,0.1,0.5,0.1*20, new ArrayList<>());
    public static AnimalSpecies hgfdsdfg = new AnimalSpecies(0.5,"Kura",0.2,500.,0.1,5,0.1,0.5,0.1*20, new ArrayList<>());


    //Farma?


    public static String TakeInputFromKeyboard() throws IOException {

        StringBuilder x = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                char c = (char) br.read();
                if (c == 13 || c == 10 || c == 9 ) {   //10 i 13 ==> enter     9 ==> tab
                    break;
                } else {
                    x.append(c);
                }
            }

        } catch (IOException e) {
            System.out.println("Ej no, nieładnie jest psuć program złymi inputami ty hujtaju >:(");
        }

        return x.toString();
        //       System.out.println(x);
    }


    public static void main(String[] args) throws IOException {



        while (true) {

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
        Double dairy = 0.;
        boolean areYouShortOnFunds = false;
        List<Animal> animals = new ArrayList<>();
        List<AnimalCount> breeding = new ArrayList<>(); //Przypisać do niej wszystkie gatunki zwierząt w ilości 0
        List<PlantSpecies> seeds = new ArrayList<>();
        List<Planted> planted = new ArrayList<>();
        List<Seeds> storage = new ArrayList<>();        //Przypisać do niej wszystkie gatunki rośliń w ilości 0
        Farm farm = new Farm();

//        List<List> mainList = new ArrayList<>();     //Lepij chyba po prostu zrobić coś w maintnanace
//        mainList.add(animals);
//        mainList.add(breeding);
//        mainList.add(seeds);
//        mainList.add(planted);
//        mainList.add(storage);
//        mainList.add(farm);

        Double AnimalCapacity;       // => suma ilości budynków na naszych farmach *5 lub 10

//        System.out.println("Debug Gra");

        for (int year = 1; year <= 20; year++) {


            //Wyświetl informacje o nowym roku
            //Statystyki?

            for (int week = 1; week <= 52; week++) {


                //Nowy tydzień

                //Sprawdź czy wygraliśmy
                if(Maintenance.DidYouWin(farm,animals,planted,storage)){
//                    Statystyki
                    Win();
                }

                System.out.println();

                MAIN_LOOP:
                while (true) {


                    //Wyświetl informacje o naszym statusie
                    System.out.println("Rok: "+year+" Tydzień: "+week+" Pieniądze: "+money);

                    //Lista zwierząt i roślin
                    //Zwierzęta
                    Maintenance.InfoAnimal(animals);
                    //Plony
                    Maintenance.InfoPlant(planted);
                    //Zapasy
                    Maintenance.InfoStorage(storage);


                    if (areYouShortOnFunds){
                        System.out.println("Deficyt finansowy");
                    }

                    //Wyświetl dostępne opcje
                    System.out.print("\nLista komend: ");

                    //Wczytaj opcje z klawiatury
                    String a = TakeInputFromKeyboard();

                    switch (a) {


//                        zakup farmy
//                        case "kup farme":
//
//                            break;

//                        zakup/sprzedaż ziemi uprawnej
                        case "kup ziemie":
                            Maintenance.BuyLand(farm);
                            break;

//                        zakup nowych budynków
                        case "kup budynek":
                            Maintenance.BuyBuilding(farm);
                            break;

//                        zakup zwierząt
                        case "kup zwierze":
                            Maintenance.BuyAnimal(animals);
                            break;

//                      lub roślin
                        case "kup rośliny":
                            Maintenance.BuySeeds(storage);
                            break;


//                        posadzenie roślin (jeżeli posiadasz sadzonki, które można posadzić w tym okresie)
//                        zbiory roślin (jeżeli masz gotowe do zebrania plony)
//                        sprzedaż roślin lub zwierząt


//                        następny tydzień
                        case "end":
                            break MAIN_LOOP;

//                        wyjście z gry
                        case "ragequit":
//                            Maintnance.Statystyki();  //Ew. pominąć
                            System.out.println("The truth is, the game was rigged from the start");
                            System.exit(0);
                            break;


//                        nieprawidlowa komenda
                        default:
                            System.out.println("Nieprawidłowa komenda");
                            System.out.println();
                            break;

//                        sprawdzenie stanu zapasów                     //gra pokazuje je automatycznie
//                        przejrzenie informacji o posiadanych zwierzętach
//                        przejrzenie informacji o posiadanych sadzonkach i zasadzonych roślinach

                    }
                }

                //
                //              MAINTENANCE:
                //

                System.out.println();
                areYouShortOnFunds = false;
                for (Animal animal : animals) {
                    animal.age++;
                    boolean animalAte = false;

//                jeżeli masz kury/krowy/owce dostajesz pieniądze za jajka albo mleko
                    switch (animal.species.name) {                                       //dodac odpowiednie zwierzęta

                        case "Kura":
                        dairy += EGG_VALUE * Maintenance.RandomInInterval(EGG_MIN,EGG_MAX);
                            break;

                        case "Krowa":
                            dairy += COW_MILK_VALUE * Maintenance.RandomInInterval(COW_MILK_MIN,COW_MILK_MAX);
                            break;

                        case "Owca":
                            dairy += SHEEP_MILK_VALUE * Maintenance.RandomInInterval(SHEEP_MILK_MIN,SHEEP_MILK_MAX);
                            break;

                        default:
                            break;
                    }
                    System.out.println("Zarobiono "+ dairy+" na mleku i jajkach");
                    money +=dairy;
                    dairy=0.;


//                zwierzęta wcinają paszę, jeśli masz dla nich odłożone plony to w pierwszej kolejności ze stodoły
                    for (int z = 0; z < storage.size(); z++) {
                        Seeds pasza = storage.get(z);
                        if (pasza.amount > animal.species.foodNeeded && animal.species.whatItCanEat.contains(pasza)) {
                            pasza.amount -= animal.species.foodNeeded;
                            animalAte = true;
                        }                        //a jeżeli nie to musisz kupić pasze/karme
                        else if (money > animal.species.costOfBoughtFood) {
                            money -= animal.species.costOfBoughtFood; //There is nothing more permanent then a temporary solution
                            animalAte = true;
                        }
                    }
//                  zwierzęta przybierają na masie
//                  Jeżeli skończą się pieniądze:  zwierzęta zaczynają chudnąć
                    if (!animalAte && animal.age <= animal.species.adultTime) {
                        animal.weight += animal.species.weightGrowth;
                        animal.sellPrice += animal.species.buyCost/animal.species.adultTime;    //Po osiągnięciu dorosłości zwierze jest warte 1.5 wartości kupna
                    } else {
                        animal.weight -= animal.species.weightGrowth / 4;
                        areYouShortOnFunds = true;
                        System.out.print("Zwierze ci głoduje. ");
                    }


                }

                //                rośliny rosną
//                ponosisz koszty ochrony roślin przed szkodnikami
                for (Planted value : planted) {
                    value.age++;
                    Double price = value.amount * value.species.costPests;

                    if (value.age==value.species.growTime){
                        value.readyToHarvest=true;
                    }

//               Jeżeli skończą się pieniądze:
//                w każdym tygodniu istnieje niewielkie ryzyko, że robaki zjedzą plony na polach
                    if (price > money) {
                        areYouShortOnFunds = true;
                        //if(Maintnance.RandomizeBool(0.1))
                        //robaki
                    } else {
                        money -= price;
                    }
                }


                //susze?
//                if(Maintnance.RandomizeBool(0.05)){
//
//                }

//                istnieje pewna, niewielka szansa, że zwierzęta się rozmnożą jeżeli posiada więcej niż jedno
                if (!areYouShortOnFunds) {
                    for (AnimalCount animalNumber : breeding) {
                        for (int pair = animalNumber.adultAmount / 2; pair > 0; pair--) {
                            if (Maintenance.RandomizeBool(animalNumber.species.breedChance)) {
                                animals.add(new Animal(animalNumber.species));
//                                breeding.add
                                System.out.println(animalNumber.species.name+" się rozmnożyły!");
                            }
                        }
                    }
                }


            }
        }
    }

    public static void Win() {

        System.out.println("Gratulacje, wygrałeś!");
        System.exit(0);
    }


}
