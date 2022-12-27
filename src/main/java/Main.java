import java.util.*;

public class Main {
    public static void main(String[] argv) {

        Random rand = new Random();
        Animal animal = new Animal();
        Cage cage = new Cage();
        cage.setIsEmpty(true);
        animal.GenerateStats(rand.nextInt(5), rand.nextInt(2), rand.nextInt(3));
        System.out.println(animal);
        try {
            cage.addAnimal(animal);
        } catch (CageFullException e) {
            throw new RuntimeException(e);
        }
        System.out.println(cage);


        ZooInterface zoo = new Zoo(9);
        zoo.createCages();
        System.out.println(zoo);
        zoo.addAnimal(animal);
        System.out.println(zoo);
        zoo.addCage(cage);
        System.out.println(zoo);
        zoo.sort();
        zoo.walk();
        Set u = new HashSet<>();
        u = zoo.getUniqueTypes();
        System.out.println(u);
        String amount;
        amount = zoo.getTypesAmount();
        System.out.println(amount);


        VisualClass zooV = new VisualClass();
        zooV.createGUI(zoo);

    }
}
