package com.wildnet.wrcUtility;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by sanjiv on 12/8/16.
 */
public class WRCCalculationUtility {

    // #CalculationUtility

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getScreenWidth(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        return width;
    }

    public static int getScreenHeight(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        return height;
    }

    public static int getPixelValue(Context activity, int dp) {

        final float scale = activity.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static PointF PointOnCircle(float radius, float angleInDegrees, PointF origin) {
        // Convert from degrees to radians via multiplication by PI/180
        float x = (float) (radius * Math.cos(angleInDegrees * Math.PI / 180F)) + origin.x;
        float y = (float) (radius * Math.sin(angleInDegrees * Math.PI / 180F)) + origin.y;
        return new PointF(x, y);
    }

    public static String formatTime(int timeInSec) {
        StringBuilder builder = new StringBuilder();
        int hours = timeInSec / 3600;
        int minutes = (timeInSec - hours * 3600) / 60;
        int seconds = timeInSec - hours * 3600 - minutes * 60;
        builder.insert(0, seconds + "s");
        if (minutes > 0 || hours > 0) {
            builder.insert(0, minutes + "m ");
        }
        if (hours > 0) {
            builder.insert(0, hours + "h ");
        }
        return builder.toString();
    }

    public static String formatDistance(int distInMeters) {
        if (distInMeters < 1000) {
            return distInMeters + "m";
        } else {
            return ((float) distInMeters / 1000) + "km";
        }
    }

    public static int getDensityInDpi(Context mContext) {
        final DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int screenDensity = metrics.densityDpi;
        return screenDensity;
    }

    public static int convertPxToDpi(Context mContext, int value) {
        int mValue = value;
        mValue = mValue / (getDensityInDpi(mContext) / 160);

        return mValue;

    }

    public static int dpToPx(Context con, int dp) {
        DisplayMetrics displayMetrics = con.getResources().getDisplayMetrics();
        int px = Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return px;
    }

    public int pxToDp(Context con, int px) {
        DisplayMetrics displayMetrics = con.getResources().getDisplayMetrics();
        int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }

}