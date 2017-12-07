package com.tryine.zzp.entity.test.remote;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/12/6 0006.
 */

public class HotelListSelectEntity extends BaseRemote {

    /**
     * info : {"room":[{"id":1,"title":"双床房"},{"id":2,"title":"单人房"},{"id":3,"title":"大床房"},{"id":4,"title":"无烟房"}],"brand":[{"type":"2","title":"测试","orderby":"0","closed":"0"},{"type":"3","title":"宝格丽","orderby":"0","closed":"0"},{"type":"4","title":"安纳塔拉","orderby":"0","closed":"0"}],"service":[{"service_id":"1","name":"无线WIFI","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon58.png","desc":"支持无线WIFI","sort_order":"22","status":"1"},{"service_id":"2","name":"停车场","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon54.png","desc":"停车场","sort_order":"11","status":"1"},{"service_id":"3","name":"早餐","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon55.png","desc":"早餐","sort_order":"0","status":"1"},{"service_id":"4","name":"专车接送","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon56.png","desc":"专车接送啦","sort_order":"0","status":"1"},{"service_id":"5","name":"加油站","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon57.png","desc":"免费加油啊","sort_order":"0","status":"1"}]}
     */

    private InfoBean info;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {
        private List<RoomBean> room;
        private List<BrandBean> brand;
        private List<ServiceBean> service;

        public List<RoomBean> getRoom() {
            return room;
        }

        public void setRoom(List<RoomBean> room) {
            this.room = room;
        }

        public List<BrandBean> getBrand() {
            return brand;
        }

        public void setBrand(List<BrandBean> brand) {
            this.brand = brand;
        }

        public List<ServiceBean> getService() {
            return service;
        }

        public void setService(List<ServiceBean> service) {
            this.service = service;
        }

        public static class RoomBean {
            /**
             * id : 1
             * title : 双床房
             */

            private int id;
            private String title;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class BrandBean {
            /**
             * type : 2
             * title : 测试
             * orderby : 0
             * closed : 0
             */

            private String type;
            private String title;
            private String orderby;
            private String closed;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getOrderby() {
                return orderby;
            }

            public void setOrderby(String orderby) {
                this.orderby = orderby;
            }

            public String getClosed() {
                return closed;
            }

            public void setClosed(String closed) {
                this.closed = closed;
            }
        }

        public static class ServiceBean {
            /**
             * service_id : 1
             * name : 无线WIFI
             * ico : zzp.dreamhup.com/themes/default/Pchome/statics/img/icon58.png
             * desc : 支持无线WIFI
             * sort_order : 22
             * status : 1
             */

            private String service_id;
            private String name;
            private String ico;
            private String desc;
            private String sort_order;
            @SerializedName("status")
            private String statusX;

            public String getService_id() {
                return service_id;
            }

            public void setService_id(String service_id) {
                this.service_id = service_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIco() {
                return ico;
            }

            public void setIco(String ico) {
                this.ico = ico;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getSort_order() {
                return sort_order;
            }

            public void setSort_order(String sort_order) {
                this.sort_order = sort_order;
            }

            public String getStatusX() {
                return statusX;
            }

            public void setStatusX(String statusX) {
                this.statusX = statusX;
            }
        }
    }
}
