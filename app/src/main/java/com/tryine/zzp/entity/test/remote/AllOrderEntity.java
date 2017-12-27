package com.tryine.zzp.entity.test.remote;

import java.util.List;

/**
 * Created by Administrator on 2017/12/27 0027.
 */

public class AllOrderEntity extends BaseRemote {

    /**
     * info : {"allnum":"1","payNum":"1","stayNum":"0","commentNum":"0","list":[{"order_id":"55","order_sn":"17121354671023","create_time":"2017-12-13","hotel_id":"1","amount":"200.00","order_status":"待付款","breakfast":null,"stime":"11-30","ltime":"11-30","num":"2","comment_status":"0","hotel_name":"中国城戴斯大酒店","photo":"zzp.dreamhup.com/attachs/default/2017/10/27/59f2c32e6f000.jpg","addr":"长沙市芙蓉区","score":null,"time_num":0}]}
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
         * allnum : 1
         * payNum : 1
         * stayNum : 0
         * commentNum : 0
         * list : [{"order_id":"55","order_sn":"17121354671023","create_time":"2017-12-13","hotel_id":"1","amount":"200.00","order_status":"待付款","breakfast":null,"stime":"11-30","ltime":"11-30","num":"2","comment_status":"0","hotel_name":"中国城戴斯大酒店","photo":"zzp.dreamhup.com/attachs/default/2017/10/27/59f2c32e6f000.jpg","addr":"长沙市芙蓉区","score":null,"time_num":0}]
         */

        private String allnum;
        private String payNum;
        private String stayNum;
        private String commentNum;
        private List<ListBean> list;

        public String getAllnum() {
            return allnum;
        }

        public void setAllnum(String allnum) {
            this.allnum = allnum;
        }

        public String getPayNum() {
            return payNum;
        }

        public void setPayNum(String payNum) {
            this.payNum = payNum;
        }

        public String getStayNum() {
            return stayNum;
        }

        public void setStayNum(String stayNum) {
            this.stayNum = stayNum;
        }

        public String getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(String commentNum) {
            this.commentNum = commentNum;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * order_id : 55
             * order_sn : 17121354671023
             * create_time : 2017-12-13
             * hotel_id : 1
             * amount : 200.00
             * order_status : 待付款
             * breakfast : null
             * stime : 11-30
             * ltime : 11-30
             * num : 2
             * comment_status : 0
             * hotel_name : 中国城戴斯大酒店
             * photo : zzp.dreamhup.com/attachs/default/2017/10/27/59f2c32e6f000.jpg
             * addr : 长沙市芙蓉区
             * score : null
             * time_num : 0
             */

            private String order_id;
            private String order_sn;
            private String create_time;
            private String hotel_id;
            private String amount;
            private String order_status;
            private Object breakfast;
            private String stime;
            private String ltime;
            private String num;
            private String comment_status;
            private String hotel_name;
            private String photo;
            private String addr;
            private Object score;
            private int time_num;

            public String getOrder_id() {
                return order_id;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
            }

            public String getOrder_sn() {
                return order_sn;
            }

            public void setOrder_sn(String order_sn) {
                this.order_sn = order_sn;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getHotel_id() {
                return hotel_id;
            }

            public void setHotel_id(String hotel_id) {
                this.hotel_id = hotel_id;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getOrder_status() {
                return order_status;
            }

            public void setOrder_status(String order_status) {
                this.order_status = order_status;
            }

            public Object getBreakfast() {
                return breakfast;
            }

            public void setBreakfast(Object breakfast) {
                this.breakfast = breakfast;
            }

            public String getStime() {
                return stime;
            }

            public void setStime(String stime) {
                this.stime = stime;
            }

            public String getLtime() {
                return ltime;
            }

            public void setLtime(String ltime) {
                this.ltime = ltime;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getComment_status() {
                return comment_status;
            }

            public void setComment_status(String comment_status) {
                this.comment_status = comment_status;
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

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public Object getScore() {
                return score;
            }

            public void setScore(Object score) {
                this.score = score;
            }

            public int getTime_num() {
                return time_num;
            }

            public void setTime_num(int time_num) {
                this.time_num = time_num;
            }
        }
    }
}
