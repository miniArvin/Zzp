package com.tryine.zzp.entity.test.remote;

import java.util.List;

/**
 * Created by Administrator on 2017/12/22 0022.
 */

public class AnswerEntity extends BaseRemote {

    /**
     * info : {"fine":{"post_id":"24","user_id":"7","city_id":"北京","title":"在线问答的测试66666","reply_num":"0","views":"3","face":"","account":null,"img":"http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e64539fb7.jpg"},"list":[{"post_id":"21","user_id":"10","city_id":"长沙","title":"在线问答在线问答在线问答","reply_num":"10","views":"210","face":"zzp.dreamhup.com/attachs/default/2017/10/20/59e9b7351f755.png","account":"18692201277","img":""},{"post_id":"20","user_id":"8","city_id":"北京","title":"在线问答","reply_num":"4","views":"23","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"22","user_id":"7","city_id":"长沙","title":"在线问答的测试","reply_num":"5","views":"44","face":"","account":null,"img":""},{"post_id":"23","user_id":"7","city_id":"长沙","title":"在线问答的测试22222","reply_num":"0","views":"7","face":"","account":null,"img":"http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e66c058b9.jpg"},{"post_id":"24","user_id":"7","city_id":"北京","title":"在线问答的测试66666","reply_num":"0","views":"3","face":"","account":null,"img":"http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e64539fb7.jpg"},{"post_id":"26","user_id":"8","city_id":"北京","title":"什么时候放假？？","reply_num":"2","views":"25","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"44","user_id":"8","city_id":"北京","title":"dasdasdsad","reply_num":"0","views":"0","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"30","user_id":"8","city_id":"北京","title":"审核测试审核测试ffffffff","reply_num":"0","views":"4","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"45","user_id":"8","city_id":"长沙","title":"qqqqq","reply_num":"0","views":"2","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"47","user_id":"1002","city_id":"北京","title":"我来测试问答","reply_num":"5","views":"14","face":"","account":null,"img":""},{"post_id":"52","user_id":"1021","city_id":"北京","title":"一顿瞎问","reply_num":"1","views":"3","face":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1d0f574672d.jpg","account":"肖测试","img":""},{"post_id":"53","user_id":"1001","city_id":"北京","title":"为什么要有悲欢离合？","reply_num":"1","views":"4","face":"zzp.dreamhup.com/attachs/default/2017/11/27/5a1bb81557ae3.jpg","account":"17336623698","img":"http://www.zhangzhongpai.com/attachs/editor/2017/12/13/thumb_5a30d02f3b192.png"},{"post_id":"54","user_id":"8","city_id":"北京","title":"悱恻的","reply_num":"0","views":"0","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"56","user_id":"8","city_id":"北京","title":"册书","reply_num":"0","views":"3","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"57","user_id":"8","city_id":"岳阳","title":"f斯蒂芬斯蒂芬地方","reply_num":"0","views":"2","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"41","user_id":"1001","city_id":"北京","title":"白点少(づ￣ 3￣)づ","reply_num":"2","views":"13","face":"zzp.dreamhup.com/attachs/default/2017/11/27/5a1bb81557ae3.jpg","account":"17336623698","img":""}]}
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
         * fine : {"post_id":"24","user_id":"7","city_id":"北京","title":"在线问答的测试66666","reply_num":"0","views":"3","face":"","account":null,"img":"http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e64539fb7.jpg"}
         * list : [{"post_id":"21","user_id":"10","city_id":"长沙","title":"在线问答在线问答在线问答","reply_num":"10","views":"210","face":"zzp.dreamhup.com/attachs/default/2017/10/20/59e9b7351f755.png","account":"18692201277","img":""},{"post_id":"20","user_id":"8","city_id":"北京","title":"在线问答","reply_num":"4","views":"23","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"22","user_id":"7","city_id":"长沙","title":"在线问答的测试","reply_num":"5","views":"44","face":"","account":null,"img":""},{"post_id":"23","user_id":"7","city_id":"长沙","title":"在线问答的测试22222","reply_num":"0","views":"7","face":"","account":null,"img":"http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e66c058b9.jpg"},{"post_id":"24","user_id":"7","city_id":"北京","title":"在线问答的测试66666","reply_num":"0","views":"3","face":"","account":null,"img":"http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e64539fb7.jpg"},{"post_id":"26","user_id":"8","city_id":"北京","title":"什么时候放假？？","reply_num":"2","views":"25","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"44","user_id":"8","city_id":"北京","title":"dasdasdsad","reply_num":"0","views":"0","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"30","user_id":"8","city_id":"北京","title":"审核测试审核测试ffffffff","reply_num":"0","views":"4","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"45","user_id":"8","city_id":"长沙","title":"qqqqq","reply_num":"0","views":"2","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"47","user_id":"1002","city_id":"北京","title":"我来测试问答","reply_num":"5","views":"14","face":"","account":null,"img":""},{"post_id":"52","user_id":"1021","city_id":"北京","title":"一顿瞎问","reply_num":"1","views":"3","face":"zzp.dreamhup.com/attachs/default/2017/11/28/5a1d0f574672d.jpg","account":"肖测试","img":""},{"post_id":"53","user_id":"1001","city_id":"北京","title":"为什么要有悲欢离合？","reply_num":"1","views":"4","face":"zzp.dreamhup.com/attachs/default/2017/11/27/5a1bb81557ae3.jpg","account":"17336623698","img":"http://www.zhangzhongpai.com/attachs/editor/2017/12/13/thumb_5a30d02f3b192.png"},{"post_id":"54","user_id":"8","city_id":"北京","title":"悱恻的","reply_num":"0","views":"0","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"56","user_id":"8","city_id":"北京","title":"册书","reply_num":"0","views":"3","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"57","user_id":"8","city_id":"岳阳","title":"f斯蒂芬斯蒂芬地方","reply_num":"0","views":"2","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","account":"15211076641","img":""},{"post_id":"41","user_id":"1001","city_id":"北京","title":"白点少(づ￣ 3￣)づ","reply_num":"2","views":"13","face":"zzp.dreamhup.com/attachs/default/2017/11/27/5a1bb81557ae3.jpg","account":"17336623698","img":""}]
         */

        private FineBean fine;
        private List<ListBean> list;

        public FineBean getFine() {
            return fine;
        }

        public void setFine(FineBean fine) {
            this.fine = fine;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class FineBean {
            /**
             * post_id : 24
             * user_id : 7
             * city_id : 北京
             * title : 在线问答的测试66666
             * reply_num : 0
             * views : 3
             * face :
             * account : null
             * img : http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e64539fb7.jpg
             */

            private String post_id;
            private String user_id;
            private String city_id;
            private String title;
            private String reply_num;
            private String views;
            private String face;
            private Object account;
            private String img;

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

            public String getReply_num() {
                return reply_num;
            }

            public void setReply_num(String reply_num) {
                this.reply_num = reply_num;
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

            public Object getAccount() {
                return account;
            }

            public void setAccount(Object account) {
                this.account = account;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }

        public static class ListBean {
            /**
             * post_id : 21
             * user_id : 10
             * city_id : 长沙
             * title : 在线问答在线问答在线问答
             * reply_num : 10
             * views : 210
             * face : zzp.dreamhup.com/attachs/default/2017/10/20/59e9b7351f755.png
             * account : 18692201277
             * img :
             */

            private String post_id;
            private String user_id;
            private String city_id;
            private String title;
            private String reply_num;
            private String views;
            private String face;
            private String account;
            private String img;

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

            public String getReply_num() {
                return reply_num;
            }

            public void setReply_num(String reply_num) {
                this.reply_num = reply_num;
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

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
