public class Animal {
    public String name, type, aclass, voice;
    public boolean isCarnivore;

    public Animal(){
        this.name = "Default Name";
        this.type = "Default Type";
        this.aclass = "Default Class";
        this.voice = "Default Voice";
        this.isCarnivore = false;
    }
    public Animal(String name, String type, String aclass, String voice, boolean isCarnivore) {
        this.name = name;
        this.type = type;
        this.aclass = aclass;
        this.voice = voice;
        this.isCarnivore = isCarnivore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAclass() {
        return aclass;
    }

    public void setAclass(String aclass) {
        this.aclass = aclass;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public boolean isCarnivore() {
        return isCarnivore;
    }

    public void setCarnivore(boolean carnivore) {
        isCarnivore = carnivore;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", aclass='" + aclass + '\'' +
                ", voice='" + voice + '\'' +
                ", isCarnivore=" + isCarnivore +
                '}';
    }
}
