package wantao.wt.myapplication.http.intercepor;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import wantao.wt.myapplication.encryption.EncrypUtil;

/**
 * Created by wantao on 2017/5/18.
 * 设置网络缓存
 */

public class NetIntercepor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException{

        Request oldRequest = chain.request();
        Request newRequest=null;
        if (oldRequest.method().equals("GET"))
            newRequest=encryptGetRequest(oldRequest);
        else if (oldRequest.method().equals("POST"))
            newRequest=encryptPostRequest(oldRequest);
        Response originalResponse = chain.proceed(newRequest);

        int maxAge = 1 * 60; // 在线缓存在1分钟内可读取 单位:秒
        return originalResponse.newBuilder()
                .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                .removeHeader("Cache-Control")
                .header("Cache-Control", "public, max-age=" + maxAge)
                .build();
    }

    /**
     * 需要将requestbody转换成formbody或者Multipart,目前无法对multipart结构进行加密
     * @param request
     * @return
     * @throws IOException
     */
    private Request encryptPostRequest(Request request)throws IOException {
        Request.Builder requestBuilder = request.newBuilder();
        if(request.body() instanceof FormBody){   //body第一种类型  FormBody，在请求时用FormUrlEncoded修饰
            FormBody.Builder newFormBody = new FormBody.Builder();
            FormBody oldFormBody = (FormBody) request.body();
            for(int i = 0;i<oldFormBody.size();i++){
                String key=oldFormBody.encodedName(i);
                String value = oldFormBody.encodedValue(i);
                newFormBody.addEncoded(key, EncrypUtil.encryp(value));
            }
            requestBuilder.method(request.method(), newFormBody.build());
        }
        return  requestBuilder.build();
    }

    private Request encryptGetRequest(Request request) throws IOException{
        Map<String, String> map = new HashMap();
        //得到？后面的部分
        String url_param = request.url().url().toString().split("[?]")[1];
        //把每个参数分开
        String[] params = url_param.split("&");
        //分开键和值
        for (String param : params) {
            String[] keyvalue = param.split("=");
            //如果有键无值则添加值为""
            if (keyvalue.length == 1) {
                String key = keyvalue[0];
                keyvalue = new String[]{key, ""};
            }
            if (keyvalue[1] != null)
                keyvalue[1] = URLDecoder.decode(keyvalue[1],"UTF-8");
            if (!"sign".equals(keyvalue[0]))
                map.put(keyvalue[0], keyvalue[1]);
        }
        //重新定义url
        //拼参数
        List<String> paramNames = new ArrayList(map.size());
        paramNames.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        //对每一个param进行加密
        for (String paramName : paramNames) {
            sb.append(paramName).append("=").append(map.get(paramName) == null ? "" :EncrypUtil.encryp(URLEncoder.encode( map.get(paramName), "UTF-8"))).append("&");
        }
        //最终的url
        String newUrl = request.url().url().toString().split("[?]")[0]+"?"+sb.toString();

        Request.Builder builder = request.newBuilder()
                .url(newUrl);
        return  builder.build();
    }



}
