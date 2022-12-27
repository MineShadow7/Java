import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualClass extends JFrame {
    GridLayout gridLayout = new GridLayout(5, 3);
    JComboBox selectedCage;
    JButton buttonWalk = new JButton("Walk");
    JButton buttonUniqueTypes = new JButton("Get Unique Types");
    JButton buttonAmountTypes = new JButton("Get Amount of Types");
    JButton buttonName = new JButton("Get Animal Name");
    JButton buttonType = new JButton("Get Animal Type");
    JButton buttonClass = new JButton("Get Animal Class");
    JButton buttonAddCage = new JButton("Add Cage from Fields");
    JButton buttonRemoveCage = new JButton("Remove Cage by Index");
    JButton buttonSaveJSON = new JButton("Save To JSON");
    JButton buttonSaveBIN = new JButton("Save To BIN");
    JButton buttonReadBIN = new JButton("Read From BIN");
    JButton buttonReadJSON = new JButton("Read From JSON");
    JTextField nameField = new JTextField();
    JComboBox typeField = new JComboBox();
    JTextField classField = new JTextField();
    JTextField voiceField = new JTextField();
    String typesList[] = {"Herbivore", "Predator"};
    JLabel[] cages;

    private void initTypesList(){
        typeField = new JComboBox<>(typesList);
    }

    private void addCages(ZooInterface zoo, JPanel components){
        int size = zoo.getMaxCount();
        cages = new JLabel[size];
        for(int i = 0; i < size; i++){
            cages[i] = new JLabel("Default Text");
            cages[i].setText((i + 1) + " " + zoo.getAnimalName(i) + " " + zoo.getAnimalClass(i)  + " " + zoo.getAnimalType(i)  + " " + zoo.getAnimalVoice(i));
            components.add(cages[i]);
        }
    }
    private void removeCages(JPanel components){
        components.removeAll();
        gridLayout.layoutContainer(components);
    }
    private void removeCageByIndex(ZooInterface zoo, JPanel components, int index) {
        zoo.removeCage(index);
        for(int i = 0; i < zoo.getMaxCount() + 1; i++){
            components.remove(cages[i]);
            gridLayout.layoutContainer(components);
        }
        addCages(zoo, components);
        gridLayout.layoutContainer(components);
    }
    public void addComponentsToPane(final Container pane, ZooInterface zoo) {
        initTypesList();
        selectedCage = new JComboBox();
        for(int i = 0; i < zoo.getMaxCount(); i++) {
            selectedCage.addItem(i + 1);
        }

        final JPanel components = new JPanel();
        components.setLayout(gridLayout);

        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(2, 3));

        JPanel outputs = new JPanel();
        outputs.setLayout(new GridLayout(3, 4));


        JLabel l = new JLabel();
        Dimension labelsize = l.getPreferredSize();
        components.setPreferredSize(new Dimension((int) (labelsize.getWidth() * 2.5) + 60, (int) (labelsize.getHeight() * 3.5) + 60 * 2));

        addCages(zoo, components);

        controls.add(buttonSaveBIN);
        controls.add(buttonSaveJSON);
        controls.add(buttonReadBIN);
        controls.add(buttonReadJSON);
        controls.add(buttonWalk);
        controls.add(buttonUniqueTypes);
        controls.add(buttonAmountTypes);
        controls.add(buttonName);
        controls.add(buttonType);
        controls.add(buttonClass);
        controls.add(selectedCage);
        controls.add(buttonRemoveCage);
        controls.add(buttonAddCage);
        controls.add(nameField);
        controls.add(typeField);
        controls.add(classField);
        controls.add(voiceField);

        buttonSaveBIN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveDataClass save = new SaveDataClass();
                save.writeToBin((Zoo) zoo);
                outputs.add(new JLabel("Done saving to BIN"));
                gridLayout.layoutContainer(outputs);
            }
        });

        buttonSaveJSON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveDataClass save = new SaveDataClass();
                save.writeToJSON((Zoo) zoo);
                outputs.add(new JLabel("Done saving to JSON"));
                gridLayout.layoutContainer(outputs);
            }
        });

        buttonReadBIN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveDataClass save = new SaveDataClass();
                ZooInterface newzoo;
                newzoo = save.ReadFromBin();
                selectedCage.removeAllItems();
                removeCages(components);
                addCages(newzoo, components);
                zoo.setNewSize((Zoo) newzoo);
                for(int i = 0; i < zoo.getMaxCount(); i++) {
                    selectedCage.addItem(i + 1);
                }
                gridLayout.layoutContainer(components);
            }
        });
        buttonReadJSON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveDataClass save = new SaveDataClass();
                ZooInterface newzoo;
                newzoo = save.ReadFromJSON();
                selectedCage.removeAllItems();
                removeCages(components);
                addCages(newzoo, components);
                zoo.setNewSize((Zoo) newzoo);
                for(int i = 0; i < zoo.getMaxCount(); i++) {
                    selectedCage.addItem(i + 1);
                }
                gridLayout.layoutContainer(components);
            }
        });
        buttonName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel animalName = new JLabel();
                int selectedIndex = selectedCage.getSelectedIndex();
                animalName.setText(zoo.getAnimalName(selectedIndex));
                outputs.add(animalName);
                gridLayout.layoutContainer(outputs);
            }
        });

        buttonClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel animalClass = new JLabel();
                int selectedIndex = selectedCage.getSelectedIndex();
                animalClass.setText(zoo.getAnimalClass(selectedIndex));
                outputs.add(animalClass);
                gridLayout.layoutContainer(outputs);
            }
        });

        buttonType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel animalType = new JLabel();
                int selectedIndex = selectedCage.getSelectedIndex();
                animalType.setText(zoo.getAnimalType(selectedIndex));
                outputs.add(animalType);
                gridLayout.layoutContainer(outputs);
            }
        });

        buttonAmountTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel animalAmountTypes = new JLabel();
                animalAmountTypes.setText(zoo.getTypesAmount());
                outputs.add(animalAmountTypes);
                gridLayout.layoutContainer(outputs);
            }
        });

        buttonUniqueTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel animalUniqueTypes = new JLabel();
                animalUniqueTypes.setText(zoo.getUniqueTypes().toString());
                outputs.add(animalUniqueTypes);
                gridLayout.layoutContainer(outputs);
            }
        });

        buttonWalk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel zooWalk = new JLabel();
                zooWalk.setText(zoo.walk());
                outputs.add(zooWalk);
                gridLayout.layoutContainer(outputs);
            }
        });

        buttonAddCage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name, aclass, voice;
                AnimalType type;
                int typeindex = 0;
                name = nameField.getText();
                typeindex = typeField.getSelectedIndex();
                aclass = classField.getText();
                voice = voiceField.getText();
                if (typeindex == 0){
                    type = AnimalType.Herbivore;
                }else{
                    type = AnimalType.Predator;
                }
                Cage newcage = new Cage();
                Animal newanimal = new Animal(name, type, aclass, voice);
                newcage.setIsEmpty(true);
                try {
                    newcage.addAnimal(newanimal);
                } catch (CageFullException ex) {
                    throw new RuntimeException(ex);
                }
                removeCages(components);
                zoo.addCage(newcage);
                addCages(zoo, components);
                selectedCage.addItem(zoo.getMaxCount());
                gridLayout.layoutContainer(components);
            }
        });
        buttonRemoveCage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = selectedCage.getSelectedIndex();
                int removableindex = zoo.getMaxCount();
                if(zoo.getMaxCount() != 1) {
                    removeCageByIndex(zoo, components, selectedIndex);
                    selectedCage.removeItem(removableindex);
                }else{
                    outputs.add(new JLabel("Must have at least 1 Cage in Zoo"));
                    gridLayout.layoutContainer(outputs);
                }
                gridLayout.layoutContainer(components);
            }
        });

        pane.add(components, BorderLayout.NORTH);
        pane.add(outputs, BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH);
    }

    public void createGUI(ZooInterface zoo) {
        VisualClass frame = new VisualClass();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane(), zoo);
        //Display the window.
        frame.pack();
        frame.setSize(768,480);
        frame.setTitle("Zoo Visual Program");
        frame.setVisible(true);
    }
}

