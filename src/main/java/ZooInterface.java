public interface ZooInterface  {
    void walk();
    void addCage(Cage newcage);
    void createCages();
    int getMaxCount();
    int getRealCount();
    void setCount(int _count);
    void addAnimal(Animal newanimal);
    String getAnimalNames();
    String getAnimalTypes();
    String getAnimalClasses();
    String getAnimalVoices();

}
