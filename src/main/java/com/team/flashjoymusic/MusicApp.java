package com.team.flashjoymusic;

import com.team.flashjoymusic.director.Director;
import javafx.application.Application;
import javafx.stage.Stage;

public class MusicApp extends Application
{

    /**
     *  程序运行会从这里开始逐步执行相关代码
     * @param stage (窗口)
     */
    @Override
    public void start(Stage stage) throws Exception
    {
        //通过单例的导演类来调用相关的场景UI
        stage.setResizable(false);
        Director.getInstance().loadLoginUI(stage);
    }


    /**
     * 初始化init()方法
     * 软件运行前会先调用次方法, 通常用于加载配置相关
     */
    @Override
    public void init() throws Exception
    {


    }

    /**
     * 主方法点击启动项目
     */
    public static void main(String[] args) {
        launch(args);
    }
}
