enum AnimalType {Predator, Herbivore}
enum AnimalNames {
    Name1("Gold"),
    Name2("Zander"),
    Name3("Toto"),
    Name4("Alehandro"),
    Name5("Sebby")
    ;
    private final String text;
    AnimalNames(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
enum AnimalClasses {
    Class1("Bird"),
    Class2("Mammals"),
    Class3("Amphibians"),
    ;
    private final String text;
    AnimalClasses(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
public class Animal {
    public String name, animalclass, voice;
    public AnimalType TypeAnimal;

    public Animal(){
        this.name = "Default Name";
        this.TypeAnimal = AnimalType.Predator;
        this.animalclass = "Default Class";
        this.voice = "Default Voice";
    }
    public Animal(String name, AnimalType type, String animalclass, String voice) {
        this.name = name;
        this.TypeAnimal = type;
        this.animalclass = animalclass;
        this.voice = voice;
    }

    public void GenerateStats(int namerandom, int typerandom, int classrandom) {
        if (typerandom == 1) {
            setType(AnimalType.Predator);
        } else {
            setType(AnimalType.Herbivore);
        }
        switch (namerandom) {
            case 0 -> setName(AnimalNames.Name1.toString());
            case 1 -> setName(AnimalNames.Name2.toString());
            case 2 -> setName(AnimalNames.Name3.toString());
            case 3 -> setName(AnimalNames.Name4.toString());
            case 4 -> setName(AnimalNames.Name5.toString());
        }
        switch (classrandom) {
            case 0 -> {
                setAnimalclass(AnimalClasses.Class1.toString());
                if (this.TypeAnimal == AnimalType.Predator) {
                    setVoice("Caw Caw");
                } else {
                    setVoice("Chirp Chirp");
                }
            }
            case 1 -> {
                setAnimalclass(AnimalClasses.Class2.toString());
                if (this.TypeAnimal == AnimalType.Predator) {
                    setVoice("Rawr");
                } else {
                    setVoice("Goaa");
                }
            }
            case 2 -> {
                setAnimalclass(AnimalClasses.Class3.toString());
                if (this.TypeAnimal == AnimalType.Predator) {
                    setVoice("Ribbit Ribbit");
                } else {
                    setVoice("Buzzz");
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return TypeAnimal.toString();
    }

    public void setType(AnimalType type) {
        this.TypeAnimal = type;
    }

    public String getAnimalclass() {
        return animalclass;
    }

    public void setAnimalclass(String animalclass) {
        this.animalclass = animalclass;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type='" + TypeAnimal + '\'' +
                ", animalclass='" + animalclass + '\'' +
                ", voice='" + voice + '\'' +
                '}';
    }
}
