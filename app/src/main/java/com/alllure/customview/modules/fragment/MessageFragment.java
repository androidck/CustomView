package com.alllure.customview.modules.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.alllure.customview.R;
import com.alllure.customview.common.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 消息fragment
 */
public class MessageFragment extends BaseFragment {

    @BindView(R.id.topbar)
    QMUITopBar topbar;
    Unbinder unbinder;
    @BindView(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.message_layout, null);
        unbinder = ButterKnife.bind(this, layout);
        initTopBar();
        return layout;
    }

    private void initTopBar() {
        topbar.setTitle("消息中心");
    }

    @Override
    public void initView() {

    }

    @Override
    public void initDate() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
