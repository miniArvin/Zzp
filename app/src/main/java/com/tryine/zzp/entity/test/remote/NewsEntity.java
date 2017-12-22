package com.tryine.zzp.entity.test.remote;

import java.util.List;

/**
 * Created by Administrator on 2017/12/22 0022.
 */

public class NewsEntity extends BaseRemote {

    private List<InfoBean> info;

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * article_id : 1
         * title : 玩味旅舍，为台湾设计师实践梦想的基地
         * profiles : 玩味旅舍应该是台湾比较有名的民宿，总共有五间不同主题的房间，每间都由台湾本土设计师参与室内和产品设计，我们想体验不同的房型，所以挑了最感兴趣的502未来旅舍（恶趣味十足的一间房，具体如何就不剧透了，大家有机会可以
         * photo : zzp.dreamhup.com/attachs/default/2017/10/13/59e06b4761232.jpg
         * views : 140
         */

        private String article_id;
        private String title;
        private String profiles;
        private String photo;
        private String views;

        public String getArticle_id() {
            return article_id;
        }

        public void setArticle_id(String article_id) {
            this.article_id = article_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getProfiles() {
            return profiles;
        }

        public void setProfiles(String profiles) {
            this.profiles = profiles;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }
    }
}
