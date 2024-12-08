

package org.somethingos.somethingsettings.fragments.statusbar;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import android.os.UserHandle;
import android.provider.Settings;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.internal.logging.nano.MetricsProto;

public class NetworkTrafficSettings extends SettingsPreferenceFragment {

    private static final String TAG = "NetworkTrafficSettings";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.network_traffic_settings);
    }

    public static void reset(Context mContext) {
        ContentResolver resolver = mContext.getContentResolver();
        Settings.System.putIntForUser(resolver,
                Settings.System.NETWORK_TRAFFIC_ENABLED, 0, UserHandle.USER_CURRENT);
        Settings.System.putIntForUser(resolver,
                Settings.System.NETWORK_TRAFFIC_MODE, 0, UserHandle.USER_CURRENT);
        Settings.System.putIntForUser(resolver,
                Settings.System.NETWORK_TRAFFIC_AUTOHIDE, 1, UserHandle.USER_CURRENT);
        Settings.System.putIntForUser(resolver,
                Settings.System.NETWORK_TRAFFIC_AUTOHIDE_THRESHOLD, 0, UserHandle.USER_CURRENT);
        Settings.System.putIntForUser(resolver,
                Settings.System.NETWORK_TRAFFIC_UNITS, 1, UserHandle.USER_CURRENT);
        Settings.System.putIntForUser(resolver,
                Settings.System.NETWORK_TRAFFIC_REFRESH_INTERVAL, 2, UserHandle.USER_CURRENT);
        Settings.System.putIntForUser(resolver,
                Settings.System.NETWORK_TRAFFIC_HIDEARROW, 0, UserHandle.USER_CURRENT);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.CRDROID_SETTINGS;
    }
}