package wantao.wt.myapplication.tuniao;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.List;

import wantao.wt.myapplication.R;
import wantao.wt.myapplication.base.BaseTitleFragment;
import wantao.wt.myapplication.databinding.FragmentNoMapBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoMapFragment extends BaseTitleFragment {

    FragmentNoMapBinding mBinding;
    int id;
    public NoMapFragment() {
        // Required empty public constructor
    }

    public static NoMapFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("id",id);
        NoMapFragment fragment = new NoMapFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_no_map;
    }

    @Override
    public void initData() {
        super.initData();
        id=getArguments().getInt("id");
        mBinding= (FragmentNoMapBinding) binding;
        mActivity.getSmallTitle(id);
    }

    @Override
    public void initTab(List<String> titles) {
        mBinding.titleBar.initTab(titles);
    }
}
