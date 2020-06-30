package plants;

public class Planted {

    public Integer id;
    public PlantSpecies species;
    public Double amount;   //w hekatarach
    public Double integrity = 100.;
    public Integer age = 0;
    public Boolean readyToHarvest = false;

    public Planted(PlantSpecies species, Double amount) {
        this.species = species;
        this.amount = amount;
    }
}
