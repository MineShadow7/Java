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

    public void addComponentsToPane(final Container pane, ZooInterface zoo) {
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
        for(int i = 0; i < zoo.getMaxCount(); i++){
            components.add(new JLabel((i + 1) + " " + zoo.getAnimalName(i) + " " + zoo.getAnimalClass(i)  + " " + zoo.getAnimalType(i)  + " " + zoo.getAnimalVoice(i)));
        }


        //controls.add(new JLabel(zoo.walk()));
        controls.add(buttonWalk);
        controls.add(buttonUniqueTypes);
        controls.add(buttonAmountTypes);
        controls.add(buttonName);
        controls.add(buttonType);
        controls.add(buttonClass);
        controls.add(selectedCage);

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

