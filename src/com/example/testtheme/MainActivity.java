
package com.example.testtheme;

import com.dolphin.browser.core.AppContext;
import com.dolphin.browser.extensions.ThemeListener;
import com.dolphin.browser.theme.ThemeManager;
import com.dolphin.browser.theme.ThemeManager.ThemeColorUpdatingCallback;
import com.dolphin.browser.theme.data.AbsTheme;
import com.dolphin.browser.theme.view.FontIconDrawableView;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {

    private ThemeManager mThemeManager;
    private LinearLayout mLayout;
    private View mColorPanel;
    private FontIconDrawableView mFontIconDrawableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppContext.init(this);
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        mThemeManager = (ThemeManager) ThemeManager.getInstance();
        mThemeManager.setTheme(mThemeManager.getAllThemes().get(0), true, true);

        FontIconDrawableView img = new FontIconDrawableView(this);
        layout.addView(img, new LinearLayout.LayoutParams(50, 50));

        img = new FontIconDrawableView(this);
        layout.addView(img, new LinearLayout.LayoutParams(50, 50));

        img = new FontIconDrawableView(this);
        layout.addView(img, new LinearLayout.LayoutParams(50, 50));

        img = new FontIconDrawableView(this);
        layout.addView(img, new LinearLayout.LayoutParams(50, 50));

        TextView tex = new TextView(this);
        tex.setText("hi");
        tex.setTextSize(30);
        tex.setTypeface(Typeface.createFromAsset(getAssets(), "normal"));
        layout.addView(tex, new LinearLayout.LayoutParams(50, 50));

        {
            //test theme color!!!!
            ImageView wocao = new ImageView(this);
            layout.addView(wocao, new LinearLayout.LayoutParams(320, 200));
            final Random ran = new Random();

            wocao.setOnTouchListener(new OnTouchListener() {

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
                public void onThemeColorChanged(final boolean isUpdatingCustomColor) {
                    Log.d("ThemeManager", "notifyed theme color changed!");
                    updateTheme();
                }
            });
            mColorPanel = wocao;
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

        final List<AbsTheme> tms = mThemeManager.getAllThemes();
        final Button button = new Button(this);
        button.setText("点击切换正常模式和夜间模式！");
        layout.addView(button, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 100));
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                index ++ ;
                if (index >= tms.size()) {
                    index = 0;
                }
                mThemeManager.setTheme(tms.get(index), true, true);
            }
        });


        updateTheme();
    }


    private int index = 0;

    private void updateTheme() {
        FontIconDrawableView img = (FontIconDrawableView) mLayout.getChildAt(0);
        img.setBackgroundColor(Color.RED);
        img.setFontIcon(mThemeManager.getFontIconDrawable(R.string.test_font_icon_0));
        img = (FontIconDrawableView) mLayout.getChildAt(1);
        img.setBackgroundColor(Color.BLUE);
        img.setFontIcon(mThemeManager.getFontIconDrawable(R.string.test_font_icon_1));
        img = (FontIconDrawableView) mLayout.getChildAt(2);
        img.setBackgroundColor(Color.GRAY);
        img.setFontIcon(mThemeManager.getFontIconDrawable(R.string.test_font_icon_2));
        img = (FontIconDrawableView) mLayout.getChildAt(3);
        img.setBackgroundColor(Color.GREEN);
        img.setFontIcon(mThemeManager.getFontIconDrawable(R.string.test_font_icon_3));
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
