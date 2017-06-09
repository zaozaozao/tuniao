package wantao.wt.myapplication.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import wantao.wt.myapplication.BR;
import wantao.wt.myapplication.R;
import wantao.wt.myapplication.bean.AddressBean;
import wantao.wt.myapplication.databinding.AddAddresItemBinding;
import wantao.wt.myapplication.databinding.AddresLishiItemBinding;

/**
 * Created by wantao on 2017/6/5.
 */

public class SearchAddressAdapter extends BaseAdapter {


    List<AddressBean.MsgBean> list;
    LayoutInflater inflater;
    AddresLishiItemBinding binding;
    public SearchAddressAdapter(Context context, List<AddressBean.MsgBean> list) {
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list==null?null:list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.addres_lishi_item, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (AddresLishiItemBinding) convertView.getTag();
        }
        binding.setVariable(BR.address, list.get(position));
        return convertView;
    }
}
