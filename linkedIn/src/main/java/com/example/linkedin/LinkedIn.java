package com.example.linkedin;

import Controller.AdminController;
import Model.graph.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
public class LinkedIn extends Application {
    static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LinkedIn.class.getResource("StartFxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 319, 650);
        stage.setScene(scene);
        PagesController.baseStage = stage;
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
        mainStage = stage;
    }
    public static void main(String[] args) {
        adminController = AdminController.getInstance();
        String s = "src/main/resources/com/example/linkedin/users.json" ;
        for (User user : readJsonFile(s)) {
            adminController.addUser(user) ;
        }

        for (User user : adminController.getAllUser()) {
            for (String id : user.getTempIdArrayList()) {
                User temp = adminController.search(id);
                user.addConnection(temp);
            }
        }
        addHajMohammadUser();
        launch();
    }
    public static void addHajMohammadUser(){
        adminController.addUser(new User("Haj", "Haj", "mohamad", "2001/03/03", "shirvan", "computer science", "isfahan"));
    }

    private static  AdminController adminController  ;
    private static List<User> readJsonFile(String filePath) {
        List<User> persons = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(filePath));
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
                person.setTempIdArrayList(connectionIdsArray);

                persons.add(person);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return persons;
    }

}