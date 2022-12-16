import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Main {
    public static void main(String[] argv) {

        Random rand = new Random();
        Animal animal = new Animal();
        Cage cage = new Cage();
        cage.setIsEmpty(true);
        System.out.println(cage);
        animal.GenerateStats(rand.nextInt(5), rand.nextInt(2), rand.nextInt(3));
        System.out.println(animal);
        try {
            cage.addAnimal(animal);
        } catch (CageFullException e) {
            throw new RuntimeException(e);
        }
        System.out.println(cage);

        String classes = new String();
        String names = new String();
        String types = new String();
        String voices = new String();
        int count;
        ZooInterface zoo = new Zoo();
        zoo.createCages();
        System.out.println(zoo);
        zoo.addAnimal(animal);
        System.out.println(zoo);
        zoo.walk();
        classes = zoo.getAnimalClasses();
        names = zoo.getAnimalNames();
        types = zoo.getAnimalTypes();
        voices = zoo.getAnimalVoices();
        count = zoo.getRealCount();
        System.out.println(classes + " " + names + " " + types + " " + voices + " " + count);
    }
}
