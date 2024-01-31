package com.example.linkedin;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class signUpFxmlController implements Initializable {

    @FXML
    private AnchorPane ap_signup;

    @FXML
    private DatePicker datePicker_birthday;

    @FXML
    private TextField tf_birthLocation;

    @FXML
    private TextField tf_fieldOfStudy;

    @FXML
    private TextField tf_id;

    @FXML
    private TextField tf_lastName;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_workPlace;
    public void mainPageAfterLogin() {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tf_password.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String string, String t1) {

                tf_password.setStyle("-fx-text-fill: red; -fx-border-color: red");
                tf_password.setStyle("-fx-text-fill: green; -fx-border-color: green");


            }
        });


    }
}
