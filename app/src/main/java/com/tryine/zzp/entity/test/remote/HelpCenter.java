package com.tryine.zzp.entity.test.remote;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4 0004.
 */

public class HelpCenter extends BaseRemote {


    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * title : 我准备在入住办理时间之外到店，我还可以办理入住吗？
         * content_id : 2
         */

        private String title;
        private String content_id;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }
    }
}
