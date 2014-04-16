package co.pinola.empy.api;

import org.joda.time.LocalDate;

import java.util.HashMap;

/**
 * Created by @chrnola on 4/15/14.
 */
public class ColorInfoCache implements IColorInfoCache {

    HashMap<LocalDate, ColorInfo> cache = new HashMap<LocalDate, ColorInfo>();

    public ColorInfo GetColorInfo(LocalDate date) {

        if(date == null)
            throw new IllegalArgumentException("Date cannot be null");

        // TODO: Enhance caching logic (retry if no event, prefetch info)
        if(cache.containsKey(date))
        {
            return cache.get(date);
        }

        ColorInfo colorInfoForGivenDate = DataAccess.GetColorInfoForDate(date);
        cache.put(date, colorInfoForGivenDate);

        return colorInfoForGivenDate;
    }
}
