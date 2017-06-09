package wantao.wt.myapplication.adapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import wantao.wt.myapplication.BR;
import wantao.wt.myapplication.R;
import wantao.wt.myapplication.bean.OrderBean;
import wantao.wt.myapplication.databinding.OrderFragmentItemBinding;

/**
 * Created by wantao on 2017/6/9.
 */

public class OrderAdapter extends BaseRecyclerAdapter<OrderBean>  implements View.OnClickListener{

    OrderFragmentItemBinding binding;
    Context context;
    public OrderAdapter(List<OrderBean> mData, Context context) {
        super(mData);
        this.context=context;
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.order_fragment_item;
    }

    @Override
    public int getVariableId(int viewType) {
        return BR.order;
    }

    @Override
    public void bindingViewClick(ViewDataBinding binding, int position) {
        this.binding= (OrderFragmentItemBinding) binding;

        this.binding.btnQuxiao.setOnClickListener(this);
        this.binding.btnQuxiao.setTag(position);

        this.binding.btnLujing.setOnClickListener(this);
        this.binding.btnLujing.setTag(position);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==binding.btnQuxiao.getId())
        {
            Toast.makeText(context,"取消订单"+(int)v.getTag(),Toast.LENGTH_SHORT).show();
        }else if (v.getId()==binding.btnLujing.getId())
        {
            Toast.makeText(context,"路径追踪"+(int)v.getTag(),Toast.LENGTH_SHORT).show();
        }


    }
}
