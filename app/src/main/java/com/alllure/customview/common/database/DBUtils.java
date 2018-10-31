package com.alllure.customview.common.database;

import android.util.Log;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库连接工具类
 */
public class DBUtils {

    public static Connection getConn(){
        //InputStream in =DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
       // Properties prop=new Properties();
        Connection conn=null;
        try {
           // prop.load(in);
            String driverClass="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://192.168.1.227:3306/bank?characterEncoding=utf-8";
            String username="root";
            String password="myzf8888";

            /*String driverClass=prop.getProperty("driverClass");
            String url=prop.getProperty("url");
            String username=prop.getProperty("username");
            String password=prop.getProperty("password");*/
            //注册驱动
            Class.forName(driverClass);
            conn= DriverManager.getConnection(url,username,password);
            Log.d("Connection",conn+"");
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static PreparedStatement getPstmt(String sql){
        Connection conn=getConn();
        PreparedStatement pstmt=null;
        try {
            pstmt= conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    //更新关闭
    public static void closeUpdateRes(PreparedStatement ps){
       if (ps!=null){
           try {
               Connection conn= ps.getConnection();
               ps.close();
               if (conn!=null){
                   conn.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
    }

    //查询关闭
    public static void closeQueryRes(ResultSet rs){
        if (rs!=null){
            Statement pstmt;
            try {
                pstmt=rs.getStatement();
                if (pstmt!=null){
                    Connection conn=pstmt.getConnection();
                    rs.close();
                    pstmt.close();
                    if (conn!=null){
                        conn.close();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
