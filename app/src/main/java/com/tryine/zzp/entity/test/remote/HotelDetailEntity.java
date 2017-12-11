package com.tryine.zzp.entity.test.remote;

import java.util.List;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class HotelDetailEntity extends BaseRemote {

    /**
     * info : {"user_id":1024,"deposit":"0","hotel_detail":{"hotel_id":"1","hotel_name":"中国城戴斯大酒店","closed":"0","audit":"1","star":"2","is_auction":"1","open_date":"2017年","photo_total":"0","comment_count":"3","comment_score_desc":"超棒","comment_score":4.7,"tag":[{"tag_name":"干净卫生"},{"tag_name":"配套不错"},{"tag_name":"无线上网"}],"fav":0},"atlas":[{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8c99b43f.jpg"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8c9df19b.jpg"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8ca3296d.png"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8ca6a7a3.jpg"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8caac957.jpg"}],"banner":[{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8c99b43f.jpg"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8c9df19b.jpg"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8ca3296d.png"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8ca6a7a3.jpg"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8caac957.jpg"}],"hotel_intro":[{"name":"无线WIFI","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon58.png"},{"name":"停车场","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon54.png"},{"name":"早餐","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon55.png"},{"name":"专车接送","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon56.png"},{"name":"加油站","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon57.png"}],"room":[{"title":"标准单人房","photo":"zzp.dreamhup.com/attachs/default/2017/10/27/59f2fbcaca9f2.jpg","bed_type":"1.5床房","price":"99","is_auction":"1","sku":"153"},{"title":"标准双人房","photo":"zzp.dreamhup.com/attachs/default/2017/10/20/59e9ab36a3828.png","bed_type":"大床房","price":"188","is_auction":"0","sku":"0"}],"tag":[{"tag_id":"3","tag_name":"干净卫生","num":"3","sort_order":"0","comment_id":"5"},{"tag_id":"2","tag_name":"服务好","num":"2","sort_order":"0","comment_id":"5"},{"tag_id":"4","tag_name":"配套不错","num":"2","sort_order":"0","comment_id":"6"},{"tag_id":"1","tag_name":"交通便利","num":"1","sort_order":"0","comment_id":"5"},{"tag_id":"5","tag_name":"无线上网","num":"1","sort_order":"0","comment_id":"8"}],"apply":{"user_id":"8","score":"4","content":"警方斯蒂芬斯蒂芬斯蒂芬发射点发斯蒂芬斯蒂芬第三方斯蒂芬斯蒂芬防守对方斯蒂芬","create_time":"2017-10-31","photo":[{"photo":"zzp.dreamhup.com/attachs/comment/201710/1509438237535948262.jpeg"},{"photo":"zzp.dreamhup.com/attachs/comment/201710/1509438237111184451.jpeg"}],"face":"zzp.dreamhup.com/attachs/default/2017/10/24/59eee3e84ddf4.jpg","nickname":"梦如江月的","rank_name":"银牌会员","icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg"},"policy":[{"key_name":"入离时间","key_value":"入住时间：14:00以后        离店时间：12:00以前"},{"key_name":"早餐说明","key_value":"单早20元     双早35元"}],"hotel":[{"hotel_id":"1","hotel_name":"中国城戴斯大酒店","photo":"zzp.dreamhup.com/attachs/default/2017/10/27/59f2c32e6f000.jpg","price":"99","city_id":"长沙","area_id":"岳麓区","addr":"长沙市芙蓉区","star":"2"},{"hotel_id":"2","hotel_name":"酒店测试2","photo":"zzp.dreamhup.com/attachs/default/2017/10/12/59df1f16a50ca.jpg","price":"99","city_id":"长沙","area_id":"岳麓区","addr":"酒店地址2","star":"5"},{"hotel_id":"4","hotel_name":"酒店测试3","photo":"zzp.dreamhup.com/attachs/default/2017/10/17/59e56d85ee52a.jpg","price":"159","city_id":"长沙","area_id":"天心区","addr":"酒店地址44444","star":"4"},{"hotel_id":"5","hotel_name":"岳阳酒店","photo":"zzp.dreamhup.com/attachs/default/2017/11/16/5a0d5c1e04d01.jpg","price":"99","city_id":"岳阳","area_id":"岳阳楼区","addr":"打扫打扫","star":"5"}]}
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
         * user_id : 1024
         * deposit : 0
         * hotel_detail : {"hotel_id":"1","hotel_name":"中国城戴斯大酒店","closed":"0","audit":"1","star":"2","is_auction":"1","open_date":"2017年","photo_total":"0","comment_count":"3","comment_score_desc":"超棒","comment_score":4.7,"tag":[{"tag_name":"干净卫生"},{"tag_name":"配套不错"},{"tag_name":"无线上网"}],"fav":0}
         * atlas : [{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8c99b43f.jpg"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8c9df19b.jpg"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8ca3296d.png"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8ca6a7a3.jpg"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8caac957.jpg"}]
         * banner : [{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8c99b43f.jpg"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8c9df19b.jpg"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8ca3296d.png"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8ca6a7a3.jpg"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8caac957.jpg"}]
         * hotel_intro : [{"name":"无线WIFI","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon58.png"},{"name":"停车场","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon54.png"},{"name":"早餐","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon55.png"},{"name":"专车接送","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon56.png"},{"name":"加油站","ico":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon57.png"}]
         * room : [{"title":"标准单人房","photo":"zzp.dreamhup.com/attachs/default/2017/10/27/59f2fbcaca9f2.jpg","bed_type":"1.5床房","price":"99","is_auction":"1","sku":"153"},{"title":"标准双人房","photo":"zzp.dreamhup.com/attachs/default/2017/10/20/59e9ab36a3828.png","bed_type":"大床房","price":"188","is_auction":"0","sku":"0"}]
         * tag : [{"tag_id":"3","tag_name":"干净卫生","num":"3","sort_order":"0","comment_id":"5"},{"tag_id":"2","tag_name":"服务好","num":"2","sort_order":"0","comment_id":"5"},{"tag_id":"4","tag_name":"配套不错","num":"2","sort_order":"0","comment_id":"6"},{"tag_id":"1","tag_name":"交通便利","num":"1","sort_order":"0","comment_id":"5"},{"tag_id":"5","tag_name":"无线上网","num":"1","sort_order":"0","comment_id":"8"}]
         * apply : {"user_id":"8","score":"4","content":"警方斯蒂芬斯蒂芬斯蒂芬发射点发斯蒂芬斯蒂芬第三方斯蒂芬斯蒂芬防守对方斯蒂芬","create_time":"2017-10-31","photo":[{"photo":"zzp.dreamhup.com/attachs/comment/201710/1509438237535948262.jpeg"},{"photo":"zzp.dreamhup.com/attachs/comment/201710/1509438237111184451.jpeg"}],"face":"zzp.dreamhup.com/attachs/default/2017/10/24/59eee3e84ddf4.jpg","nickname":"梦如江月的","rank_name":"银牌会员","icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg"}
         * policy : [{"key_name":"入离时间","key_value":"入住时间：14:00以后        离店时间：12:00以前"},{"key_name":"早餐说明","key_value":"单早20元     双早35元"}]
         * hotel : [{"hotel_id":"1","hotel_name":"中国城戴斯大酒店","photo":"zzp.dreamhup.com/attachs/default/2017/10/27/59f2c32e6f000.jpg","price":"99","city_id":"长沙","area_id":"岳麓区","addr":"长沙市芙蓉区","star":"2"},{"hotel_id":"2","hotel_name":"酒店测试2","photo":"zzp.dreamhup.com/attachs/default/2017/10/12/59df1f16a50ca.jpg","price":"99","city_id":"长沙","area_id":"岳麓区","addr":"酒店地址2","star":"5"},{"hotel_id":"4","hotel_name":"酒店测试3","photo":"zzp.dreamhup.com/attachs/default/2017/10/17/59e56d85ee52a.jpg","price":"159","city_id":"长沙","area_id":"天心区","addr":"酒店地址44444","star":"4"},{"hotel_id":"5","hotel_name":"岳阳酒店","photo":"zzp.dreamhup.com/attachs/default/2017/11/16/5a0d5c1e04d01.jpg","price":"99","city_id":"岳阳","area_id":"岳阳楼区","addr":"打扫打扫","star":"5"}]
         */

        private int user_id;
        private int deposit;
        private HotelDetailBean hotel_detail;
        private ApplyBean apply;
        private List<AtlasBean> atlas;
        private List<BannerBean> banner;
        private List<HotelIntroBean> hotel_intro;
        private List<RoomBean> room;
        private List<TagBeanX> tag;
        private List<PolicyBean> policy;
        private List<HotelBean> hotel;

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getDeposit() {
            return deposit;
        }

        public void setDeposit(int deposit) {
            this.deposit = deposit;
        }

        public HotelDetailBean getHotel_detail() {
            return hotel_detail;
        }

        public void setHotel_detail(HotelDetailBean hotel_detail) {
            this.hotel_detail = hotel_detail;
        }

        public ApplyBean getApply() {
            return apply;
        }

        public void setApply(ApplyBean apply) {
            this.apply = apply;
        }

        public List<AtlasBean> getAtlas() {
            return atlas;
        }

        public void setAtlas(List<AtlasBean> atlas) {
            this.atlas = atlas;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<HotelIntroBean> getHotel_intro() {
            return hotel_intro;
        }

        public void setHotel_intro(List<HotelIntroBean> hotel_intro) {
            this.hotel_intro = hotel_intro;
        }

        public List<RoomBean> getRoom() {
            return room;
        }

        public void setRoom(List<RoomBean> room) {
            this.room = room;
        }

        public List<TagBeanX> getTag() {
            return tag;
        }

        public void setTag(List<TagBeanX> tag) {
            this.tag = tag;
        }

        public List<PolicyBean> getPolicy() {
            return policy;
        }

        public void setPolicy(List<PolicyBean> policy) {
            this.policy = policy;
        }

        public List<HotelBean> getHotel() {
            return hotel;
        }

        public void setHotel(List<HotelBean> hotel) {
            this.hotel = hotel;
        }

        public static class HotelDetailBean {
            /**
             * hotel_id : 1
             * hotel_name : 中国城戴斯大酒店
             * closed : 0
             * audit : 1
             * star : 2
             * is_auction : 1
             * open_date : 2017年
             * photo_total : 0
             * comment_count : 3
             * comment_score_desc : 超棒
             * comment_score : 4.7
             * tag : [{"tag_name":"干净卫生"},{"tag_name":"配套不错"},{"tag_name":"无线上网"}]
             * fav : 0
             */

            private String hotel_id;
            private String hotel_name;
            private String closed;
            private String audit;
            private String star;
            private String is_auction;
            private String open_date;
            private String photo_total;
            private String comment_count;
            private String comment_score_desc;
            private double comment_score;
            private int fav;
            private List<TagBean> tag;

            public String getHotel_id() {
                return hotel_id;
            }

            public void setHotel_id(String hotel_id) {
                this.hotel_id = hotel_id;
            }

            public String getHotel_name() {
                return hotel_name;
            }

            public void setHotel_name(String hotel_name) {
                this.hotel_name = hotel_name;
            }

            public String getClosed() {
                return closed;
            }

            public void setClosed(String closed) {
                this.closed = closed;
            }

            public String getAudit() {
                return audit;
            }

            public void setAudit(String audit) {
                this.audit = audit;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }

            public String getIs_auction() {
                return is_auction;
            }

            public void setIs_auction(String is_auction) {
                this.is_auction = is_auction;
            }

            public String getOpen_date() {
                return open_date;
            }

            public void setOpen_date(String open_date) {
                this.open_date = open_date;
            }

            public String getPhoto_total() {
                return photo_total;
            }

            public void setPhoto_total(String photo_total) {
                this.photo_total = photo_total;
            }

            public String getComment_count() {
                return comment_count;
            }

            public void setComment_count(String comment_count) {
                this.comment_count = comment_count;
            }

            public String getComment_score_desc() {
                return comment_score_desc;
            }

            public void setComment_score_desc(String comment_score_desc) {
                this.comment_score_desc = comment_score_desc;
            }

            public double getComment_score() {
                return comment_score;
            }

            public void setComment_score(double comment_score) {
                this.comment_score = comment_score;
            }

            public int getFav() {
                return fav;
            }

            public void setFav(int fav) {
                this.fav = fav;
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

        public static class ApplyBean {
            /**
             * user_id : 8
             * score : 4
             * content : 警方斯蒂芬斯蒂芬斯蒂芬发射点发斯蒂芬斯蒂芬第三方斯蒂芬斯蒂芬防守对方斯蒂芬
             * create_time : 2017-10-31
             * photo : [{"photo":"zzp.dreamhup.com/attachs/comment/201710/1509438237535948262.jpeg"},{"photo":"zzp.dreamhup.com/attachs/comment/201710/1509438237111184451.jpeg"}]
             * face : zzp.dreamhup.com/attachs/default/2017/10/24/59eee3e84ddf4.jpg
             * nickname : 梦如江月的
             * rank_name : 银牌会员
             * icon : zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg
             */

            private String user_id;
            private String score;
            private String content;
            private String create_time;
            private String face;
            private String nickname;
            private String rank_name;
            private String icon;
            private List<PhotoBean> photo;

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getRank_name() {
                return rank_name;
            }

            public void setRank_name(String rank_name) {
                this.rank_name = rank_name;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public List<PhotoBean> getPhoto() {
                return photo;
            }

            public void setPhoto(List<PhotoBean> photo) {
                this.photo = photo;
            }

            public static class PhotoBean {
                /**
                 * photo : zzp.dreamhup.com/attachs/comment/201710/1509438237535948262.jpeg
                 */

                private String photo;

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }
            }
        }

        public static class AtlasBean {
            /**
             * photo : zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8c99b43f.jpg
             */

            private String photo;

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public static class BannerBean {
            /**
             * photo : zzp.dreamhup.com/attachs/default/2017/11/28/5a1cf8c99b43f.jpg
             */

            private String photo;

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public static class HotelIntroBean {
            /**
             * name : 无线WIFI
             * ico : zzp.dreamhup.com/themes/default/Pchome/statics/img/icon58.png
             */

            private String name;
            private String ico;

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
        }

        public static class RoomBean {
            /**
             * title : 标准单人房
             * photo : zzp.dreamhup.com/attachs/default/2017/10/27/59f2fbcaca9f2.jpg
             * bed_type : 1.5床房
             * price : 99
             * is_auction : 1
             * sku : 153
             */

            private String title;
            private String photo;
            private String bed_type;
            private String price;
            private String is_auction;
            private int sku;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getBed_type() {
                return bed_type;
            }

            public void setBed_type(String bed_type) {
                this.bed_type = bed_type;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getIs_auction() {
                return is_auction;
            }

            public void setIs_auction(String is_auction) {
                this.is_auction = is_auction;
            }

            public int getSku() {
                return sku;
            }

            public void setSku(int sku) {
                this.sku = sku;
            }
        }

        public static class TagBeanX {
            /**
             * tag_id : 3
             * tag_name : 干净卫生
             * num : 3
             * sort_order : 0
             * comment_id : 5
             */

            private String tag_id;
            private String tag_name;
            private String num;
            private String sort_order;
            private String comment_id;

            public String getTag_id() {
                return tag_id;
            }

            public void setTag_id(String tag_id) {
                this.tag_id = tag_id;
            }

            public String getTag_name() {
                return tag_name;
            }

            public void setTag_name(String tag_name) {
                this.tag_name = tag_name;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getSort_order() {
                return sort_order;
            }

            public void setSort_order(String sort_order) {
                this.sort_order = sort_order;
            }

            public String getComment_id() {
                return comment_id;
            }

            public void setComment_id(String comment_id) {
                this.comment_id = comment_id;
            }
        }

        public static class PolicyBean {
            /**
             * key_name : 入离时间
             * key_value : 入住时间：14:00以后        离店时间：12:00以前
             */

            private String key_name;
            private String key_value;

            public String getKey_name() {
                return key_name;
            }

            public void setKey_name(String key_name) {
                this.key_name = key_name;
            }

            public String getKey_value() {
                return key_value;
            }

            public void setKey_value(String key_value) {
                this.key_value = key_value;
            }
        }

        public static class HotelBean {
            /**
             * hotel_id : 1
             * hotel_name : 中国城戴斯大酒店
             * photo : zzp.dreamhup.com/attachs/default/2017/10/27/59f2c32e6f000.jpg
             * price : 99
             * city_id : 长沙
             * area_id : 岳麓区
             * addr : 长沙市芙蓉区
             * star : 2
             */

            private String hotel_id;
            private String hotel_name;
            private String photo;
            private String price;
            private String city_id;
            private String area_id;
            private String addr;
            private String star;

            public String getHotel_id() {
                return hotel_id;
            }

            public void setHotel_id(String hotel_id) {
                this.hotel_id = hotel_id;
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

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

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

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            public String getStar() {
                return star;
            }

            public void setStar(String star) {
                this.star = star;
            }
        }
    }
}
