package wantao.wt.myapplication.myaddress;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import wantao.wt.myapplication.R;
import wantao.wt.myapplication.adapter.DrGoodsAdapter;
import wantao.wt.myapplication.bean.AddressBean;
import wantao.wt.myapplication.databinding.FragmentDrGoodsBinding;
import wantao.wt.myapplication.fragment.BaseFragment;
import wantao.wt.myapplication.myaddress.presenter.AddressPresenter;
import wantao.wt.myapplication.myaddress.view.IViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrGoodsFragment extends BaseFragment implements IViewModel{


    DrGoodsAdapter adapter;
    FragmentDrGoodsBinding mbinding;
    String type;//根据传入的type，1为发货，2为收货，请求收货地址


    AddressPresenter presenter;
    public DrGoodsFragment() {
        // Required empty public constructor
    }

    public static DrGoodsFragment newInstance(String type) {

        Bundle args = new Bundle();
        args.putString("type",type);
        DrGoodsFragment fragment = new DrGoodsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_dr_goods;
    }

    @Override
    public void initData() {
        super.initData();
        presenter=new AddressPresenter(this);
        type=getArguments().getString("type");

        presenter.getCarlist(type);

        adapter=new DrGoodsAdapter(this);

    }

    @Override
    public void initView() {
        super.initView();
        mbinding= (FragmentDrGoodsBinding) binding;
        mbinding.deliverListview.setAdapter(adapter);

    }

    @Override
    public void getCarListOk(List<AddressBean.MsgBean> data) {
        adapter.setList(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void getCarListFail() {

    }

    /**
     *添加地址
     * @return
     */
    public void addAddress(View view) {
        presenter.addAddress(type);
    }


    public void deleteAddress(View view)
    {
        presenter.deleteAddress((AddressBean.MsgBean) view.getTag());
    }

    public void setDefaultAddress(View view)
    {
        presenter.setDefaultAddress("");
    }

    @Override
    public void addAddressOk() {
        Snackbar.make(mbinding.coordinatorlayout, "添加成功", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void addAddressFail() {

    }

    @Override
    public void deleteAddressOk(AddressBean.MsgBean address) {
        Snackbar.make(mbinding.coordinatorlayout, "删除成功", Snackbar.LENGTH_LONG).show();
        adapter.getList().remove(address);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void deleteAddressFail() {

    }

    @Override
    public void setDefaultAddressOk() {

    }
    @Override
    public void setDefaultAddressFail() {

    }
}
