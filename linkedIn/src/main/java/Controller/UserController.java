package Controller;

import Model.graph.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    public static UserController userController;
    public UserController(){};
    public static UserController getInstance(){
        if (userController == null){
            userController = new UserController();
        }
        return userController;
    }
    public static User mainUser;
    public void setMainUser(User user){
        mainUser = user;
    }
    public void editName(String newName){
        mainUser.setName(newName);
    }
    public void editBirthday(String newBirthday){
        mainUser.setBirthday(newBirthday);
    }
    public void editBirthLocation(String newBirthLocation){
        mainUser.setBirthLocation(newBirthLocation);
    }
    public void editField(String newField){
        mainUser.setField(newField);
    }
    public void editWorkplace(String newWorkplace){
        mainUser.setWorkplace(newWorkplace);
    }
    public void addSpecialty(String newSpecialty){
        mainUser.addSpecialties(newSpecialty);
    }
    public void removeSpecialty(String newSpecialty){
        mainUser.removeSpecialties(newSpecialty);
    }
    public List<String> getSpecialties(){
        return mainUser.getSpecialties();
    }
    public String getName(){
        return mainUser.getName();
    }
    public String getBirthday(){
        return mainUser.getBirthday();
    }
    public String getBirthLocation(){
        return mainUser.getBirthLocation();
    }
    public String getField(){
        return mainUser.getField();
    }
    public String getWorkplace(){
        return mainUser.getWorkplace();
    }
    public User getMainUser(){
        return mainUser;
    }
    public String getPassword(){
        return mainUser.getPassword();
    }
    public void setPassword(String password){
        mainUser.setPassword(password);
    }
    public void setProfilePicture(String path){
        mainUser.setProfilePicture(path);
    }


}
