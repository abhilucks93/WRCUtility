package com.wildnet.wrcUtility;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class WRCStrings {

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    public static String wordUtils(String str) {
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        if (words[0].length() > 0) {
            sb.append(Character.toUpperCase(words[0].charAt(0)) + words[0].subSequence(1, words[0].length()).toString().toLowerCase());
            for (int i = 1; i < words.length; i++) {
                sb.append(" ");
                sb.append(Character.toUpperCase(words[i].charAt(0)) + words[i].subSequence(1, words[i].length()).toString().toLowerCase());
            }
        }
        return sb.toString();
    }


    public static String capitalizeString(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i] == '\'') { // You can add other chars here
                found = false;
            }
        }
        return String.valueOf(chars);
    }

    public static String firstCapitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public static ArrayList<Integer> stringToList(String occupantIds, String divider)
    {
        ArrayList<Integer> occupantIdsList = new ArrayList<Integer>();
        String[] occupantIdsArray = occupantIds.split(divider);
        for(String occupantId : occupantIdsArray)
        {
            occupantId = occupantId.replaceAll("\\[", "").replaceAll("\\]", "").trim();
            occupantIdsList.add(Integer.valueOf(occupantId));
        }
        return occupantIdsList;
    }

    public static String intListToString(List<Integer> occupantIdsList, String divider)
    {
        return TextUtils.join(divider, occupantIdsList);
    }

    public static String stringListToString(List<String> occupantIdsList, String divider)
    {
        return TextUtils.join(divider, occupantIdsList);
    }

}
