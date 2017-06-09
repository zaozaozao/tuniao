package wantao.wt.myapplication.bean;

/**
 * Created by wantao on 2017/5/22.
 */

public class Test {
    /**
     * status : {"code":"10008","request":"/api/user/address"}
     * data : {"msg":"绑定成功"}
     */

    private StatusBean status;
    private DataBean data;

    public Test() {
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class StatusBean {
        /**
         * code : 10008
         * request : /api/user/address
         */

        private String code;
        private String request;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getRequest() {
            return request;
        }

        public void setRequest(String request) {
            this.request = request;
        }
    }

    public static class DataBean {
        /**
         * msg : 绑定成功
         */

        private String msg;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
