package org.example;

import javax.swing.*;
import java.awt.*;

// Main class that includes all functionalities
public class CalculatorAllInOneClass extends JFrame {
    // Fields for entering coefficients
    private JTextField aField = new JTextField(5);
    private JTextField bField = new JTextField(5);
    private JTextField cField = new JTextField(5);
    private JTextField resultField = new JTextField(20);
    private JButton calculateButton = new JButton("Calculate");
    private JButton clearButton = new JButton("Clear");
    private JButton exitButton = new JButton("Exit");

    // Constructor with setting title, size, location and adding components
    public CalculatorAllInOneClass() {
        setTitle("Quadratic Equation Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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

        // Adding action listeners to buttons
        calculateButton.addActionListener(_ -> showRoots());
        clearButton.addActionListener(_ -> clearFields());
        exitButton.addActionListener(_ -> System.exit(0));
    }

    // Method to show roots in result field using calculateRoots method in model class
    private void showRoots() {
        try {
            // Get coefficients from text fields
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());
            double c = Double.parseDouble(cField.getText());
            CalculatorModel model = new CalculatorModel(a, b, c);

            // Calculate roots and get them in array, because there can be 1 or 2 roots
            double[] roots = model.calculateRoots();

            // Show roots in result field & check if there is 1 or 2 roots
            if (roots.length == 1) {
                resultField.setText("x = " + roots[0]);
            } else {
                resultField.setText("x1 = " + roots[0] + ", x2 = " + roots[1]);
            }
        } catch (NumberFormatException ex) { // if input is not a number
            JOptionPane.showMessageDialog(this, "You input invalid data. Please, enter correct numbers.");
        } catch (IllegalArgumentException ex) { // if discriminant is negative or others
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    // Method to clear all fields
    private void clearFields() {
        aField.setText("");
        bField.setText("");
        cField.setText("");
        resultField.setText("");
    }

    // Main method to run the application
    public static void main(String[] args) {
        CalculatorAllInOneClass view = new CalculatorAllInOneClass();
        view.setVisible(true);
    }

    // Model class to calculate roots by discriminant
    private static class CalculatorModel {
        private double a, b, c;

        // Constructor with full parameters
        public CalculatorModel(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        // Method to calculate roots by discriminant
        public double[] calculateRoots() throws IllegalArgumentException {
            double discr = b * b - 4 * a * c;
            if (discr < 0) { // if discriminant is negative, no real roots
                throw new IllegalArgumentException("Discriminant is negative. No real roots.");
            } else if (discr == 0) { // if discriminant is zero, one root
                return new double[]{-b / (2 * a)};
            } else { // default case, two roots
                return new double[]{
                        (-b + Math.sqrt(discr)) / (2 * a),
                        (-b - Math.sqrt(discr)) / (2 * a)
                };
            }
        }
    }
}
