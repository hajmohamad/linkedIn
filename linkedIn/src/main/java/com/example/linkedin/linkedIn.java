package com.example.linkedin;

import Model.graph.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
launch(args);
        for(User user:readJsonFile("I:\\ramezon\\data structures\\social-network-hajehsan\\linkedIn\\src\\main\\resources\\com\\example\\linkedin\\users.json")){
            System.out.println(user);
        }
    }


    private static List<User> readJsonFile(String filePath) {
        List<User> persons = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("I:\\users.json"));
            JSONArray jsonArray = (JSONArray) obj;

            jsonArray.forEach(json -> {
                JSONObject personObj = (JSONObject) json;
                User person = new User(null, null, null, null, null, null, null);
                person.setID((String) personObj.get("id"));
                person.setName((String) personObj.get("name"));
                person.setBirthday((String) personObj.get("dateOfBirth"));
                person.setBirthLocation((String) personObj.get("universityLocation"));
                person.setField((String) personObj.get("field"));
                person.setWorkplace((String) personObj.get("workplace"));

                List<String> specialties = new ArrayList<>();
                JSONArray specialtiesArray = (JSONArray) personObj.get("specialties");
                specialtiesArray.forEach(specialty -> specialties.add((String) specialty));
                person.setSpecialties(specialties);

                List<String> connectionIds = new ArrayList<>();
                JSONArray connectionIdsArray = (JSONArray) personObj.get("connectionId");
                connectionIdsArray.forEach(connectionId -> connectionIds.add((String) connectionId));
                person.setConnectionsId(connectionIdsArray);

                persons.add(person);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return persons;
    }

}