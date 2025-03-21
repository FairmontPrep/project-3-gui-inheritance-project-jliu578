import javax.swing.*;
import java.awt.*;
import java.util.Random;

// Parent Class
class AirplanePart {
    protected String description;
    protected String imagePath;

    public AirplanePart(String description, String imagePath) {
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public ImageIcon getImage() {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}

// Child Classes
class Wings extends AirplanePart {
    public Wings() {
        super(
            new Random().nextBoolean() ? "Red Wings" : "Blue Wings",
            new Random().nextBoolean() ? "red_wings.png" : "blue_wings.png"
        );
    }
}

class Body extends AirplanePart {
    public Body() {
        super("Airplane Body", "body.png");
    }
}

class Tail extends AirplanePart {
    public Tail() {
        super("Airplane Tail", "tail.png");
    }
}

// GUI Class
public class AirplaneGUI extends JFrame {
    public AirplaneGUI() {
        setTitle("GUI Inheritance Project - Airplane");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel to hold airplane parts
        JPanel airplanePanel = new JPanel();
        airplanePanel.setLayout(new BoxLayout(airplanePanel, BoxLayout.Y_AXIS));
        airplanePanel.setBackground(Color.WHITE);

        // Create parts
        Wings wings = new Wings();
        Body body = new Body();
        Tail tail = new Tail();

        // Add images to panel
        airplanePanel.add(new JLabel(wings.getImage(), SwingConstants.CENTER));
        airplanePanel.add(new JLabel(body.getImage(), SwingConstants.CENTER));
        airplanePanel.add(new JLabel(tail.getImage(), SwingConstants.CENTER));

        // Description Panel
        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setLayout(new GridLayout(1, 1));
        JLabel descriptionLabel = new JLabel(
            "<html><center>" + wings.getDescription() + "<br>" +
            body.getDescription() + "<br>" +
            tail.getDescription() + "</center></html>",
            SwingConstants.CENTER
        );
        descriptionPanel.add(descriptionLabel);

        // Add panels to frame
        add(airplanePanel, BorderLayout.CENTER);
        add(descriptionPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AirplaneGUI();
    }
}