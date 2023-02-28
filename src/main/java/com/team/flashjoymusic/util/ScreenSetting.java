package com.team.flashjoymusic.util;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

/**
 * 工具类 屏幕相关的方法
 */
public class ScreenSetting
{
    static final Rectangle2D screenRectangle = Screen.getPrimary().getBounds();

    //获取屏幕的宽和高的方法
    public static double getScreenWidth()
    {
        return screenRectangle.getWidth();
    }

    public static double getScreenHeight() {
        return screenRectangle.getHeight();
    }

}
