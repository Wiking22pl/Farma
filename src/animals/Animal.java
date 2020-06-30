package animals;

public class Animal {

    //    public final String subSpiecies;

    public Integer id;
    public AnimalSpecies species;
    public Integer age = 1;
    public Double weight;
    public Double sellPrice;
    //public String name;

    public static Integer id_counter = 0;

    public Animal(AnimalSpecies species) {
        this.id = id_counter++;
        this.species = species;
        this.sellPrice = species.buyCost/2.;
        this.weight = species.weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", species=" + species.name +
                ", age=" + age +
                ", weight=" + weight +
                ", sellPrice=" + sellPrice +
                '}';
    }
//Grow
    //Eat
    //Breed
    //Sell
    //Buy


}
