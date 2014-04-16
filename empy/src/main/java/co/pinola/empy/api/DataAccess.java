package co.pinola.empy.api;

import org.joda.time.LocalDate;

import retrofit.RestAdapter;

/**
 * Wrapper around Retrofit service for getting an entity back for a Date.
 *
 * Created by @chrnola on 4/15/14.
 */
public class DataAccess {

    private static final String ENDPOINT_URL = "http://whatcoloristheempirestatebuilding.com";

    private static ColorInfoWebService service = new RestAdapter.Builder()
            .setEndpoint(ENDPOINT_URL)
            .build().create(ColorInfoWebService.class);

    public static ColorInfo GetColorInfoForDate(LocalDate date)
    {
        int year = date.getYear();
        int month = date.getMonthOfYear();
        int day = date.getDayOfMonth();

        return service.GetColorInfoForDate(year, month, day);
    }


}
