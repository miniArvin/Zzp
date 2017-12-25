package com.tryine.zzp.entity.test.remote;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/12/5 0005.
 */

public class HomeEntity extends BaseRemote implements Serializable {

    private static final long serialVersionUID = 3563988033062559923L;
    /**
     * info : {"water":[{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a2629ed6da0b.jpg","title":"江南水乡","link_url":""},{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a2629e05fd4a.jpg","title":"江南春色","link_url":""}],"coastal_city":[{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a26298aa01e1.jpg","title":"沿海城市","link_url":""},{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a2629740572a.jpg","title":"岳阳楼","link_url":""}],"img":{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a262a4936aac.jpg","title":"中间广告位","link_url":""},"hotel":[{"city_id":"长沙","area_id":"岳麓区","price":"99","hotel_id":"1","star":"2","addr":"长沙市芙蓉区","hotel_name":"中国城戴斯大酒店","photo":"zzp.dreamhup.com/attachs/default/2017/10/27/59f2c32e6f000.jpg"},{"city_id":"长沙","area_id":"岳麓区","price":"99","hotel_id":"2","star":"5","addr":"酒店地址2","hotel_name":"酒店测试2","photo":"zzp.dreamhup.com/attachs/default/2017/10/12/59df1f16a50ca.jpg"},{"city_id":"长沙","area_id":"天心区","price":"159","hotel_id":"4","star":"4","addr":"酒店地址44444","hotel_name":"酒店测试3","photo":"zzp.dreamhup.com/attachs/default/2017/10/17/59e56d85ee52a.jpg"},{"city_id":"岳阳","area_id":"岳阳楼区","price":"99","hotel_id":"5","star":"5","addr":"打扫打扫","hotel_name":"岳阳酒店","photo":"zzp.dreamhup.com/attachs/default/2017/11/16/5a0d5c1e04d01.jpg"}],"historical_culture":[{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a2629cbd8120.jpg","title":"丽江","link_url":""},{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a2629bf5a980.jpg","title":"凤凰","link_url":""}],"gourmet_city":[{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a262a26ce8d7.jpg","title":"成都宽窄巷子","link_url":""},{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a262a182c493.jpg","title":"重庆特色小吃","link_url":""},{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a262a05cc593.jpg","title":"西安美食","link_url":""}],"banner":[{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a25fc9a7c6cf.jpg","title":"第一张banner","link_url":""},{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a25fcd418e35.jpg","title":"第二张banner","link_url":""},{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a25fcf27e249.jpg","title":"第三张banner","link_url":""}]}
     */

    private InfoBean info;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * water : [{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a2629ed6da0b.jpg","title":"江南水乡","link_url":""},{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a2629e05fd4a.jpg","title":"江南春色","link_url":""}]
         * coastal_city : [{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a26298aa01e1.jpg","title":"沿海城市","link_url":""},{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a2629740572a.jpg","title":"岳阳楼","link_url":""}]
         * img : {"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a262a4936aac.jpg","title":"中间广告位","link_url":""}
         * hotel : [{"city_id":"长沙","area_id":"岳麓区","price":"99","hotel_id":"1","star":"2","addr":"长沙市芙蓉区","hotel_name":"中国城戴斯大酒店","photo":"zzp.dreamhup.com/attachs/default/2017/10/27/59f2c32e6f000.jpg"},{"city_id":"长沙","area_id":"岳麓区","price":"99","hotel_id":"2","star":"5","addr":"酒店地址2","hotel_name":"酒店测试2","photo":"zzp.dreamhup.com/attachs/default/2017/10/12/59df1f16a50ca.jpg"},{"city_id":"长沙","area_id":"天心区","price":"159","hotel_id":"4","star":"4","addr":"酒店地址44444","hotel_name":"酒店测试3","photo":"zzp.dreamhup.com/attachs/default/2017/10/17/59e56d85ee52a.jpg"},{"city_id":"岳阳","area_id":"岳阳楼区","price":"99","hotel_id":"5","star":"5","addr":"打扫打扫","hotel_name":"岳阳酒店","photo":"zzp.dreamhup.com/attachs/default/2017/11/16/5a0d5c1e04d01.jpg"}]
         * historical_culture : [{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a2629cbd8120.jpg","title":"丽江","link_url":""},{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a2629bf5a980.jpg","title":"凤凰","link_url":""}]
         * gourmet_city : [{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a262a26ce8d7.jpg","title":"成都宽窄巷子","link_url":""},{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a262a182c493.jpg","title":"重庆特色小吃","link_url":""},{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a262a05cc593.jpg","title":"西安美食","link_url":""}]
         * banner : [{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a25fc9a7c6cf.jpg","title":"第一张banner","link_url":""},{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a25fcd418e35.jpg","title":"第二张banner","link_url":""},{"photo":"zzp.dreamhup.com/attachs/default/2017/12/05/5a25fcf27e249.jpg","title":"第三张banner","link_url":""}]
         */

        private ImgBean img;
        private List<WaterBean> water;
        private List<CoastalCityBean> coastal_city;
        private List<HotelBean> hotel;
        private List<HistoricalCultureBean> historical_culture;
        private List<GourmetCityBean> gourmet_city;
        private List<BannerBean> banner;

        public ImgBean getImg() {
            return img;
        }

        public void setImg(ImgBean img) {
            this.img = img;
        }

        public List<WaterBean> getWater() {
            return water;
        }

        public void setWater(List<WaterBean> water) {
            this.water = water;
        }

        public List<CoastalCityBean> getCoastal_city() {
            return coastal_city;
        }

        public void setCoastal_city(List<CoastalCityBean> coastal_city) {
            this.coastal_city = coastal_city;
        }

        public List<HotelBean> getHotel() {
            return hotel;
        }

        public void setHotel(List<HotelBean> hotel) {
            this.hotel = hotel;
        }

        public List<HistoricalCultureBean> getHistorical_culture() {
            return historical_culture;
        }

        public void setHistorical_culture(List<HistoricalCultureBean> historical_culture) {
            this.historical_culture = historical_culture;
        }

        public List<GourmetCityBean> getGourmet_city() {
            return gourmet_city;
        }

        public void setGourmet_city(List<GourmetCityBean> gourmet_city) {
            this.gourmet_city = gourmet_city;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public static class ImgBean implements Serializable {
            private static final long serialVersionUID = 5023966717647875862L;
            /**
             * photo : zzp.dreamhup.com/attachs/default/2017/12/05/5a262a4936aac.jpg
             * title : 中间广告位
             * link_url :
             */

            private String photo;
            private String title;
            private String link_url;

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }
        }

        public static class WaterBean implements Serializable {
            private static final long serialVersionUID = 8810795343580932005L;
            /**
             * photo : zzp.dreamhup.com/attachs/default/2017/12/05/5a2629ed6da0b.jpg
             * title : 江南水乡
             * link_url :
             */

            private String photo;
            private String title;
            private String link_url;

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }
        }

        public static class CoastalCityBean implements Serializable {
            private static final long serialVersionUID = 6030104639419535966L;
            /**
             * photo : zzp.dreamhup.com/attachs/default/2017/12/05/5a26298aa01e1.jpg
             * title : 沿海城市
             * link_url :
             */

            private String photo;
            private String title;
            private String link_url;

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }
        }

        public static class HotelBean implements Serializable {
            private static final long serialVersionUID = 5384613329876008757L;
            /**
             * city_id : 长沙
             * area_id : 岳麓区
             * price : 99
             * hotel_id : 1
             * star : 2
             * addr : 长沙市芙蓉区
             * hotel_name : 中国城戴斯大酒店
             * photo : zzp.dreamhup.com/attachs/default/2017/10/27/59f2c32e6f000.jpg
             */

            private String city_id;
            private String area_id;
            private String price;
            private String hotel_id;
            private String star;
            private String addr;
            private String hotel_name;
            private String photo;

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public String getArea_id() {
                return area_id;
            }

            public void setArea_id(String area_id) {
                this.area_id = area_id;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getHotel_id() {
                return hotel_id;
            }

            public void setHotel_id(String hotel_id) {
                this.hotel_id = hotel_id;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getHotel_name() {
                return hotel_name;
            }

            public void setHotel_name(String hotel_name) {
                this.hotel_name = hotel_name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public static class HistoricalCultureBean implements Serializable {
            private static final long serialVersionUID = -3815191018401571519L;
            /**
             * photo : zzp.dreamhup.com/attachs/default/2017/12/05/5a2629cbd8120.jpg
             * title : 丽江
             * link_url :
             */

            private String photo;
            private String title;
            private String link_url;

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }
        }

        public static class GourmetCityBean implements Serializable {
            private static final long serialVersionUID = -6841032198932691460L;
            /**
             * photo : zzp.dreamhup.com/attachs/default/2017/12/05/5a262a26ce8d7.jpg
             * title : 成都宽窄巷子
             * link_url :
             */

            private String photo;
            private String title;
            private String link_url;

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }
        }

        public static class BannerBean implements Serializable {
            private static final long serialVersionUID = -5522802291049144873L;
            /**
             * photo : zzp.dreamhup.com/attachs/default/2017/12/05/5a25fc9a7c6cf.jpg
             * title : 第一张banner
             * link_url :
             */

            private String photo;
            private String title;
            private String link_url;

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }
        }
    }
}
