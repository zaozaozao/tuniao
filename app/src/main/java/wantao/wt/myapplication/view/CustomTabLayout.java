package wantao.wt.myapplication.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

import wantao.wt.myapplication.utils.ScreenUtil;

/**
 * Created by wantao on 2017/6/8.
 */

public class CustomTabLayout extends TabLayout {

    // 这个值控制可以把ScrollView包裹的控件拉出偏离顶部或底部的距离。
    int MAX_OVERSCROLL_X = 150;

    private Context mContext;
    private int newMaxOverScrollX;
    public CustomTabLayout(Context context) {
        super(context);
        init(context);
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    @SuppressLint("NewApi")
    private void init(Context context) {

        MAX_OVERSCROLL_X = ScreenUtil.getInstance(context).getScreenWidth()/10;

        this.mContext = context;
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        float density = metrics.density;
        newMaxOverScrollX = (int) (density * MAX_OVERSCROLL_X);

    }

    // 最关键的地方。
    //支持到SDK8需要增加@SuppressLint("NewApi")。
    @SuppressLint("NewApi")
    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
                                   int scrollY, int scrollRangeX, int scrollRangeY,
                                   int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY,
                scrollRangeX, scrollRangeY, newMaxOverScrollX, maxOverScrollY,
                isTouchEvent);
    }
}
