import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The class declaration, extending JFrame and implementing ActionListener
public class Main2 extends JFrame implements ActionListener {
    // Declaring JFrame and text fields as static s they can be accessed in the main method
    static JFrame frame;
    static JTextField result1;
    static JTextField result2;
    static JTextField result3;
    static JTextArea result4;

    // Main method
    public static void main(String[] args) {
        // Creating a new JFrame
        frame = new JFrame("Geometric progression");

        // Creating labels and text fields for user input
        JLabel text1 = new JLabel("First number");
        result1 = new JTextField("", 5);
        result1.setPreferredSize(new Dimension(100, 30));
        result1.setEditable(true);

        JLabel text2 = new JLabel("Common Ratio");
        result2 = new JTextField("", 5);
        result2.setPreferredSize(new Dimension(100, 30));
        result2.setEditable(true);

        JLabel text3 = new JLabel("Number of Terms");
        result3 = new JTextField("", 5);
        result3.setPreferredSize(new Dimension(100, 30));
        result3.setEditable(true);

        // Text field for displaying results
        result4 = new JTextArea(10,15);
        result4.setEditable(false);

        // Button for quitting the application
        JButton quitButton = new JButton("Quit");
        frame.setLayout(new FlowLayout());
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Button for computing progression
        JButton compute = new JButton("Compute");
        compute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calculation of progression terms
                int x = Integer.parseInt(result1.getText());
                int r = Integer.parseInt(result2.getText());
                int n = Integer.parseInt(result3.getText());

                StringBuilder result = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    Integer an = (int) (x * Math.pow(r, i)); // Formula for finding the nth term of the progression
                    result.append("a").append(i + 1).append(" = ").append(an).append("\n"); // Displaying the nth term of the progression
                }
                result4.setText(result.toString());
            }
        });

        // Creating vertical boxes for organizing components
        Box box1 = Box.createVerticalBox();
        box1.add(Box.createRigidArea(new Dimension(0, 90)));
        box1.add(text1);
        box1.add(Box.createRigidArea(new Dimension(0, 30)));
        box1.add(text2);
        box1.add(Box.createRigidArea(new Dimension(0, 30)));
        box1.add(text3);
        box1.add(Box.createRigidArea(new Dimension(0, 30)));
        box1.add(compute);
        box1.add(Box.createRigidArea(new Dimension(0, 30)));
        box1.add(quitButton);

        Box box2 = Box.createVerticalBox();
        box2.setAlignmentY(Component.TOP_ALIGNMENT);
        box2.add(result1);
        box2.add(Box.createRigidArea(new Dimension(0, 15)));
        box2.add(result2);
        box2.add(Box.createRigidArea(new Dimension(0, 15)));
        box2.add(result3);

        Box box3 = Box.createVerticalBox();
        box3.setAlignmentY(Component.TOP_ALIGNMENT);
        box3.add(result4);

        // Adding components to the frame
        frame.add(box1);
        frame.add(box2);
        frame.add(box3);
        frame.setSize(450, 400);
        frame.setVisible(true);
    }

    // ActionPerformed method for handling button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // This method can be used to handle events for other buttons if needed
    }
}

