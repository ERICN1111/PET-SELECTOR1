import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Petselector extends JFrame {
    private JRadioButton birdRadio, catRadio, dogRadio, rabbitRadio, pigRadio;
    private ButtonGroup petGroup;
    private JLabel petLabel;
    private JButton showButton;

    public Petselector() {
        setTitle("RadioButtonDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Create the radio buttons
        birdRadio = new JRadioButton("Bird");
        catRadio = new JRadioButton("Cat");
        dogRadio = new JRadioButton("Dog");
        rabbitRadio = new JRadioButton("Rabbit");
        pigRadio = new JRadioButton("Pig");

        // Group the radio buttons
        petGroup = new ButtonGroup();
        petGroup.add(birdRadio);
        petGroup.add(catRadio);
        petGroup.add(dogRadio);
        petGroup.add(rabbitRadio);
        petGroup.add(pigRadio);

        // Set default selection
        dogRadio.setSelected(true);

        // Create the pet label with icon
        petLabel = new JLabel();
        petLabel.setHorizontalAlignment(JLabel.CENTER);
        petLabel.setFont(new Font("Arial", Font.BOLD, 16));
        petLabel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        updatePetDisplay("Dog");

        // Create radio button panel
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1, 5, 5));
        radioPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        radioPanel.add(birdRadio);
        radioPanel.add(catRadio);
        radioPanel.add(dogRadio);
        radioPanel.add(rabbitRadio);
        radioPanel.add(pigRadio);

        // Create show button
        showButton = new JButton("Show Selection");
        showButton.setFont(new Font("Arial", Font.BOLD, 14));
        showButton.setBackground(new Color(70, 130, 180));
        showButton.setForeground(Color.WHITE);
        showButton.setFocusPainted(false);
        showButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Add action listener to radio buttons
        ActionListener radioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton selected = (JRadioButton) e.getSource();
                updatePetDisplay(selected.getText());
            }
        };

        birdRadio.addActionListener(radioListener);
        catRadio.addActionListener(radioListener);
        dogRadio.addActionListener(radioListener);
        rabbitRadio.addActionListener(radioListener);
        pigRadio.addActionListener(radioListener);

        // Add action listener to show button
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSelection();
            }
        });

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showButton);

        // Add components to frame
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(radioPanel, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(petLabel, BorderLayout.CENTER);

        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set background colors
        leftPanel.setBackground(new Color(240, 248, 255));
        centerPanel.setBackground(new Color(255, 255, 255));
        buttonPanel.setBackground(new Color(240, 248, 255));

        setVisible(true);
    }

    private void updatePetDisplay(String pet) {
        String emoji = getPetEmoji(pet);
        String label = getPetLabel(pet);
        petLabel.setText(emoji + "  " + label);
        petLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 24));
    }

    private String getPetEmoji(String pet) {
        switch (pet) {
            case "Bird": return "🐦";
            case "Cat": return "🐱";
            case "Dog": return "🐶";
            case "Rabbit": return "🐰";
            case "Pig": return "🐷";
            default: return "";
        }
    }

    private String getPetLabel(String pet) {
        switch (pet) {
            case "Bird": return "I'm a Bird! 🐦";
            case "Cat": return "I'm a Cat! 🐱";
            case "Dog": return "I'm a Dog! 🐶";
            case "Rabbit": return "I'm a Rabbit! 🐰";
            case "Pig": return "I'm a Pig! 🐷";
            default: return "";
        }
    }

    private void showSelection() {
        String selectedPet = "";
        if (birdRadio.isSelected()) selectedPet = "Bird";
        else if (catRadio.isSelected()) selectedPet = "Cat";
        else if (dogRadio.isSelected()) selectedPet = "Dog";
        else if (rabbitRadio.isSelected()) selectedPet = "Rabbit";
        else if (pigRadio.isSelected()) selectedPet = "Pig";

        String message = "You selected: " + selectedPet + " " + getPetEmoji(selectedPet);
        JOptionPane.showMessageDialog(this, message, "Pet Selection", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Petselector();
            }
        });
    }
}