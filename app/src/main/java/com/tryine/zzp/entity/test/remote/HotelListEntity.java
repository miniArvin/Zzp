package com.tryine.zzp.entity.test.remote;

import java.util.List;

/**
 * Created by Administrator on 2017/12/5 0005.
 */

public class HotelListEntity extends BaseRemote {


    private List<InfoBean> info;

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * comment_count : 3
         * area_id : 岳麓区
         * hotel_id : 1
         * fav : null
         * tag : [{"tag_name":"干净卫生"},{"tag_name":"配套不错"},{"tag_name":"无线上网"}]
         * star : 2
         * addr : 长沙市芙蓉区
         * hotel_name : 中国城戴斯大酒店
         * photo : zzp.dreamhup.com/attachs/default/2017/10/27/59f2c32e6f000.jpg
         * is_auction : 1
         * city_id : 长沙
         * comment_score : 4.7
         * price : 99
         * comment_score_desc : 超棒
         */

        private String comment_count;
        private String area_id;
        private String hotel_id;
        private int fav;
        private String star;
        private String addr;
        private String hotel_name;
        private String photo;
        private String is_auction;
        private String city_id;
        private double comment_score;
        private String price;
        private String comment_score_desc;
        private List<TagBean> tag;

        public String getComment_count() {
            return comment_count;
        }

        public void setComment_count(String comment_count) {
            this.comment_count = comment_count;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getHotel_id() {
            return hotel_id;
        }

        public void setHotel_id(String hotel_id) {
            this.hotel_id = hotel_id;
        }

        public int getFav() {
            return fav;
        }

        public void setFav(int fav) {
            this.fav = fav;
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

        public String getIs_auction() {
            return is_auction;
        }

        public void setIs_auction(String is_auction) {
            this.is_auction = is_auction;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public double getComment_score() {
            return comment_score;
        }

        public void setComment_score(double comment_score) {
            this.comment_score = comment_score;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getComment_score_desc() {
            return comment_score_desc;
        }

        public void setComment_score_desc(String comment_score_desc) {
            this.comment_score_desc = comment_score_desc;
        }

        public List<TagBean> getTag() {
            return tag;
        }

        public void setTag(List<TagBean> tag) {
            this.tag = tag;
        }

        public static class TagBean {
            /**
             * tag_name : 干净卫生
             */

            private String tag_name;

            public String getTag_name() {
                return tag_name;
            }

            public void setTag_name(String tag_name) {
                this.tag_name = tag_name;
            }
        }
    }
}
