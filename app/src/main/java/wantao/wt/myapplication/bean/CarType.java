package wantao.wt.myapplication.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import wantao.wt.myapplication.http.BaseImageModel;

/**
 * Created by wantao on 2017/5/18.
 */

public class CarType extends BaseImageModel implements Serializable{


    /**
     * msg : {"data":[{"id":"2","name":"同城货运","menu":"","child":[{"id":"12","title":"小面包","btn":"取货","content":"上线中，敬请期待！","home_type":"1","pai_ui":"3","yjhj":"2","is_open":"1","name":"小面包","and_icon":"/Public/icon/car/android/12.png","ios_icon":"/Public/icon/car/ios/12.png"},{"id":"46","title":"搬家专车","btn":"用车","content":"上线中，敬请期待","home_type":"1","pai_ui":"6","yjhj":"2","is_open":"1","name":"搬家专车","and_icon":"/Public/icon/car/android/46.png","ios_icon":"/Public/icon/car/ios/46.png"},{"id":"13","title":"大面包","btn":"取货","content":"上线中，敬请期待！","home_type":"1","pai_ui":"3","yjhj":"2","is_open":"1","name":"大面包","and_icon":"/Public/icon/car/android/13.png","ios_icon":"/Public/icon/car/ios/13.png"},{"id":"48","title":"同城零担","btn":"用车","content":"上线中，敬请期待","home_type":"1","pai_ui":"7","yjhj":"2","is_open":"1","name":"同城零担","and_icon":"/Public/icon/car/android/48.png","ios_icon":"/Public/icon/car/ios/48.png"},{"id":"49","title":"家居专车","btn":"用车","content":"上线中，敬请期待","home_type":"1","pai_ui":"8","yjhj":"2","is_open":"1","name":"家居专车","and_icon":"/Public/icon/car/android/49.png","ios_icon":"/Public/icon/car/ios/49.png"},{"id":"58","title":"三轮车","btn":"用车","content":"上线中，敬请期待","home_type":"","pai_ui":"3","yjhj":"2","is_open":"1","name":"三轮车","and_icon":"/Public/icon/car/android/58.png","ios_icon":"/Public/icon/car/ios/58.png"}]},{"id":"4","name":"零担专线","menu":"","child":[{"id":"55","title":"零担专线","btn":"用车","content":"零担专线","home_type":"2","pai_ui":"12","yjhj":"1","is_open":"1","name":"零担专线","and_icon":"/Public/icon/car/android/55.png","ios_icon":"/Public/icon/car/ios/55.png"}]},{"id":"1","name":"小件速递","menu":"","child":[{"id":"7","title":"及时送","btn":"取件","content":"上线中，敬请期待！","home_type":"1","pai_ui":"13","yjhj":"2","is_open":"1","name":"及时送","and_icon":"/Public/icon/car/android/7.png","ios_icon":"/Public/icon/car/ios/7.png"},{"id":"8","title":"半日达","btn":"取件","content":"上线中，敬请期待！","home_type":"1","pai_ui":"14","yjhj":"2","is_open":"1","name":"半日达","and_icon":"/Public/icon/car/android/8.png","ios_icon":"/Public/icon/car/ios/8.png"}]},{"id":"3","name":"货运整车","menu":"","child":[{"id":"15","title":"厢式","btn":"用车","content":"上线中，敬请期待！","home_type":"1","pai_ui":"4","yjhj":"1","is_open":"1","name":"厢式","and_icon":"/Public/icon/car/android/15.png","ios_icon":"/Public/icon/car/ios/15.png"},{"id":"16","title":"平板","btn":"用车","content":"上线中，敬请期待！","home_type":"1","pai_ui":"4","yjhj":"1","is_open":"1","name":"平板","and_icon":"/Public/icon/car/android/16.png","ios_icon":"/Public/icon/car/ios/16.png"},{"id":"17","title":"高栏","btn":"用车","content":"上线中，敬请期待！","home_type":"1","pai_ui":"4","yjhj":"1","is_open":"1","name":"高栏","and_icon":"/Public/icon/car/android/17.png","ios_icon":"/Public/icon/car/ios/17.png"},{"id":"18","title":"冷藏","btn":"用车","content":"上线中，敬请期待！","home_type":"1","pai_ui":"4","yjhj":"1","is_open":"1","name":"冷藏","and_icon":"/Public/icon/car/android/18.png","ios_icon":"/Public/icon/car/ios/18.png"},{"id":"36","title":"中栏","btn":"用车","content":"上线中，敬请期待","home_type":"1","pai_ui":"4","yjhj":"1","is_open":"1","name":"中栏","and_icon":"/Public/icon/car/android/36.png","ios_icon":"/Public/icon/car/ios/36.png"},{"id":"37","title":"低栏","btn":"用车","content":"上线中，敬请期待","home_type":"1","pai_ui":"4","yjhj":"1","is_open":"1","name":"低栏","and_icon":"/Public/icon/car/android/37.png","ios_icon":"/Public/icon/car/ios/37.png"}]}],"scrollimg":{"3":[{"ad_img":"/Public/System/AD/huoche1.png","ad_img_click_url":"http://www.tuniaokeji.com/"},{"ad_img":"/Public/System/AD/huoche2.png","ad_img_click_url":"http://www.tuniaokeji.com/"}],"4":[{"ad_img":"/Public/System/AD/shunfngche1.png","ad_img_click_url":"http://www.tuniaokeji.com/"},{"ad_img":"/Public/System/AD/shunfngche2.png","ad_img_click_url":"http://www.tuniaokeji.com/"}],"5":[{"ad_img":"/Public/System/AD/zhuanxian1.png","ad_img_click_url":"http://www.tuniaokeji.com/"},{"ad_img":"/Public/System/AD/zhuanxian2.png","ad_img_click_url":"http://www.tuniaokeji.com/"}],"6":[{"ad_img":"/Public/System/AD/center1.png","ad_img_click_url":"http://www.tuniaokeji.com/"},{"ad_img":"/Public/System/AD/center2.png","ad_img_click_url":"http://www.tuniaokeji.com/"}]}}
     */

    private MsgBean msg;

    public MsgBean getMsg() {
        return msg;
    }

    public void setMsg(MsgBean msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * data : [{"id":"2","name":"同城货运","menu":"","child":[{"id":"12","title":"小面包","btn":"取货","content":"上线中，敬请期待！","home_type":"1","pai_ui":"3","yjhj":"2","is_open":"1","name":"小面包","and_icon":"/Public/icon/car/android/12.png","ios_icon":"/Public/icon/car/ios/12.png"},{"id":"46","title":"搬家专车","btn":"用车","content":"上线中，敬请期待","home_type":"1","pai_ui":"6","yjhj":"2","is_open":"1","name":"搬家专车","and_icon":"/Public/icon/car/android/46.png","ios_icon":"/Public/icon/car/ios/46.png"},{"id":"13","title":"大面包","btn":"取货","content":"上线中，敬请期待！","home_type":"1","pai_ui":"3","yjhj":"2","is_open":"1","name":"大面包","and_icon":"/Public/icon/car/android/13.png","ios_icon":"/Public/icon/car/ios/13.png"},{"id":"48","title":"同城零担","btn":"用车","content":"上线中，敬请期待","home_type":"1","pai_ui":"7","yjhj":"2","is_open":"1","name":"同城零担","and_icon":"/Public/icon/car/android/48.png","ios_icon":"/Public/icon/car/ios/48.png"},{"id":"49","title":"家居专车","btn":"用车","content":"上线中，敬请期待","home_type":"1","pai_ui":"8","yjhj":"2","is_open":"1","name":"家居专车","and_icon":"/Public/icon/car/android/49.png","ios_icon":"/Public/icon/car/ios/49.png"},{"id":"58","title":"三轮车","btn":"用车","content":"上线中，敬请期待","home_type":"","pai_ui":"3","yjhj":"2","is_open":"1","name":"三轮车","and_icon":"/Public/icon/car/android/58.png","ios_icon":"/Public/icon/car/ios/58.png"}]},{"id":"4","name":"零担专线","menu":"","child":[{"id":"55","title":"零担专线","btn":"用车","content":"零担专线","home_type":"2","pai_ui":"12","yjhj":"1","is_open":"1","name":"零担专线","and_icon":"/Public/icon/car/android/55.png","ios_icon":"/Public/icon/car/ios/55.png"}]},{"id":"1","name":"小件速递","menu":"","child":[{"id":"7","title":"及时送","btn":"取件","content":"上线中，敬请期待！","home_type":"1","pai_ui":"13","yjhj":"2","is_open":"1","name":"及时送","and_icon":"/Public/icon/car/android/7.png","ios_icon":"/Public/icon/car/ios/7.png"},{"id":"8","title":"半日达","btn":"取件","content":"上线中，敬请期待！","home_type":"1","pai_ui":"14","yjhj":"2","is_open":"1","name":"半日达","and_icon":"/Public/icon/car/android/8.png","ios_icon":"/Public/icon/car/ios/8.png"}]},{"id":"3","name":"货运整车","menu":"","child":[{"id":"15","title":"厢式","btn":"用车","content":"上线中，敬请期待！","home_type":"1","pai_ui":"4","yjhj":"1","is_open":"1","name":"厢式","and_icon":"/Public/icon/car/android/15.png","ios_icon":"/Public/icon/car/ios/15.png"},{"id":"16","title":"平板","btn":"用车","content":"上线中，敬请期待！","home_type":"1","pai_ui":"4","yjhj":"1","is_open":"1","name":"平板","and_icon":"/Public/icon/car/android/16.png","ios_icon":"/Public/icon/car/ios/16.png"},{"id":"17","title":"高栏","btn":"用车","content":"上线中，敬请期待！","home_type":"1","pai_ui":"4","yjhj":"1","is_open":"1","name":"高栏","and_icon":"/Public/icon/car/android/17.png","ios_icon":"/Public/icon/car/ios/17.png"},{"id":"18","title":"冷藏","btn":"用车","content":"上线中，敬请期待！","home_type":"1","pai_ui":"4","yjhj":"1","is_open":"1","name":"冷藏","and_icon":"/Public/icon/car/android/18.png","ios_icon":"/Public/icon/car/ios/18.png"},{"id":"36","title":"中栏","btn":"用车","content":"上线中，敬请期待","home_type":"1","pai_ui":"4","yjhj":"1","is_open":"1","name":"中栏","and_icon":"/Public/icon/car/android/36.png","ios_icon":"/Public/icon/car/ios/36.png"},{"id":"37","title":"低栏","btn":"用车","content":"上线中，敬请期待","home_type":"1","pai_ui":"4","yjhj":"1","is_open":"1","name":"低栏","and_icon":"/Public/icon/car/android/37.png","ios_icon":"/Public/icon/car/ios/37.png"}]}]
         * scrollimg : {"3":[{"ad_img":"/Public/System/AD/huoche1.png","ad_img_click_url":"http://www.tuniaokeji.com/"},{"ad_img":"/Public/System/AD/huoche2.png","ad_img_click_url":"http://www.tuniaokeji.com/"}],"4":[{"ad_img":"/Public/System/AD/shunfngche1.png","ad_img_click_url":"http://www.tuniaokeji.com/"},{"ad_img":"/Public/System/AD/shunfngche2.png","ad_img_click_url":"http://www.tuniaokeji.com/"}],"5":[{"ad_img":"/Public/System/AD/zhuanxian1.png","ad_img_click_url":"http://www.tuniaokeji.com/"},{"ad_img":"/Public/System/AD/zhuanxian2.png","ad_img_click_url":"http://www.tuniaokeji.com/"}],"6":[{"ad_img":"/Public/System/AD/center1.png","ad_img_click_url":"http://www.tuniaokeji.com/"},{"ad_img":"/Public/System/AD/center2.png","ad_img_click_url":"http://www.tuniaokeji.com/"}]}
         */

        private ScrollimgBean scrollimg;
        @SerializedName("data")
        private List<DataBean> dataX;

        public ScrollimgBean getScrollimg() {
            return scrollimg;
        }

        public void setScrollimg(ScrollimgBean scrollimg) {
            this.scrollimg = scrollimg;
        }

        public List<DataBean> getDataX() {
            return dataX;
        }

        public void setDataX(List<DataBean> dataX) {
            this.dataX = dataX;
        }

        public static class ScrollimgBean {
            @SerializedName("3")
            private List<_$3Bean> _$3;
            @SerializedName("4")
            private List<_$4Bean> _$4;
            @SerializedName("5")
            private List<_$5Bean> _$5;
            @SerializedName("6")
            private List<_$6Bean> _$6;

            public List<_$3Bean> get_$3() {
                return _$3;
            }

            public void set_$3(List<_$3Bean> _$3) {
                this._$3 = _$3;
            }

            public List<_$4Bean> get_$4() {
                return _$4;
            }

            public void set_$4(List<_$4Bean> _$4) {
                this._$4 = _$4;
            }

            public List<_$5Bean> get_$5() {
                return _$5;
            }

            public void set_$5(List<_$5Bean> _$5) {
                this._$5 = _$5;
            }

            public List<_$6Bean> get_$6() {
                return _$6;
            }

            public void set_$6(List<_$6Bean> _$6) {
                this._$6 = _$6;
            }

            public static class _$3Bean {
                /**
                 * ad_img : /Public/System/AD/huoche1.png
                 * ad_img_click_url : http://www.tuniaokeji.com/
                 */

                private String ad_img;
                private String ad_img_click_url;

                public String getAd_img() {
                    return ad_img;
                }

                public void setAd_img(String ad_img) {
                    this.ad_img = ad_img;
                }

                public String getAd_img_click_url() {
                    return ad_img_click_url;
                }

                public void setAd_img_click_url(String ad_img_click_url) {
                    this.ad_img_click_url = ad_img_click_url;
                }
            }

            public static class _$4Bean {
                /**
                 * ad_img : /Public/System/AD/shunfngche1.png
                 * ad_img_click_url : http://www.tuniaokeji.com/
                 */

                private String ad_img;
                private String ad_img_click_url;

                public String getAd_img() {
                    return ad_img;
                }

                public void setAd_img(String ad_img) {
                    this.ad_img = ad_img;
                }

                public String getAd_img_click_url() {
                    return ad_img_click_url;
                }

                public void setAd_img_click_url(String ad_img_click_url) {
                    this.ad_img_click_url = ad_img_click_url;
                }
            }

            public static class _$5Bean {
                /**
                 * ad_img : /Public/System/AD/zhuanxian1.png
                 * ad_img_click_url : http://www.tuniaokeji.com/
                 */

                private String ad_img;
                private String ad_img_click_url;

                public String getAd_img() {
                    return ad_img;
                }

                public void setAd_img(String ad_img) {
                    this.ad_img = ad_img;
                }

                public String getAd_img_click_url() {
                    return ad_img_click_url;
                }

                public void setAd_img_click_url(String ad_img_click_url) {
                    this.ad_img_click_url = ad_img_click_url;
                }
            }

            public static class _$6Bean {
                /**
                 * ad_img : /Public/System/AD/center1.png
                 * ad_img_click_url : http://www.tuniaokeji.com/
                 */

                private String ad_img;
                private String ad_img_click_url;

                public String getAd_img() {
                    return ad_img;
                }

                public void setAd_img(String ad_img) {
                    this.ad_img = ad_img;
                }

                public String getAd_img_click_url() {
                    return ad_img_click_url;
                }

                public void setAd_img_click_url(String ad_img_click_url) {
                    this.ad_img_click_url = ad_img_click_url;
                }
            }
        }

        public static class DataBean {
            /**
             * id : 2
             * name : 同城货运
             * menu :
             * child : [{"id":"12","title":"小面包","btn":"取货","content":"上线中，敬请期待！","home_type":"1","pai_ui":"3","yjhj":"2","is_open":"1","name":"小面包","and_icon":"/Public/icon/car/android/12.png","ios_icon":"/Public/icon/car/ios/12.png"},{"id":"46","title":"搬家专车","btn":"用车","content":"上线中，敬请期待","home_type":"1","pai_ui":"6","yjhj":"2","is_open":"1","name":"搬家专车","and_icon":"/Public/icon/car/android/46.png","ios_icon":"/Public/icon/car/ios/46.png"},{"id":"13","title":"大面包","btn":"取货","content":"上线中，敬请期待！","home_type":"1","pai_ui":"3","yjhj":"2","is_open":"1","name":"大面包","and_icon":"/Public/icon/car/android/13.png","ios_icon":"/Public/icon/car/ios/13.png"},{"id":"48","title":"同城零担","btn":"用车","content":"上线中，敬请期待","home_type":"1","pai_ui":"7","yjhj":"2","is_open":"1","name":"同城零担","and_icon":"/Public/icon/car/android/48.png","ios_icon":"/Public/icon/car/ios/48.png"},{"id":"49","title":"家居专车","btn":"用车","content":"上线中，敬请期待","home_type":"1","pai_ui":"8","yjhj":"2","is_open":"1","name":"家居专车","and_icon":"/Public/icon/car/android/49.png","ios_icon":"/Public/icon/car/ios/49.png"},{"id":"58","title":"三轮车","btn":"用车","content":"上线中，敬请期待","home_type":"","pai_ui":"3","yjhj":"2","is_open":"1","name":"三轮车","and_icon":"/Public/icon/car/android/58.png","ios_icon":"/Public/icon/car/ios/58.png"}]
             */

            private String id;
            private String name;
            private String menu;
            private List<ChildBean> child;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMenu() {
                return menu;
            }

            public void setMenu(String menu) {
                this.menu = menu;
            }

            public List<ChildBean> getChild() {
                return child;
            }

            public void setChild(List<ChildBean> child) {
                this.child = child;
            }

            public static class ChildBean {
                /**
                 * id : 12
                 * title : 小面包
                 * btn : 取货
                 * content : 上线中，敬请期待！
                 * home_type : 1
                 * pai_ui : 3
                 * yjhj : 2
                 * is_open : 1
                 * name : 小面包
                 * and_icon : /Public/icon/car/android/12.png
                 * ios_icon : /Public/icon/car/ios/12.png
                 */

                private String id;
                private String title;
                private String btn;
                private String content;
                private String home_type;
                private String pai_ui;
                private String yjhj;
                private String is_open;
                private String name;
                private String and_icon;
                private String ios_icon;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getBtn() {
                    return btn;
                }

                public void setBtn(String btn) {
                    this.btn = btn;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getHome_type() {
                    return home_type;
                }

                public void setHome_type(String home_type) {
                    this.home_type = home_type;
                }

                public String getPai_ui() {
                    return pai_ui;
                }

                public void setPai_ui(String pai_ui) {
                    this.pai_ui = pai_ui;
                }

                public String getYjhj() {
                    return yjhj;
                }

                public void setYjhj(String yjhj) {
                    this.yjhj = yjhj;
                }

                public String getIs_open() {
                    return is_open;
                }

                public void setIs_open(String is_open) {
                    this.is_open = is_open;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAnd_icon() {
                    return and_icon;
                }

                public void setAnd_icon(String and_icon) {
                    this.and_icon = and_icon;
                }

                public String getIos_icon() {
                    return ios_icon;
                }

                public void setIos_icon(String ios_icon) {
                    this.ios_icon = ios_icon;
                }
            }
        }
    }
}
