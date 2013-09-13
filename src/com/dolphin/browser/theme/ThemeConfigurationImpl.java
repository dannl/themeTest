/*******************************************************************************
 *
 *    Copyright (c) Baina Info Tech Co. Ltd
 *
 *    testtheme
 *
 *    ThemeConfigurationImpl
 *    TODO File description or class description.
 *
 *    @author: danliu
 *    @since:  Sep 11, 2013
 *    @version: 1.0
 *
 ******************************************************************************/
package com.dolphin.browser.theme;

import com.dolphin.browser.theme.resources.IColorProcessor;
import com.dolphin.browser.theme.util.IIconProcessor;
import android.graphics.Bitmap;

/**
 * ThemeConfigurationImpl of testtheme.
 * @author danliu
 *
 */
public class ThemeConfigurationImpl extends ThemeConfiguration {

    @Override
    public int getNightModeThemeColor() {
        return 0xff123456;
    }

    @Override
    public IIconProcessor getIconProcessor() {
        return new IIconProcessor() {

            @Override
            public Bitmap processIcon(Bitmap src, int iconWidth, int iconHeight) {
                return src;
            }
        };
    }

    @Override
    public int getThemeCompatibility() {
        return 0;
    }

    @Override
    public int getWallpaperIconWidth() {
        return 20;
    }

    @Override
    public int getWallpaperIconHeight() {
        return 20;
    }

    @Override
    public int getThemeColorIconWidth() {
        return 20;
    }

    @Override
    public int getThemeColorIconHeight() {
        return 20;
    }

    @Override
    public int getThemeIconWidth() {
        return 20;
    }

    @Override
    public int getThemeIconHeight() {
        return 20;
    }

    @Override
    public int getDefaultThemeIconId() {
        return R.drawable.ic_search_category_bookmark;
    }

    @Override
    public int getNightModeIconId() {
        return com.example.testtheme.R.drawable.ic_launcher;
    }

    @Override
    public int getWallpaperImageId() {
        return R.drawable.ic_search_category_bookmark;
    }

    @Override
    public int getDefaultThemeColor() {
        return 0xff379c00;
    }

    @Override
    public String getFontIconPath() {
        return "normal";
    }

    @Override
    public String getNightModeFontPath() {
        return "normal";
    }

    @Override
    public IColorProcessor getColorProcessor() {
        return new ColorProcessor();
    }

    @Override
    public int[] getDefaultThemeColorIdSet() {
        return ColorProcessor.sThemeColorIds;
    }

    @Override
    public int getCustomIconId() {
        return 0;
    }

    @Override
    public int getDefaultCustomColor() {
        return 0x123456;
    }

}
