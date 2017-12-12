package com.tryine.zzp.entity.test.remote;

import java.util.List;

/**
 * Created by Administrator on 2017/12/11 0011.
 */

public class HotelAllCommentEntity extends BaseRemote {

    /**
     * info : {"score":{"comment_count":"3","comment_score_desc":"超棒","comment_score":4.7},"tag":[{"tag_id":"3","tag_name":"干净卫生","num":"3","sort_order":"0","comment_id":"5"},{"tag_id":"4","tag_name":"配套不错","num":"2","sort_order":"0","comment_id":"6"},{"tag_id":"2","tag_name":"服务好","num":"2","sort_order":"0","comment_id":"5"},{"tag_id":"5","tag_name":"无线上网","num":"1","sort_order":"0","comment_id":"8"},{"tag_id":"1","tag_name":"交通便利","num":"1","sort_order":"0","comment_id":"5"}],"apply":[{"user_id":"8","score":"4","content":"警方斯蒂芬斯蒂芬斯蒂芬发射点发斯蒂芬斯蒂芬第三方斯蒂芬斯蒂芬防守对方斯蒂芬","create_time":"2017-10-31","photo":[{"photo":"zzp.dreamhup.com/attachs/comment/201710/1509438237535948262.jpeg"},{"photo":"zzp.dreamhup.com/attachs/comment/201710/1509438237111184451.jpeg"}],"face":"zzp.dreamhup.com/attachs/default/2017/10/24/59eee3e84ddf4.jpg","nickname":"梦如江月的","rank_name":"银牌会员","icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg"},{"user_id":"3","score":"5","content":"第三方是对方","create_time":"2017-10-31","photo":[],"face":"zzp.dreamhup.com/attachs/default/2017/10/20/59e9b76037cdc.jpg","nickname":"中国城戴斯","rank_name":"铜牌会员","icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon102.png"},{"user_id":"1","score":"5","content":"哈哈哈哈哈哈哈","create_time":"2017-10-31","photo":[],"face":"","nickname":"123456@qq.com","rank_name":"铜牌会员","icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon102.png"}]}
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
         * score : {"comment_count":"3","comment_score_desc":"超棒","comment_score":4.7}
         * tag : [{"tag_id":"3","tag_name":"干净卫生","num":"3","sort_order":"0","comment_id":"5"},{"tag_id":"4","tag_name":"配套不错","num":"2","sort_order":"0","comment_id":"6"},{"tag_id":"2","tag_name":"服务好","num":"2","sort_order":"0","comment_id":"5"},{"tag_id":"5","tag_name":"无线上网","num":"1","sort_order":"0","comment_id":"8"},{"tag_id":"1","tag_name":"交通便利","num":"1","sort_order":"0","comment_id":"5"}]
         * apply : [{"user_id":"8","score":"4","content":"警方斯蒂芬斯蒂芬斯蒂芬发射点发斯蒂芬斯蒂芬第三方斯蒂芬斯蒂芬防守对方斯蒂芬","create_time":"2017-10-31","photo":[{"photo":"zzp.dreamhup.com/attachs/comment/201710/1509438237535948262.jpeg"},{"photo":"zzp.dreamhup.com/attachs/comment/201710/1509438237111184451.jpeg"}],"face":"zzp.dreamhup.com/attachs/default/2017/10/24/59eee3e84ddf4.jpg","nickname":"梦如江月的","rank_name":"银牌会员","icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/grade1.jpg"},{"user_id":"3","score":"5","content":"第三方是对方","create_time":"2017-10-31","photo":[],"face":"zzp.dreamhup.com/attachs/default/2017/10/20/59e9b76037cdc.jpg","nickname":"中国城戴斯","rank_name":"铜牌会员","icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon102.png"},{"user_id":"1","score":"5","content":"哈哈哈哈哈哈哈","create_time":"2017-10-31","photo":[],"face":"","nickname":"123456@qq.com","rank_name":"铜牌会员","icon":"zzp.dreamhup.com/themes/default/Pchome/statics/img/icon102.png"}]
         */

        private ScoreBean score;
        private List<TagBean> tag;
        private List<ApplyBean> apply;

        public ScoreBean getScore() {
            return score;
        }

        public void setScore(ScoreBean score) {
            this.score = score;
        }

        public List<TagBean> getTag() {
            return tag;
        }

        public void setTag(List<TagBean> tag) {
            this.tag = tag;
        }

        public List<ApplyBean> getApply() {
            return apply;
        }

        public void setApply(List<ApplyBean> apply) {
            this.apply = apply;
        }

        public static class ScoreBean {
            /**
             * comment_count : 3
             * comment_score_desc : 超棒
             * comment_score : 4.7
             */

            private String comment_count;
            private String comment_score_desc;
            private double comment_score;

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
        }

        public static class TagBean {
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
    }
}
