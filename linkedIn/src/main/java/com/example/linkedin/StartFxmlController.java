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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ap_login.setOnMouseClicked(event -> {
            pagesController.suggestionPage();

        });
        ap_signup.setOnMouseClicked(event -> {

        });

    }
}
