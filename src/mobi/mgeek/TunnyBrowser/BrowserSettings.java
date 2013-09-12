/*******************************************************************************
 *
 *    Copyright (c) Baina Info Tech Co. Ltd
 *
 *    testtheme
 *
 *    BrowserSettings
 *    TODO File description or class description.
 *
 *    @author: danliu
 *    @since:  Sep 11, 2013
 *    @version: 1.0
 *
 ******************************************************************************/
package mobi.mgeek.TunnyBrowser;

import com.dolphin.browser.annotation.AddonSDK;

/**
 * BrowserSettings of testtheme.
 * @author danliu
 *
 */
public class BrowserSettings extends com.dolphin.browser.core.BrowserSettings {

    private static BrowserSettings sInstance;

    @AddonSDK
    public static synchronized BrowserSettings getInstance() {
        if (sInstance == null) {
            sInstance = new BrowserSettings();
        }

        return sInstance;
    }

    @Override
    public int getUserAgent() {
        return 0;
    }

    @Override
    public String getAddonBlackListServerUrl() {
        return null;
    }

    @Override
    public String getPromotedAddonHost() {
        return null;
    }

    @Override
    public boolean isSupportCustomAddressBar() {
        return false;
    }

    @Override
    public int getLastPruneImageCount() {
        return 0;
    }

    @Override
    public void setLastPruneImageCount(int count) {
    }

    @Override
    public long getInstallTime() {
        return 0;
    }

    @Override
    public boolean shouldUpdateAddonBlackList() {
        return false;
    }

    @Override
    public boolean isTitleBarFixed() {
        return false;
    }

    @Override
    public boolean acceptCookie() {
        return false;
    }

    @Override
    public void setAcceptCookie(boolean accept) {
    }

    @Override
    public boolean isBrowserCN() {
        return false;
    }

}
