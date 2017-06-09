package wantao.wt.myapplication.fragment;


import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import wantao.wt.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {
    protected Activity activity;
    protected View parentView;
    protected ViewDataBinding binding;
    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = getActivity();
        parentView = inflater.inflate(getLayoutResId(),container,false);
        binding= DataBindingUtil.bind(parentView);
        initData();
        initView();
        return parentView;
    }

    public void initView() {
    }

    public void initData() {

    }

    protected abstract int getLayoutResId();

}
