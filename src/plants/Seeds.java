package plants;

public class Seeds {

    public PlantSpecies species;
    public Double amount;

    public Seeds(PlantSpecies species, Double amount) {
        this.species = species;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Seeds{" +
                "species=" + species.name +
                ", amount=" + amount +
                '}';
    }
}
