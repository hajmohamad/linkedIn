package com.example.linkedin;

import Controller.UserController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class editProfileFxmlController implements Initializable {


    @FXML
    private ImageView ImageView_profile;

    @FXML
    private AnchorPane ap_signup;

    @FXML
    private AnchorPane ic_explor;

    @FXML
    private AnchorPane ic_heart;

    @FXML
    private AnchorPane ic_home;

    @FXML
    private AnchorPane ic_personal;

    @FXML
    private AnchorPane ic_plus;

    @FXML
    private ImageView icon_picture;

    @FXML
    private ImageView icon_specialties;

    @FXML
    private Label lbl_connectionNumber;

    @FXML
    private TextField tf_birthLocation;

    @FXML
    private TextField tf_fieldOfStudy;

    @FXML
    private PasswordField tf_password;

    @FXML
    private TextField tf_photoPath;

    @FXML
    private TextField tf_workPlace;

    @FXML
    private VBox vbox_specialties;

    @FXML
    private HBox vbox_menuBar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tf_password.setText(userController.getPassword()) ;
        tf_birthLocation.setText(userController.getBirthLocation()) ;
        tf_fieldOfStudy.setText(userController.getField()) ;
        tf_workPlace.setText(userController.getWorkplace()) ;
        ap_signup.setOnMouseClicked(event -> {
            userController.setPassword(tf_password.getText());
            userController.editField(tf_fieldOfStudy.getText());
            userController.editWorkplace(tf_workPlace.getText());
        });
        icon_specialties.setOnMouseClicked(event -> {
            VBox vBox = new VBox() ;
        });
    }
    UserController userController = UserController.getInstance() ;


}
