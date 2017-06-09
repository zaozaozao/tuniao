package wantao.wt.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import wantao.wt.myapplication.myaddress.DrGoodsFragment;

/**
 * Created by wantao on 2017/5/19.
 */

public class TabAdapter extends FragmentPagerAdapter {
    List<DrGoodsFragment> list;
    public TabAdapter(FragmentManager fm,List<DrGoodsFragment> list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0)
            return "发货地址";
        else
            return "收货地址";
    }
}
