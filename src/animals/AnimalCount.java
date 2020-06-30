package animals;

public class AnimalCount {

    public AnimalSpecies species;
    public Integer amount = 0;
    public Integer adultAmount = 0;

    public AnimalCount(AnimalSpecies species, Integer amount, Integer adultAmount) {
        this.species = species;
        this.amount = amount;
        this.adultAmount = adultAmount;
    }

    @Override
    public String toString() {
        return "AnimalCount{" +
                "species=" + species +
                ", amount=" + amount +
                ", adultAmount=" + adultAmount +
                '}';
    }
}
