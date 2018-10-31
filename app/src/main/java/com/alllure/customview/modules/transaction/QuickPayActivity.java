package com.alllure.customview.modules.transaction;

import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alllure.customview.R;
import com.alllure.customview.common.base.BaseActivity;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.zhy.autolayout.AutoLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 快捷交易
 */
public class QuickPayActivity extends BaseActivity {


    @BindView(R.id.topbar)
    QMUITopBar topbar;
    @BindView(R.id.ed_money)
    EditText edMoney;
    @BindView(R.id.tv_show_money)
    TextView tvShowMoney;
    @BindView(R.id.tv_show_rate)
    TextView tvShowRate;
    @BindView(R.id.tv_show_settle_rate)
    TextView tvShowSettleRate;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.buttom_menu)
    AutoLinearLayout buttomMenu;
    @BindView(R.id.pay_confirm)
    TextView payConfirm;

    QMUITipDialog tipDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qucik_transaction);
        setStatusBarLightMode(this);
        ButterKnife.bind(this);
        initTopBar();
        initView();
        initDate();
    }

    @Override
    protected void initTopBar() {
        topbar.setTitle("快捷收款");
        topbar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initView() {
        String str = "应结算金额：<font color=\"#5494ff\">￥0.00</font>";
        tvMoney.setText(Html.fromHtml(str));
    }

    @Override
    protected void initDate() {
        //监听输入内容变化
        edMoney.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //变化前
                Log.d("quick_pay输入前", start + "----" + count + "----" + after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                //变化中
                Log.d("quick_pay输入过程", start + "----" + count + "----" + after);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //变化后
            }
        });
    }

    @Override
    protected int getContextViewId() {
        return 0;
    }

    @OnClick(R.id.pay_confirm)
    public void onViewClicked() {
        tipDialog=new QMUITipDialog.Builder(mContext)
                .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                .setTipWord("正在加载")
                .create();
        tipDialog.show();
        payConfirm.postDelayed(new Runnable() {
            @Override
            public void run() {
                tipDialog.dismiss();
            }
        },1500);
    }
}
