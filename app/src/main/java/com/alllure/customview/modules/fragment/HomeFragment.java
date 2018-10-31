package com.alllure.customview.modules.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alllure.customview.R;
import com.alllure.customview.common.base.BaseFragment;
import com.alllure.customview.common.util.DateUtil;
import com.alllure.customview.modules.card.DebitCardActivity;
import com.alllure.customview.modules.transaction.TransactionRecord;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment {
    @BindView(R.id.tv_pos)
    TextView tvPos;
    @BindView(R.id.tv_shuangmian)
    TextView tvShuangmian;
    @BindView(R.id.tv_sm)
    TextView tvSm;
    @BindView(R.id.tv_shanshou)
    TextView tvShanshou;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    Unbinder unbinder;

    String str = null;
    @BindView(R.id.transaction_manage)
    QMUIRoundButton transactionManage;
    @BindView(R.id.modify_card)
    QMUIRoundButton modifyCard;

    @Override
    protected View onCreateView() {
        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.home_main, null);
        unbinder = ButterKnife.bind(this, layout);

        initView();
        return layout;
    }

    @Override
    public void initView() {
        tvDate.setText(DateUtil.getDate() + "(" + DateUtil.getWeekOfDate(new Date()) + ")");
    }

    @Override
    public void initDate() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_pos, R.id.tv_shuangmian, R.id.tv_sm, R.id.tv_shanshou, R.id.tv_money,R.id.transaction_manage,R.id.modify_card})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.tv_pos:
                break;
            case R.id.tv_shuangmian:
                break;
            case R.id.tv_sm:
                break;
            case R.id.tv_shanshou:
                break;
            case R.id.tv_money:
                break;
            case R.id.transaction_manage:
                intent=new Intent(getActivity(), TransactionRecord.class);
                startActivity(intent);
                break;
            case R.id.modify_card:
                intent=new Intent(getActivity(), DebitCardActivity.class);
                startActivity(intent);
                break;
        }
    }


}
