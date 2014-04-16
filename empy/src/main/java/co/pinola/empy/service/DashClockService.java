package co.pinola.empy.service;

import com.google.android.apps.dashclock.api.DashClockExtension;
import com.google.android.apps.dashclock.api.ExtensionData;

/**
 * Simple integration point with DashClock API.
 * Intentionally keeping all logic external to this class.
 *
 * Created by @chrnola on 4/14/14.
 */
public class DashClockService extends DashClockExtension {

    private IServiceDataManager service = new ServiceDataManager();

    @Override
    protected void onUpdateData(int reason) {

        DashClockInfo info = service.GetUpdatedInfo(reason);

        publishUpdate(new ExtensionData()
                .visible(info.GetIsVisible())
                .icon(info.GetImageCode())
                .expandedTitle(info.GetTitle())
                .expandedBody(info.GetDescription())
                .clickIntent(info.GetClickIntent())
        );
    }

}
