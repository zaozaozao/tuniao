package wantao.wt.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import wantao.wt.myapplication.fragment.BaseFragment;

/**
 * Created by wantao on 2017/6/9.
 */

public class OrderTabAdapter extends FragmentPagerAdapter {

    List<BaseFragment> list;

    public OrderTabAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "全部";
        } else if (position == 1) {
            return "待抢单";
        } else if (position == 2) {
            return "待取货";
        } else if (position == 3) {
            return "送货中";
        } else if (position == 4) {
            return "已完成";
        } else if (position == 5) {
            return "退货中";
        } else if (position == 6) {
            return "未完成";
        }
        return "";
    }
}
