package com.tryine.zzp.entity.test.remote;

/**
 * Created by Administrator on 2017/11/23 0023.
 */

public class User extends BaseRemote {

    public User() {
    }

    public User(UserInfo userInfo, UserToken userToken) {
        this.userInfo = userInfo;
        this.userToken = userToken;
    }

    @Override
    public String toString() {
        return "User{" +
                "userInfo=" + userInfo +
                ", userToken=" + userToken +
                '}';
    }

    private UserInfo userInfo;
    private UserToken userToken;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserToken getUserToken() {
        return userToken;
    }


    public void setUserToken(UserToken userToken) {
        this.userToken = userToken;
    }

    public static class UserInfo {
        private String user_id;
        private String account;
        private String password;
        private String face;
        private String ext0;
        private String ext_account;
        private String ext_mobile;
        private String nickname;
        private String integral;
        private String money;
        private String rank_id;
        private String gold;
        private String frozen;
        private String is_agent;
        private String is_pay;
        private String pay_money;
        private String reg_time;
        private String reg_ip;
        private String last_time;
        private String frozen_time;
        private String closed;
        private String uc_id;
        private String email;
        private String mobile;
        private String ping_num;
        private String post_num;
        private String invite1;
        private String invite2;
        private String invite3;

        public UserInfo() {
        }

        public UserInfo(String user_id,
                        String account,
                        String password,
                        String face,
                        String ext0,
                        String ext_account,
                        String ext_mobile,
                        String nickname,
                        String integral,
                        String money,
                        String rank_id,
                        String gold,
                        String frozen,
                        String is_agent,
                        String is_pay,
                        String pay_money,
                        String reg_time,
                        String reg_ip,
                        String last_time,
                        String frozen_time,
                        String closed,
                        String uc_id,
                        String email,
                        String mobile,
                        String ping_num,
                        String post_num,
                        String invite1,
                        String invite2,
                        String invite3) {
            this.user_id = user_id;
            this.account = account;
            this.password = password;
            this.face = face;
            this.ext0 = ext0;
            this.ext_account = ext_account;
            this.ext_mobile = ext_mobile;
            this.nickname = nickname;
            this.integral = integral;
            this.money = money;
            this.rank_id = rank_id;
            this.gold = gold;
            this.frozen = frozen;
            this.is_agent = is_agent;
            this.is_pay = is_pay;
            this.pay_money = pay_money;
            this.reg_time = reg_time;
            this.reg_ip = reg_ip;
            this.last_time = last_time;
            this.frozen_time = frozen_time;
            this.closed = closed;
            this.uc_id = uc_id;
            this.email = email;
            this.mobile = mobile;
            this.ping_num = ping_num;
            this.post_num = post_num;
            this.invite1 = invite1;
            this.invite2 = invite2;
            this.invite3 = invite3;
        }

        @Override
        public String toString() {
            return "UserInfo{" +
                    "user_id='" + user_id + '\'' +
                    ", account='" + account + '\'' +
                    ", password='" + password + '\'' +
                    ", face='" + face + '\'' +
                    ", ext0='" + ext0 + '\'' +
                    ", ext_account='" + ext_account + '\'' +
                    ", ext_mobile='" + ext_mobile + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", integral='" + integral + '\'' +
                    ", money='" + money + '\'' +
                    ", rank_id='" + rank_id + '\'' +
                    ", gold='" + gold + '\'' +
                    ", frozen='" + frozen + '\'' +
                    ", is_agent='" + is_agent + '\'' +
                    ", is_pay='" + is_pay + '\'' +
                    ", pay_money='" + pay_money + '\'' +
                    ", reg_time='" + reg_time + '\'' +
                    ", reg_ip='" + reg_ip + '\'' +
                    ", last_time='" + last_time + '\'' +
                    ", frozen_time='" + frozen_time + '\'' +
                    ", closed='" + closed + '\'' +
                    ", uc_id='" + uc_id + '\'' +
                    ", email='" + email + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", ping_num='" + ping_num + '\'' +
                    ", post_num='" + post_num + '\'' +
                    ", invite1='" + invite1 + '\'' +
                    ", invite2='" + invite2 + '\'' +
                    ", invite3='" + invite3 + '\'' +
                    '}';
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public String getExt0() {
            return ext0;
        }

        public void setExt0(String ext0) {
            this.ext0 = ext0;
        }

        public String getExt_account() {
            return ext_account;
        }

        public void setExt_account(String ext_account) {
            this.ext_account = ext_account;
        }

        public String getExt_mobile() {
            return ext_mobile;
        }

        public void setExt_mobile(String ext_mobile) {
            this.ext_mobile = ext_mobile;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public String getRank_id() {
            return rank_id;
        }

        public void setRank_id(String rank_id) {
            this.rank_id = rank_id;
        }

        public String getGold() {
            return gold;
        }

        public void setGold(String gold) {
            this.gold = gold;
        }

        public String getFrozen() {
            return frozen;
        }

        public void setFrozen(String frozen) {
            this.frozen = frozen;
        }

        public String getIs_agent() {
            return is_agent;
        }

        public void setIs_agent(String is_agent) {
            this.is_agent = is_agent;
        }

        public String getIs_pay() {
            return is_pay;
        }

        public void setIs_pay(String is_pay) {
            this.is_pay = is_pay;
        }

        public String getPay_money() {
            return pay_money;
        }

        public void setPay_money(String pay_money) {
            this.pay_money = pay_money;
        }

        public String getReg_time() {
            return reg_time;
        }

        public void setReg_time(String reg_time) {
            this.reg_time = reg_time;
        }

        public String getReg_ip() {
            return reg_ip;
        }

        public void setReg_ip(String reg_ip) {
            this.reg_ip = reg_ip;
        }

        public String getLast_time() {
            return last_time;
        }

        public void setLast_time(String last_time) {
            this.last_time = last_time;
        }

        public String getFrozen_time() {
            return frozen_time;
        }

        public void setFrozen_time(String frozen_time) {
            this.frozen_time = frozen_time;
        }

        public String getClosed() {
            return closed;
        }

        public void setClosed(String closed) {
            this.closed = closed;
        }

        public String getUc_id() {
            return uc_id;
        }

        public void setUc_id(String uc_id) {
            this.uc_id = uc_id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPing_num() {
            return ping_num;
        }

        public void setPing_num(String ping_num) {
            this.ping_num = ping_num;
        }

        public String getPost_num() {
            return post_num;
        }

        public void setPost_num(String post_num) {
            this.post_num = post_num;
        }

        public String getInvite1() {
            return invite1;
        }

        public void setInvite1(String invite1) {
            this.invite1 = invite1;
        }

        public String getInvite2() {
            return invite2;
        }

        public void setInvite2(String invite2) {
            this.invite2 = invite2;
        }

        public String getInvite3() {
            return invite3;
        }

        public void setInvite3(String invite3) {
            this.invite3 = invite3;
        }


    }

    public static class UserToken {
        private String token;
        private String uid;

        public UserToken() {
        }

        public UserToken(String token, String uid) {
            this.token = token;
            this.uid = uid;
        }

        @Override
        public String toString() {
            return "UserToken{" +
                    "token='" + token + '\'' +
                    ", uid='" + uid + '\'' +
                    '}';
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }

}
