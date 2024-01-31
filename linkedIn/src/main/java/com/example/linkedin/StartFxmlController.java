package com.example.linkedin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class StartFxmlController implements Initializable {
    @FXML
    private AnchorPane ap_login;

    @FXML
    private AnchorPane ap_signup;
    public void goToLogin(){

    }
    public void goToSignup(){
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
