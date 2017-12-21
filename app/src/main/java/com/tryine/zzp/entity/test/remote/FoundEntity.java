package com.tryine.zzp.entity.test.remote;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21 0021.
 */

public class FoundEntity extends BaseRemote {

    /**
     * info : {"img":[{"photo":"zzp.dreamhup.com/attachs/default/2017/11/30/5a1fb90d76f5b.jpg","link_url":"","title":"第一张banner"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/30/5a1fb9728e581.jpeg","link_url":"","title":"第二张banner"},{"photo":"zzp.dreamhup.com/attachs/default/2017/11/30/5a1fb999465ff.png","link_url":"","title":"第三张banner"}],"city":[{"city_id":"8","name":"岳阳","photo":""},{"city_id":"2","name":"长沙","photo":"zzp.dreamhup.com/attachs/2016/09/04/57cbceb632cc0.jpg"}],"post":[{"post_id":"3","pic":"zzp.dreamhup.com/attachs/default/2017/10/16/59e440fbb96d7.jpg","city":"长沙","title":"dsadsads","face":"zzp.dreamhup.com/attachs/default/2017/10/20/59e9b7351f755.png","zan_num":"1","views":"10"},{"post_id":"5","pic":"zzp.dreamhup.com/attachs/default/2017/10/16/59e4698b871d6.jpg","city":"长沙","title":"ddddddddddddddd","face":"zzp.dreamhup.com/attachs/default/2017/12/14/5a3204e82feea.jpg","zan_num":"0","views":"190"},{"post_id":"7","pic":"zzp.dreamhup.com/attachs/default/2017/10/16/59e45f7f5a686.jpg","city":"长沙","title":"1吱吱吱吱吱吱","face":"zzp.dreamhup.com/attachs/default/2017/10/20/59e9b7351f755.png","zan_num":"5","views":"49"},{"post_id":"4","pic":"zzp.dreamhup.com/attachs/default/2017/10/16/59e441498dd62.jpg","city":"长沙","title":"qqqqqqqqqq","face":"zzp.dreamhup.com/attachs/default/2017/10/20/59e9b76037cdc.jpg","zan_num":"1","views":"7"}],"answer":[{"post_id":"22","img":"http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e692848c4.jpg","city":"长沙","title":"qqqqqqqqqq","face":"zzp.dreamhup.com/attachs/default/2017/10/20/59e9b76037cdc.jpg","account":"15200381387","reply_num":"0","views":"7"},{"post_id":"23","img":"http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e66c058b9.jpg","city":"长沙","title":"qqqqqqqqqq","face":"zzp.dreamhup.com/attachs/default/2017/10/20/59e9b76037cdc.jpg","account":"15200381387","reply_num":"0","views":"7"}],"article":[{"article_id":"3","title":"DASD","profiles":"方芳芳防守对方","photo":"zzp.dreamhup.com/attachs/default/2017/10/19/59e8759182513.jpg","views":"295"},{"article_id":"1","title":"玩味旅舍，为台湾设计师实践梦想的基地","profiles":"玩味旅舍应该是台湾比较有名的民宿，总共有五间不同主题的房间，每间都由台湾本土设计师参与室内和产品设计，我们想体验不同的房型，所以挑了最感兴趣的502未来旅舍（恶趣味十足的一间房，具体如何就不剧透了，大家有机会可以","photo":"zzp.dreamhup.com/attachs/default/2017/10/13/59e06b4761232.jpg","views":"140"}],"hotel":[{"hotel_id":"1","hotel_name":"中国城戴斯大酒店","photo":"zzp.dreamhup.com/attachs/default/2017/10/27/59f2c32e6f000.jpg","price":"99","city_id":"长沙","area_id":"岳麓区","addr":"长沙市芙蓉区","star":"2"},{"hotel_id":"2","hotel_name":"酒店测试2","photo":"zzp.dreamhup.com/attachs/default/2017/10/12/59df1f16a50ca.jpg","price":"99","city_id":"长沙","area_id":"岳麓区","addr":"酒店地址2","star":"5"},{"hotel_id":"4","hotel_name":"酒店测试3","photo":"zzp.dreamhup.com/attachs/default/2017/10/17/59e56d85ee52a.jpg","price":"159","city_id":"长沙","area_id":"天心区","addr":"酒店地址44444","star":"4"},{"hotel_id":"5","hotel_name":"岳阳酒店","photo":"zzp.dreamhup.com/attachs/default/2017/11/16/5a0d5c1e04d01.jpg","price":"99","city_id":"岳阳","area_id":"岳阳楼区","addr":"打扫打扫","star":"5"}]}
     */

    private InfoBean info;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {
        private List<ImgBean> img;
        private List<CityBean> city;
        private List<PostBean> post;
        private List<AnswerBean> answer;
        private List<ArticleBean> article;
        private List<HotelBean> hotel;

        public List<ImgBean> getImg() {
            return img;
        }

        public void setImg(List<ImgBean> img) {
            this.img = img;
        }

        public List<CityBean> getCity() {
            return city;
        }

        public void setCity(List<CityBean> city) {
            this.city = city;
        }

        public List<PostBean> getPost() {
            return post;
        }

        public void setPost(List<PostBean> post) {
            this.post = post;
        }

        public List<AnswerBean> getAnswer() {
            return answer;
        }

        public void setAnswer(List<AnswerBean> answer) {
            this.answer = answer;
        }

        public List<ArticleBean> getArticle() {
            return article;
        }

        public void setArticle(List<ArticleBean> article) {
            this.article = article;
        }

        public List<HotelBean> getHotel() {
            return hotel;
        }

        public void setHotel(List<HotelBean> hotel) {
            this.hotel = hotel;
        }

        public static class ImgBean {
            /**
             * photo : zzp.dreamhup.com/attachs/default/2017/11/30/5a1fb90d76f5b.jpg
             * link_url :
             * title : 第一张banner
             */

            private String photo;
            private String link_url;
            private String title;

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getLink_url() {
                return link_url;
            }

            public void setLink_url(String link_url) {
                this.link_url = link_url;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class CityBean {
            /**
             * city_id : 8
             * name : 岳阳
             * photo :
             */

            private String city_id;
            private String name;
            private String photo;

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }

        public static class PostBean {
            /**
             * post_id : 3
             * pic : zzp.dreamhup.com/attachs/default/2017/10/16/59e440fbb96d7.jpg
             * city : 长沙
             * title : dsadsads
             * face : zzp.dreamhup.com/attachs/default/2017/10/20/59e9b7351f755.png
             * zan_num : 1
             * views : 10
             */

            private String post_id;
            private String pic;
            private String city;
            private String title;
            private String face;
            private String zan_num;
            private String views;

            public String getPost_id() {
                return post_id;
            }

            public void setPost_id(String post_id) {
                this.post_id = post_id;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getFace() {
                return face;
            }

            public void setFace(String face) {
                this.face = face;
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
        }

        public static class AnswerBean {
            /**
             * post_id : 22
             * img : http://www.zhongguocheng.net:8080/attachs/editor/2017/10/18/thumb_59e6e692848c4.jpg
             * city : 长沙
             * title : qqqqqqqqqq
             * face : zzp.dreamhup.com/attachs/default/2017/10/20/59e9b76037cdc.jpg
             * account : 15200381387
             * reply_num : 0
             * views : 7
             */

            private String post_id;
            private String img;
            private String city;
            private String title;
            private String face;
            private String account;
            private String reply_num;
            private String views;

            public String getPost_id() {
                return post_id;
            }

            public void setPost_id(String post_id) {
                this.post_id = post_id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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
        }

        public static class ArticleBean {
            /**
             * article_id : 3
             * title : DASD
             * profiles : 方芳芳防守对方
             * photo : zzp.dreamhup.com/attachs/default/2017/10/19/59e8759182513.jpg
             * views : 295
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
