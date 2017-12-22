package com.tryine.zzp.entity.test.remote;

import java.util.List;

/**
 * Created by Administrator on 2017/12/22 0022.
 */

public class FoodDetailEntity extends BaseRemote {

    /**
     * info : {"info":{"pic":"zzp.dreamhup.com/attachs/default/2017/10/16/59e442cfaa7a4.jpg","city_id":"长沙","title":"防守对方的手","user_id":"8","details":"<p>发射点发第三方<\/p>","tag":null,"create_time":"2017-10-13 15:48:52","reply_num":"2","zan_num":"13","views":"159","collect_num":"1","is_zan":0,"is_collect":0,"face":"zzp.dreamhup.com/attachs/default/2017/12/22/5a3c99966b5df.png","rank_name":"银牌会员","icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg","account":"15211076641"},"list":[{"reply_id":"1","user_id":"8","contents":"<p>dasd&nbsp;<\/p>","create_time":"2017-10-16 11:21:59","face":"zzp.dreamhup.com/attachs/default/2017/12/22/5a3c99966b5df.png","rank_name":"银牌会员","icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg","account":"15211076641","cont":"发生大幅度"},{"reply_id":"77","user_id":"8","contents":"发生的方式的","create_time":"2017-12-19 11:01:03","face":"zzp.dreamhup.com/attachs/default/2017/12/22/5a3c99966b5df.png","rank_name":"银牌会员","icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg","account":"15211076641","cont":""}],"num":"2","user":1023}
     */

    private InfoBeanX info;

    public InfoBeanX getInfo() {
        return info;
    }

    public void setInfo(InfoBeanX info) {
        this.info = info;
    }

    public static class InfoBeanX {
        /**
         * info : {"pic":"zzp.dreamhup.com/attachs/default/2017/10/16/59e442cfaa7a4.jpg","city_id":"长沙","title":"防守对方的手","user_id":"8","details":"<p>发射点发第三方<\/p>","tag":null,"create_time":"2017-10-13 15:48:52","reply_num":"2","zan_num":"13","views":"159","collect_num":"1","is_zan":0,"is_collect":0,"face":"zzp.dreamhup.com/attachs/default/2017/12/22/5a3c99966b5df.png","rank_name":"银牌会员","icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg","account":"15211076641"}
         * list : [{"reply_id":"1","user_id":"8","contents":"<p>dasd&nbsp;<\/p>","create_time":"2017-10-16 11:21:59","face":"zzp.dreamhup.com/attachs/default/2017/12/22/5a3c99966b5df.png","rank_name":"银牌会员","icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg","account":"15211076641","cont":"发生大幅度"},{"reply_id":"77","user_id":"8","contents":"发生的方式的","create_time":"2017-12-19 11:01:03","face":"zzp.dreamhup.com/attachs/default/2017/12/22/5a3c99966b5df.png","rank_name":"银牌会员","icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg","account":"15211076641","cont":""}]
         * num : 2
         * user : 1023
         */

        private InfoBean info;
        private String num;
        private int user;
        private List<ListBean> list;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public int getUser() {
            return user;
        }

        public void setUser(int user) {
            this.user = user;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class InfoBean {
            /**
             * pic : zzp.dreamhup.com/attachs/default/2017/10/16/59e442cfaa7a4.jpg
             * city_id : 长沙
             * title : 防守对方的手
             * user_id : 8
             * details : <p>发射点发第三方</p>
             * tag : null
             * create_time : 2017-10-13 15:48:52
             * reply_num : 2
             * zan_num : 13
             * views : 159
             * collect_num : 1
             * is_zan : 0
             * is_collect : 0
             * face : zzp.dreamhup.com/attachs/default/2017/12/22/5a3c99966b5df.png
             * rank_name : 银牌会员
             * icon : zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg
             * account : 15211076641
             */

            private String pic;
            private String city_id;
            private String title;
            private String user_id;
            private String details;
            private Object tag;
            private String create_time;
            private String reply_num;
            private String zan_num;
            private String views;
            private String collect_num;
            private int is_zan;
            private int is_collect;
            private String face;
            private String rank_name;
            private String icon;
            private String account;

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getDetails() {
                return details;
            }

            public void setDetails(String details) {
                this.details = details;
            }

            public Object getTag() {
                return tag;
            }

            public void setTag(Object tag) {
                this.tag = tag;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getReply_num() {
                return reply_num;
            }

            public void setReply_num(String reply_num) {
                this.reply_num = reply_num;
            }

            public String getZan_num() {
                return zan_num;
            }

            public void setZan_num(String zan_num) {
                this.zan_num = zan_num;
            }

            public String getViews() {
                return views;
            }

            public void setViews(String views) {
                this.views = views;
            }

            public String getCollect_num() {
                return collect_num;
            }

            public void setCollect_num(String collect_num) {
                this.collect_num = collect_num;
            }

            public int getIs_zan() {
                return is_zan;
            }

            public void setIs_zan(int is_zan) {
                this.is_zan = is_zan;
            }

            public int getIs_collect() {
                return is_collect;
            }

            public void setIs_collect(int is_collect) {
                this.is_collect = is_collect;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
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

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }
        }

        public static class ListBean {
            /**
             * reply_id : 1
             * user_id : 8
             * contents : <p>dasd&nbsp;</p>
             * create_time : 2017-10-16 11:21:59
             * face : zzp.dreamhup.com/attachs/default/2017/12/22/5a3c99966b5df.png
             * rank_name : 银牌会员
             * icon : zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg
             * account : 15211076641
             * cont : 发生大幅度
             */

            private String reply_id;
            private String user_id;
            private String contents;
            private String create_time;
            private String face;
            private String rank_name;
            private String icon;
            private String account;
            private String cont;

            public String getReply_id() {
                return reply_id;
            }

            public void setReply_id(String reply_id) {
                this.reply_id = reply_id;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getContents() {
                return contents;
            }

            public void setContents(String contents) {
                this.contents = contents;
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

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getCont() {
                return cont;
            }

            public void setCont(String cont) {
                this.cont = cont;
            }
        }
    }
}
