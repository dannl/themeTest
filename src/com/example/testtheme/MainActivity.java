
package com.example.testtheme;

import com.dolphin.browser.core.AppContext;
import com.dolphin.browser.extensions.ThemeListener;
import com.dolphin.browser.theme.ThemeManager;
import com.dolphin.browser.theme.ThemeManager.ThemeColorUpdatingCallback;
import com.dolphin.browser.theme.data.AbsTheme;
import com.dolphin.browser.util.Log;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {

    private ThemeManager mThemeManager;
    private LinearLayout mLayout;
    private View mColorPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppContext.init(this);
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        mThemeManager = (ThemeManager) ThemeManager.getInstance();
        mThemeManager.setTheme(mThemeManager.getAllThemes().get(0), true, true);
        ImageView img = new ImageView(this);
        layout.addView(img, new LinearLayout.LayoutParams(50, 50));

        img = new ImageView(this);
        layout.addView(img, new LinearLayout.LayoutParams(50, 50));

        img = new ImageView(this);
        layout.addView(img, new LinearLayout.LayoutParams(50, 50));
        img.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("FontIconDrawable", "holy shit clicking!!");
            }
        });

        img = new ImageView(this);
        layout.addView(img, new LinearLayout.LayoutParams(50, 50));

        TextView tex = new TextView(this);
        tex.setText("hi");
        tex.setTextSize(30);
        tex.setTypeface(Typeface.createFromAsset(getAssets(), "normal"));
        layout.addView(tex, new LinearLayout.LayoutParams(50, 50));

        final List<AbsTheme> tms = mThemeManager.getAllThemes();
        img.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                index ++ ;
                if (index >= tms.size()) {
                    index = 0;
                }
                mThemeManager.setTheme(tms.get(index), true, true);
            }
        });


        {
            //test theme color!!!!
            img = new ImageView(this);
            layout.addView(img, new LinearLayout.LayoutParams(320, 200));
            final Random ran = new Random();

            img.setOnTouchListener(new OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_MOVE) {
                        Log.d("ThemeManager", "on touch move!");
                        mThemeManager.setCustomThemeColor(ran.nextInt(0xffffff));
                    } else if (event.getAction() == MotionEvent.ACTION_UP) {
                        mThemeManager.abortUsingCustomThemeColor();
                    }
                    return true;
                }
            });

            mThemeManager.addThemeColorUpdatingCallback(new ThemeColorUpdatingCallback() {

                @Override
                public void onThemeColorChanged() {
                    Log.d("ThemeManager", "notifyed theme color changed!");
                    updateTheme();
                }
            });
            mColorPanel = img;
        }

        setContentView(layout);
        mLayout = layout;

        mThemeManager.addListener(new ThemeListener() {

            @Override
            public void onNightModeHappens(boolean enabled) {
            }

            @Override
            public void onInstalledThemeChanged() {
            }

            @Override
            public void onCurrentThemeChanged() {
            }
        });

        mThemeManager.addCriticalListener(new ThemeListener() {

            @Override
            public void onNightModeHappens(boolean enabled) {
            }

            @Override
            public void onInstalledThemeChanged() {
            }

            @Override
            public void onCurrentThemeChanged() {
                updateTheme();
            }
        });
        updateTheme();
    }


    private int index = 0;

    private void updateTheme() {
        ImageView img = (ImageView) mLayout.getChildAt(0);
        img.setBackgroundColor(Color.RED);
        img.setImageDrawable(mThemeManager.getFontIconDrawable(R.string.test_font_icon_0));
        img = (ImageView) mLayout.getChildAt(1);
        img.setBackgroundColor(Color.BLUE);
        img.setImageDrawable(mThemeManager.getFontIconDrawable(R.string.test_font_icon_1));
        img = (ImageView) mLayout.getChildAt(2);
        img.setBackgroundColor(Color.GRAY);
        img.setImageDrawable(mThemeManager.getFontIconDrawable(R.string.test_font_icon_2));
        img = (ImageView) mLayout.getChildAt(3);
        img.setBackgroundColor(Color.GREEN);
        img.setImageDrawable(mThemeManager.getFontIconDrawable(R.string.test_font_icon_3));
        final int color  = mThemeManager.getColor(R.color.dolphin_theme_color);
        Log.d("ThemeManager", "got color=================" + Integer.toHexString(color));
        mColorPanel.setBackgroundColor(color);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
