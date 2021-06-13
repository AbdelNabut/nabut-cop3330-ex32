package ex32;

public class InputValidator {
    public static boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
}
