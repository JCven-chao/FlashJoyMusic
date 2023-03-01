package com.team.flashjoymusic.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.io.IOException;

public class MenuUI {
    public static Scene initMenuUI(){
        Scene scene;
        try
        {
            FXMLLoader loader = new FXMLLoader(LoginUI.class.getResource("/view/menu.fxml"));
            scene = new Scene(loader.load());
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return scene;
    }
}
