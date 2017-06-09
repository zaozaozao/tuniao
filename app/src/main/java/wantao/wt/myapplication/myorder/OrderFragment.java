package wantao.wt.myapplication.myorder;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wantao.wt.myapplication.R;
import wantao.wt.myapplication.adapter.CarRecyclerAdapter;
import wantao.wt.myapplication.adapter.OrderAdapter;
import wantao.wt.myapplication.bean.OrderBean;
import wantao.wt.myapplication.databinding.FragmentOrderBinding;
import wantao.wt.myapplication.fragment.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {


    FragmentOrderBinding mBinding;
    OrderAdapter adapter;

    List<OrderBean> list;
    public OrderFragment() {
        // Required empty public constructor
    }

    @Override
    public void initData() {
        super.initData();
        mBinding= (FragmentOrderBinding) binding;
        list=new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            list.add(new OrderBean());
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_order;
    }

    @Override
    public void initView() {
        super.initView();
        mBinding.refresh.setProgressBackgroundColorSchemeResource(android.R.color.white);
        mBinding.refresh.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        mBinding.refresh.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        mBinding.refresh.setOnRefreshListener(this);

        mBinding.recycler.setLayoutManager(new LinearLayoutManager(activity));
        adapter=new OrderAdapter(list,activity);
        mBinding.recycler.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                list.add(new OrderBean());
                adapter.notifyDataSetChanged();
                mBinding.refresh.setRefreshing(false);
            }
        }, 1000);
    }
}
