package com.alllure.customview.modules.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.alllure.customview.R;
import com.alllure.customview.common.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 我的
 */
public class MyFragment extends BaseFragment {


    @BindView(R.id.topbar)
    QMUITopBar topbar;
    Unbinder unbinder;

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.my_layout, null);
        unbinder = ButterKnife.bind(this, layout);
        initTopBar();
        return layout;
    }

    private void initTopBar(){
        topbar.setTitle("我的");
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
