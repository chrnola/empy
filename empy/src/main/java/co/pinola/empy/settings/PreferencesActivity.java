package co.pinola.empy.settings;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import co.pinola.empy.R;


/**
 * Activity for changing user-configurable settings.
 *
 * Created by @chrnola on 5/2/14.
 */
public class PreferencesActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

}
