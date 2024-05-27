package org.example;

import javax.swing.*;
import java.awt.*;

// view class Calculator
public class CalculatorView extends JFrame {
    private JTextField aField = new JTextField(5);
    private JTextField bField = new JTextField(5);
    private JTextField cField = new JTextField(5);
    private JTextField resultField = new JTextField(20);
    private JButton calculateButton = new JButton("Calculate");
    private JButton clearButton = new JButton("Clear");
    private JButton exitButton = new JButton("Exit");

    // constructor with setting title, size, location and adding components
    public CalculatorView() {
        // set title, size, location and default close operation
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // add components to input panel
        inputPanel.add(new JLabel("Coefficient a:"));
        inputPanel.add(aField);
        inputPanel.add(new JLabel("Coefficient b:"));
        inputPanel.add(bField);
        inputPanel.add(new JLabel("Coefficient c:"));
        inputPanel.add(cField);
        inputPanel.add(new JLabel("Roots:"));
        inputPanel.add(resultField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // getters for all fields and buttons
    public JTextField getAField() {
        return aField;
    }

    public JTextField getBField() {
        return bField;
    }

    public JTextField getCField() {
        return cField;
    }

    public JTextField getResultField() {
        return resultField;
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        view.setVisible(true);
    }
}
