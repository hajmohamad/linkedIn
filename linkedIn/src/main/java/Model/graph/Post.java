package Model.graph;

import Controller.UserController;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private List<User> userLiked;
    private String image;
    private User userPostIt;
    private String description;
    private AnchorPane anchorPane_post;


    public Post(String image, User userPostIt, String description) {
        this.userLiked=new ArrayList<>();
        this.image = image;
        this.userPostIt = userPostIt;
        this.description = description;
    }
   public String path(String s){
        return Paths.get(s).toAbsolutePath().normalize().toString();
   }
    public AnchorPane makeAnchorPane(){


            AnchorPane anchorPane = new AnchorPane();
            anchorPane.setMaxHeight(327.0);
            anchorPane.setPrefHeight(320.0);
            anchorPane.setPrefWidth(270);
        anchorPane.setMinWidth(270);

        anchorPane.setStyle("-fx-background-color: #efe8e8;  -fx-border-radius: 6px; -fx-background-radius: 6;");

            ImageView iv_postImage = new ImageView(image);
            iv_postImage.setFitHeight(159.0);
            iv_postImage.setFitWidth(278);

            iv_postImage.setPickOnBounds(true);
            iv_postImage.setPreserveRatio(true);
            AnchorPane.setLeftAnchor(iv_postImage, 20.0);
            AnchorPane.setRightAnchor(iv_postImage, 2.0);
            AnchorPane.setTopAnchor(iv_postImage, 46.0);

            ImagePattern pattern = new ImagePattern(userPostIt.getImage());
            Circle iv_profile = new Circle(18);
            iv_profile.setFill(pattern);
            iv_profile.setEffect(new DropShadow(20, Color.BLACK));
            iv_profile.setPickOnBounds(true);
            AnchorPane.setBottomAnchor(iv_profile, 271.0);
            AnchorPane.setLeftAnchor(iv_profile, 8.0);
            AnchorPane.setTopAnchor(iv_profile, 4.0);


            ImageView icon_like = new ImageView();
        if(!userLiked.contains(UserController.mainUser)){
            icon_like.setImage( new Image(path("src/main/resources/com/example/linkedin/image/icon/heart.png")));
        }
        else{
            icon_like.setImage( new Image(path("src/main/resources/com/example/linkedin/image/icon/redheart.png")));
        }
            icon_like.setOnMouseClicked(event -> {
                if(userLiked.contains(UserController.mainUser)){
                    userLiked.remove(UserController.mainUser);
                    icon_like.setImage( new Image(path("src/main/resources/com/example/linkedin/image/icon/heart.png")));
                }
                else{
                    userLiked.add(UserController.mainUser);
                    icon_like.setImage( new Image(path("src/main/resources/com/example/linkedin/image/icon/redheart.png")));
                }

            });
            icon_like.setFitHeight(24.0);
            icon_like.setFitWidth(30.0);
            icon_like.setLayoutX(15.0);
            icon_like.setLayoutY(213);
            icon_like.setPickOnBounds(true);
            icon_like.setPreserveRatio(true);

            Label lbl_name = new Label(userPostIt.getName());
            lbl_name.setPrefHeight(17.0);
            lbl_name.setPrefWidth(108.0);
            lbl_name.setTextFill(Color.web("#796666"));
            lbl_name.setLayoutX(56.0);
            lbl_name.setLayoutY(16.0);

            ImageView icon_coment = new ImageView(new Image(path("src/main/resources/com/example/linkedin/image/icon/coment.png")));
            icon_coment.setFitHeight(24.0);
            icon_coment.setFitWidth(30.0);
            icon_coment.setLayoutX(50.0);
            icon_coment.setLayoutY(213);
            icon_coment.setPickOnBounds(true);
            icon_coment.setPreserveRatio(true);

            ImageView icon_send = new ImageView(new Image(path("src/main/resources/com/example/linkedin/image/icon/send.png")));
            icon_send.setFitHeight(24.0);
            icon_send.setFitWidth(30.0);
            icon_send.setLayoutX(86.0);
            icon_send.setLayoutY(213);
            icon_send.setPickOnBounds(true);
            icon_send.setPreserveRatio(true);

            Label textFlow_description=new Label(description);
            textFlow_description.setWrapText(true);
        textFlow_description.setLayoutX(10);
        textFlow_description.setLayoutY(251);
        textFlow_description.setLineSpacing(0.5);
        textFlow_description.prefHeight(88);
        textFlow_description.prefWidth(100);
        textFlow_description.setMaxWidth(250);

        anchorPane.getChildren().add(textFlow_description);
        anchorPane.getChildren().add(icon_coment);
        anchorPane.getChildren().add(icon_send);
        anchorPane.getChildren().add(iv_profile);

        anchorPane.getChildren().add(icon_like);
        anchorPane.getChildren().add(iv_postImage);
        anchorPane.getChildren().add(lbl_name);
        anchorPane.setEffect(new DropShadow(20, Color.BLACK));
VBox.setMargin(anchorPane, new javafx.geometry.Insets(11, 5, 3, 5));



       return anchorPane;

    }

    private AnchorPane getAnchorPane_post() {
        return anchorPane_post;
    }


}
