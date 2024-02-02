package Model.graph;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.nio.file.Paths;

public class Post {
    private int like;
    private String image;
    private User userPostIt;
    private String description;
    private AnchorPane anchorPane_post;


    public Post(String image, User userPostIt, String description) {
        this.like = 0;
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
            anchorPane.setPrefWidth(282.0);
            anchorPane.setStyle("-fx-background-color: #efe8e8; -fx-border-color: #948b8b; -fx-border-width: 3px; -fx-border-radius: 4px; -fx-background-radius: 6;");

            ImageView iv_postImage = new ImageView(image);
            iv_postImage.setFitHeight(159.0);
            iv_postImage.setFitWidth(282.0);
            iv_postImage.setPickOnBounds(true);
            iv_postImage.setPreserveRatio(true);
            AnchorPane.setLeftAnchor(iv_postImage, 0.0);
            AnchorPane.setRightAnchor(iv_postImage, 0.0);
            AnchorPane.setTopAnchor(iv_postImage, 46.0);

            ImageView iv_profile = new ImageView(userPostIt.getImage());
            iv_profile.setFitHeight(39.0);
            iv_profile.setFitWidth(39.0);
            iv_profile.setPickOnBounds(true);
            iv_profile.setPreserveRatio(true);
            AnchorPane.setBottomAnchor(iv_profile, 271.0);
            AnchorPane.setLeftAnchor(iv_profile, 4.0);
            AnchorPane.setTopAnchor(iv_profile, 4.0);
        Polygon clip = new Polygon(
                0, 0,
                150, 0,
                150, 150,
                0, 150
        );
            iv_profile.setClip(clip);
            ImageView icon_like = new ImageView(new Image(path("src/main/resources/com/example/linkedin/image/icon/heart.png")));
            icon_like.setOnMouseClicked(event -> {
                if(like%2==0){
                like++;
                icon_like.setImage( new Image(path("src/main/resources/com/example/linkedin/image/icon/redheart.png")));}
                else{
                    like++;
                    icon_like.setImage( new Image(path("image/icon/heart.png")));}

            });
            icon_like.setFitHeight(24.0);
            icon_like.setFitWidth(30.0);
            icon_like.setLayoutX(15.0);
            icon_like.setLayoutY(197.0);
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
            icon_coment.setLayoutY(197.0);
            icon_coment.setPickOnBounds(true);
            icon_coment.setPreserveRatio(true);

            ImageView icon_send = new ImageView(new Image(path("src/main/resources/com/example/linkedin/image/icon/send.png")));
            icon_send.setFitHeight(24.0);
            icon_send.setFitWidth(30.0);
            icon_send.setLayoutX(86.0);
            icon_send.setLayoutY(197.0);
            icon_send.setPickOnBounds(true);
            icon_send.setPreserveRatio(true);

            TextFlow textFlow_description=new TextFlow();
        Text text1 = new Text(description.substring(0,description.length()/2));
        text1.setStyle("-fx-font-weight: bold");

        Text text2 = new Text(description.substring(description.length()/2,description.length()-1));
        text2.setStyle("-fx-font-weight: regular");

        textFlow_description.getChildren().addAll(text1, text2);
        textFlow_description.setLayoutX(10);
        textFlow_description.setLayoutY(221);
        textFlow_description.setLineSpacing(0.5);
        textFlow_description.prefHeight(88);
        textFlow_description.prefWidth(271);
        anchorPane.getChildren().add(textFlow_description);
        anchorPane.getChildren().add(icon_coment);
        anchorPane.getChildren().add(icon_send);
        anchorPane.getChildren().add(iv_profile);

        anchorPane.getChildren().add(icon_like);
        anchorPane.getChildren().add(iv_postImage);
        anchorPane.getChildren().add(lbl_name);




       return anchorPane;

    }

    private AnchorPane getAnchorPane_post() {
        return anchorPane_post;
    }


}
