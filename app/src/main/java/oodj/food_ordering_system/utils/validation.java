package oodj.food_ordering_system.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

public class validation {

    private static final Pattern CARD_NUMBER_PATTERN = Pattern.compile("^\\d{16}$");
    private static final Pattern EXPIRY_DATE_PATTERN = Pattern.compile("^(0[1-9]|1[0-2])\\/\\d{2}$");
    private static final Pattern CVV_PATTERN = Pattern.compile("^\\d{3}$");

    private static final String PHONE_REGEX = "^(\\+?6?01)[02-46-9]-*[0-9]{7}$|^(\\+?6?01)[1]-*[0-9]{8}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
    "^(?=.{1,254}$)[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");


//+6010-2345678 (7 digits after 010, with optional + and optional dash)
//6012-3456789 (7 digits after 012, without +, with optional dash)
//013-4567890 (7 digits after 013, no country code or +, with optional dash)
//+6011-23456789 (8 digits after 011, with +, with optional dash)
//01134567890 (8 digits after 011, no dashes)
    public static boolean isValidPhone(String contactnumber) {
        if (contactnumber == null) {
            return false;
        }
        Matcher matcher = PHONE_PATTERN.matcher(contactnumber);
        return matcher.matches();
    }

    public static boolean nameFormat(String fullname) {
        return fullname.matches("^[a-zA-Z]+(?: [a-zA-Z]+)*$");
    }

    public static boolean checkUsername(String username) {
        ArrayList<String> usernames = UserHandling.getUsernames();

        if (usernames.contains(username)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkEmail(String email) {
        ArrayList<String> emails = UserHandling.getEmails();

        if (emails.contains(email)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 6) {
            return false;
        }

        boolean hasLetter = false;
        boolean hasNumber = false;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            }

            if (hasLetter && hasNumber) {
                return true;
            }
        }

        return false;
    }

    // car validation
    public static boolean brandFormat(String brand) {
        return brand.matches("^[a-zA-Z]+(?:[-\\s][a-zA-Z]+)*$");
    }

    public static boolean modelFormat(String model) {
        return model.matches("^[a-zA-Z0-9\\s-]+$");
    }

    public static boolean colorFormat(String color) {
        return color.matches("^[a-zA-Z\\s]+$");
    }

    public static boolean plateFormat(String plate) {
        return plate.matches("^[A-Z]{1,3}[1-9][0-9]{0,3}(?:[A-Z])?$");
    }

    public static boolean priceFormat(String price) {
        return price.matches("^\\d+(\\.\\d{1,2})?$");
    }

    public static DefaultTableModel nonEditTable(Object[] columnNames, int rowCount) {
        return new DefaultTableModel(columnNames, rowCount) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Makes cells non-editable
            }
        };
    }

    public static boolean validateCardNumber(String cardNumber) {
        Matcher matcher = CARD_NUMBER_PATTERN.matcher(cardNumber);
        return matcher.matches();
    }

    public static boolean validateExpiryDate(String expiryDate) {
        Matcher matcher = EXPIRY_DATE_PATTERN.matcher(expiryDate);
        return matcher.matches();
    }

    public static boolean validateCVV(String cvv) {
        Matcher matcher = CVV_PATTERN.matcher(cvv);
        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

}
