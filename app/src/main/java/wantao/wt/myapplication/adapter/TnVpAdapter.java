package wantao.wt.myapplication.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import wantao.wt.myapplication.R;
import wantao.wt.myapplication.fragment.BaseFragment;


/**
 * Created by wantao on 2017/5/27.
 */

public class TnVpAdapter extends FragmentPagerAdapter {

    List<BaseFragment> list;
    LayoutInflater inflater;
    public TnVpAdapter(FragmentManager fm, List<BaseFragment> list, Context context) {
        super(fm);
        this.list=list;
        inflater= LayoutInflater.from(context);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0)
            return "小件速递";
        else if (position==1)
            return "零担专线";
        else if (position==2)
            return "同城货运";
        else if (position==3)
            return "货运整车";
        else
            return "途鸟测试"+position;
    }

    /**
     * 自定义TabLayout
     * @param position
     * @return
     */
    public View getTabView(int position){
        View view = inflater.inflate(R.layout.custom_tabview, null);
        TextView tv= (TextView) view.findViewById(R.id.tv);
        tv.setText(getPageTitle(position));
        if (position==0)
            tv.setSelected(true);
        return view;
    }
}
