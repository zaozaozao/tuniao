package wantao.wt.myapplication.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.List;

import wantao.wt.myapplication.BR;
import wantao.wt.myapplication.R;
import wantao.wt.myapplication.bean.AddressBean;
import wantao.wt.myapplication.bean.builder.MsgBeanBuilder;
import wantao.wt.myapplication.databinding.AddAddresItemBinding;

/**
 * Created by wantao on 2017/6/5.
 */

public class AddressAdapter extends BaseAdapter implements View.OnClickListener{

    List<AddressBean.MsgBean> list;
    LayoutInflater inflater;

    AddAddresItemBinding binding;

    ListView listView;

    public AddressAdapter(Context context, List<AddressBean.MsgBean> list) {
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
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
            binding = DataBindingUtil.inflate(inflater, R.layout.add_addres_item, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (AddAddresItemBinding) convertView.getTag();
        }
        binding.setVariable(BR.addressbean, list.get(position));

        if (position==0)
        {
            binding.imgAddres.setImageResource(R.mipmap.addres_fa);
        }else if (position==list.size()-1)
            binding.imgAddres.setImageResource(R.mipmap.addres_jia_da);
        else {
            binding.imgAddres.setImageResource(R.mipmap.addres_jian_da);
        }
        binding.imgAddres.setTag(position);
        binding.imgAddres.setOnClickListener(this);
        return convertView;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==binding.imgAddres.getId())
        {
            int position= (int) v.getTag();
            if (position==list.size()-1)
            {
                addAddress();
            }else if (position!=0){
                delAddress(position);
            }
        }
    }

    private void delAddress(int position) {
        list.remove(position);
        notifyDataSetChanged();
    }

    private void addAddress() {
        AddressBean.MsgBean address1 = new MsgBeanBuilder().createMsgBean();
        address1.setAddr1("您要送哪儿");
        address1.setPhone("手机号码");
        list.add(address1);
        notifyDataSetChanged();
    }

}
