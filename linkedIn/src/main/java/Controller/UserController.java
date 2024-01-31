package Controller;

import Model.graph.User;

import java.util.ArrayList;

public class UserController {

    public static User mainUser;
    public void setMainUser(User user){
        mainUser = user;
    }
    public void editName(String newName){
        mainUser.setName(newName);
    }
    public void editLastname(String newLastname){
        mainUser.setLastname(newLastname);
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
    public ArrayList<String> getSpecialties(){
        return mainUser.getSpecialties();
    }



}
