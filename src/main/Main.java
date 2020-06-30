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
import java.util.Comparator;
import java.util.List;
import java.util.Random;

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
    public static List<PlantSpecies> plantsSpecies = new ArrayList<>();
    public static PlantSpecies pszenica = new PlantSpecies("Pszenica", 1000., 500., 100., 1000., 20, 20, 45, 1000.);
    public static PlantSpecies pszenica2 = new PlantSpecies("Pszenica2", 1000., 500., 100., 1000., 20, 20, 45, 1000.);
    public static PlantSpecies pszenica3 = new PlantSpecies("Pszenica3", 1000., 500., 100., 1000., 20, 20, 45, 1000.);
    public static PlantSpecies pszenica4 = new PlantSpecies("Pszenica4", 1000., 500., 100., 1000., 20, 20, 45, 1000.);
    public static PlantSpecies pszenica5 = new PlantSpecies("Pszenica5", 1000., 500., 100., 1000., 20, 20, 45, 1000.);


    //Gatunki zwierząt
    public static List<AnimalSpecies> animalSpiecies = new ArrayList<>();
    public static AnimalSpecies kura = new AnimalSpecies(0.5, "Kura", 0.2, 500., 0.1, 5, 0.1, 0.5, 0.1 * 20, new ArrayList<>());
    public static AnimalSpecies krowa = new AnimalSpecies(0.5, "Krowa", 0.2, 500., 0.1, 5, 0.1, 0.5, 0.1 * 20, new ArrayList<>());
    public static AnimalSpecies owca = new AnimalSpecies(0.5, "Owca", 0.2, 500., 0.1, 5, 0.1, 0.5, 0.1 * 20, new ArrayList<>());
    public static AnimalSpecies krowa2 = new AnimalSpecies(0.5, "Krowa2", 0.2, 500., 0.1, 5, 0.1, 0.5, 0.1 * 20, new ArrayList<>());
    public static AnimalSpecies krowa3 = new AnimalSpecies(0.5, "Krowa3", 0.2, 500., 0.1, 5, 0.1, 0.5, 0.1 * 20, new ArrayList<>());


    //Farma?
    public static final Farm STARTING_FARM = new Farm(4.,2,10000.,25000.);


    public static String TakeInputFromKeyboard() throws IOException {

        StringBuilder x = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                char c = (char) br.read();
                if (c == 13 || c == 10 || c == 9) {   //10 i 13 ==> enter     9 ==> tab
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

    public static Boolean DidYouWin(Farm farm, List<Animal> animalList, List<AnimalCount> animals, List<Planted> planted, List<Seeds> storage) {

        List<AnimalSpecies> uniqueAnimals = new ArrayList<>();
        List<PlantSpecies> uniquePlants = new ArrayList<>();
        List<Seeds> CopyOfStorage = new ArrayList<>(storage);

        for (AnimalCount a : animals) {
            if (a.amount > 0 && !uniqueAnimals.contains(a.species)) {
                uniqueAnimals.add(a.species);
            }
        }
        if (uniqueAnimals.size() >= WIN_ANIMALS_SPECIES) {

            for (Planted p : planted) {
                if (p.integrity > 0. && p.amount > 0 && !uniquePlants.contains(p.species)) {
                    uniquePlants.add(p.species);
                }
            }

            if (uniquePlants.size() >= WIN_PLANTS_SPECIES) {

                boolean papu = true;

                for (Animal animal : animalList) {
                    boolean hasEnough = false;
                    for (int z = 0; z < CopyOfStorage.size() && hasEnough == false; z++) {
                        if (CopyOfStorage.get(z).amount > animal.species.foodNeeded * WIN_WEEKS_OF_FOOD && animal.species.whatItCanEat.contains(CopyOfStorage.get(z).species)) {
                            CopyOfStorage.get(z).amount -= animal.species.foodNeeded * WIN_WEEKS_OF_FOOD;
                            hasEnough = true;
                        }
                    }
                    if (hasEnough == false) {
                        papu = false;
                    }
                }

                if (papu) {
                    if (farm.size > WIN_HECTARS) {
                        return true;
                    }
                }
            }
        }

        return false;


    }


    public static void main(String[] args) throws IOException {

        plantsSpecies.add(pszenica);
        plantsSpecies.add(pszenica2);
        plantsSpecies.add(pszenica3);
        plantsSpecies.add(pszenica4);
        plantsSpecies.add(pszenica5);

        animalSpiecies.add(kura);
        animalSpiecies.add(krowa);
        animalSpiecies.add(krowa2);
        animalSpiecies.add(krowa3);
        animalSpiecies.add(owca);


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
        List<AnimalCount> breeding = new ArrayList<>();
//        List<Seeds> seeds = new ArrayList<>();
        List<Planted> planted = new ArrayList<>();
        List<Seeds> storage = new ArrayList<>();
        Farm farm =  STARTING_FARM;

        for (AnimalSpecies a : animalSpiecies) {
            breeding.add(new AnimalCount(a, 0, 0));
        }

        for (PlantSpecies p : plantsSpecies) {
            storage.add(new Seeds(p, 0.));
        }
        Comparator<Seeds> Lambda = (s1, s2) -> s1.species.buyCost.compareTo(s2.species.buyCost);
        storage.sort(Lambda);

//        List<List> mainList = new ArrayList<>();     //Lepij chyba po prostu zrobić coś w maintnanace
//        mainList.add(animals);
//        mainList.add(breeding);
//        mainList.add(seeds);
//        mainList.add(planted);
//        mainList.add(storage);
//        mainList.add(farm);

//        System.out.println("Debug Gra");

        for (int year = 1; year <= 20; year++) {


            //Wyświetl informacje o nowym roku
            //Statystyki?

            for (int week = 1; week <= 52; week++) {


                //Nowy tydzień

                //Sprawdź czy wygraliśmy
                if (DidYouWin(farm, animals, breeding, planted, storage)) {
//                    Statystyki
                    Win();
                }

                System.out.println();

                MAIN_LOOP:
                while (true) {


                    //Wyświetl informacje o naszym statusie
                    System.out.println("Rok: " + year + " Tydzień: " + week + " Pieniądze: " + money);

                    //Lista zwierząt i roślin
                    //Zwierzęta
                    InfoAnimal(animals);
                    //Plony
                    InfoPlant(planted);
                    //Zapasy
                    InfoStorage(storage);


                    if (areYouShortOnFunds) {
                        System.out.println("Deficyt finansowy");
                    }

                    //Wyświetl dostępne opcje
                    System.out.print("\nLista komend:   land - kup/sprzedaj ziemię,   building - kup nowy budynek,   "+
                            "buya - kup zwierze   buyp - kup nasiona   plant - zasadź nasiona harvest - zbierz plony\n" +
                            "   sella - sprzedaj zwierzęta   sellp - sprzedaj plony/nasiona   exit - zakończ tydzień" +
                            "   ragequit - zakończ program\n");

                    //Wczytaj opcje z klawiatury
                    String a = TakeInputFromKeyboard();

                    switch (a) {


//                        zakup farmy
//                        case "kup farme":
//
//                            break;

//                        zakup/sprzedaż ziemi uprawnej
                        case "land":
                            money -= BuyLand(farm, money);
                            break;

//                        zakup nowych budynków
                        case "building":
                            money -= BuyBuilding(farm, money);
                            break;

//                        zakup zwierząt
                        case "buya":
                            money -= BuyAnimal(animals, breeding, money, farm);
                            break;

//                      lub roślin
                        case "buyp":
                            money -= BuySeeds(storage, money);
                            break;


//                        posadzenie roślin (jeżeli posiadasz sadzonki, które można posadzić w tym okresie)
                        case "plant":
                            Plant(storage,planted,farm);
                            break;

//                        zbiory roślin (jeżeli masz gotowe do zebrania plony)
                        case "harvest":
                            money -= Harvest(storage,planted,money);
                            break;

//                        sprzedaż zwierząt
                        case "sella":
                            money += SellAnimal(animals,breeding);
                            break;

//                        sprzedaż roślin
                        case "sellp":
                            money += SellSeeds(storage);
                            break;


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
                //              WEEKLY MAINTENANCE:
                //

                System.out.println();
                areYouShortOnFunds = false;
                for (Animal animal : animals) {
                    animal.age++;
                    //Jeżeli jest dorosłe to dodaj do listy breeding
                    if (animal.age.equals(animal.species.adultTime)) {
                        for (AnimalCount b : breeding) {
                            if (b.species == animal.species) {
                                b.adultAmount++;
                                break;
                            }
                        }
                    }
                    boolean animalAte = false;

//                jeżeli masz kury/krowy/owce dostajesz pieniądze za jajka albo mleko
                    switch (animal.species.name) {

                        case "Kura":
                            dairy += EGG_VALUE * RandomInInterval(EGG_MIN, EGG_MAX);
                            break;

                        case "Krowa":
                            dairy += COW_MILK_VALUE * RandomInInterval(COW_MILK_MIN, COW_MILK_MAX);
                            break;

                        case "Owca":
                            dairy += SHEEP_MILK_VALUE * RandomInInterval(SHEEP_MILK_MIN, SHEEP_MILK_MAX);
                            break;

                        default:
                            break;
                    }
                    System.out.println("Zarobiono " + dairy + " na mleku i jajkach");
                    money += dairy;
                    dairy = 0.;


//                zwierzęta wcinają paszę, jeśli masz dla nich odłożone plony to w pierwszej kolejności ze stodoły
                    for (int z = 0; z < storage.size() && animalAte == false; z++) {
                        if (storage.get(z).amount > animal.species.foodNeeded && animal.species.whatItCanEat.contains(storage.get(z).species)) {
                            storage.get(z).amount -= animal.species.foodNeeded;
                            animalAte = true;
                        }
                    }                        //a jeżeli nie to musisz kupić pasze/karme
                    if (animalAte == false && money > animal.species.costOfBoughtFood) {
                        money -= animal.species.costOfBoughtFood; //There is nothing more permanent then a temporary solution
                        animalAte = true;
                    }
//                  zwierzęta przybierają na masie
//                  Jeżeli skończą się pieniądze:  zwierzęta zaczynają chudnąć
                    if (!animalAte && animal.age <= animal.species.adultTime) {
                        animal.weight += animal.species.weightGrowth;
                        animal.sellPrice += animal.species.buyCost / animal.species.adultTime;    //Po osiągnięciu dorosłości zwierze jest warte 1.5 wartości kupna
                    } else {
                        animal.weight -= animal.species.weightGrowth / 4;
                        animal.sellPrice -= animal.species.buyCost / (4 * animal.species.adultTime);
                        areYouShortOnFunds = true;
                        System.out.print("Zwierze ci głoduje. ");
                    }


                }

                //                rośliny rosną
//                ponosisz koszty ochrony roślin przed szkodnikami
                for (Planted value : planted) {
                    value.age++;
                    Double price = value.amount * value.species.costPests;

                    if (value.age == value.species.growTime) {
                        value.readyToHarvest = true;
                    }

//               Jeżeli skończą się pieniądze:
//                w każdym tygodniu istnieje niewielkie ryzyko, że robaki zjedzą plony na polach
                    if (price > money) {
                        areYouShortOnFunds = true;
                        if (RandomizeBool(0.1)) {
                            value.integrity -= RandomInInterval(20., 40.);
                            if (value.integrity < 0.) {
                                value.integrity = 0.;
                            }
                        }
                    } else {
                        money -= price;
                    }
                }


                //Szusze itp.
                if(RandomizeBool(0.05)){
                    System.out.println("Z przyczyn naturalnych częśc upraw została zniszczona");
                    for (Planted value : planted){
                        value.integrity -= RandomInInterval(5.,35.);
                        if(value.integrity <0.){
                            value.integrity=0.;
                        }
                    }

                }

//                istnieje pewna, niewielka szansa, że zwierzęta się rozmnożą jeżeli posiada więcej niż jedno
                if (!areYouShortOnFunds) {
                    for (AnimalCount animalNumber : breeding) {
                        for (int pair = animalNumber.adultAmount / 2; pair > 0; pair--) {
                            if (RandomizeBool(animalNumber.species.breedChance)) {
                                animals.add(new Animal(animalNumber.species));

                                for (AnimalCount a : breeding) {
                                    if (a.species == animalNumber.species) {
                                        a.amount++;
                                        break;
                                    }
                                }

                                System.out.println(animalNumber.species.name + " się rozmnożyły!");
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

    public static Boolean RandomizeBool(Double p) {       //losować czy to się stało
        if (Math.random() < p) {
            return true;
        } else {
            return false;
        }
    }

    public static Double RandomInInterval(Double min, Double max) {      //losować liczbe z odpowiedniego zakresu
        Random rand = new Random();
        Double wynik = ((double) rand.nextInt((int) (max - min))) + min;
        return wynik;
    }


    public static void InfoAnimal(List<Animal> list) {
        System.out.println("Zwierzęta: Id, Gatunek, Wiek, Wiek_Dojrzewania, Waga, Wartosc");
        for (Animal a : list) {
            System.out.println("        "+a.id + ", " + a.species.name + ", " + a.age + ", " + a.species.adultTime + ", " + a.weight + ", " + a.sellPrice);
        }
    }

    public static void InfoPlant(List<Planted> list) {
        System.out.println("Zasadzone: Id, Gatunek, Wiek, Wiek_Dojrzewania, Procent_zdrowy, Czy_mozna_zebrac");
        for (Planted p : list) {
            System.out.println("        "+p.id + ", " + p.species.name + ", " + p.age + ", " + p.species.growTime + ", " + p.integrity + ", " + p.readyToHarvest);
        }
    }

    public static void InfoStorage(List<Seeds> list) {
        System.out.println("W magazynie: Gatunek, Ilość,  Wartosc_kilograma,Kiedy można sadzić Koszt_ochrony");
        for (Seeds s : list) {
            System.out.println("        "+s.species.name + ", " + s.amount + ", " + s.species.buyCost + ", " + s.species.plantingStart + "-" + s.species.plantingEnd + ", " + s.species.costPests);
        }
    }

    public static Double BuyLand(Farm farm, Double money) throws IOException {

        double amount;
        System.out.println("Liczba pieniędzy: " + money);
        System.out.println(farm);

        try {
            System.out.println("Cena za hektar to:" + farm.hectarCost + " . Ile hektarów chcesz kupić/sprzedać");
            amount = Double.parseDouble(Main.TakeInputFromKeyboard());

            if (farm.size + amount > 0.) {
                if (money > farm.hectarCost * amount) {
                    farm.size += amount;
                    return farm.hectarCost * amount;
                } else {
                    System.out.println("Stary, kasy na to nie masz");
                    return 0.;
                }
            } else {
                System.out.println("Sprzedawanie nieswojej ziemi to kiepski pomysł");
                return 0.;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Miałeś podać liczbe bęcwale");
        } finally {
            return 0.;
        }


    }

    public static Double BuyBuilding(Farm farm, Double money) throws IOException {

        System.out.println("Liczba pieniędzy: " + money);
        System.out.println(farm);

        while (true) {
            System.out.println("Cena za budynek to:" + farm.buildingCost + " . Czy chcesz kontynuować? wpisz tak/nie");
            String a = Main.TakeInputFromKeyboard();

            switch (a) {

                default:
                    break;

                case "nie":
                    System.out.println("Przerwano tranzakcje");
                    return 0.;

                case "tak":
                    if (money > farm.buildingCost) {
                        farm.buildingAmount++;
                        System.out.println("Kupiono nowy budynek");
                        return farm.buildingCost;
                    } else {
                        System.out.println("Stary, kasy na to nie masz");
                        return 0.;
                    }


            }
        }


    }

    public static Double BuyAnimal(List<Animal> animals, List<AnimalCount> breeding, Double money, Farm farm) throws IOException {

        int id;
        int amount;
        AnimalSpecies specie;
        double farmCapasity;
        System.out.println(Main.animalSpiecies);
        System.out.println("Liczba pieniędzy: " + money);

        try {
            System.out.println("Jakie zwierzęta chcesz kupić? (Podaj numer od 0 do " + (Main.animalSpiecies.size() - 1) + " aby wybrać gatunek zwierząt");
            id = Integer.parseInt(Main.TakeInputFromKeyboard());

            specie = Main.animalSpiecies.get(id);

            System.out.println("Ile sztuk zwierząt chcesz kupić?");
            amount = Integer.parseInt(Main.TakeInputFromKeyboard());

            double farmCapasityTaken = 0;
            for (Animal a : animals) {
                farmCapasityTaken += a.species.capasity;
            }

            farmCapasity = farm.buildingAmount - farmCapasityTaken;

            if (money > amount * specie.buyCost) {
                if (farmCapasity > amount * specie.weight) {
                    for (int i = 0; i < amount; i++) {
                        animals.add(new Animal(specie));
                        for (AnimalCount b : breeding) {
                            if (b.species == specie) {
                                b.adultAmount++;
                                break;
                            }
                        }
                    }
                    return amount * specie.buyCost;
                } else {
                    System.out.println("Za mało miejsca na farmie bratku");
                    return 0.;
                }

            } else {
                System.out.println("Za mało kasy bratku");
                return 0.;
            }


        } catch (NumberFormatException e) {
            System.out.println("Miałeś podać liczbe bęcwale");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Niepoprawne id");
        } finally {
            return 0.;
        }

    }

    public static double BuySeeds(List<Seeds> storage, Double money) throws IOException {


        int id;
        int amount;
        PlantSpecies specie;
        System.out.println(Main.plantsSpecies);
        System.out.println("Liczba pieniędzy: " + money);

        try {
            System.out.println("Jakie rośliny chcesz kupić? (Podaj numer od 0 do " + (Main.plantsSpecies.size() - 1) + " aby wybrać gatunek rośliny");
            id = Integer.parseInt(Main.TakeInputFromKeyboard());

            specie = Main.plantsSpecies.get(id);

            System.out.println("Ile ton roślin chcesz kupić?");
            amount = Integer.parseInt(Main.TakeInputFromKeyboard());

            if (amount > 0) {
                if (money > amount * specie.buyCost) {

                    for (int i = 0; i < storage.size(); i++) {
                        if (storage.get(i).species == specie) {
                            storage.get(i).amount += amount;
                            return amount * specie.buyCost;
                        }
                    }


                } else {
                    System.out.println("Za mało kasy bratku");
                    return 0.;
                }
            } else {
                System.out.println("Nasiona kupuje się gdzie indziej");
            }


        } catch (NumberFormatException e) {
            System.out.println("Miałeś podać liczbe bęcwale");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Niepoprawne id");
        } finally {
            return 0.;
        }


    }

    public static void Plant(List<Seeds> storage, List<Planted> planted, Farm farm) throws IOException {

        int id;
        double amount;
        PlantSpecies specie;
        double farmCapasity;
        System.out.println(Main.plantsSpecies);
        System.out.println("Dostępne nasiona: ");
        InfoStorage(storage);

        try {
            System.out.println("które nasiona chcesz zasiać? (Podaj numer od 0 do " + (Main.plantsSpecies.size() - 1) + " aby wybrać gatunek ");
            id = Integer.parseInt(Main.TakeInputFromKeyboard());

            specie = Main.plantsSpecies.get(id);

            System.out.println("Ile hektarów chcesz obsiac?");
            amount = Integer.parseInt(Main.TakeInputFromKeyboard());

            double farmCapasityTaken = 0;
            for (Planted p : planted) {
                farmCapasityTaken += p.amount;
            }

            farmCapasity = farm.size - farmCapasityTaken;

            if (farmCapasity > amount) {
                for (Seeds s : storage) {
                    if (s.species == specie) {
                        if (s.amount > amount) {
                            planted.add(new Planted(specie, amount));
                            s.amount -= amount;
                            System.out.println("Zasiano");
                        } else {
                            System.out.println("Za mało nasion bratku");
                        }
                        break;
                    }
                }

            } else {
                System.out.println("Za mało miejsca na farmie bratku");
            }


        } catch (NumberFormatException e) {
            System.out.println("Miałeś podać liczbe bęcwale");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Niepoprawne id");
        }


    }

    public static Double Harvest(List<Seeds> storage, List<Planted> planted, Double money) throws IOException {

        int id;
        double amount;
        System.out.println("Rośliny gotowe do zbiorów:");
        for (int i = 0; i < planted.size(); i++) {
            if (planted.get(i).readyToHarvest) {
                System.out.println("Id: " + i + " " + planted.get(i));
            }
        }

        try {
            System.out.println("Podaj które id tego co chcesz zebrać");
            id = Integer.parseInt(Main.TakeInputFromKeyboard());

            if (planted.get(id).readyToHarvest) {
                amount = planted.get(id).amount;

                if (money > amount * planted.get(id).species.costHarvest) {

                    for (Seeds s : storage) {
                        if (s.species == planted.get(id).species) {

                            s.amount += amount * planted.get(id).integrity * 0.01;
                            planted.remove(id);
                            System.out.println("Zebrano");
                            return amount * planted.get(id).species.costHarvest;
                        }
                    }


                } else {
                    System.out.println("Za mało kasy na zbiory bratku");
                    return 0.;
                }
            } else {
                System.out.println("Niepoprawne id");
                return 0.;
            }


        } catch (NumberFormatException e) {
            System.out.println("Miałeś podać liczbe bęcwale");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Niepoprawne id");
        }
        return 0.;

    }

    public static Double SellAnimal(List<Animal> animals, List<AnimalCount> breeding) throws IOException {

        int id;

        InfoAnimal(animals);

        try {
            System.out.println("Które zwierzę chcesz sprzedać? (Podaj numer od 0 do " + (animals.size() - 1));
            id = Integer.parseInt(Main.TakeInputFromKeyboard());

            double price = animals.get(id).sellPrice;

            if (animals.get(id).age >= animals.get(id).species.adultTime) {
                for (AnimalCount b : breeding) {
                    if (b.species == animals.get(id).species) {
                        b.adultAmount--;
                        break;
                    }
                }
            }
            animals.remove(id);
            System.out.println("Sprzedano zwierze");
            return price;


        } catch (NumberFormatException e) {
            System.out.println("Miałeś podać liczbe bęcwale");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Niepoprawne id");
        }
        return 0.;
    }

    public static Double SellSeeds(List<Seeds> storage) throws IOException {

        int id;
        double amount;

        InfoStorage(storage);

        try {
            System.out.println("Które zbiory chcesz sprzedać? (Podaj numer od 0 do " + (storage.size() - 1));
            id = Integer.parseInt(Main.TakeInputFromKeyboard());

//            double price = animals.get(id).sellPrice;

            System.out.println("Ile ton chcesz sprzedać?");
            amount = Integer.parseInt(Main.TakeInputFromKeyboard());

            if (amount > 0) {
                if (storage.get(id).amount - amount > 0 && storage.get(id).amount > amount) {

                    storage.get(id).amount -= amount;
                    System.out.println("Sprzedano zbiory");
                    return amount * storage.get(id).species.buyCost;
                } else {
                    System.out.println("Nie masz tyle zbiorów");
                    return 0.;
                }
            } else {
                System.out.println("Nasiona kupuje się gdzie indziej");
            }


        } catch (NumberFormatException e) {
            System.out.println("Miałeś podać liczbe bęcwale");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Niepoprawne id");
        }
        return 0.;
    }
    

}

