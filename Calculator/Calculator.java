import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;

    public Calculator() {
        setTitle("Simple Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        num1Field = new JTextField();
        num2Field = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        addButton = new JButton("Add");
        subtractButton = new JButton("Subtract");
        multiplyButton = new JButton("Multiply");
        divideButton = new JButton("Divide");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        add(new JLabel("First Number:"));
        add(num1Field);
        add(new JLabel("Second Number:"));
        add(num2Field);
        add(new JLabel("Result:"));
        add(resultField);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;
            if (e.getSource() == addButton) result = num1 + num2;
            else if (e.getSource() == subtractButton) result = num1 - num2;
            else if (e.getSource() == multiplyButton) result = num1 * num2;
            else if (e.getSource() == divideButton) result = num1 / num2;
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
