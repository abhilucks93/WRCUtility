package com.wildnet.wrcUtility;

import android.content.Context;
import android.telephony.TelephonyManager;

public class WRCDeviceUtility {

    public static String getDeviceKey(Context mContext) {
        String theDevId;

            theDevId = ((TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();

        return theDevId;

    }

}
