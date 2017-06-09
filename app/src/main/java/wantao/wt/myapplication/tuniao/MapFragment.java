package wantao.wt.myapplication.tuniao;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.List;

import wantao.wt.myapplication.R;
import wantao.wt.myapplication.base.BaseTitleFragment;
import wantao.wt.myapplication.databinding.FragmentMapBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends BaseTitleFragment {

    FragmentMapBinding mBinding;



    public MapFragment() {
        // Required empty public constructor
    }

    public static MapFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("id",id);
        MapFragment fragment = new MapFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_map;
    }

    @Override
    public void initData() {
        super.initData();
        mBinding= (FragmentMapBinding) binding;

    }
    /**
     *   由于没有网络加载的异步操作，再initdada（）方法里面做数据加载，会导致空值针
     */
    @Override
    public void initView() {
        super.initView();
        mActivity.getSmallTitle(id);
    }

    @Override
    public void initTab(List<String> titles) {
        mBinding.titleBar.initTab(titles);
    }

}
