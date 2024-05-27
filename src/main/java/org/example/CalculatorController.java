package org.example;

import javax.swing.*;

// controller class Calculator
public class CalculatorController {
    // model and view fields
    private CalculatorModel modelObject;
    private CalculatorView viewObject;

    // constructor with setting model and view and adding action listeners
    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.modelObject = model;
        this.viewObject = view;

        // add action listeners to buttons, using lambda expressions
        this.viewObject.getCalculateButton().addActionListener(_ -> showRoots());
        this.viewObject.getClearButton().addActionListener(_ -> clearFields());
        this.viewObject.getExitButton().addActionListener(_ -> System.exit(0));
    }

    // method to show them in result field using calculateRoots method in model class
    private void showRoots() {
        // make try block to catch exceptions
        try {
            // get coefficients from text fields
            double a = Double.parseDouble(viewObject.getAField().getText());
            double b = Double.parseDouble(viewObject.getBField().getText());
            double c = Double.parseDouble(viewObject.getCField().getText());
            modelObject = new CalculatorModel(a, b, c);

            // calculate roots and get them in array, because there can be 1 or 2 roots
            double[] roots = modelObject.calculateRoots();

            // show roots in result field & check if there is 1 or 2 roots
            if (roots.length == 1) {
                viewObject.getResultField().setText("x = " + roots[0]);
            } else {
                viewObject.getResultField().setText("x1 = " + roots[0] + ", x2 = " + roots[1]);
            }
            // catch exceptions
        } catch (NumberFormatException ex) { // if input is not a number
            JOptionPane.showMessageDialog(viewObject, "You input invalid data. Please, enter correct numbers.");
        } catch (IllegalArgumentException ex) { // if discriminant is negative or others
            JOptionPane.showMessageDialog(viewObject, ex.getMessage());
        }
    }

    // method to clear all fields
    private void clearFields() {
        viewObject.getAField().setText("");
        viewObject.getBField().setText("");
        viewObject.getCField().setText("");
        viewObject.getResultField().setText("");
    }

    // main method to run the application
    public static void main(String[] args) {
        CalculatorView view = new CalculatorView();
        new CalculatorController(null, view);
        view.setVisible(true);
    }
}

