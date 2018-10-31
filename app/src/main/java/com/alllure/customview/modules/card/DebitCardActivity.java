package com.alllure.customview.modules.card;

import android.os.Bundle;
import android.view.View;

import com.alllure.customview.R;
import com.alllure.customview.common.base.BaseActivity;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 修改结算卡
 */
public class DebitCardActivity extends BaseActivity {

    @BindView(R.id.topbar)
    QMUITopBar topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debit_card);
        setStatusBarLightMode(this);
        ButterKnife.bind(this);
        initTopBar();
    }

    @Override
    protected void initTopBar() {
        topbar.setTitle("修改结算卡");
        topbar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popBackStack();
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
