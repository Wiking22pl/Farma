package animals;

import plants.Seeds;

import java.util.ArrayList;
import java.util.List;

public class AnimalSpecies {

    public final Double weight;

    public final String name;

    //ile miejsca w budynku dane zwierze zajmuje
    public final Double capasity;

    //    koszt zakupu
    public final Double buyCost;

    //Ile kosztuje teraz


    //    tempo przybierania na wadze na tydzień
    public final Double weightGrowth;

    //    czas wzrostu do dojrzałości w tygodniach (po tym okresie przestaje rosnąć, ale może się rozmnażać)
    public final Integer adultTime;

    //    ilość jedzenia jaką musisz dostarczyć na tydzień
    public final Double foodNeeded;

    //    rodzaje jedzenia jakie to zwierze akceptuje, pożywienie dla niektórych zwierząt możesz wyhodować samodzielnie.
    public final List<Seeds> whatItCanEat = new ArrayList<>();

    //    szansę na rozmnożenie, jeżeli posiadasz więcej niż jedno
    public final Double breedChance;

    public final Double costOfBoughtFood;   //Zrobic obiekt pasza i dać tu do niego referencje

    public AnimalSpecies(Double weight, String name, Double capasity, Double buyCost, Double weightGrowth, Integer adultTime, Double foodNeeded, Double breedChance, Double costOfBoughtFood) {
        this.weight = weight;
        this.name = name;
        this.capasity = capasity;
        this.buyCost = buyCost;
        this.weightGrowth = weightGrowth;
        this.adultTime = adultTime;
        this.foodNeeded = foodNeeded;
        this.breedChance = breedChance;
        this.costOfBoughtFood = costOfBoughtFood;
    }
}
