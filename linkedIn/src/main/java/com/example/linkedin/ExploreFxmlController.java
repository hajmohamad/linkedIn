package com.example.linkedin;

import Controller.UserController;
import Model.graph.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

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
        menuBar();
    }
    private UserController userController = UserController.getInstance();
    private User mainUser ;
}
