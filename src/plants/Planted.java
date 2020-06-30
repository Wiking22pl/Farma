package plants;

public class Planted {

    public PlantSpecies species;
    public Double amount;   //w hekatarach
    public Double integrity = 100.;
    public Integer age = 0;
    public Boolean readyToHarvest = false;

    public Planted(PlantSpecies species, Double amount) {
        this.species = species;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Planted{" +
                ", species=" + species.name +
                ", amount=" + amount +
                ", integrity=" + integrity +
                ", age=" + age +
                ", readyToHarvest=" + readyToHarvest +
                '}';
    }
}
