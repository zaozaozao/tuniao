package wantao.wt.myapplication.http.intercepor;


import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import wantao.wt.myapplication.MyApplication;
import wantao.wt.myapplication.utils.NetworkUtil;

/**
 * Created by wantao on 2017/5/18.
 * 基础请求头和参数可以在这里添加
 */

public class BaseIntercepor implements Interceptor {


    private Map<String, String> headers;

    public BaseIntercepor() {

    }

    public BaseIntercepor(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();

        //在这里设置请求头
        if (headers != null && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            for (String headerKey : keys) {
                builder.addHeader(headerKey, headers.get(headerKey)).build();
            }
        }
        /**
         * 這裡添加公共的參數，但是後台解析不出來
         * 在方法裡面添加body
         */
//
//        HttpUrl url = request.url().newBuilder()
//                .addQueryParameter("uid", "64")
//                .addQueryParameter("token", "0vStJdjpdYDrkyCZT0lvAUz4CCDVTd1T")
//                .addQueryParameter("client_type", "2")
//                .addQueryParameter("device_type", "1")
//                .build();
//
//        request = builder.url(url).build();


        //设置离线缓存
        if (!NetworkUtil.isNetworkAvailable(MyApplication.context)) {
            /**
             * 离线缓存控制  总的缓存时间=在线缓存时间+设置离线缓存时间
             */
            int maxStale = 60 * 60 * 24 * 28; // 离线时缓存保存4周,单位:秒
            CacheControl tempCacheControl = new CacheControl.Builder()
                    .onlyIfCached()
                    .maxStale(maxStale, TimeUnit.SECONDS)
                    .build();
            request = request.newBuilder()
                    .cacheControl(tempCacheControl)
                    .build();
        }
        return chain.proceed(request);

    }


}
