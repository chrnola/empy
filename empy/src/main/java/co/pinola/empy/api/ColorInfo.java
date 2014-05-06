package co.pinola.empy.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity object for transferring parsed results from API.
 *
 * Created by @chrnola on 4/15/14.
 */
public class ColorInfo {

    public List<String> colors;
    public String event;
    public boolean manual; // not quite sure what this is for

    public boolean IsNormalDay()
    {
        if (this.event != null) return false;

        List<String> uniqueColors = this.GetUniqueColors();

        if(uniqueColors.size() != 1) return false;

        if(uniqueColors.get(0).equalsIgnoreCase("White")) return true;

        return false;
    }

    public List<String> GetUniqueColors()
    {
        ArrayList<String> uniqueColors = new ArrayList<String>();

        if (colors == null) return uniqueColors;

        for (String color : colors)
        {
            if(!ListContainsString(uniqueColors, color))
                uniqueColors.add(color);
        }

        return uniqueColors;
    }

    private boolean ListContainsString(List<String> list, String testString)
    {
        if (list == null) return false;

        for (String string : list)
        {
            if (string.equalsIgnoreCase(testString))
                return true;
        }

        return false;
    }
}
