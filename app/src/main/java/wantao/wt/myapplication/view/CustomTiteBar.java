package wantao.wt.myapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import wantao.wt.myapplication.R;

/**
 * Created by wantao on 2017/6/5.
 */

public class CustomTiteBar extends CustomScrollView implements View.OnClickListener{
    LayoutInflater inflater;
    LinearLayout linearLayout;
    ItemClickListener listener;
    public CustomTiteBar(Context context) {
        super(context);
        init();
    }

    public CustomTiteBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflater=LayoutInflater.from(context);
        init();
    }



    private void init()
    {
        View view= inflater.inflate(R.layout.titilbar,null);
        LinearLayout linearLayout= (LinearLayout) view.findViewById(R.id.container);
        this.linearLayout=linearLayout;
        addView(view);
    }

    public void initTab(List<String> smallTitles) {
        linearLayout.removeAllViews();
        for (int i = 0; i < smallTitles.size(); i++) {
            View view = inflater.inflate(R.layout.custom_tabview, null);
            TextView tv = (TextView) view.findViewById(R.id.tv);
            tv.setText(smallTitles.get(i));
            tv.setTag(i);
            tv.setOnClickListener(this);
            if (i == 0)
                view.setSelected(true);
            linearLayout.addView(view);
        }
    }

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            if ((Integer) v.getTag() == i)
                linearLayout.getChildAt(i).setSelected(true);
            else
                linearLayout.getChildAt(i).setSelected(false);
        }
        if (listener!=null)
        {
            listener.itemClick(v, (Integer) v.getTag());
        }
    }

    public interface ItemClickListener
    {
        void itemClick(View v, int position);
        void getListTitle(List<String> titles);
    }

}
