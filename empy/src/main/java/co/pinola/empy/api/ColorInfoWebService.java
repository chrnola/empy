package co.pinola.empy.api;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Retrofit interface for querying the WCITESB API.
 *
 * Created by @chrnola on 4/14/14.
 */
public interface ColorInfoWebService {

    @GET("/{year}/{month}/{day}")
    ColorInfo GetColorInfoForDate(@Path("year") int year,
                                  @Path("month") int month,
                                  @Path("day") int day);

}
