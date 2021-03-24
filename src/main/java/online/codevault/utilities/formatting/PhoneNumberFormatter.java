package online.codevault.utilities.formatting;

import org.apache.commons.lang3.StringUtils;

public class PhoneNumberFormatter {

    public static String format(String phoneNumber) {
        return format(phoneNumber, null);
    }

    public static String format(String phoneNumber, String extension) {

        StringBuilder sb = new StringBuilder();

        if (!StringUtils.isBlank(phoneNumber)) {
            if (10 == phoneNumber.length()) {
                sb.append("(").append(phoneNumber, 0, 3).append(")").append(" ").append(phoneNumber, 3, 6).append("-").append(phoneNumber, 6, 10);
            } else {
                sb.append(phoneNumber);
            }
        }

        if (!StringUtils.isBlank(extension)) {

            if (sb.length() > 0) {
                sb.append(" ");
            }

            sb.append("x").append(extension);

        }

        return sb.toString();

    }

}
