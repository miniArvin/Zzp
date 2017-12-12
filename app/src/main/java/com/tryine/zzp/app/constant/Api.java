package com.tryine.zzp.app.constant;

/**
 * Created by Administrator on 2017/11/22 0022.
 */

public class Api {
    //测试服务器地址
    public static final String BASE_URL = "http://zzp.dreamhup.com/";


    //注册

    public static final String REGISTER = BASE_URL + "app/passport/register";

    //注册验证码

    public static final String CODE = BASE_URL + "app/passport/sendSmss";

    //登录
    public static final String LOGIN = BASE_URL + "app/passport/login";

    //个人中心
    public static final String PERSONAL = BASE_URL + "app/Pensonal/user_center";

    //安全中心
    public static final String SECURITYCENTER = BASE_URL + "app/security/security_center";


    //填写安全问题
    public static final String FILLANSWER = BASE_URL + "app/security/problem";

    //验证安全问题页面
    public static final String VERIFYQUESTION = BASE_URL +"app/security/validate_problem";

    //验证安全问题提交接口
    public static final String COMMITQUESTION = BASE_URL +"app/security/validate_problem_post";

    //验证方式
    public static final String VERITYTYPE = BASE_URL +"app/security/verify";

    //发送邮箱验证码
    public static final String EMAILCODE = BASE_URL +"app/security/send";

    //（修改）发送手机验证码
    public static final String PHONECODE = BASE_URL +"app/security/sendsmss1";

    //绑定邮箱
    public static final String BINDINGEMAIL = BASE_URL +"app/security/bind_email";

    //密保验证
    public static final String ENCRYPTED = BASE_URL +"app/security/verify_security";

    //账户信息
    public static final String ACCOUNTMESSAGE = BASE_URL +"app/news/user_detail";

    //设置
    public static final String SETTING = BASE_URL +"app/news/index";

    //消息中心
    public static final String MESSAGECENTER = BASE_URL +"app/news/information";

    //消息详情
    public static final String MESSAGEDETAIL = BASE_URL +"app/news/information_detail";

    //注销
    public static final String LOGOUT = BASE_URL +"app/passport/logout";

    //联系我们
    public static final String CONTACTUS = BASE_URL +"app/news/contact_us";

    //帮助中心
    public static final String HELPCENTER = BASE_URL +"app/news/helper";

    //帮助中心详情
    public static final String HELPCENTERDETAIL = BASE_URL +"app/news/helper_details";

    //首页
    public static final String HOME = BASE_URL +"app/index/home";

    //发现
    public static final String FOUND = BASE_URL +"app/index/finds";

    //酒店列表
    public static final String HOTELLIST = BASE_URL +"app/hotel/lists";

    //酒店详情
    public static final String HOTELDETAIL = BASE_URL +"app/hotel/detail";

    //酒店收藏
    public static final String HOTELCOLLECT = BASE_URL +"app/hotel/collet_hotel";

    //取消酒店收藏
    public static final String HOTELCANCELCOLLECT = BASE_URL +"app/hotel/cancel_collet_hotel";

    //筛选列表
    public static final String HOTELLISTSELECT = BASE_URL +"app/hotel/screen";

    //酒店详情——详情、设备
    public static final String HOTELDETAILEQUIPMENT = BASE_URL +"app/hotel/equipment";

    //酒店详情——评论
    public static final String HOTELDETAILCOMMENT = BASE_URL +"app/hotel/apply";
}
