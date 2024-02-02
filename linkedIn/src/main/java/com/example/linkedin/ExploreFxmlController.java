package com.example.linkedin;

import Controller.UserController;
import Model.graph.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import  Controller.imageFinder.findImage;

public class ExploreFxmlController implements Initializable {
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
    private ScrollPane sp_images;

    @FXML
    private HBox vbox_menuBar;
    public void menuBar(){
        ic_explore.setStyle("-fx-background-color: #b7b3b3; -fx-background-radius: 0 0 30 30;");

        ic_home.setOnMouseClicked(event -> {
            PagesController.goMainPage();
        });
        ic_personal.setOnMouseClicked(event -> {
            PagesController.goEditeProfilePage();
        });
        ic_plus.setOnMouseClicked(event -> {
            PagesController.goAddPostPage();
        });
        ic_heart.setOnMouseClicked(event -> {
            PagesController.goSuggestionPage();
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserController userController = UserController.getInstance();
        mainUser = userController.getMainUser();
        if(mainUser.getSpecialties().isEmpty()){
            makeImageView("IT");
        }else{
            makeImageView(mainUser.getSpecialties().get(0));
        }





        menuBar();
    }
    public void makeImageView(String str){
        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: white;");
        gridPane.setHgap(4);
        gridPane.setVgap(4);

        // Set up column constraints
        ColumnConstraints column1 = new ColumnConstraints(137); // 275 - 3*4
        column1.setHgrow(Priority.NEVER);
        ColumnConstraints column2 = new ColumnConstraints(137);
        column2.setHgrow(Priority.NEVER);

        gridPane.getColumnConstraints().addAll(column1, column2);
        ArrayList<String> link=findImage.getLink(str);
        // Add sample images
        for (int i = 0; i < link.size(); i++) {

            Image image = new Image(link.get(i));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(137);
            imageView.setFitHeight(224);
            gridPane.add(imageView, i % 2, i / 2);
        }
        sp_images.contentProperty().set(gridPane);

    }
    private UserController userController = UserController.getInstance();
    private User mainUser ;
}
