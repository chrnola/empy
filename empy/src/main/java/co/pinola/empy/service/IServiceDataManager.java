package co.pinola.empy.service;

import android.content.SharedPreferences;

/**
 * Created by @chrnola on 4/15/14.
 */
public interface IServiceDataManager {

    DashClockInfo GetUpdatedInfo(int reasonCode, SharedPreferences prefs);

}
