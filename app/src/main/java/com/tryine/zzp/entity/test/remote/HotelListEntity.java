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
         * comment_count : 0
         * area_id : 岳阳楼区
         * hotel_id : 5
         * fav : null
         * tag :
         * star : 5
         * addr : 打扫打扫
         * hotel_name : 岳阳酒店
         * photo : zzp.dreamhup.com/attachs/default/2017/11/16/5a0d5c1e04d01.jpg
         * is_auction : 1
         * city_id : 岳阳
         * comment_score : 5.0
         * price : 99
         * comment_score_desc : 超棒
         */

        private String comment_count;
        private String area_id;
        private String hotel_id;
        private Object fav;
        private String tag;
        private String star;
        private String addr;
        private String hotel_name;
        private String photo;
        private String is_auction;
        private String city_id;
        private String comment_score;
        private String price;
        private String comment_score_desc;

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

        public Object getFav() {
            return fav;
        }

        public void setFav(Object fav) {
            this.fav = fav;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
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

        public String getComment_score() {
            return comment_score;
        }

        public void setComment_score(String comment_score) {
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
    }
}
