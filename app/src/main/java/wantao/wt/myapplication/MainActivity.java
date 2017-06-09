package wantao.wt.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import wantao.wt.myapplication.adapter.TnVpAdapter;
import wantao.wt.myapplication.base.BaseTitleFragment;
import wantao.wt.myapplication.databinding.ActivityMainBinding;
import wantao.wt.myapplication.myaddress.AddAddressActivity;
import wantao.wt.myapplication.myorder.MyOrderActivity;
import wantao.wt.myapplication.personcertification.PersonalCertificationActivity;
import wantao.wt.myapplication.tuniao.MapFragment;
import wantao.wt.myapplication.tuniao.NoMapFragment;
import wantao.wt.myapplication.tuniao.TuniaoHelpActivity;
import wantao.wt.myapplication.tuniao.presenter.TuniaoPresenter;
import wantao.wt.myapplication.tuniao.view.IViewModel;
import wantao.wt.myapplication.ui.TestImageActivity;


public class MainActivity extends TuniaoHelpActivity implements NavigationView.OnNavigationItemSelectedListener, TabLayout.OnTabSelectedListener, IViewModel {

    ActivityMainBinding mBinding;
    TnVpAdapter adapter;
    TuniaoPresenter presenter;
    View headView;//头部view

    @Override
    public void initPre() {
        super.initPre();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        super.initData();
        mBinding = (ActivityMainBinding) binding;
        presenter = new TuniaoPresenter(this);
        showLoading();
        presenter.getBigTitle();//获取大标题

    }

    @Override
    public void initView() {
        super.initView();

        mBinding.navigationView.setItemIconTintList(null); //让图片显示本身的效果
        mBinding.navigationView.setNavigationItemSelectedListener(this);
        headView = mBinding.navigationView.getHeaderView(0);

        //初始化头部
        initHeadView();
    }

    /**
     * 自定义的tab相对复杂一些
     */
    private void initTabLaout(List<String> titles) {
        adapter = new TnVpAdapter(getSupportFragmentManager(), fragments, this);
        mBinding.tuniaoMain.viewpager.setAdapter(adapter);
        //将TabLayout和ViewPager关联起来
        mBinding.tuniaoMain.tablayout.setupWithViewPager(mBinding.tuniaoMain.viewpager);
        mBinding.tuniaoMain.tablayout.addOnTabSelectedListener(this);
        //设置自定义的tab
        for (int i = 0; i < titles.size(); i++) {
            TabLayout.Tab tab = mBinding.tuniaoMain.tablayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }
    }

    private void initHeadView() {
        setTitleBackground(R.mipmap.lgogo);
        setLeftImg(R.mipmap.icon_center_photo);
        setRightImg(R.drawable.btn_title_xiaoxi_selector);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.favorite:
                intent = new Intent(this, AddAddressActivity.class);
                break;
            case R.id.wallet:
                intent = new Intent(this, PersonalCertificationActivity.class);
                break;
            case R.id.photo:
                intent = new Intent(this, TestImageActivity.class);
                break;
            case R.id.file:
                intent=new Intent(this, MyOrderActivity.class);
            default:
                initSnackeBar(item.getTitle().toString(), mBinding.drawerlayout);
                break;
        }
        if (intent != null)
            startActivity(intent);
        return true;
    }


    @Override
    public void rightViewClick(View v) {
        super.rightViewClick(v);
        initSnackeBar("跳转到消息界面", mBinding.drawerlayout);
    }

    @Override
    public void leftViewClick(View v) {
        super.leftViewClick(v);

        if (mBinding.drawerlayout.isDrawerVisible(GravityCompat.START)) {
            mBinding.drawerlayout.closeDrawer(GravityCompat.START);//关闭抽屉
        } else {
            mBinding.drawerlayout.openDrawer(GravityCompat.START);//打开抽屉
        }
    }

    /**
     * 自定义的tab需要手动设置背景色
     *
     * @param tab
     */
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        currentPostion = tab.getPosition();
        tab.getCustomView().setSelected(true);
        presenter.getSmallTitle(currentPostion);
        showCustomFragment(currentPostion);//展示不同界面的ui
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        tab.getCustomView().setSelected(false);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    /**
     * 子fragment需要获取小标题，通过位置判断，解决viewapger的预加载问题，viewpager的预加载会同时加载2个frgment
     *
     * @param id
     */
    public void getSmallTitle(int id) {
        if (id == currentPostion)
            presenter.getSmallTitle(id);
    }

    @Override
    public void loadBigTitleSuccess(List<String> titles) {
        fragments.clear();
        for (int i = 0; i < titles.size(); i++) {
            if (i == 0 || i == 2)
                fragments.add(MapFragment.newInstance(i));
            else
                fragments.add(NoMapFragment.newInstance(i));
        }
        initTabLaout(titles);
    }

    @Override
    public void loadSmallTitleSuccess(List<String> titles) {
        BaseTitleFragment fragment = (BaseTitleFragment) fragments.get(currentPostion);
        fragment.getListTitle(titles);
    }

    @Override
    public void loadFail() {

    }

    @Override
    public void loadCompete() {
        hideLoading();
    }

}
