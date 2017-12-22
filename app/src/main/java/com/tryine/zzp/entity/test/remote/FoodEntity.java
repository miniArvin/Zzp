package com.tryine.zzp.entity.test.remote;

import java.util.List;

/**
 * Created by Administrator on 2017/12/22 0022.
 */

public class FoodEntity extends BaseRemote {

    private List<InfoBean> info;

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * post_id : 1
         * user_id : 8
         * pic : zzp.dreamhup.com/attachs/default/2017/10/16/59e442cfaa7a4.jpg
         * city_id : 长沙
         * title : 防守对方的手
         * zan_num : 13
         * views : 104
         * face : zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg
         * is_zan : 0
         */

        private String post_id;
        private String user_id;
        private String pic;
        private String city_id;
        private String title;
        private String zan_num;
        private String views;
        private String face;
        private int is_zan;

        public String getPost_id() {
            return post_id;
        }

        public void setPost_id(String post_id) {
            this.post_id = post_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

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

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public int getIs_zan() {
            return is_zan;
        }

        public void setIs_zan(int is_zan) {
            this.is_zan = is_zan;
        }
    }
}
