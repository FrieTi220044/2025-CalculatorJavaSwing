import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    JButton[] numberButtons = new JButton[10];
    JButton[] operatorButtons = new JButton[6];

    CalculatorGUI() {


        // ---------- OutputPanel -------------
        Panel outputPanel = new Panel();
        outputPanel.setBackground(Color.GRAY);
        outputPanel.setLayout(null);
        outputPanel.setBounds(0, 0, 410, 150);


        JTextField TextBar = new JTextField();
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
        String[] operators = {"+", "-", "*", "/", "=", "C"};
        for (int i = 0; i < operators.length; i++) {
            operatorButtons[i] = new JButton(operators[i]);
            operatorButtons[i].setFont(new Font("Arial", Font.BOLD, 24));
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
            inputPanel.add(numberButtons[i]);
        }

        // (-) Button
        JButton negButton = new JButton("(-)");
        negButton.setFont(new Font("Arial", Font.BOLD, 24));
        inputPanel.add(negButton);

        // 0 Button
        numberButtons[0] = new JButton("0");
        numberButtons[0].setFont(new Font("Arial", Font.BOLD, 24));
        inputPanel.add(numberButtons[0]);

        // . Button
        JButton decimalButton = new JButton(".");
        decimalButton.setFont(new Font("Arial", Font.BOLD, 24));
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

    }
}
