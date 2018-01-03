package com.tryine.zzp.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.blankj.utilcode.util.ActivityUtils;
import com.othershe.nicedialog.BaseNiceDialog;
import com.othershe.nicedialog.ViewHolder;
import com.tryine.zzp.R;
import com.tryine.zzp.ui.activity.login.LoginActivity;
import com.tryine.zzp.utils.UIUtils;

/**
 * Created by Administrator on 2018/1/3 0003.
 */

public class IsloginDialog extends BaseNiceDialog {

    private String type;

    public static IsloginDialog newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        IsloginDialog dialog = new IsloginDialog();
        dialog.setArguments(bundle);
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        type = bundle.getString("type");
    }

    @Override
    public int intLayoutId() {
        return R.layout.islogin_item;
    }

    @Override
    public void convertView(ViewHolder viewHolder, final BaseNiceDialog baseNiceDialog) {
        if ("1".equals(type)) {
            viewHolder.setText(R.id.title, "提示");
            viewHolder.setText(R.id.message, "您尚未登录，是否前去登录？");
        } else if ("2".equals(type)) {
            viewHolder.setText(R.id.title, "警告");
            viewHolder.setText(R.id.message, "您的账号已被冻结！");
        }
        viewHolder.setOnClickListener(R.id.cancel, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseNiceDialog.dismiss();

            }
        });

        viewHolder.setOnClickListener(R.id.ok, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equals("1")) {
                    ActivityUtils.startActivity(LoginActivity.class);
                }
                baseNiceDialog.dismiss();
            }
        });
    }
}
