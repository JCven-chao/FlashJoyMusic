package com.team.flashjoymusic.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.team.flashjoymusic.data.Password;
import com.team.flashjoymusic.director.Director;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LoginController
{
    //对控件进行控制 比如点击事件
    @FXML
    private PasswordField textPassword;

    @FXML
    private Label labelTitle;

    @FXML
    private Button btnLogin;

    @FXML
    private Label labelNotice;


    @FXML
    void login(ActionEvent event) throws IOException, ParseException {
        //获取字符串
        String str="";
        String filePath="D:\\JavaProject\\FlashJoyMusic\\src\\main\\resources\\password\\password.txt";
        File file=new File(filePath);
        int readData=0;
        byte[] b=new byte[8];
        FileInputStream fileInputStream= null;
        try {
            fileInputStream = new FileInputStream(file);
            while((readData=fileInputStream.read(b))!=-1)
            {
                str+=new String(b,0,readData);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //字符串判断
        String[] s=str.split(",");
        switch(s[0])
        {
            case "1": {
                if (textPassword.getText().equals(s[1]) || textPassword.getText().equals(s[2])) {
                    Director.getInstance().loadLoginUI(new Stage());
                    Calendar c = Calendar.getInstance();
                    Date date = c.getTime();
                    //按yyyy-MM-dd hh:mm:ss 格式化对象
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    String time = simpleDateFormat.format(date);
                    time = "2" + "," + s[1] + "," + s[2] + "," + time;
                    //将时间字符串写进文件
                    FileOutputStream fileOutputStream = null;
                    try {
                        fileOutputStream = new FileOutputStream(filePath);
                        fileOutputStream.write(time.getBytes(), 0, time.length());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } finally {
                        fileOutputStream.close();
                    }
                } else labelNotice.setText("请输入密码！！！");
            }
            case "2":
            {
                //判断失效时间
                Calendar c = Calendar.getInstance();
                //按yyyy-MM-dd hh:mm:ss 格式化对象
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date t1=simpleDateFormat.parse(s[3]);
                Date t2=c.getTime();
                long betweenMinute = DateUtil.between(t1, t2, DateUnit.SECOND);
                //如果失效更改文件字符串并写入
                if(betweenMinute>=1)
                {
                    String time="1"+","+s[1]+","+s[2];
                    FileOutputStream fileOutputStream=null;
                    try {
                        fileOutputStream=new FileOutputStream(filePath);
                        fileOutputStream.write(time.getBytes(),0,time.length());
                    }
                    catch (IOException e) {
                        throw new RuntimeException(e);
                    } finally {
                        fileOutputStream.close();
                    }
                }
                //直接登录
                Director.getInstance().loadLoginUI(new Stage());
            }
        }
        //点击登录按钮的事件 这里面还要进行页面跳转还要登录验证等需求
    }
}
