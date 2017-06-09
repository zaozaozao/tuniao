package wantao.wt.myapplication.http;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import wantao.wt.myapplication.MyApplication;
import wantao.wt.myapplication.encryption.EncrypUtil;
import wantao.wt.myapplication.http.intercepor.BaseIntercepor;
import wantao.wt.myapplication.http.intercepor.NetIntercepor;
import wantao.wt.myapplication.http.request.CallService;

/**
 * Created by wantao on 2017/5/18.
 */

public class RetrofitFactory {

    private static final int DEFAULT_TIMEOUT = 5;//设置超时的时间
    public static final long CACHE_MAXSIZE = 10 * 1024 * 1024; // 最大缓存值



    private static Retrofit createRetrofit()
    {
        return  new Retrofit.Builder()
                .baseUrl(ContentUrl.BASEURL)
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static CallService getCallService()
    {
        return createRetrofit().create(CallService.class);
    }


    /**
     * @return
     * 添加日志打印
     * 添加基础的请求参数
     * 添加网络缓存
     */
    private static OkHttpClient getHttpClient() {
        return new OkHttpClient().newBuilder()
                .cache(getCache())
                .addInterceptor(new HttpLoggingInterceptor().setLevel((HttpLoggingInterceptor.Level.BODY)))
                .addInterceptor(new BaseIntercepor())
                .addNetworkInterceptor(new NetIntercepor())
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

    public static Map<String,String> creatBaseParams()
    {
        Map<String,String> map=new HashMap<>();
        map.put("uid","40417");
        map.put("token","vXbi6C3HfTtbEzGPhcnisAOgwm25iz5L");
        map.put("client_type","2");
        map.put("device_type","1");
        return  map;
    }

    public static Map<String ,RequestBody> createBaseBody()
    {
        Map<String ,RequestBody> map=new HashMap<>();
        map.put("uid",getRequestBody(EncrypUtil.encryp("40417")));
        map.put("token",getRequestBody(EncrypUtil.encryp("vXbi6C3HfTtbEzGPhcnisAOgwm25iz5L")));
        map.put("client_type",getRequestBody(EncrypUtil.encryp("2")));
        map.put("device_type",getRequestBody(EncrypUtil.encryp("1")));
        return map;
    }

    /**
     * 多文件上传
     * @param fileMap
     * @return
     */
    public static List<MultipartBody.Part> getMultipartBodyPart(Map<String, File> fileMap) {
        List<MultipartBody.Part> list=new ArrayList<>();
        for (String fileName: fileMap.keySet()
                ) {
            MultipartBody.Part part = MultipartBody.Part.createFormData(fileName,fileMap.get(fileName).getName(),RetrofitFactory.getRequestBody(fileMap.get(fileName)));
            list.add(part);
        }
        return list;
    }

    /**
     * 生成requestbody
     * @param o
     * @return
     */
    public static RequestBody getRequestBody(Object o) {
        RequestBody body=null;
        if (o instanceof String) {
            body= RequestBody.create(MediaType.parse("text/plain"), EncrypUtil.encryp((String) o));
        } else if (o instanceof File) {
            body = RequestBody.create(MediaType.parse("image/*"), (File) o);
        }
        return body;
    }


    public static Cache getCache() {
        File cacheFile = new File(MyApplication.context.getCacheDir(), "HttpCache");
        Cache cache = new Cache(cacheFile, CACHE_MAXSIZE);
        return cache;
    }

}
