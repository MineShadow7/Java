import java.io.Serializable;
import java.util.Random;

public class Cage implements Serializable {
    public Animal animal;
    public boolean isEmpty;
    transient private Random random = new Random();

    public Cage() {
        isEmpty = random.nextBoolean();
        if (!isEmpty) {
            animal = new Animal();
            int randname = random.nextInt(5);
            int randtype = random.nextInt(2);
            int randclass = random.nextInt(3);
            animal.GenerateStats(randname, randtype, randclass);
        }
    }
    public boolean getisEmpty(){ return isEmpty; }
    public void setIsEmpty(boolean isEmpty1) { isEmpty = isEmpty1; };
    public Cage(int randname, int randtype, int randclass) {
        isEmpty = random.nextBoolean();
        if (!isEmpty) {
            animal = new Animal();
            animal.GenerateStats(randname, randtype, randclass);
        }
    }

    public void addAnimal(Animal newAnimal) throws CageFullException {
        if (!isEmpty) throw new CageFullException(true, "Cage can't be full when adds new animal");
        if (isEmpty) {
            animal = newAnimal;
            isEmpty = false;
            System.out.println("Done!");
        }
    }

    @Override
    public String toString() {
        if (!getisEmpty()) {
            return "Cage{" +
                    "random=" + animal.toString() +
                    '}';
        } else {
            return "Cage is empty.";
        }
    }
}