package wantao.wt.myapplication.http;

import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wantao.wt.myapplication.http.BaseCallModel;

/**
 * Created by wantao on 2017/5/18.
 * 简单的对Retrofit进行封装
 */

public abstract class ObjectCallBack<T extends BaseCallModel> implements Callback<T>{


    private static final int OBJECT_SUCCESS_CODE = 10008;
    private static final int FAIL_CODE_DROP=10001;  //登陆掉线
    private static final int FAIL_CODE_NET=-1;      //网络连接失败code

    private static final int FAIL_CODE=10006;
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.body()==null||response.body().status==null)
            return;
        int code=response.body().status.code;
        if (code==OBJECT_SUCCESS_CODE)
         {
           T obj= response.body();
           onSuccessed(obj);

       }else if (code==FAIL_CODE_DROP)
       {
           onAutoLogin();
       }
       else if (code==10006){
            onFailMessage(response.body().status.msg);
       }else
            onErrored(code,response);
    }

    @Override
    public void onFailure(Call call, Throwable t) {  //网络连接失败

        onErrored(FAIL_CODE_NET,null);
    }


    //成功
    public abstract void onSuccessed(T object);

    //失败
    public abstract void onErrored(int code,Response<T> response) ;

    //自动登陆
    public  void onAutoLogin(){}

    public void onFailMessage(String msg )
    {}


}
