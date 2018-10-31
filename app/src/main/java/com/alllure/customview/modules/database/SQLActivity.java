package com.alllure.customview.modules.database;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.alllure.customview.R;
import com.alllure.customview.common.base.BaseActivity;
import com.alllure.customview.common.database.DBUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SQLActivity extends BaseActivity {


    @BindView(R.id.getDate)
    Button getDate;
    @BindView(R.id.tv_id)
    TextView tvId;
    @BindView(R.id.tv_user)
    TextView tvUser;
    @BindView(R.id.tv_pass)
    TextView tvPass;

    @Override
    protected int getContextViewId() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sql_layout);
        ButterKnife.bind(this);
        new Thread(runnable).start();

    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle bundle=msg.getData();
            String user=bundle.getString("user");
            String pass=bundle.getString("pass");
            tvUser.setText(user);
            tvPass.setText(pass);
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            initDate();
        }
    };

    @Override
    protected void initTopBar() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initDate() {
        String sql = "select * from user";
        PreparedStatement pstmt = DBUtils.getPstmt(sql);
        try {
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            Integer id = rs.getInt("id");
            String user = rs.getString("user");
            String pass = rs.getString("pass");
            Bundle bundle=new Bundle();
            bundle.putString("user",user);
            bundle.putString("pass",pass);
            Message message=new Message();
            message.setData(bundle);
            handler.sendMessage(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
