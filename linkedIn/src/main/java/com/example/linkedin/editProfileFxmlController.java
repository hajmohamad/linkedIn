package com.example.linkedin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class editProfileFxmlController implements Initializable {

    @FXML
    private ImageView ImageView_profile;

    @FXML
    private AnchorPane ap_edit;

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
    private VBox vboc_specialties;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {





    }
}
