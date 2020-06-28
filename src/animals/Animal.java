package animals;

public class Animal {

    //    public final String subSpiecies;

    public AnimalSpecies species;
    public Integer age = 1;
    public Double weight = species.weight;
    public Double sellPrice;
    //public String name;

    public Animal(AnimalSpecies species) {
        this.species = species;
        this.sellPrice = species.buyCost/2.;
    }

    //Grow
    //Eat
    //Breed
    //Sell
    //Buy


}
