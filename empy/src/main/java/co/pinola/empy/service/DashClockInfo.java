package co.pinola.empy.service;

import android.content.Intent;

/**
 * Contains all the information that the DashClock service would
 * need to publish an update.
 *
 * Created by @chrnola on 4/15/14.
 */
public class DashClockInfo {

    private boolean _isVisible;
    public boolean GetIsVisible()
    {
        return _isVisible;
    }

    private int _imageCode;
    public int GetImageCode()
    {
        return _imageCode;
    }

    private String _title;
    public String GetTitle()
    {
        return _title;
    }

    private String _description;
    public String GetDescription()
    {
        return _description;
    }

    private Intent _clickIntent;
    public Intent GetClickIntent()
    {
        return _clickIntent;
    }

    public DashClockInfo(boolean isVisible, int imageCode, String title,
                         String description, Intent clickIntent) {
        this._isVisible = isVisible;
        this._imageCode = imageCode;
        this._title = title;
        this._description = description;
        this._clickIntent = clickIntent;
    }
}
