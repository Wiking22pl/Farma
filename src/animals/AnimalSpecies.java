package animals;

import plants.Seeds;

import java.util.ArrayList;
import java.util.List;

public class AnimalSpecies {

    public final Double weight;

    //ile miejsca w budynku dane zwierze zajmuje
    public final Double capasity;

    //    koszt zakupu
    public final Double buyCost;

    //    tempo przybierania na wadze na tydzień
    public final Double weightGrowth;

    //    czas wzrostu do dojrzałości w tygodniach (po tym okresie przestaje rosnąć, ale może się rozmnażać)
    public final Double adultTime;

    //    ilość jedzenia jaką musisz dostarczyć na tydzień
    public final Double foodNeeded;

    //    rodzaje jedzenia jakie to zwierze akceptuje, pożywienie dla niektórych zwierząt możesz wyhodować samodzielnie.
    public final List<Seeds> whatItCanEat = new ArrayList<>();

    //    szansę na rozmnożenie, jeżeli posiadasz więcej niż jedno
    public final Double breedChance;

    public final Double costOfBoughtFood;

    public AnimalSpecies(Double weight, Double capasity, Double buyCost, Double weightGrowth, Double adultTime, Double foodNeeded, Double breedChance, Double costOfBoughtFood) {
        this.weight = weight;
        this.capasity = capasity;
        this.buyCost = buyCost;
        this.weightGrowth = weightGrowth;
        this.adultTime = adultTime;
        this.foodNeeded = foodNeeded;
        this.breedChance = breedChance;
        this.costOfBoughtFood = costOfBoughtFood;
    }
}
