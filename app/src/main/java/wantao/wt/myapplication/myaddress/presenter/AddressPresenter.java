package wantao.wt.myapplication.myaddress.presenter;

import java.util.List;

import wantao.wt.myapplication.bean.AddressBean;
import wantao.wt.myapplication.myaddress.model.AddressModel;
import wantao.wt.myapplication.myaddress.view.IViewModel;

/**
 * Created by wantao on 2017/5/23.
 */

public class AddressPresenter {
    AddressModel model ;
    IViewModel view;

    public AddressPresenter(IViewModel view) {
        this.view = view;
        model=new AddressModel(this);
    }

    public void deleteAddress(AddressBean.MsgBean address)
    {
        model.deleteAddress(address);
    }

    public void deleteAddressOk(AddressBean.MsgBean address)
    {
        view.deleteAddressOk(address);
    }
    public void deleteAddressFail()
    {
        view.deleteAddressFail();
    }

    public void addAddress(String type)
    {
        model.addAddress(type);
    }

    public void addAddressOk()
    {
        view.addAddressOk();
    }

    public  void addAddressFail()
    {

    }

    public void getCarlist(String type)
    {
        model.getCarList(type);
    }
    public void getCarlistOk(List<AddressBean.MsgBean> list)
    {
        view.getCarListOk(list);
    }
    public void getCarlistFail()
    {

    }

    public void setDefaultAddress(String id)
    {

    }











}
