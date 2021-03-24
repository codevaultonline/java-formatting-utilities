package online.codevault.utilities.formatting;

import online.codevault.utilities.formatting.model.StreetAddress;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AddressFormatter {

    public static String formatAddress(String addressLine1, String addressLine2, String addressLine3, String city, String state, String postalCode, String glue) {
        List<String> parts = addressPartsAsList(new StreetAddress(addressLine1, addressLine2, addressLine3, city, state, postalCode));
        return String.join(glue, parts);
    }

    public static String formatAddress(StreetAddress address, String glue) {
        List<String> parts = addressPartsAsList(address);
        return String.join(glue, parts);
    }

    public static List<String> addressPartsAsList(StreetAddress address) {

        ArrayList<String> parts = new ArrayList<>();

        if (!StringUtils.isBlank(address.getAddressLine1())) {
            parts.add(address.getAddressLine1());
        }

        if (!StringUtils.isBlank(address.getAddressLine2())) {
            parts.add(address.getAddressLine2());
        }

        if (!StringUtils.isBlank(address.getAddressLine3())) {
            parts.add(address.getAddressLine3());
        }

        if (!StringUtils.isBlank(address.getCity()) || !StringUtils.isBlank(address.getState()) || !StringUtils.isBlank(address.getPostalCode())) {
            parts.add(address.getCity() + ", " + address.getState() + "     " + formatZipCode(address.getPostalCode()));
        }

        return parts;

    }

    public static String formatZipCode(String zipCode) {

        if (!StringUtils.isBlank(zipCode)) {

            zipCode = zipCode.replaceAll("[^\\d.]", "");

            if (!StringUtils.isBlank(zipCode)) {

                String zipCodeBase = zipCode.substring(0, 5);

                if (9 == zipCode.length()) {

                    String zipPlus4 = zipCode.substring(5);

                    if (!"0000".equals(zipPlus4)) {
                        return zipCodeBase + "-" + zipPlus4;
                    }

                    return zipCodeBase;

                }

            }

        }

        return zipCode;

    }

}
