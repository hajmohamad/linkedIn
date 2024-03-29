package com.example.linkedin;

import Controller.*;
import Model.graph.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.*;

public class SuggestionFxmlController implements Initializable {
     @FXML
     private AnchorPane ap_filter;

     @FXML
     private Button btn_filter;

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
     private ImageView icon_filter;

     @FXML
     private Spinner<Integer> sp_BirthLocation;

     @FXML
     private Spinner<Integer> sp_birthday;

     @FXML
     private Spinner<Integer> sp_field;

     @FXML
     private Spinner<Integer> sp_name;

     @FXML
     private Spinner<Integer> sp_specialties;
     @FXML
     private Spinner<Integer> sp_connections;

     @FXML
     private Spinner<Integer> sp_workPlace;

     @FXML
     private VBox vbox_Suggestion;

     @FXML
     private HBox vbox_menuBar;


     public void menuBar() {
         ic_heart.setStyle("-fx-background-color: #b7b3b3; -fx-background-radius: 0 0 30 30;");
         ic_home.setOnMouseClicked(event -> {
             PagesController.goMainPage();
         });
         ic_personal.setOnMouseClicked(event -> {
             PagesController.goEditeProfilePage();
         });
         ic_explore.setOnMouseClicked(event -> {
             PagesController.goExplorePage();
         });

         ic_plus.setOnMouseClicked(event -> {
             PagesController.goAddPostPage();
         });
     }

     public AnchorPane customAnchorPane(User user) {
         menuBar();
         AnchorPane ap = new AnchorPane();
         ap.setMinHeight(74.0);
         ap.setMinWidth(265.0);
         ap.setStyle("-fx-border-color: #8d8888; -fx-border-radius: 20px; -fx-border-width: 2px;");

         VBox.setMargin(ap, new javafx.geometry.Insets(5.0, 15, 5.0, 5.0));
         ImagePattern userImage = new ImagePattern(user.getImage());
         Circle iv_profile = new Circle(23);
         iv_profile.setFill(userImage);
         iv_profile.setEffect(new DropShadow(20, Color.BLACK));
         iv_profile.setPickOnBounds(true);
         iv_profile.setLayoutX(35);
         iv_profile.setLayoutY(35);
         Label label1 = new Label(user.getID());
         label1.setPrefHeight(13.0);
         label1.setPrefWidth(98.0);
         label1.setLayoutX(74.0);
         label1.setLayoutY(12.0);
         AnchorPane.setLeftAnchor(label1, 74.0);
         Label Name = new Label(user.getName());
         Name.setPrefHeight(17.0);
         Name.setPrefWidth(98.0);
         Name.setLayoutX(74.0);
         Name.setLayoutY(22.0);
         AnchorPane.setLeftAnchor(Name, 74.0);
         AnchorPane.setTopAnchor(Name, 26.0);
         if (user.getSpecialties().size() > 2) {
             Label label2 = new Label(user.getSpecialties().get(0) + " " + user.getSpecialties().get(1));
             label2.setPrefHeight(17.0);
             label2.setPrefWidth(166.0);
             label2.setLayoutX(76.0);
             label2.setLayoutY(42.0);
             AnchorPane.setLeftAnchor(label2, 76.0);
             AnchorPane.setTopAnchor(label2, 42.0);
             ap.getChildren().add(label2);

         }

         ImageView addImage = new ImageView(new Image(LinkedIn.class.getResource("image/icon/bAdd.png").toString()));
         addImage.setFitHeight(40.0);
         addImage.setFitWidth(30.0);
         addImage.setLayoutX(223.0);
         addImage.setLayoutY(20.0);
         addImage.setPickOnBounds(true);
         addImage.setPreserveRatio(true);
         AnchorPane.setLeftAnchor(addImage, 223.0);
         AnchorPane.setTopAnchor(addImage, 20.0);
         Image badd=new Image(addImage.getImage().getUrl());
         addImage.setOnMouseClicked(event -> {
             if(addImage.getImage().getUrl().equals(badd.getUrl())) {
                 addImage.setImage(new Image(LinkedIn.class.getResource("image/icon/afAdd.png").toString()));
                 AdminController.getInstance().addConnection(UserController.getInstance().getMainUser(), user);
             }else {
                 addImage.setImage(badd);
                 AdminController.getInstance().removeConnection(UserController.getInstance().getMainUser(), user);
             }

         });

         ap.getChildren().addAll(iv_profile,Name, label1, addImage);
         return ap;
     }
     public void filterPane() {
         ap_filter.setVisible(false);
         ap_filter.setStyle("-fx-background-color: #ffffff;");
         icon_filter.setOnMouseClicked(e -> {
             ap_filter.setVisible(!ap_filter.isVisible());
         });
         sp_name.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
         sp_birthday.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
         sp_BirthLocation.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
         sp_field.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
         sp_workPlace.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
         sp_specialties.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));
         sp_connections.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 1));

         btn_filter.setOnMouseClicked(event -> {
             vbox_Suggestion.getChildren().clear();
             ap_filter.setVisible(false);
             setPriorities();
             List<User> suggestion = PriorityCalculation.suggestions(mainUser, 10);
             for (User user : suggestion) {
                 vbox_Suggestion.getChildren().add(customAnchorPane(user));
             }
         });
     }

     private void setPriorities () {
         Map <Priority ,Integer> priorities = new HashMap<>();
         priorities.put(Priority.name , sp_name.getValue());
         priorities.put(Priority.birthDay , sp_birthday.getValue());
         priorities.put(Priority.birthLocation , sp_birthday.getValue());
         priorities.put(Priority.field , sp_field.getValue());
         priorities.put(Priority.workPlace , sp_workPlace.getValue());
         priorities.put(Priority.specialties , sp_specialties.getValue());
         priorities.put(Priority.connection , sp_connections.getValue());
         PriorityCalculation.setMyPriority(priorities);
     }

     @Override
     public void initialize(URL url, ResourceBundle resourceBundle) {
         filterPane();
         UserController userController = UserController.getInstance();
         mainUser = userController.getMainUser();
         List<User> suggestion = PriorityCalculation.suggestions(mainUser, 10);
         for (User user : suggestion) {
             vbox_Suggestion.getChildren().add(customAnchorPane(user));
         }
     }

     private UserController userController = UserController.getInstance();
     private User mainUser;
 }
