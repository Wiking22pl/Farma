package main;

import animals.Animal;
import farms.Farm;
import plants.Planted;
import plants.Seeds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public static Boolean DidYouWin(Farm farm, List<Animal> animals, List<Planted> planted, List<Seeds> storage) {
        Boolean rosliny=false;
        Boolean zwierzeta=false;
        Boolean zapasy=false;




        if(farm.size>20. ){
            return true;
        }

        return false;
    }

    public static void InfoAnimal(List<Animal> list) {
        System.out.println("Zwierzęta: Gatunek, Wiek, Wiek_Dojrzewania, Waga, Wartosc");
        for (Animal a : list) {
            System.out.println(a.species.name + ", " + a.age + ", " + a.species.adultTime + ", " + a.weight + ", " + a.sellPrice);
        }
    }

    public static void InfoPlant(List<Planted> list) {
        System.out.println("Zasadzone: Gatunek, Wiek, Wiek_Dojrzewania, Procent_zdrowy, Czy_mozna_zebrac");
        for (Planted p : list) {
            System.out.println(p.species.name + ", " + p.age + ", " + p.species.growTime + ", " + p.integrity + ", " + p.readyToHarvest);
        }
    }

    public static void InfoStorage(List<Seeds> list) {
        System.out.println("W magazynie: Gatunek, Ilość,  Wartosc_kilograma,Kiedy można sadzić Koszt_ochrony");
        for (Seeds s : list) {
            System.out.println(s.species.name + ", " + s.amount + ", " + s.species.seedCost + ", " + s.species.plantingEnd + "-" + s.species.plantingEnd + ", " + s.species.costPests);
        }
    }

    public static void BuyLand(Farm farm) {

    }

    public static void BuyBuilding(Farm farm) {

    }

    public static void BuyAnimal(List<Animal> animals) {

    }

    public static void BuySeeds(List<Seeds> storage) {

    }
}
