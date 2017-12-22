package com.tryine.zzp.entity.test.remote;

import java.util.List;

/**
 * Created by Administrator on 2017/12/22 0022.
 */

public class AnswerDetailEntity extends BaseRemote {

    /**
     * info : {"num":"0","list":[{"icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg","face":"zzp.dreamhup.com/attachs/default/2017/12/22/5a3ca93ae43a3.png","contents":"<p>大撒撒打算大撒旦撒<img src=\"http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e64539fb7.jpg\" _src=\"http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e64539fb7.jpg\"/><\/p>","reply_id":"15","create_time":"2017-10-18 13:27:34","account":"15211076641","rank_name":"银牌会员","user_id":"8","cont":""}],"info":{"city_id":"北京","icon":"zzp.dreamhup.com","face":"","title":"在线问答的测试66666","details":"<p>大叔大叔大叔大叔大叔大大大大<\/p>","views":"4","tag":"攻略,路线,美食","create_time":"2017-10-18 13:25:58","account":null,"rank_name":null,"user_id":"7","reply_num":"0"}}
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
         * num : 0
         * list : [{"icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg","face":"zzp.dreamhup.com/attachs/default/2017/12/22/5a3ca93ae43a3.png","contents":"<p>大撒撒打算大撒旦撒<img src=\"http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e64539fb7.jpg\" _src=\"http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e64539fb7.jpg\"/><\/p>","reply_id":"15","create_time":"2017-10-18 13:27:34","account":"15211076641","rank_name":"银牌会员","user_id":"8","cont":""}]
         * info : {"city_id":"北京","icon":"zzp.dreamhup.com","face":"","title":"在线问答的测试66666","details":"<p>大叔大叔大叔大叔大叔大大大大<\/p>","views":"4","tag":"攻略,路线,美食","create_time":"2017-10-18 13:25:58","account":null,"rank_name":null,"user_id":"7","reply_num":"0"}
         */

        private String num;
        private InfoBean info;
        private List<ListBean> list;

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class InfoBean {
            /**
             * city_id : 北京
             * icon : zzp.dreamhup.com
             * face :
             * title : 在线问答的测试66666
             * details : <p>大叔大叔大叔大叔大叔大大大大</p>
             * views : 4
             * tag : 攻略,路线,美食
             * create_time : 2017-10-18 13:25:58
             * account : null
             * rank_name : null
             * user_id : 7
             * reply_num : 0
             */

            private String city_id;
            private String icon;
            private String face;
            private String title;
            private String details;
            private String views;
            private String tag;
            private String create_time;
            private String account;
            private String rank_name;
            private String user_id;
            private String reply_num;

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDetails() {
                return details;
            }

            public void setDetails(String details) {
                this.details = details;
            }

            public String getViews() {
                return views;
            }

            public void setViews(String views) {
                this.views = views;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getRank_name() {
                return rank_name;
            }

            public void setRank_name(String rank_name) {
                this.rank_name = rank_name;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getReply_num() {
                return reply_num;
            }

            public void setReply_num(String reply_num) {
                this.reply_num = reply_num;
            }
        }

        public static class ListBean {
            /**
             * icon : zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg
             * face : zzp.dreamhup.com/attachs/default/2017/12/22/5a3ca93ae43a3.png
             * contents : <p>大撒撒打算大撒旦撒<img src="http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e64539fb7.jpg" _src="http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e64539fb7.jpg"/></p>
             * reply_id : 15
             * create_time : 2017-10-18 13:27:34
             * account : 15211076641
             * rank_name : 银牌会员
             * user_id : 8
             * cont :
             */

            private String icon;
            private String face;
            private String contents;
            private String reply_id;
            private String create_time;
            private String account;
            private String rank_name;
            private String user_id;
            private String cont;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
            }

            public String getContents() {
                return contents;
            }

            public void setContents(String contents) {
                this.contents = contents;
            }

            public String getReply_id() {
                return reply_id;
            }

            public void setReply_id(String reply_id) {
                this.reply_id = reply_id;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getRank_name() {
                return rank_name;
            }

            public void setRank_name(String rank_name) {
                this.rank_name = rank_name;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
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
