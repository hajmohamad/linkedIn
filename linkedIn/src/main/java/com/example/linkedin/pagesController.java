package com.example.linkedin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class pagesController {
    static Stage baseStage;
    public static void loginPage(){
        FXMLLoader fxmlLoader = new FXMLLoader(linkedIn.class.getResource("loginPageFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);

    }
    public static void signupPage(){
        FXMLLoader fxmlLoader = new FXMLLoader(linkedIn.class.getResource("signupFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
    }
    public static void editeProfile(){
        FXMLLoader fxmlLoader = new FXMLLoader(linkedIn.class.getResource("editeProfileFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
    }
    public static void mainPage(){
        FXMLLoader fxmlLoader = new FXMLLoader(linkedIn.class.getResource("mainPageFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
    }
    public static void addPost(){
        FXMLLoader fxmlLoader = new FXMLLoader(linkedIn.class.getResource("addPostFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
    }
    public static void suggestionPage(){
        FXMLLoader fxmlLoader = new FXMLLoader(linkedIn.class.getResource("suggestionFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        baseStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
    }
    public static void explorePage(){
        FXMLLoader fxmlLoader = new FXMLLoader(linkedIn.class.getResource("exploreFxml.fxml"));
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
