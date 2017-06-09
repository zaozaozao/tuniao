package wantao.wt.myapplication.http;


import java.io.Serializable;

/**
 * Created by wantao on 2017/5/18.
 * 该类是基础的服务器返回数据
 */

public class BaseCallModel<T> implements Serializable {

    public StatusBean status;
    public T data;

    public static class StatusBean {

        public int code;
        public String request;
        public String msg;
    }
}
