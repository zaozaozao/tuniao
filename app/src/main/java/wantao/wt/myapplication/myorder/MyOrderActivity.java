package wantao.wt.myapplication.myorder;

import android.support.design.widget.TabLayout;

import java.util.ArrayList;
import java.util.List;

import wantao.wt.myapplication.R;
import wantao.wt.myapplication.adapter.OrderTabAdapter;
import wantao.wt.myapplication.base.BaseActivity;
import wantao.wt.myapplication.databinding.ActivityMyOrderBinding;
import wantao.wt.myapplication.fragment.BaseFragment;

public class MyOrderActivity extends BaseActivity implements TabLayout.OnTabSelectedListener{
    public List<BaseFragment> fragments = new ArrayList<>();//大标题的fragments
    ActivityMyOrderBinding mBinding;

    OrderTabAdapter adapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_my_order;
    }

    @Override
    public void initData() {
        super.initData();
        mBinding= (ActivityMyOrderBinding) binding;
        for (int i = 0; i < 7; i++) {
            fragments.add(new OrderFragment());
        }
    }

    @Override
    public void initView() {
        super.initView();
        setCenterTitle("普通订单");
        adapter = new OrderTabAdapter(getSupportFragmentManager(), fragments);
        mBinding.viewpager.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来
        mBinding.tablayout.setupWithViewPager(mBinding.viewpager);
        mBinding.tablayout.addOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
