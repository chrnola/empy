package co.pinola.empy.service;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;

import com.google.common.base.Joiner;

import org.joda.time.LocalDate;

import co.pinola.empy.R;
import co.pinola.empy.api.ColorInfoCache;
import co.pinola.empy.api.ColorInfo;
import co.pinola.empy.api.IColorInfoCache;

/**
 *
 *
 * Created by @chrnola on 4/15/14.
 */
public class ServiceDataManager implements IServiceDataManager {

    private IColorInfoCache cache = new ColorInfoCache();

    public DashClockInfo GetUpdatedInfo(int reasonCode, SharedPreferences prefs)
    {
        // TODO: Do something with the reason

        // Determine current date
        LocalDate currentDate = new LocalDate();

        // Get ColorInfo from the cache
        ColorInfo colorInfo = cache.GetColorInfo(currentDate);

        // Construct a DashClockInfo to send back to the DashClock API
        return PrepareUpdateInfo(colorInfo, prefs);
    }

    private DashClockInfo PrepareUpdateInfo(ColorInfo colorInfo, SharedPreferences prefs)
    {
        if (colorInfo == null)
        {
            throw new IllegalArgumentException("Given ColorInfo must not be null.");
        }

        if (prefs == null)
        {
            throw new IllegalArgumentException("Given SharedPreferences must not be null.");
        }

        return new DashClockInfo(IsVisible(colorInfo, UserRequestedHideOnNormalDays(prefs)),
                GetImageCode(),
                FormatColors(colorInfo),
                GetDescription(colorInfo),
                GetClickIntent());
    }

    private boolean UserRequestedHideOnNormalDays(SharedPreferences prefs)
    {
        String settingKey = Resources.getSystem().getString(R.string.SETTING_HIDE_NO_EVENT);

        return prefs.getBoolean(settingKey, true);
    }

    private boolean IsVisible(ColorInfo colorInfo, boolean userRequestedHideOnNormal)
    {
        // TODO: Return false during the day?

        if(colorInfo.IsNormalDay() && userRequestedHideOnNormal)
        {
            return false;
        }

        return true;
    }

    private int GetImageCode()
    {
        // TODO: Get a real image
        return R.drawable.dash;
    }

    public static String GetDescription(ColorInfo colorInfo)
    {
        if(colorInfo.event != null)
        {
            return colorInfo.event;
        }

        return "Just a regular evening.";
    }

    public static Intent GetClickIntent()
    {
        return new Intent(Intent.ACTION_VIEW, Uri.parse("http://whatcoloristheempirestatebuilding.com/"));
    }

    private static String FormatColors(ColorInfo colorInfo)
    {
        if(colorInfo.colors == null)
        {
            // TODO: Log
            return "Error retrieving colors!";
        }

        return Joiner.on(", ").skipNulls().join(colorInfo.colors);
    }
}
