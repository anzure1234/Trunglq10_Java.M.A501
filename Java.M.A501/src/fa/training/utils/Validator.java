package fa.training.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b");

    }

    public static boolean isOrderNumber(String orderNumber) {
        return orderNumber.matches("\\d{5}");
    }

}
