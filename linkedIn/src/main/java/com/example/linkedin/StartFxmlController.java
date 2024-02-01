package com.example.linkedin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartFxmlController implements Initializable {
    @FXML
    private AnchorPane ap_login;
    @FXML
    private AnchorPane ap_signup;
    public void goToLogin(){
        FXMLLoader fxmlLoader = new FXMLLoader(linkedIn.class.getResource("loginPageFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        linkedIn.mainStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
    }
    public void goToSignup(){
        FXMLLoader fxmlLoader = new FXMLLoader(linkedIn.class.getResource("signupFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        linkedIn.mainStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ap_login.setOnMouseClicked(event -> {
            goToLogin();
        });
        ap_signup.setOnMouseClicked(event -> {
            goToSignup();
        });

    }
}
