/*******************************************************************************
 *
 *    Copyright (c) Baina Info Tech Co. Ltd
 *
 *    testtheme
 *
 *    Configuration
 *    TODO File description or class description.
 *
 *    @author: danliu
 *    @since:  Sep 11, 2013
 *    @version: 1.0
 *
 ******************************************************************************/
package mobi.mgeek.TunnyBrowser;

import com.dolphin.browser.core.IBrowserSettings;
import com.dolphin.browser.util.GoogleTrackerBase;
import com.example.testtheme.R;
import java.util.Locale;

/**
 * Configuration of testtheme.
 * @author danliu
 *
 */
public class Configuration extends com.dolphin.browser.core.Configuration {

    @Override
    public int getAddonSDKVersion() {
        return 0;
    }

    @Override
    public String getApplicationName() {
        return "fk";
    }

    @Override
    public String getPromotedAddonApplicationName() {
        return null;
    }

    @Override
    public String getPromotedAppApplicationName() {
        return null;
    }

    @Override
    public String getPreInstallAddonApplicationName() {
        return null;
    }

    @Override
    public String getPreInstallAppApplicationName() {
        return null;
    }

    @Override
    public int getThemeMinVersionRes() {
        return R.string.wocao;
    }

    @Override
    public int getThemeVersionRes() {
        return R.string.wocao;
    }

    @Override
    public String getImageCacheDirBase() {
        return null;
    }

    @Override
    public String getDolphinServerUrl() {
        return null;
    }

    @Override
    public String getDolphinSyncUrl() {
        return null;
    }

    @Override
    public String getDolphinPushUrl() {
        return null;
    }

    @Override
    public String getDolphinServerApiPath() {
        return null;
    }

    @Override
    public String getSyncServiceApiPath() {
        return null;
    }

    @Override
    public String getVoiceServiceUrl() {
        return null;
    }

    @Override
    public int getTraceInterval() {
        return 0;
    }

    @Override
    public GoogleTrackerBase getGoogleTracker() {
        return null;
    }

    @Override
    public boolean getMessageStoreReceiveUpdates() {
        return false;
    }

    @Override
    public String getGoogleTrackerId() {
        return null;
    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public String getBelugaAppKey() {
        return null;
    }

    @Override
    public int getBelugaServerHostType() {
        return 0;
    }

    @Override
    public int getBelugaSendTrackInterval() {
        return 0;
    }

    @Override
    public Class<?> getActionExecutorClass() {
        return null;
    }

    @Override
    @Deprecated
    public IBrowserSettings getBrowserSettings() {
        return null;
    }

    @Override
    public String getTrustStorePassword() {
        return null;
    }

    @Override
    public int getTrustStoreResource() {
        return 0;
    }

    @Override
    public boolean isNewThemeEnabled() {
        return true;
    }

}
