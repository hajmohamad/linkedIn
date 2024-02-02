package com.example.linkedin;

import Controller.AdminController;
import Controller.UserController;
import Model.graph.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class EditProfileFxmlController implements Initializable {
    @FXML
    private ImageView ImageView_profile;
    @FXML
    private AnchorPane ap_edit;
    @FXML
    private AnchorPane ic_explore;
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
    private ImageView ic_logout;
    @FXML
    private VBox vbox_specialties;
    private Map<TextField, String> Map ;
    @FXML
    private HBox vbox_menuBar;

    public void menuBar(){
        ic_personal.setStyle("-fx-background-color: #b7b3b3; -fx-background-radius: 0 0 30 30;");

        ic_home.setOnMouseClicked(event -> {
            PagesController.goMainPage();
        });
        ic_explore.setOnMouseClicked(event -> {
            PagesController.goExplorePage();
        });

        ic_plus.setOnMouseClicked(event -> {
            PagesController.goAddPostPage();
        });
        ic_heart.setOnMouseClicked(event -> {
            PagesController.goSuggestionPage();
        });
    }

    public void editPersonal(){
        tf_password.setText(userController.getPassword()) ;
        tf_birthLocation.setText(userController.getBirthLocation()) ;
        tf_fieldOfStudy.setText(userController.getField()) ;
        tf_workPlace.setText(userController.getWorkplace()) ;
        ap_edit.setOnMouseClicked(event -> {
            userController.setPassword(tf_password.getText());
            userController.editField(tf_fieldOfStudy.getText());
            userController.editBirthLocation(tf_birthLocation.getText());
            userController.editWorkplace(tf_workPlace.getText());
            editeSpecialties();
            editProfile();
            PagesController.goEditeProfilePage();
        });
    }
    public void logout(){
        ic_logout.setOnMouseClicked(event ->
        {
            AdminController.getInstance().logout();
            PagesController.StartPage();
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
    public void editProfile(){
        if(changed){
            Path projectLocation = Paths.get("src/main/resources/com/example/linkedin/profile/").toAbsolutePath().normalize();
        String s=projectLocation+UserController.mainUser.getID()+".jpg";
            userController.setProfilePicture(s);
            File a=new File(s);
            if (a.exists() && !a.isDirectory()) {
                boolean success = a.delete();}
        File z=new File(ImageView_profile.getImage().getUrl());
        try {
            Files.copy(z.toPath(),a.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainUser.setImagePath(s);}
    }
    boolean changed = false;
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
    public void imageChooser(){
        icon_picture.setOnMouseClicked(event -> {

            FileChooser fileChooser = new FileChooser();
            File sourceFile = fileChooser.showOpenDialog(PagesController.baseStage);
            if (sourceFile != null) {
                changed=true;
                    ImageView_profile.setImage(new Image(sourceFile.toString()));

            }
        });
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logout();
        imageChooser();
        UserController userController = UserController.getInstance();
        mainUser = userController.getMainUser();
        menuBar();
        Map = new HashMap<>();
        ImageView_profile.setImage(userController.getMainUser().getImage());
        editPersonal();
        specialties();
        lbl_connectionNumber.setText(String.valueOf(AdminController.getInstance().getAllUserConnections(mainUser).size()));
        lbl_name.setText(userController.getName());

    }

    private UserController userController = UserController.getInstance();
    private User mainUser ;

}
