/*******************************************************************************
 *
 *    Copyright (c) Baina Info Tech Co. Ltd
 *
 *    testtheme
 *
 *    ColorProcessor
 *    TODO File description or class description.
 *
 *    @author: danliu
 *    @since:  Sep 12, 2013
 *    @version: 1.0
 *
 ******************************************************************************/
package com.dolphin.browser.theme;

import com.dolphin.browser.theme.resources.IColorProcessor;

/**
 * ColorProcessor of testtheme.
 * @author danliu
 *
 */
public class ColorProcessor implements IColorProcessor {

    public static final int[] sThemeColorIds = new int[] {
        com.example.testtheme.R.color.dolphin_theme_color,
        com.example.testtheme.R.color.dolphin_theme_color_90,
        com.example.testtheme.R.color.dolphin_theme_color_80,
        com.example.testtheme.R.color.dolphin_theme_color_70
    };

    @Override
    public int processColor(int id, int themeColor) {
        if (id == sThemeColorIds[0]) {
            return themeColor | 0xff000000;
        } else if (id == sThemeColorIds[1]) {
            return themeColor & 0x00ffffff | 0xdd000000;
        } else if (id == sThemeColorIds[2]) {
            return themeColor & 0x00ffffff | 0xaa000000;
        } else if (id == sThemeColorIds[3]) {
            return themeColor & 0x00ffffff | 0x88000000;
        }
        return themeColor;
    }

}
