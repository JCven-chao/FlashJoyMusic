package com.team.flashjoymusic.director;

import com.team.flashjoymusic.util.ScreenSetting;
import com.team.flashjoymusic.view.LoginUI;
import javafx.stage.Stage;

/**
 * 导演类,(单例模式) 用于场景切换
 */
public class Director
{
    //宽高属性
    public static final double WIDTH = ScreenSetting.getScreenWidth();
    public static final double HEIGHT = ScreenSetting.getScreenHeight();

    //定义相关变量
    private Stage stage;


    //单例模式导演类
    private static final Director instance = new Director();

    public static Director getInstance() {
        return instance;
    }

    private Director() {
    }

    //加载登录页面的方法
    public void loadLoginUI(Stage stage)
    {
        LoginUI.initLoginUI(stage);
    }
    //加载其他页面的方法(各个页面都写这里面 这是一个终端调用的方法 具体的方法要写在每个具体UI类里面)
    //todo
}
