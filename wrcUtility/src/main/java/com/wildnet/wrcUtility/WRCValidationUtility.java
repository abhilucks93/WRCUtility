package com.wildnet.wrcUtility;

import android.util.Patterns;

public class WRCValidationUtility {
    public static boolean isValidPhoneNumber(String phone) {
        return Patterns.PHONE.matcher(phone).matches();
    }

    public static boolean isValidEmaillId(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPassword(String password, int length) {
        return password.length() > length;
    }

}
