package com.example.linkedin;

import Controller.AdminController;
import Model.graph.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Objects;
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
//            if (checkLogin()) {
//                PagesController.goMainPage();
//            }
            PagesController.goMainPage();
        });
    }
    private final AdminController adminController = AdminController.getInstance();
    private User mainUser = null ;
    private boolean checkLogin () {
        String id = tf_Id.getText() ;
        String pass = tf_passWord.getText() ;
        if (!Objects.equals(id, "") && !Objects.equals(pass, "")) {
            User temp = adminController.search(id) ;
            if (temp.getPassword().equals(pass)) {
                mainUser = temp ;
                return true;
            } else {
                return false;
            }
        } else {
            return false ;
        }
    }

}
