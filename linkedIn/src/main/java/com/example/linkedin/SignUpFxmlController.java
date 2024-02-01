package com.example.linkedin;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpFxmlController implements Initializable {

    @FXML
    private AnchorPane ap_signup;
    @FXML
    private TextField tf_id;

    @FXML
    private TextField tf_lastName;

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



    public void mainPageAfterLogin() {
        FXMLLoader fxmlLoader = new FXMLLoader(LinkedIn.class.getResource("editeProfileFxml.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 319, 650);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LinkedIn.mainStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ap_signup.setOnMouseClicked(event -> {
            mainPageAfterLogin();
        });
        tf_password.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String string, String t1) {

                tf_password.setStyle("-fx-text-fill: red; -fx-border-color: red");
                tf_password.setStyle("-fx-text-fill: green; -fx-border-color: green");


            }
        });


    }
}
