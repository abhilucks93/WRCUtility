package com.wildnet.wrcUtility;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

public class WRCPreferences {


    public static void addPreferences(Context context, String key, String value) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getPreferences(Context context, String key, String defaul) {
        SharedPreferences prefs = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE);
        String value = prefs.getString(key, defaul);
        return value;
    }


    public static void addPreferences(Context context, String key, Boolean value) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static Boolean getPreferences(Context context, String key, Boolean defaul) {
        SharedPreferences prefs = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE);
        Boolean value = prefs.getBoolean(key, defaul);
        return value;
    }


    public static void addPreferences(Context context, String key, float value) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE).edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public static float getPreferences(Context context, String key, float defaul) {
        SharedPreferences prefs = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE);
        float value = prefs.getFloat(key, defaul);
        return value;
    }


    public static void addPreferences(Context context, String key, int value) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getPreferences(Context context, String key, int defaul) {
        SharedPreferences prefs = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE);
        int value = prefs.getInt(key, defaul);
        return value;
    }


    public static void addPreferences(Context context, String key, long value) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE).edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static long getPreferences(Context context, String key, long defaul) {
        SharedPreferences prefs = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE);
        long value = prefs.getLong(key, defaul);
        return value;
    }


    public static void addPreferences(Context context, String key, Set<String> value) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE).edit();
        editor.putStringSet(key, value);
        editor.commit();
    }

    public static Set<String> getPreferences(Context context, String key, Set<String> defaul) {
        SharedPreferences prefs = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE);
        Set<String> value = prefs.getStringSet(key, defaul);
        return value;
    }


    public static void clearSharedPreferenceData(Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences("Preferences_", Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
    }


}
