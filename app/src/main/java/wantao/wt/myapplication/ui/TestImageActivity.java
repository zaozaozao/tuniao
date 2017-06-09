package wantao.wt.myapplication.ui;

import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import wantao.wt.myapplication.base.BaseActivity;
import wantao.wt.myapplication.R;
import wantao.wt.myapplication.adapter.CarRecyclerAdapter;
import wantao.wt.myapplication.bean.CarType;
import wantao.wt.myapplication.databinding.ActivityMainBinding;
import wantao.wt.myapplication.databinding.ActivityOrderBinding;
import wantao.wt.myapplication.http.BaseCallModel;
import wantao.wt.myapplication.http.ObjectCallBack;
import wantao.wt.myapplication.http.RetrofitFactory;

public class TestImageActivity extends BaseActivity {



    CarRecyclerAdapter recyclerAdapter;
    ActivityOrderBinding mBinding;
    List<CarType.MsgBean.DataBean> list=new ArrayList<>();

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_order;
    }

    @Override
    public void initView() {
        super.initView();
        mBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter=new CarRecyclerAdapter(list,this);
        mBinding.recyclerview.setAdapter(recyclerAdapter);
    }

    @Override
    public void initData() {
        super.initData();
        mBinding= (ActivityOrderBinding) binding;
        initData(420502);//加载网络数据
    }


    /**
     *
     * @param cityCode
     */
    private void initData(int cityCode) {

        Call<BaseCallModel<CarType>> call=RetrofitFactory.getCallService().getCarType(RetrofitFactory.creatBaseParams(),cityCode);
        call.enqueue(new ObjectCallBack<BaseCallModel<CarType>>() {

            @Override
            public void onSuccessed(BaseCallModel<CarType> object) {
                list.clear();
                list.addAll(object.data.getMsg().getDataX());
                for (int i = 0; i <list.size() ; i++) {
                    list.get(i).setName("http://cdn.meme.am/instances/60677654.jpg");
                }
                recyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onErrored(int code, Response<BaseCallModel<CarType>> response) {

            }
        });
    }

}
