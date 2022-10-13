import java.util.Arrays;

public class Zoo {
    public int size = 4;
    public Cage[] ZooCages = new Cage[size];
    Zoo(){
        this.size = 4;
        Cage[] ZooCages = new Cage[size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size > 4 || size < 1){
            System.out.println("Size can't be more than 4 or less than 1");
        }else {
            this.size = size;
            Cage[] ZooCages = new Cage[size];
        }
    }
    public void print(){
        for (int i = 0; i < size; i++){
            ZooCages[i].print();
        }
    }
}
