package com.example.linkedin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class mainFxmlController  implements Initializable {
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
menuBar();

    }
}
