import static java.lang.System.*;

public class Cage {
    private static Animal animal = new Animal();
    public static boolean isEmpty = false;

    public Cage() {
        isEmpty = false;
        animal.setAclass("Default Class");
        animal.setCarnivore(false);
        animal.setName("Default Name");
        animal.setType("Default Type");
        animal.setVoice("Default Voice");
    }

    public static void print() {
        if (isEmpty == false) {
            out.println(animal);
        }else {
            out.println("Cage Empty");
        }
    }
}