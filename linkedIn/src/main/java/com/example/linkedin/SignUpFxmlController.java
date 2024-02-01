package com.example.linkedin;

import Controller.AdminController;
import Model.graph.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class SignUpFxmlController implements Initializable {

    @FXML
    private AnchorPane ap_signup;
    @FXML
    private TextField tf_id;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_password;

    @FXML
    private DatePicker datePicker_birthday;

    @FXML
    private TextField tf_birthLocation;

    @FXML
    private TextField tf_workPlace;
    @FXML
    private TextField tf_fieldOfStudy;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ap_signup.setOnMouseClicked(event -> {
            if (checkSignUp()) {
                PagesController.goMainPage();
            }
        });
        tf_password.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String string, String t1) {

                tf_password.setStyle("-fx-text-fill: red; -fx-border-color: red");
                tf_password.setStyle("-fx-text-fill: green; -fx-border-color: green");


            }
        });
    }
    private final AdminController adminController = AdminController.getInstance();
    private User mainUser = null ;
    private boolean checkFieldFull () {
        if (tf_id.getText() == "") {
            return false ;
        }
        if (tf_birthLocation.getText() == "") {
            return false ;
        }
        if (tf_fieldOfStudy.getText() == "") {
            return false ;
        }
        if (tf_name.getText() == "") {
            return false ;
        }
        if (tf_workPlace.getText() == "") {
            return false ;
        }
        if (datePicker_birthday == null) {
            return false ;
        }
        return true ;
    }
    private boolean checkSignUp () {
        if (checkFieldFull()) {
            if (checkRegexPass()) {
                String pass = tf_password.getText();
                String id = tf_id.getText();
                User temp = adminController.search(id);
                if (temp == null) {
                    String name = tf_name.getText() ;
                    String date = datePicker_birthday.toString() ;
                    String birthLocation = tf_birthLocation.getText() ;
                    String field = tf_fieldOfStudy.getText() ;
                    String work = tf_workPlace.getText() ;
                    temp = new User(id , pass , name , date , birthLocation , field , work) ;
                    mainUser = temp ;
                    return true ;
                }
            }
        }
        return false ;
    }
    private boolean checkRegexPass () {
        String pass = tf_password.getText() ;
        boolean t1 = Pattern.matches("[a-zA-Z0-9]+" , pass) ;
        boolean t2 = Pattern.matches(".{6,}" , pass) ;
        return  (t1 && t2) ;
    }
}
