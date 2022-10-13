
public class Main{
    public static void main(String[] argv){
        Animal defaultanimal = new Animal();
        System.out.println(defaultanimal);
        Cage defaultcage = new Cage();
        Cage.print();
        Zoo newzoo = new Zoo();
        newzoo.print();
    }
}
