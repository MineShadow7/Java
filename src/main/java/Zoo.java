import java.util.*;

public class Zoo implements ZooInterface {
    private int size;
    private Cage[] ZooCages;


    Zoo(int _size){
        size = _size;
        ZooCages = new Cage[size];
    }

    public  void createCages(){
        for(int i = 0; i < size; i++){
            ZooCages[i] = new Cage();
        }
    }

    @Override
    public int getMaxCount() {
        return size;
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
        HashMap<Integer, String> amount = new HashMap<>();
        int countP = 0;
        int countH = 0;
        String result;
        for (Cage c: ZooCages) {
            if(!c.getisEmpty()){
                if(c.animal.TypeAnimal == AnimalType.Predator){
                    amount.remove(countP, c.animal.getType());
                    countP += 1;
                    amount.put(countP, c.animal.getType());
                }else{
                    amount.remove(countH, c.animal.getType());
                    countH += 1;
                    amount.put(countH, c.animal.getType());
                }
            }
        }
        result = amount.toString();
        return result;
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

    @Override
    public String toString() {
        return "Zoo{" +
                "size=" + size +
                ", ZooCages=" + Arrays.toString(ZooCages) +
                '}';
    }
}
