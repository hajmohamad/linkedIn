package com.example.linkedin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class PagesController {
    static Stage baseStage;
    public static void goLoginPage(){
        FXMLLoader fxmlLoader = new FXMLLoader(LinkedIn.class.getResource("LoginPageFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);

    }
    public static void goSignupPage(){
        FXMLLoader fxmlLoader = new FXMLLoader(LinkedIn.class.getResource("SignupFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
    }
    public static void goEditeProfilePage(){
        FXMLLoader fxmlLoader = new FXMLLoader(LinkedIn.class.getResource("EditeProfileFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
    }
    public static void goMainPage(){
        FXMLLoader fxmlLoader = new FXMLLoader(LinkedIn.class.getResource("MainPageFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
    }
    public static void goAddPostPage(){
        FXMLLoader fxmlLoader = new FXMLLoader(LinkedIn.class.getResource("AddPostFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
    }
    public static void goSuggestionPage(){
        FXMLLoader fxmlLoader = new FXMLLoader(LinkedIn.class.getResource("SuggestionsFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
    }
    public static void goExplorePage(){
        FXMLLoader fxmlLoader = new FXMLLoader(LinkedIn.class.getResource("ExploreFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
    }


}
