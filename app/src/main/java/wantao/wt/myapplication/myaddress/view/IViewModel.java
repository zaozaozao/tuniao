package wantao.wt.myapplication.myaddress.view;

import java.util.List;

import wantao.wt.myapplication.bean.AddressBean;

/**
 * Created by wantao on 2017/5/23.
 */

public interface IViewModel {

    void addAddressOk();

    void addAddressFail();

    void deleteAddressOk(AddressBean.MsgBean address);

    void deleteAddressFail();

    void setDefaultAddressOk();

    void setDefaultAddressFail();

    void getCarListOk(List<AddressBean.MsgBean> data);
    void getCarListFail();

}
