import java.util.HashMap;
import java.util.Set;

public interface ZooInterface  {
    String walk();
    void addCage(Cage newcage);
    void createCages();
    int getMaxCount();
    int getRealCount();
    void addAnimal(Animal newanimal);
    String getAnimalName(int index);
    String getAnimalType(int index);
    String getAnimalClass(int index);
    String getAnimalVoice(int index);
    String getTypesAmount();
    Set getUniqueTypes();


}
