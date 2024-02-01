package com.example.linkedin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
public class linkedIn extends Application {
    static Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(linkedIn.class.getResource("StartFxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 319, 650);
        stage.setScene(scene);
        pagesController.baseStage = stage;
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }

    public static void main(String[] args) {
//launch();
        JSONParser parser = new JSONParser();

//        String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";

        String s = linkedIn.class.getResource("users.json").toString() ;

        try{
            Object obj = parser.parse(s);
            JSONArray array = (JSONArray)obj;
            System.out.println("The 2nd element of array");
            System.out.println(array.get(1));
            System.out.println();
            JSONObject obj2 = (JSONObject)array.get(1);
            System.out.println("Field \"1\"");
            System.out.println(obj2.get("1"));
            s = "{}";
            obj = parser.parse(s);
            System.out.println(obj);
            s = "[5,]";
            obj = parser.parse(s);
            System.out.println(obj);
            s = "[5,,2]";
            obj = parser.parse(s);
            System.out.println(obj);
        }catch(ParseException pe){
            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }


//---------------------------

    }
}