package wantao.wt.myapplication.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wantao on 2017/5/19.
 */

public class AddressBean implements Serializable {


    private List<MsgBean> msg;

    public List<MsgBean> getMsg() {
        return msg;
    }

    public void setMsg(List<MsgBean> msg) {
        this.msg = msg;
    }

    public static class MsgBean implements Serializable {
        public MsgBean() {
        }

        public MsgBean(String id, String phone, String type, String uid, String addr1, String addr2, String lng, String lat, String status, String area, String provice, String city, String city_code, String token, String client_type, String device_type, String poi) {
            this.id = id;
            this.phone = phone;
            this.type = type;
            this.uid = uid;
            this.addr1 = addr1;
            this.addr2 = addr2;
            this.lng = lng;
            this.lat = lat;
            this.status = status;
            this.area = area;
            this.provice = provice;
            this.city = city;
            this.city_code = city_code;
            this.token = token;
            this.client_type = client_type;
            this.device_type = device_type;
            this.poi = poi;
        }

        /**
         * id : 14
         * phone : 15872531297
         * type : 1
         * uid : 64
         * addr1 : 夷陵区多样商行
         * addr2 : test
         * lng : 111.331394000
         * lat : 30.778902000
         * status : 1
         * area : 夷陵区
         * provice : 湖北省
         * city : 宜昌市
         * city_code : 420506
         */

        private String id;
        private String phone;
        private String type;
        private String uid;
        private String addr1;
        private String addr2;
        private String lng;
        private String lat;
        private String status;
        private String area;
        private String provice;
        private String city;
        private String city_code;
        private String token;
        private String client_type;
        private String device_type;
        private String poi;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getClient_type() {
            return client_type;
        }

        public void setClient_type(String client_type) {
            this.client_type = client_type;
        }

        public String getDevice_type() {
            return device_type;
        }

        public void setDevice_type(String device_type) {
            this.device_type = device_type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getAddr1() {
            return addr1;
        }

        public void setAddr1(String addr1) {
            this.addr1 = addr1;
        }

        public String getAddr2() {
            return addr2;
        }

        public void setAddr2(String addr2) {
            this.addr2 = addr2;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getProvice() {
            return provice;
        }

        public void setProvice(String provice) {
            this.provice = provice;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity_code() {
            return city_code;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }

        public String getPoi() {
            return poi;
        }

        public void setPoi(String poi) {
            this.poi = poi;
        }

        public void refreshData(AddressBean.MsgBean bean) {
            if (bean.getPhone() != null)
                setPhone(bean.getPhone());
            if (bean.getAddr1() != null)
                setAddr1(bean.getAddr1());
        }

    }
}
