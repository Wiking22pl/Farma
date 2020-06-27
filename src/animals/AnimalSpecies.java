package animals;

import plants.Planted;

import java.util.ArrayList;
import java.util.List;

public class AnimalSpecies {

    public Double weight;

    //    koszt zakupu
    public Double buyCost;

    //    tempo przybierania na wadze na tydzień
    public Double weightGrowth;

    //    czas wzrostu do dojrzałości w tygodniach (po tym okresie przestaje rosnąć, ale może się rozmnażać)
    public Double growthTime;

    //    ilość jedzenia jaką musisz dostarczyć na tydzień
    public Double foodNeeded;

    //    rodzaje jedzenia jakie to zwierze akceptuje, pożywienie dla niektórych zwierząt możesz wyhodować samodzielnie.
    public List<Planted> whatItCanEat = new ArrayList<>();

    //    szansę na rozmnożenie, jeżeli posiadasz więcej niż jedno
    public Double breedChance;
}
