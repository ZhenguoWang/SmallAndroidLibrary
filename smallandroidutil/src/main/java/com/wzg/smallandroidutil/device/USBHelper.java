package com.wzg.smallandroidutil.device;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

/**
 * Helper class for USB devices or connections.
 */
public class USBHelper {
    private static USBHelper ourInstance = new USBHelper();

    public static USBHelper getInstance() {
        return ourInstance;
    }

    private USBHelper() {
    }

    public static boolean isPlugged(Context context) {
        Intent intent = context.getApplicationContext().registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        assert intent != null;
        int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        return plugged == BatteryManager.BATTERY_PLUGGED_USB;
    }
}
