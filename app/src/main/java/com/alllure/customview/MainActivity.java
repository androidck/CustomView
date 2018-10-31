package com.alllure.customview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.alllure.customview.common.adapter.MyFragmentPagerAdapter;
import com.alllure.customview.common.base.BaseActivity;
import com.alllure.customview.modules.fragment.CustomerFragment;
import com.alllure.customview.modules.fragment.HomeFragment;
import com.alllure.customview.modules.fragment.MessageFragment;
import com.alllure.customview.modules.fragment.MyFragment;
import com.qmuiteam.qmui.widget.QMUIViewPager;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 主页面
 */
public class MainActivity extends BaseActivity {


    @BindView(R.id.viewPage)
    QMUIViewPager viewPage;
    @BindView(R.id.radio_community)
    RadioButton radioCommunity;
    @BindView(R.id.radio_messages)
    RadioButton radioMessages;
    @BindView(R.id.radio_collections)
    RadioButton radioCollections;
    @BindView(R.id.radio_aboutme)
    RadioButton radioAboutme;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;


    @Override
    protected int getContextViewId() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initDate();

    }

    @Override
    protected void initTopBar() {

    }

    @Override
    protected void initView() {
        //监听按钮组
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_community:
                        viewPage.setCurrentItem(0, false);
                        break;
                    case R.id.radio_messages:
                        viewPage.setCurrentItem(1, false);
                        break;
                    case R.id.radio_collections:
                        viewPage.setCurrentItem(2, false);
                        break;
                    case R.id.radio_aboutme:
                        viewPage.setCurrentItem(3, false);
                        break;
                }
            }
        });

        HomeFragment home=new HomeFragment();
        CustomerFragment customer=new CustomerFragment();
        MessageFragment message=new MessageFragment();
        MyFragment my=new MyFragment();

        //增加fragment
        List<Fragment> list=new ArrayList<>();
        list.add(home);
        list.add(customer);
        list.add(message);
        list.add(my);

        viewPage.setSwipeable(false);
        viewPage.setEnableLoop(false);
        //viewpage 选中监听
        viewPage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        radioGroup.check(R.id.radio_community);
                        break;
                    case 1:
                        radioGroup.check(R.id.radio_messages);
                        break;
                    case 2:
                        radioGroup.check(R.id.radio_collections);
                        break;
                    case 3:
                        radioGroup.check(R.id.radio_aboutme);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        viewPage.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),list));
    }

    @Override
    protected void initDate() {

    }




}
