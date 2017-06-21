package com.wildnet.wrcUtility;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class WRCNetworkUtility {
    public static boolean isInternetConnected(Context mContext) {

        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public static boolean isLocationEnabled(Context context) {


        LocationManager lm = null;
        boolean gps_enabled = false, network_enabled = false;
        if (lm == null) {
            lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        }
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {

        }
        try {
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception ex) {
        }
        if (gps_enabled == true && network_enabled == true) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Checks if the current device has a GPS module (hardware)
     *
     * @return true if the current device has GPS
     */
    public static boolean hasGpsModule(final Context context) {
        final LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        for (final String provider : locationManager.getAllProviders()) {
            if (provider.equals(LocationManager.GPS_PROVIDER)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the current device has a  NETWORK module (hardware)
     *
     * @return true if the current device has NETWORK
     */
    public static boolean hasNetworkModule(final Context context) {
        final LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        for (final String provider : locationManager.getAllProviders()) {
            if (provider.equals(LocationManager.NETWORK_PROVIDER)) {
                return true;
            }
        }
        return false;
    }

}
