package wantao.wt.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.view.View;

import java.util.List;

import wantao.wt.myapplication.myaddress.AddAddressActivity;
import wantao.wt.myapplication.BR;
import wantao.wt.myapplication.R;
import wantao.wt.myapplication.bean.CarType;
import wantao.wt.myapplication.interfaced.CustomListClickListener;
import wantao.wt.myapplication.personcertification.PersonalCertificationActivity;

/**
 * Created by wantao on 2017/5/19.
 */

public class CarRecyclerAdapter extends BaseRecyclerAdapter<CarType.MsgBean.DataBean> implements CustomListClickListener {
    Context context;
    public CarRecyclerAdapter(List mData, Context context) {
        super(mData);
        this.context=context;
        setCustomItemClickListener(this);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.item_car;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.carType;
    }

    @Override
    public void bindingViewClick(ViewDataBinding binding, int position) {

    }

    @Override
    public void onItemClick(View view, int pos) {

    }
}
