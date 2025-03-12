import javax.management.StringValueExp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    JButton[] numberButtons = new JButton[10];
    JButton[] operatorButtons = new JButton[6];
    JTextField TextBar;
    JButton negButton;
    JButton decimalButton;
    private double num1;
    private double num2;
    private char operator;
    double result;
    Math mathoperations = new Math();

    CalculatorGUI() {


        // ---------- OutputPanel -------------
        Panel outputPanel = new Panel();
        outputPanel.setBackground(new Color(28, 28, 28));
        outputPanel.setLayout(null);
        outputPanel.setBounds(0, 0, 410, 150);
        outputPanel.setBackground(Color.decode("#333333"));



        TextBar = new JTextField();
        TextBar.setBackground(Color.WHITE);
        TextBar.setBounds(75, 40, 260, 70);
        TextBar.setFont(new Font("Arial", Font.BOLD, 25)); // Größere Schrift
        TextBar.setHorizontalAlignment(JTextField.RIGHT); // Text rechtsbündig für Taschenrechner

        outputPanel.add(TextBar);
        // ---------- OutputPanel -------------

        // ---------- OperatorsPanel -------------
        Panel operatorPanel = new Panel();
        operatorPanel.setBackground(Color.darkGray);
        operatorPanel.setBounds(255,155,150,455);
        operatorPanel.setLayout(new GridLayout(6, 1, 5, 5));

        // Operatoren hinzufügen
        String[] operators = {"+", "-", "*", "/", "=", "Clear"};
        for (int i = 0; i < operators.length; i++) {
            operatorButtons[i] = new JButton(operators[i]);
            operatorButtons[i].setFont(new Font("Arial", Font.BOLD, 24));
            operatorButtons[i].addActionListener(this);
            operatorPanel.add(operatorButtons[i]);
        }

        // ---------- OperatorsPanel -------------

        // ---------- InputPanel -------------
        Panel inputPanel = new Panel();
        inputPanel.setBackground(Color.black);
        inputPanel.setBounds(0,155,250,455);
        inputPanel.setLayout(new GridLayout(4, 3, 5, 5));

        for (int i = 1; i <= 9; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 24));
            numberButtons[i].addActionListener(this);
            inputPanel.add(numberButtons[i]);
        }

        // (-) Button
        negButton = new JButton("(-)");
        negButton.setFont(new Font("Arial", Font.BOLD, 24));
        negButton.addActionListener(this);
        inputPanel.add(negButton);

        // 0 Button
        numberButtons[0] = new JButton("0");
        numberButtons[0].setFont(new Font("Arial", Font.BOLD, 24));
        numberButtons[0].addActionListener(this);
        inputPanel.add(numberButtons[0]);

        // . Button
        decimalButton = new JButton(".");
        decimalButton.setFont(new Font("Arial", Font.BOLD, 24));
        decimalButton.addActionListener(this);
        inputPanel.add(decimalButton);

        // ---------- FRAME -------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);
        this.add(outputPanel);
        this.add(operatorPanel);
        this.add(inputPanel);
        this.setSize(410,650);
        this.setResizable(false);
        this.setVisible(true);
        // ---------- FRAME -------------

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10 ; i++) {
            if (e.getSource() == numberButtons[i]) {
                TextBar.setText(TextBar.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimalButton) {
            TextBar.setText(TextBar.getText().concat("."));
        }

        if (e.getSource() == operatorButtons[0]) { // operatorButton[0] = +
            num1 = Double.parseDouble(TextBar.getText());
            operator = '+';
            TextBar.setText("");
        }

        if (e.getSource() == operatorButtons[1]) { // operatorButton[1] = -
            num1 = Double.parseDouble(TextBar.getText());
            operator = '-';
            TextBar.setText("");
        }

        if (e.getSource() == operatorButtons[2]) { // operatorButton[2] = *
            num1 = Double.parseDouble(TextBar.getText());
            operator = '*';
            TextBar.setText("");
        }

        if (e.getSource() == operatorButtons[3]) { // operatorButton[3] = /
            num1 = Double.parseDouble(TextBar.getText());
            operator = '/';
            TextBar.setText("");
        }

        if (e.getSource() == operatorButtons[4]) { // operatorButton[4] = =
            num2 = Double.parseDouble(TextBar.getText());

            switch (operator) {
                case '+':
                    result = mathoperations.addition(num1,num2);
                    TextBar.setText(String.valueOf(result));
                    break;
                case '-':
                    result = mathoperations.subtraction(num1,num2);
                    TextBar.setText(String.valueOf(result));
                    break;
                case '*':
                    result = mathoperations.multiplication(num1,num2);
                    TextBar.setText(String.valueOf(result));
                    break;
                case '/':
                    if (num2 == 0) {
                        TextBar.setText("ERROR!");
                        break;
                    }
                    result = mathoperations.division(num1,num2);
                    TextBar.setText(String.valueOf(result));
                    break;
            }
            num1 = result;
        }

        if (e.getSource() == operatorButtons[5]) {  // clear Button
            num1 = 0;
            num2 = 0;
            TextBar.setText("");
        }

        if (e.getSource() == negButton) {
            if (TextBar.getText().isEmpty()) {
                throw new NumberFormatException("negated without a Number!");
            }

            double temp = Double.parseDouble(TextBar.getText());
            temp *= -1;
            TextBar.setText(String.valueOf(temp));
        }
    }
}
