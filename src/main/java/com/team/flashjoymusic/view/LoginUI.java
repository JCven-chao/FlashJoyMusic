package com.team.flashjoymusic.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginUI
{
    //从fxml文件中加载布局并设置到应用窗口上
    public static void initLoginUI(Stage stage)
    {
        Scene scene;
        try
        {
            FXMLLoader loader = new FXMLLoader(LoginUI.class.getResource("/view/login.fxml"));
            scene = new Scene(loader.load());
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        stage.getIcons().add(new Image("/image/icon.png"));
        stage.setTitle("闪悦Music");
        stage.setScene(scene);
        stage.show();
    }
}
