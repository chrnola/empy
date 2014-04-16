package co.pinola.empy.service;

import android.content.Intent;
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

    public DashClockInfo GetUpdatedInfo(int reasonCode)
    {
        // TODO: Do something with the reason

        // Determine current date
        LocalDate currentDate = new LocalDate();

        // Get ColorInfo from the cache
        ColorInfo colorInfo = cache.GetColorInfo(currentDate);

        // Construct a DashClockInfo to send back to the DashClock API
        return PrepareUpdateInfo(colorInfo);
    }

    private DashClockInfo PrepareUpdateInfo(ColorInfo colorInfo)
    {
        if (colorInfo == null)
        {
            throw new IllegalArgumentException("Given ColorInfo must not be null");
        }

        return new DashClockInfo(IsVisible(),
                GetImageCode(),
                FormatColors(colorInfo),
                colorInfo.event,
                GetClickIntent());
    }

    private boolean IsVisible()
    {
        // TODO: Return false during the day?
        return true;
    }

    private int GetImageCode()
    {
        // TODO: Get a real image
        return R.drawable.empy;
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
