package wantao.wt.myapplication.myaddress.model;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import wantao.wt.myapplication.bean.AddressBean;
import wantao.wt.myapplication.http.BaseCallModel;
import wantao.wt.myapplication.http.BaseInfo;
import wantao.wt.myapplication.http.ObjectCallBack;
import wantao.wt.myapplication.http.RetrofitFactory;
import wantao.wt.myapplication.myaddress.presenter.AddressPresenter;

/**
 * Created by wantao on 2017/5/23.
 */

public class AddressModel   {
    AddressPresenter  presenter;


    public AddressModel(AddressPresenter presenter) {
        this.presenter = presenter;
    }

    public void deleteAddress(final AddressBean.MsgBean address) {
        Call<BaseCallModel<BaseInfo>> call = RetrofitFactory.getCallService().deleteAddress(RetrofitFactory.creatBaseParams(), address.getId());
        call.enqueue(new ObjectCallBack<BaseCallModel<BaseInfo>>() {
            @Override
            public void onSuccessed(BaseCallModel<BaseInfo> object) {
                if (object.data.msg.equals("删除成功"))
                {
                    presenter.deleteAddressOk(address);
                }
            }
            @Override
            public void onErrored(int code, Response<BaseCallModel<BaseInfo>> response) {

            }
        });
    }

    public  void addAddress(final String type)
    {
        final Map map=getParams(type);
        Call<BaseCallModel<BaseInfo>> call = RetrofitFactory.getCallService().addAddressMap(RetrofitFactory.creatBaseParams(), map);
        call.enqueue(new ObjectCallBack<BaseCallModel<BaseInfo>>() {
            @Override
            public void onSuccessed(BaseCallModel<BaseInfo> object) {
                if (object.data.msg.equals("绑定成功")) {
                    presenter.addAddressOk();
                    getCarList(type);

                }
            }

            @Override
            public void onErrored(int code, Response<BaseCallModel<BaseInfo>> response) {

            }
        });
    }

    public void setDefaultAddress()
    {

    }

    public void getCarList(String type)
    {
        Call<BaseCallModel<AddressBean>> call = RetrofitFactory.getCallService().getAddressList(RetrofitFactory.creatBaseParams(), type);
        call.enqueue(new ObjectCallBack<BaseCallModel<AddressBean>>() {
            @Override
            public void onSuccessed(BaseCallModel<AddressBean> object) {
                presenter.getCarlistOk(object.data.getMsg());
            }
            @Override
            public void onErrored(int code, Response<BaseCallModel<AddressBean>> response) {

            }
        });
    }


    /**
     * 先生成map，再将map用反射的原理生成对象
     * @return
     */
    public Map<String,String> getParams(String type) {
        HashMap<String, String> map = new HashMap<>();
        map.put("addr1", "夷陵区多样商行");
        map.put("addr2", "test");
        map.put("lng", "111.331394000");
        map.put("lat", "30.778902000");
        map.put("city_code", "420506");
        map.put("status", "2");
        map.put("phone", "15872531297");
        map.put("type", type);
        return map;
    }



}
