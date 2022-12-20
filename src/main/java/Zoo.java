import java.io.Serializable;
import java.util.*;
import java.util.Comparator;

public class Zoo implements ZooInterface, Serializable {
    private int size;
    private Cage[] ZooCages;
    transient private static Comparator<Cage> ascEmpty;


    Zoo(int _size){
        size = _size;
        ZooCages = new Cage[size];
    }


    static {
        ascEmpty = new Comparator<Cage>() {
            @Override
            public int compare(Cage c1, Cage c2) {
                return Boolean.compare(c1.getisEmpty(), c2.getisEmpty());
            }
        };
    }

    public void createCages(){
        for(int i = 0; i < size; i++){
            ZooCages[i] = new Cage();
        }
    }

    @Override
    public int getMaxCount() {
        return size;
    }
    public void setNewSize(Zoo newcages){
        size = newcages.getMaxCount();
        ZooCages = newcages.ZooCages;
    }
    public int getRealCount() {
        int realsize = 0;
        for (Cage ZooCages : ZooCages) {
            if (!ZooCages.getisEmpty()) {
                realsize = realsize + 1;
            }
        }
        return realsize;
    }

    @Override
    public void addAnimal(Animal newanimal) {
        for(Cage ZooCages : ZooCages){
            if(ZooCages.getisEmpty()) {
                try {
                    ZooCages.addAnimal(newanimal);
                } catch (CageFullException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }

    @Override
    public String getAnimalName(int index) {
        String name = "";
        if(!ZooCages[index].getisEmpty()) {
            name = ZooCages[index].animal.getName();
        }else{
            name = "Empty";
        }
        return name;
    }

    @Override
    public String getAnimalType(int index) {
        String type = "";
        if(!ZooCages[index].getisEmpty()) {
            type = ZooCages[index].animal.getType();
        }else{
            type = "Empty";
        }
        return type;
    }

    @Override
    public String getAnimalClass(int index) {
        String aclass = "";
        if(!ZooCages[index].getisEmpty()) {
            aclass = ZooCages[index].animal.getAnimalclass();
        }else{
            aclass = "Empty";
        }
        return aclass;
    }

    @Override
    public String getAnimalVoice(int index) {
        String voice = "";
        if(!ZooCages[index].getisEmpty()) {
            voice = ZooCages[index].animal.getVoice();
        }else{
            voice = "Empty";
        }
        return voice;
    }

    public Set getUniqueTypes(){
        Set<String> strings = new HashSet<>();
        for (Cage c : ZooCages){
            if(!c.getisEmpty()) {
                strings.add(c.animal.getType());
            }
        }
        return strings;
    }

    public String getTypesAmount(){
        HashMap<Integer, String> PredatorAmount = new HashMap<>();
        HashMap<Integer, String> HerbivoreAmount = new HashMap<>();
        int countP = 0;
        int countH = 0;
        String result;
        for (Cage c: ZooCages) {
            if(!c.getisEmpty()){
                if(c.animal.TypeAnimal == AnimalType.Predator){
                    countP += 1;
                }else{
                    countH += 1;
                }
            }
        }
        PredatorAmount.put(countP, AnimalType.Predator.name());
        HerbivoreAmount.put(countH, AnimalType.Herbivore.name());
        result = PredatorAmount.toString() + HerbivoreAmount.toString();
        return result;
    }

    public void sort(){
        Arrays.sort(ZooCages, ascEmpty);
    }
    @Override
    public String walk() {
        String msg = "You walk in the Zoo and get near the cages. You hear voices: |";
        for(Cage ZooCages : ZooCages){
            if(!ZooCages.getisEmpty()) {
                msg += " " + ZooCages.animal.getVoice()+ " | ";
            }else{
                msg +=" " + "Empty Cage" + " | ";
            }
        }
        return msg;
    }

    public void addCage(Cage cage){
        size += 1;
        if (ZooCages.length < size) {
            Cage[] newcages = new Cage[size];
            for (int i = 0; i < ZooCages.length; i++){
                newcages[i] = ZooCages[i];
            }
            newcages[ZooCages.length] = cage;
            this.ZooCages = newcages;
        }else{
            throw new RuntimeException("Cannot Add more cages then Max size: " + size);
        }
    }

    public void removeCage(int index){
        Cage[] newcages = new Cage[size - 1];
        for (int i = 0; i < size - 1; i++)
        {
            newcages[i] = ZooCages[i];
        }
        size -= 1;
        ZooCages = newcages;
        this.sort();
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "size=" + size +
                ", ZooCages=" + Arrays.toString(ZooCages) +
                '}';
    }
}
