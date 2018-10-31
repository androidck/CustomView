package com.alllure.customview.modules.transaction;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alllure.customview.R;
import com.alllure.customview.common.base.BaseActivity;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 交易记录
 */
public class TransactionRecord extends BaseActivity {


    @BindView(R.id.topbar)
    QMUITopBar topbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarLightMode(this);
        setContentView(R.layout.transaction_record);
        ButterKnife.bind(this);
        initTopBar();
    }


    @Override
    protected void initTopBar() {
        topbar.setTitle("交易管理");
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
