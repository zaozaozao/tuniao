package wantao.wt.myapplication.bean.builder;

import wantao.wt.myapplication.bean.AddressBean;

public class MsgBeanBuilder {
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

    public MsgBeanBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public MsgBeanBuilder setPoi(String poi) {
        this.poi = poi;
        return  this;
    }

    public MsgBeanBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public MsgBeanBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public MsgBeanBuilder setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public MsgBeanBuilder setAddr1(String addr1) {
        this.addr1 = addr1;
        return this;
    }

    public MsgBeanBuilder setAddr2(String addr2) {
        this.addr2 = addr2;
        return this;
    }

    public MsgBeanBuilder setLng(String lng) {
        this.lng = lng;
        return this;
    }

    public MsgBeanBuilder setLat(String lat) {
        this.lat = lat;
        return this;
    }

    public MsgBeanBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public MsgBeanBuilder setArea(String area) {
        this.area = area;
        return this;
    }

    public MsgBeanBuilder setProvice(String provice) {
        this.provice = provice;
        return this;
    }

    public MsgBeanBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public MsgBeanBuilder setCity_code(String city_code) {
        this.city_code = city_code;
        return this;
    }

    public MsgBeanBuilder setToken(String token) {
        this.token = token;
        return this;
    }

    public MsgBeanBuilder setClient_type(String client_type) {
        this.client_type = client_type;
        return this;
    }

    public MsgBeanBuilder setDevice_type(String device_type) {
        this.device_type = device_type;
        return this;
    }

    public AddressBean.MsgBean createMsgBean() {
        return new AddressBean.MsgBean(id, phone, type, uid, addr1, addr2, lng, lat, status, area, provice, city, city_code, token, client_type, device_type,poi);
    }
}