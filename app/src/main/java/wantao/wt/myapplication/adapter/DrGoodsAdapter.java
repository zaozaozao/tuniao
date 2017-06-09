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
import wantao.wt.myapplication.myaddress.DrGoodsFragment;
import wantao.wt.myapplication.myaddress.presenter.AddressPresenter;
import wantao.wt.myapplication.databinding.ItemListAddressBinding;
import wantao.wt.myapplication.myaddress.view.IViewModel;

/**
 * Created by wantao on 2017/5/19.
 */

public class DrGoodsAdapter extends BaseAdapter  {
    List<AddressBean.MsgBean> list;
    LayoutInflater inflater;
    ItemListAddressBinding binding;
    DrGoodsFragment fragment;
    public DrGoodsAdapter(DrGoodsFragment fragment) {
        this.fragment=fragment;
        inflater=LayoutInflater.from(fragment.getContext());
    }

    public void setList(List<AddressBean.MsgBean> list) {
        this.list = list;
    }

    public List<AddressBean.MsgBean> getList() {
        return list;
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.item_list_address, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ItemListAddressBinding) convertView.getTag();
        }
        binding.setVariable(BR.address, list.get(position));

        binding.setDrGoodsFragment(fragment);

        binding.btnDel.setTag(list.get(position));
        return convertView;
    }




}
