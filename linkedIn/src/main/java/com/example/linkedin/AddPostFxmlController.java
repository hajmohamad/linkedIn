package com.example.linkedin;

import Controller.UserController;
import Model.graph.Post;
import Model.graph.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class AddPostFxmlController implements Initializable {
    @FXML
    private AnchorPane ic_explore;
    @FXML
    private TextArea ta_description;

    @FXML
    private AnchorPane ic_heart;

    @FXML
    private AnchorPane ic_home;

    @FXML
    private AnchorPane ic_personal;

    @FXML
    private AnchorPane ic_plus;

    @FXML
    private ImageView ic_savePost;

    @FXML
    private ImageView iv_PostImage;

    @FXML
    private HBox vbox_menuBar;

    public void menuBar(){
        ic_plus.setStyle("-fx-background-color: #b7b3b3; -fx-background-radius: 0 0 30 30;");

        ic_home.setOnMouseClicked(event -> {
            PagesController.goMainPage();
        });
        ic_personal.setOnMouseClicked(event -> {
            PagesController.goEditeProfilePage();
        });
        ic_explore.setOnMouseClicked(event -> {
            PagesController.goExplorePage();
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
        iv_PostImage.setOnMouseClicked(event -> {
            FileChooser fileChooser = new FileChooser();
            File sourceFile = fileChooser.showOpenDialog(PagesController.baseStage);
            if (sourceFile != null) {
                iv_PostImage.setImage(new Image(sourceFile.toString()));
                iv_PostImage.setPickOnBounds(true);
                iv_PostImage.setPreserveRatio(true);
                iv_PostImage.setFitWidth(268);
                iv_PostImage.maxWidth(268);

                AnchorPane.setLeftAnchor(iv_PostImage, 7.0);
//                AnchorPane.setRightAnchor(iv_PostImage, 2.0);
//                AnchorPane.setTopAnchor(iv_PostImage, 46.0);
            }
        });
        ic_savePost.setOnMouseClicked(event -> {
            Path projectLocation = Paths.get("src/main/resources/com/example/linkedin/PostImage").toAbsolutePath().normalize();
            //System.out.println(projectLocation);
                String s=projectLocation+"/"+UserController.mainUser.getID()+"-"+UserController.mainUser.getPosts().size()+".jpg";
                File a=new File(s);
                if (a.exists() && !a.isDirectory()) {
                    boolean success = a.delete();}
                File z=new File(iv_PostImage.getImage().getUrl());
                try {
                    Files.copy(z.toPath(),a.toPath());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    throw new RuntimeException(e);
                }
            Post post = new Post(s,UserController.mainUser,ta_description.getText());
            System.out.println(s);
                UserController.mainUser.setPosts(post);

        });

    }
    private UserController userController = UserController.getInstance();
    private User mainUser ;
}
