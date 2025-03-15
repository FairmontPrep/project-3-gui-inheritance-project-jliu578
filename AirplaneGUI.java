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
        return new ImageIcon(imagePath);
    }
}

// Child Class
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
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // Create parts
        Wings wings = new Wings();
        Body body = new Body();
        Tail tail = new Tail();

        // Add images
        add(new JLabel(wings.getImage()));
        add(new JLabel(body.getImage()));
        add(new JLabel(tail.getImage()));

        // Display description
        JLabel descriptionLabel = new JLabel(
            "<html>" + wings.getDescription() + "<br>" +
            body.getDescription() + "<br>" +
            tail.getDescription() + "<br>" +
            SwingConstants.CENTER
        );
        add(descriptionLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AirplaneGUI();
    }
}