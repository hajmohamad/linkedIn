package com.example.linkedin;

import Controller.UserController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class editProfileFxmlController implements Initializable {


    @FXML
    private ImageView ImageView_profile;

    @FXML
    private AnchorPane ap_edit;

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
    private Label lbl_name;

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
    private Map<TextField, String> Map ;

    @FXML
    private HBox vbox_menuBar;
    public void menuBar(){
        ic_home.setOnMouseClicked(event -> {
            pagesController.mainPage();
        });
        ic_personal.setOnMouseClicked(event -> {
            pagesController.editeProfile();
        });
        ic_explor.setOnMouseClicked(event -> {
            pagesController.explorePage();
        });

        ic_plus.setOnMouseClicked(event -> {
            pagesController.addPost();
        });
        ic_heart.setOnMouseClicked(event -> {
            pagesController.suggestionPage();
        });
    }

public void editPersonal(){
    tf_password.setText(userController.getPassword()) ;
    tf_birthLocation.setText(userController.getBirthLocation()) ;
    tf_fieldOfStudy.setText(userController.getField()) ;
    tf_workPlace.setText(userController.getWorkplace()) ;
    ap_edit.setOnMouseClicked(event -> {
        System.out.println(tf_password.getText());
        userController.setPassword(tf_password.getText());
        userController.editField(tf_fieldOfStudy.getText());
        userController.editBirthLocation(tf_birthLocation.getText());
        userController.editWorkplace(tf_workPlace.getText());
        editeSpecialties();
        pagesController.editeProfile();
    });
}
public void editeSpecialties(){
         for(TextField tf:Map.keySet()) {
             if(Map.get(tf).equals(".")){
                 if(tf.getText().length()>1){
                 userController.addSpecialty(tf.getText());}
             }else{
                 userController.removeSpecialty(Map.get(tf));
                 userController.addSpecialty(tf.getText());
             }

         }

    }
public void specialties(){
        for(String txt:UserController.getInstance().getSpecialties())  {
            TextField textField = new TextField();
            textField.setPrefHeight(25.0);
            textField.setPrefWidth(208.0);
            textField.setText(txt);
            Map.put(textField,txt);
            vbox_specialties.getChildren().add(textField);
            VBox.setMargin(textField, new javafx.geometry.Insets(4,20,4,0));
        }
    icon_specialties.setOnMouseClicked(event -> {
        TextField textField = new TextField();
        textField.setPrefHeight(25.0);
        textField.setPrefWidth(208.0);
        VBox.setMargin(textField, new javafx.geometry.Insets(4,20,4,0));
        vbox_specialties.getChildren().add(textField);
        Map.put(textField,".");
    });



}
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userController=UserController.getInstance();
        Map = new HashMap<>();
        ImageView_profile.setImage(userController.getMainUser().getImage());
        menuBar();
        editPersonal();
        specialties();
        lbl_connectionNumber.setText(String.valueOf(UserController.mainUser.getConnectionsId().size()));
        lbl_name.setText(userController.getName());



    }
    UserController userController  ;


}
