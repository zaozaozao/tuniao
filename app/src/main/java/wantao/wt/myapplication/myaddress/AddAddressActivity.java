package wantao.wt.myapplication.myaddress;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import wantao.wt.myapplication.base.BaseActivity;
import wantao.wt.myapplication.R;
import wantao.wt.myapplication.adapter.TabAdapter;
import wantao.wt.myapplication.databinding.ActivityAddAddressBinding;

public class AddAddressActivity extends BaseActivity {

    ActivityAddAddressBinding mbinding;
    TabAdapter adapter;

    private List<DrGoodsFragment> fragments;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_add_address;
    }

    @Override
    public void initData() {
        super.initData();
        this.mbinding= (ActivityAddAddressBinding) binding;
        fragments=new ArrayList<>();
        fragments.add(DrGoodsFragment.newInstance("1"));
        fragments.add(DrGoodsFragment.newInstance("2"));
    }

    @Override
    public void initView() {
        super.initView();
        adapter=new TabAdapter(getSupportFragmentManager(),fragments);
        mbinding.viewpager.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来
        mbinding.tablayout.setupWithViewPager(mbinding.viewpager);

        //初始化头部
        initHeadView();
    }

    private void initHeadView() {
        setCenterTitle("地址管理");
        setRightImg(R.drawable.btn_title_add_selector);
    }

    /**
     * 添加地址
     * @param v
     */
    @Override
    public void rightViewClick(View v) {
        super.rightViewClick(v);
        int position=mbinding.tablayout.getSelectedTabPosition();
        fragments.get(position).addAddress(v);

    }


}
