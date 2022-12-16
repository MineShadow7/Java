public class CageFullException extends  Exception{
    private boolean Full = true;

    public CageFullException(boolean isEmpty, String message){
        super(message);
        this.Full = isEmpty;
    }

    @Override
    public String toString() {
        return "CageFullException{" +
                "Full=" + Full +
                "}:" + this.getMessage();
    }
}
