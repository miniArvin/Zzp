package com.tryine.zzp.ui.activity.mine.message;

import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.tryine.zzp.R;
import com.tryine.zzp.app.constant.Api;
import com.tryine.zzp.base.BaseStatusMActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Response;

public class WebViewActivity extends BaseStatusMActivity {
    private TextView view_head_title;
    private String content_id;
    private TextView web_view_tv;
    private String type;
    private WebView web_view_wb;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void afterOnCreate() {
        type=getIntent().getStringExtra("type");
        if (type.equals("0")) {
            content_id = getIntent().getStringExtra("content_id");
            loadMessage(Api.HELPCENTERDETAIL,"id");
        }else{
            content_id = type;
            loadMessage(Api.MEMBERSHIPCLAUSE,"content_id");
        }
        loadData();
    }

    public void loadData(){
        view_head_title= (TextView) findViewById(R.id.view_head_title);
        web_view_tv= (TextView) findViewById(R.id.web_view_tv);
        findViewById(R.id.view_head_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        web_view_wb = (WebView) findViewById(R.id.web_view_wb);
    }

    public void loadMessage(String url,String id){
        OkHttpUtils
                .post()
                .url(url)
                .addParams(id,content_id)
                .build()
                .execute(new Callback() {
                    @Override
                    public Object parseNetworkResponse(Response response, int id) throws Exception {
                        String string = response.body().string();
                        LogUtils.e(string);
                        return string;
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        LogUtils.e(e);
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                        try {
                            JSONObject jsonObject=new JSONObject(response.toString());
                            LogUtils.e(jsonObject);
                            if (jsonObject.getInt("status")==330) {
                                JSONObject list = new JSONObject(jsonObject.getString("list"));
                                if (!type.equals("1")) {
                                    CharSequence charSequence = Html.fromHtml(list.getString("contents"));
                                    web_view_tv.setText(charSequence);
                                    web_view_tv.setMovementMethod(LinkMovementMethod.getInstance());
                                }else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("<html>");
                                    sb.append("<head>");
                                    sb.append("<title></title>");
                                    sb.append("</head>");
                                    sb.append("<body>");
                                    sb.append(list.getString("contents"));
                                    sb.append("</body>");
                                    sb.append("</html>");
                                    web_view_wb.loadDataWithBaseURL(null,sb.toString(),"text/html","utf-8",null);
                                }

                                view_head_title.setText(list.getString("title"));
                            }else {
                                ToastUtils.showShort(jsonObject.getString("msg"));
                            }
                        }catch (Exception e){

                        }
                    }
                });
    }

//                    public String jsonStringConvert(String s){
//                        char[] temp = s.toCharArray();
//                        int n = temp.length;
//                        for(int i =0;i<n;i++){
//                            if(temp[i]==':'&&temp[i+1]=='"'){
//                                for(int j =i+2;j<n;j++){
//                    if(temp[j]=='"'){
//                        if(temp[j+1]!=',' &&  temp[j+1]!='}'){
//                            temp[j]='”';
//                        }else if(temp[j+1]==',' ||  temp[j+1]=='}'){
//                            break ;
//                        }
//                    }
//                }
//            }
//        }
//        return new String(temp);
//    }
//
//    public String replaceBlank(String str) {
//        String dest = "";
//        if (str != null) {
//            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
//            Matcher m = p.matcher(str);
//            dest = m.replaceAll("");
//            // Pattern p2 = Pattern.compile("\\s*\"");
//            // Matcher m2 = p2.matcher(dest);
//            // dest = m2.replaceAll("\'");
//            dest = dest.replace("=\"", "='");
//            p = Pattern.compile("\"\0*>");
//            m = p.matcher(dest);
//            dest = m.replaceAll(">'");
//        }
//        return dest;
//    }

}
