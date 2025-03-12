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
        TextBar.setBackground(new Color(240, 240, 240));
        TextBar.setBounds(75, 40, 260, 70);
        TextBar.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        TextBar.setHorizontalAlignment(JTextField.RIGHT);
        TextBar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding inside text field

        outputPanel.add(TextBar);
        // ---------- OutputPanel -------------

        // ---------- OperatorsPanel -------------
        Panel operatorPanel = new Panel();
        operatorPanel.setBounds(255,155,150,455);
        operatorPanel.setLayout(new GridLayout(6, 1, 5, 5));
        operatorPanel.setBackground(new Color(56, 56, 56)); // Dark background

        // Operatoren hinzufügen
        String[] operators = {"+", "-", "*", "/", "=", "Clear"};
        for (int i = 0; i < operators.length; i++) {
            operatorButtons[i] = new JButton(operators[i]);
            operatorButtons[i].setFont(new Font("Segoe UI", Font.PLAIN, 24));
            operatorButtons[i].setFocusPainted(false);
            operatorButtons[i].setBackground(new Color(74, 74, 74)); // Dark background for operators
            operatorButtons[i].setForeground(Color.WHITE);
            operatorButtons[i].setBorder(BorderFactory.createLineBorder(new Color(40, 40, 40), 2));
            operatorButtons[i].setPreferredSize(new Dimension(70, 70)); // Larger buttons
            operatorButtons[i].addActionListener(this);
            operatorPanel.add(operatorButtons[i]);
        }

        // ---------- OperatorsPanel -------------

        // ---------- InputPanel -------------
        Panel inputPanel = new Panel();
        inputPanel.setBounds(0, 155, 250, 455);
        inputPanel.setLayout(new GridLayout(4, 3, 5, 5));
        inputPanel.setBackground(new Color(28, 28, 28)); // Dark background for input panel

        for (int i = 1; i <= 9; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Segoe UI", Font.PLAIN, 24));
            numberButtons[i].setFocusPainted(false);
            numberButtons[i].setBackground(new Color(58, 58, 58)); // Darker button color
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setBorder(BorderFactory.createLineBorder(new Color(40, 40, 40), 2));
            numberButtons[i].setPreferredSize(new Dimension(70, 70)); // Larger buttons
            numberButtons[i].addActionListener(this);
            inputPanel.add(numberButtons[i]);
        }

        // (-) Button
        negButton = new JButton("(-)");
        negButton.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        negButton.setFocusPainted(false);
        negButton.setBackground(new Color(58, 58, 58));
        negButton.setForeground(Color.WHITE);
        negButton.setBorder(BorderFactory.createLineBorder(new Color(40, 40, 40), 2));
        negButton.setPreferredSize(new Dimension(70, 70));
        negButton.addActionListener(this);
        inputPanel.add(negButton);

        // 0 Button
        numberButtons[0] = new JButton("0");
        numberButtons[0].setFont(new Font("Segoe UI", Font.PLAIN, 24));
        numberButtons[0].setFocusPainted(false);
        numberButtons[0].setBackground(new Color(58, 58, 58));
        numberButtons[0].setForeground(Color.WHITE);
        numberButtons[0].setBorder(BorderFactory.createLineBorder(new Color(40, 40, 40), 2));
        numberButtons[0].setPreferredSize(new Dimension(70, 70));
        numberButtons[0].addActionListener(this);
        inputPanel.add(numberButtons[0]);


        // . Button
        decimalButton = new JButton(".");
        decimalButton.setFont(new Font("Segoe UI", Font.PLAIN, 24));
        decimalButton.setFocusPainted(false);
        decimalButton.setBackground(new Color(58, 58, 58));
        decimalButton.setForeground(Color.WHITE);
        decimalButton.setBorder(BorderFactory.createLineBorder(new Color(40, 40, 40), 2));
        decimalButton.setPreferredSize(new Dimension(70, 70));
        decimalButton.addActionListener(this);
        inputPanel.add(decimalButton);

        // ---------- FRAME -------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(22, 22, 22));
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
