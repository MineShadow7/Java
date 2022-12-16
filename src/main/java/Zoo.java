import java.util.ArrayList;
import java.util.List;

public class Zoo implements ZooInterface {
    private int size = 4;
    private final List<Cage> ZooCages = new ArrayList<Cage>();
    Zoo(){
    }

    public  void createCages(){
        for(int i = 0; i < size; i++){
            ZooCages.add(new Cage());
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
    public void setCount(int _count) {
        size = _count;
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
    public String getAnimalNames() {
        StringBuilder names = new StringBuilder(new String());
        for (Cage ZooCages : ZooCages) {
            if (!ZooCages.getisEmpty()) {
                names.append(ZooCages.animal.getName());
            }
        }
        return names.toString();
    }

    @Override
    public String getAnimalTypes() {
        StringBuilder types = new StringBuilder(new String());
        for (Cage ZooCages : ZooCages) {
            if (!ZooCages.getisEmpty()) {
                types.append(ZooCages.animal.getType());
            }
        }
        return types.toString();
    }

    @Override
    public String getAnimalClasses() {
        StringBuilder classes = new StringBuilder(new String());
        for (Cage ZooCages : ZooCages) {
            if (!ZooCages.getisEmpty()) {
                classes.append(ZooCages.animal.getAnimalclass());
            }
        }
        return classes.toString();
    }

    @Override
    public String getAnimalVoices() {
        StringBuilder voices = new StringBuilder(new String());
        for (Cage ZooCages : ZooCages) {
            if (!ZooCages.getisEmpty()) {
                voices.append(ZooCages.animal.getVoice());
            }
        }
        return voices.toString();
    }

    @Override
    public void walk() {
        System.out.println("You walk in the Zoo and get near the cages. You hear voices: ");
        for(Cage ZooCages : ZooCages){
            if(!ZooCages.getisEmpty()) {
                System.out.println(ZooCages.animal.getVoice());
            }else{
                System.out.println("An empty cage...");
            }
        }
    }

    public void addCage(Cage cage){
        if (ZooCages.size() != 4) {
            ZooCages.add(cage);
        }else{
            throw new RuntimeException("Cannot Add more cages then Max size: " + size);
        }
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "size=" + size +
                ", ZooCages=" + ZooCages +
                '}';
    }
}
