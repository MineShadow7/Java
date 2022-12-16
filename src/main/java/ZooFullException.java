public class ZooFullException extends Exception{
    private int Fullness = 4;


    public ZooFullException(int size, String message){
        super(message);
        this.Fullness = size;
    }

    @Override
    public String toString() {
        return "CageFullException{" +
                "Size=" + Fullness +
                "}:" + this.getMessage();
    }
}
