package com.example.linkedin;

import Controller.PriorityCalculation;
import Controller.UserController;
import Model.graph.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class suggestionFxmlController implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<User> suggestion = PriorityCalculation.suggestions(userController.getMainUser() , 4) ;
    }
    UserController userController = UserController.getInstance() ;
}
