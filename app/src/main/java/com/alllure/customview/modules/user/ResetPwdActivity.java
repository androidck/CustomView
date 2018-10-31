package com.alllure.customview.modules.user;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alllure.customview.R;
import com.alllure.customview.common.base.BaseActivity;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 重置密码
 */
public class ResetPwdActivity extends BaseActivity {

    @BindView(R.id.topbar)
    QMUITopBar topbar;
    @BindView(R.id.ed_phone)
    EditText edPhone;
    @BindView(R.id.ed_code)
    EditText edCode;
    @BindView(R.id.tv_get_msg)
    TextView tvGetMsg;
    @BindView(R.id.btn_next)
    QMUIRoundButton btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarLightMode(this);
        setContentView(R.layout.reset_layout);
        ButterKnife.bind(this);
        initTopBar();
    }

    @Override
    protected void initTopBar() {
        topbar.setTitle("重置密码");
        topbar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
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

    @OnClick({R.id.tv_get_msg, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_get_msg:
                break;
            case R.id.btn_next:
                break;
        }
    }
}
