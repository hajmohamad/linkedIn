package com.example.linkedin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginFxmlController implements Initializable {

    @FXML
    private AnchorPane ap_login;

    @FXML
    private TextField tf_Id;
    @FXML
    private Label lbl_wrongLogin;

    @FXML
    private TextField tf_passWord;
    public void mainPageAfterLogin() {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ap_login.setOnMouseClicked(event -> {

        });
    }

    private boolean checkLogin () {
        tf_Id.getText() ;
        tf_passWord.getText() ;
    }

}
