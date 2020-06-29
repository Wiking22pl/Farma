package plants;

public class PlantSpecies {

    public final String name;

    //    cenę skupu kilograma
    public final Double buyCost;

    //    koszt przygotowania ziemi i sadzenia (w przeliczeniu na hektar)
    public final Double costPlanting;

    //    koszt ochrony przed szkodnikami (w przeliczeniu na hektar)
    public final Double costPests;

    //    wydajność upraw w tonach z hektara (ile możesz zebrać gotowego towaru)
    public final Double yield;

    //    długość okresu od posadzenia do zbiorów w tygodniach
    public final Integer growTime;

    //    informację o tym w których tygodniach roku można siać/sadzić
    public final Integer plantingStart;
    public final Integer plantingEnd;

    //    koszt zbioru (w przeliczeniu na hektar)
    public final Double costHarvest;

    public PlantSpecies(String name, Double buyCost, Double costPlanting, Double costPests, Double yield, Integer growTime, Integer plantingStart, Integer plantingEnd, Double costHarvest) {
        this.name = name;
        this.buyCost = buyCost;
        this.costPlanting = costPlanting;
        this.costPests = costPests;
        this.yield = yield;
        this.growTime = growTime;
        this.plantingStart = plantingStart;
        this.plantingEnd = plantingEnd;
        this.costHarvest = costHarvest;
    }
}
