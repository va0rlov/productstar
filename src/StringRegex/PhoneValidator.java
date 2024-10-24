// src/StringRegex/PhoneValidator.java

package StringRegex;

public class PhoneValidator {
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String pattern = "^\\+\\d{1,3}\\d{10}$";
        return phoneNumber.matches(pattern);
    }
}
