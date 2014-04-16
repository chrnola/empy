package co.pinola.empy.api;

import org.joda.time.LocalDate;

/**
 * Created by @chrnola on 4/15/14.
 */
public interface IColorInfoCache {

    ColorInfo GetColorInfo(LocalDate date);

}
