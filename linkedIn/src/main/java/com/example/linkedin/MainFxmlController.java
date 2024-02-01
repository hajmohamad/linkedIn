package com.example.linkedin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        menuBar();
    }
}
