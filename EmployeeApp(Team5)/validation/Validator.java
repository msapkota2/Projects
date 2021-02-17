package validation;

import java.awt.*;
import java.util.regex.Pattern;
import javax.swing.*;

public class Validator {

    public static Component getParentFrame(Component c) {
        while (!(c instanceof Frame)) {
            c = c.getParent();
            if (c == null) {
                break;
            }
        }
        return c;
    }

    public static void errorMessage(String message, JTextField txtField) {
        JOptionPane.showMessageDialog(getParentFrame(txtField), message, "Invalid input", JOptionPane.ERROR_MESSAGE);
        txtField.setText("");
        txtField.requestFocusInWindow();
    }

    public static boolean isTextFieldNotEmpty(JTextField txtField) {
        if (txtField.getText().isEmpty()) {
            errorMessage("Please enter value for " + txtField.getName() + "!", txtField);
            txtField.requestFocusInWindow();
            return false;
        }
        return true;
    }

    // Validate names for Swing Form elements
    public static boolean isValidName(JTextField txtField) {
        // Validate that entries only contain alphabetic characters
        boolean validName = false;
        if (Pattern.matches("^\\p{Alpha}+", txtField.getText())) {
            validName = true;
        } else {
            JOptionPane.showMessageDialog(getParentFrame(txtField), "Please enter a valid "
                    + txtField.getName()
                    + ". It may only contain letters.");
            txtField.setText("");
            txtField.requestFocusInWindow();
        }
        return validName;
    }

    // Validate names for Swing Form elements
    public static boolean isValidAddress(JTextField txtField) {
        // Validate that entries only contain alphabetic characters
        boolean validName = false;
        if (Pattern.matches("^[\\p{Alnum}\\ \\.\\#\\-]+", txtField.getText())) {
            validName = true;
        } else {
            JOptionPane.showMessageDialog(getParentFrame(txtField), "Please enter a valid "
                    + txtField.getName()
                    + ". It may only contain numbers, letters, and some specific special characters.");
            txtField.setText("");
            txtField.requestFocusInWindow();
        }
        return validName;
    }

    public static boolean isValidDate(JTextField txtField) {
        boolean validDate = false;
        if (Pattern.matches("^[\\d]{4}([\\/-]){1}[\\d]{2}\\1[\\d]{2}", txtField.getText())) {
            validDate = true;
        } else {
            JOptionPane.showMessageDialog(getParentFrame(txtField), "Please enter a valid "
                    + txtField.getName()
                    + ". It must be formatted as yyyy/mm/dd or yyyy-mm-dd.");
            txtField.setText("");
            txtField.requestFocusInWindow();
        }
        return validDate;
    }

    public static boolean isTextFieldInt(JTextField txtField) {
        if (isTextFieldNotEmpty(txtField)) {
            if (!tryParseInt(txtField.getText())) {
                errorMessage("Data entered for " + txtField.getName() + " is not a valid value!\nPlease try again!", txtField);
                txtField.setText("");
                txtField.requestFocusInWindow();
                return false;
            }
        }
        return true;
    }

    public static boolean isTextFieldLong(JTextField txtField) {
        if (isTextFieldNotEmpty(txtField)) {
            if (!tryParseLong(txtField.getText())) {
                errorMessage("Data entered for " + txtField.getName() + " is not a valid value!\nPlease try again!", txtField);
                txtField.setText("");
                txtField.requestFocusInWindow();
                return false;
            }
        }
        return true;
    }

    public static boolean isTextFieldLongInRange(JTextField txtField, long min, long max) {
        if (isTextFieldLong(txtField)) {
            long number = Long.parseLong(txtField.getText());
            if (number < min || number > max) {
                errorMessage("The entered " + txtField.getName() + " value is not in the range of " + min + " to " + max + "!\nPlease try again.", txtField);
                txtField.setText("");
                txtField.requestFocusInWindow();
            }
        }
        return true;
    }

    public static boolean isTextFieldIntInRange(JTextField txtField, int min, int max) {
        if (isTextFieldInt(txtField)) {
            int number = Integer.parseInt(txtField.getText());
            if (number < min || number > max) {
                errorMessage("The entered " + txtField.getName() + " value is not in the range of " + min + " to " + max + "!\nPlease try again.", txtField);
                txtField.setText("");
                txtField.requestFocusInWindow();
            }
        }
        return true;
    }

    public static boolean isTextFieldDouble(JTextField txtField) {
        if (isTextFieldNotEmpty(txtField)) {
            if (!tryParseDouble(txtField.getText(), txtField)) {
                errorMessage("Data entered for " + txtField.getName() + " is not a valid number!\nPlease try again!", txtField);
                txtField.setText("");
                txtField.requestFocusInWindow();
                return false;
            }
        }
        return true;
    }

    public static boolean isTextFieldDoubleInRange(JTextField txtField, double min, double max) {
        if (isTextFieldDouble(txtField)) {
            double number = Double.parseDouble(txtField.getText());
            if (number < min || number > max) {
                errorMessage("The entered " + txtField.getName() + " value is not in the range of " + min + " to " + max + "!\nPlease try again.", txtField);
                txtField.setText("");
                txtField.requestFocusInWindow();
            }
        }
        return true;
    }

    public static boolean tryParseInt(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean tryParseLong(String number) {
        try {
            Long.parseLong(number);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean tryParseDouble(String number, JTextField txtField) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException nfe) {
            errorMessage("Entered value is not valid, please enter valid value", txtField);
            return false;
        }
    }
}
