package com.tryine.zzp.entity.test.remote;

import java.util.List;

/**
 * Created by Administrator on 2017/12/26 0026.
 */

public class OrderEntity extends BaseRemote {

    private List<InfoBean> info;

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * bed_type : 1.5床房
         * area_id : 岳麓区
         * stime : 11月30日
         * hotel_id : 1
         * breakfast : 1
         * addr : 长沙市芙蓉区
         * hotel_name : 中国城戴斯大酒店
         * photo : zzp.dreamhup.com/attachs/default/2017/10/27/59f2c32e6f000.jpg
         * order_status : 0
         * city_id : 长沙
         * amount : 200.00
         * title : 标准单人房
         * room_id : 2
         * ltime : 11月30日
         * order_sn : 17121354671023
         * night_num : 0
         */

        private String bed_type;
        private String area_id;
        private String stime;
        private String hotel_id;
        private String breakfast;
        private String addr;
        private String hotel_name;
        private String photo;
        private String order_status;
        private String city_id;
        private String amount;
        private String title;
        private String room_id;
        private String ltime;
        private String order_sn;
        private int night_num;

        public String getBed_type() {
            return bed_type;
        }

        public void setBed_type(String bed_type) {
            this.bed_type = bed_type;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getStime() {
            return stime;
        }

        public void setStime(String stime) {
            this.stime = stime;
        }

        public String getHotel_id() {
            return hotel_id;
        }

        public void setHotel_id(String hotel_id) {
            this.hotel_id = hotel_id;
        }

        public String getBreakfast() {
            return breakfast;
        }

        public void setBreakfast(String breakfast) {
            this.breakfast = breakfast;
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

        public String getOrder_status() {
            return order_status;
        }

        public void setOrder_status(String order_status) {
            this.order_status = order_status;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRoom_id() {
            return room_id;
        }

        public void setRoom_id(String room_id) {
            this.room_id = room_id;
        }

        public String getLtime() {
            return ltime;
        }

        public void setLtime(String ltime) {
            this.ltime = ltime;
        }

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public int getNight_num() {
            return night_num;
        }

        public void setNight_num(int night_num) {
            this.night_num = night_num;
        }
    }
}
