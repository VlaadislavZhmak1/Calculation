import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    static JFrame frame;
    static JTextField result, result1, result2, result3, result4;
    static String a = "", b = "", operation = "";
    static JButton calculation;
    static JButton erase; // Оголошуємо статичні змінні, які використовуються в калькуляторі

    public static void main(String[] args) {
        Main listen = new Main();
        frame = new JFrame("Calculator"); // Створення фрейму з назвою "Calculator"
        // Налаштування елементів інтерфейсу та їх розташування
        JLabel label1 = new JLabel("X^2 + "); // Поле для введення коефіцієнта при x^2
        result = new JTextField("", 5);
        result.setBounds(200, 110, 100, 30);
        result.setEditable(true);

        JLabel label2= new JLabel("X + "); // Поле для введення коефіцієнта при x
        result1 = new JTextField("", 5);
        result1.setBounds(250, 200, 100, 30);
        result1.setEditable(true);

        JLabel label3 = new JLabel("= 0");// Поле для введення вільного члена
        result2 = new JTextField("", 5);
        result2.setBounds(200, 110, 100, 30);
        result2.setEditable(true);

        JLabel label4 = new JLabel("Root1:"); // Поле для виводу першого кореня x1
        result3 = new JTextField("", 12);
        result3.setBounds(250, 200, 100, 30);
        result3.setEditable(false);

        JLabel label5= new JLabel("Root2:"); // Поле для виводу другого кореня x2
        result4 = new JTextField("", 12);
        result4.setBounds(200, 110, 100, 30);
        result4.setEditable(false);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(230, 110, 50, 30);
        frame.setLayout(new FlowLayout());
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                // Закриття програми кнопки Quit
            }
        });

        erase = new JButton("Erase");
        erase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());

                String s = e.getActionCommand();
                if (s == "Erase") {
                    a = operation = b;
                    result.setText(a + operation + b);
                    result1.setText(a + operation + b);
                    result2.setText(a + operation + b);
                    result3.setText(a + operation + b);
                    result4.setText(a + operation + b);
                    // При нажимання кнопки Erase відбувається очищення всіх полів вводу та результатів
                }
            }
        });

        calculation = new JButton("Calculation");
        calculation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Обчислення коренів квадратного рівняння
                double a = Double.parseDouble(result.getText());
                double b = Double.parseDouble(result1.getText());
                double c = Double.parseDouble(result2.getText());

                double discrim = (b*b) - (4*a*c);// Дискримінант
                double x;
                double y;
                if(discrim > 0){ // Дії далі якщо дискримінант більше 0
                    x = ((-b + Math.sqrt(discrim)) / (2 * a));
                    y = ((-b - Math.sqrt(discrim)) / (2 * a));
                    result3.setText("" + x);
                    result4.setText("" + y);
                }else if(discrim == 0){// Дії далі якщо дискримінант дорівнює 0
                    x = (-b/(2*a));
                    result3.setText("Має один корінь");
                    result4.setText("" + x);
                }else if(discrim < 0){// Дії далі якщо дискримінант менше 0
                    result3.setText("Помилка");
                    result4.setText("Розв.немає");
                }
            }
        });

        // Розташування компонентів на панелях під номером 1
        JPanel mainPanel = new JPanel();
        mainPanel.add(result);
        mainPanel.add(label1);
        mainPanel.add(result1);
        mainPanel.add(label2);
        mainPanel.add(result2);
        mainPanel.add(label3);
        // Розташування компонентів на панелях під номером 2
        JPanel mainPanelRoot = new JPanel();
        mainPanelRoot.add(label4);
        mainPanelRoot.add(result3);
        mainPanelRoot.add(label5);
        mainPanelRoot.add(result4);
        // Розташування компонентів на панелях під номером 3
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculation);
        buttonPanel.add(erase);
        buttonPanel.add(new JLabel("              "));
        buttonPanel.add(quitButton);

        // Всі 3 панелі додаємо до фрейму
        frame.add(mainPanel);
        frame.add(mainPanelRoot);
        frame.add(buttonPanel);
        frame.setSize(360, 150);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // В цьому методі можна обробляти події для інших кнопок, якщо це потрібно
    }
}