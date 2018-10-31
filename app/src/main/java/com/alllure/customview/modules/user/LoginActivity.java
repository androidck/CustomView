package com.alllure.customview.modules.user;

import android.os.Bundle;
import android.view.View;

import com.alllure.customview.R;
import com.alllure.customview.common.base.BaseActivity;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 用户登录
 */
public class LoginActivity extends BaseActivity {


    @BindView(R.id.topbar)
    QMUITopBar topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarLightMode(this);
        setContentView(R.layout.login_layout);
        ButterKnife.bind(this);
        initTopBar();
    }

    @Override
    protected void initTopBar() {
        topbar.setTitle("登录");
        topbar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        topbar.addRightTextButton("注册",R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initDate() {

    }

    @Override
    protected int getContextViewId() {
        return 0;
    }
}
