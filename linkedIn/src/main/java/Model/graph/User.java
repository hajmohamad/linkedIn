package Model.graph;


import com.example.linkedin.StartFxmlController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User extends ImageView {
    // add  private variable
    private  String ID;
    private  String name;
    private  String password;
    private  String birthday;
    private String BirthLocation;
    private String field;
    private String Workplace;
    private List<String> specialties;



    public User(String ID,String password, String name, String birthday, String birthLocation, String field, String workplace) {
        super.setImage(new Image(StartFxmlController.class.getResource("/image/icon/user.png").toString()));
        this.ID = ID;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        BirthLocation = birthLocation;
        this.field = field;
        Workplace = workplace;
        specialties = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthLocation() {
        return BirthLocation;
    }

    public void setBirthLocation(String birthLocation) {
        BirthLocation = birthLocation;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getWorkplace() {
        return Workplace;
    }

    public void setWorkplace(String workplace) {
        Workplace = workplace;
    }

    public List<String> getSpecialties() {
        return specialties;
    }

    public void addSpecialties(String specialties) {
        this.specialties.add(specialties) ;
    }
    public void removeSpecialties(String special) {
        specialties.remove(special);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setProfilePicture(String path){
        this.setImage(new Image(StartFxmlController.class.getResource(path).toString()));
    }


}
