import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SaveDataClass {

    public void writeToJSON(Zoo zoo){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Writer writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get("ZooData.json"));
            gson.toJson(zoo, writer);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToBin(Zoo zoo){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ZooData.bin"));
            oos.writeObject(zoo);
        } catch (IOException ex) {
            System.out.println("Error writing type 1");
        }
    }

    public Zoo ReadFromBin() {
        Zoo zoo2 = null;
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream("ZooData.bin"));
            zoo2 = (Zoo) oos.readObject();
        } catch (IOException ex) {
            System.out.println("Error reading type 1");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error reading type 2");
        }
        return zoo2;
    }
    public Zoo ReadFromJSON(){
        Zoo zoo1;
        Gson gson = new Gson();
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("ZooData.json"));
            zoo1 = gson.fromJson(reader, Zoo.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return zoo1;
    }
}
