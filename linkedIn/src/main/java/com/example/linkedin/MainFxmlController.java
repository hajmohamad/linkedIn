package com.example.linkedin;

import Controller.AdminController;
import Controller.UserController;
import Model.graph.Post;
import Model.graph.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainFxmlController implements Initializable {
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
    ic_home.setStyle("-fx-background-color: #b7b3b3; -fx-background-radius: 0 0 30 30;");

    ic_personal.setOnMouseClicked(event -> {
        PagesController.goEditeProfilePage();
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
    @FXML
    private VBox vbox_posts;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserController userController = UserController.getInstance();
        mainUser = userController.getMainUser();
        menuBar();

        s();

    }
    public String s(){
        for(User u: mainUser.getMyConnection()){
            for(Post p:u.getPosts()){
                vbox_posts.getChildren().add(p.makeAnchorPane());
            }

        }
        return "Asd";
    }
    private UserController userController = UserController.getInstance();
    private User mainUser ;
}
