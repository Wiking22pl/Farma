package main;

import animals.Animal;
import animals.AnimalSpecies;
import farms.Farm;
import plants.PlantSpecies;
import plants.Planted;
import plants.Seeds;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Maintenance {

//    public static void addToList(List<Object> list, Object o ){
//        list.add(o);
//    }


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
            System.out.println(a.id + ", " + a.species.name + ", " + a.age + ", " + a.species.adultTime + ", " + a.weight + ", " + a.sellPrice);
        }
    }

    public static void InfoPlant(List<Planted> list) {
        System.out.println("Zasadzone: Id, Gatunek, Wiek, Wiek_Dojrzewania, Procent_zdrowy, Czy_mozna_zebrac");
        for (Planted p : list) {
            System.out.println(p.id + ", " + p.species.name + ", " + p.age + ", " + p.species.growTime + ", " + p.integrity + ", " + p.readyToHarvest);
        }
    }

    public static void InfoStorage(List<Seeds> list) {
        System.out.println("W magazynie: Gatunek, Ilość,  Wartosc_kilograma,Kiedy można sadzić Koszt_ochrony");
        for (Seeds s : list) {
            System.out.println(s.species.name + ", " + s.amount + ", " + s.species.buyCost + ", " + s.species.plantingEnd + "-" + s.species.plantingEnd + ", " + s.species.costPests);
        }
    }

    public static Double BuyLand(Farm farm, Double money) {

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

    public static Double BuyAnimal(List<Animal> animals, Double money, Farm farm) throws IOException {

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
                if (farmCapasity > 0) {
                    for (int i = 0; i < amount; i++) {
                        animals.add(new Animal(specie));
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

    public static double BuySeeds(List<Seeds> storage, Double money) {


        int id;
        int amount;
        PlantSpecies specie;
        System.out.println(Main.plantsSpecies.toString());
        System.out.println("Liczba pieniędzy: " + money);

        try {
            System.out.println("Jakie rośliny chcesz kupić? (Podaj numer od 0 do " + (Main.plantsSpecies.size() - 1) + " aby wybrać gatunek rośliny");
            id = Integer.parseInt(Main.TakeInputFromKeyboard());

            specie = Main.plantsSpecies.get(id);

            System.out.println("Ile ton roślin chcesz kupić?");
            amount = Integer.parseInt(Main.TakeInputFromKeyboard());

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


        } catch (NumberFormatException e) {
            System.out.println("Miałeś podać liczbe bęcwale");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Niepoprawne id");
        } finally {
            return 0.;
        }


    }
}
