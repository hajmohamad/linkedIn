package Model.graph;


import com.example.linkedin.LinkedIn;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class User {
    // add  private variable
    private  String ID;
    private  String name;
    private  String password;
    private  String birthday;
    private String BirthLocation;
    private String field;
    private String Workplace;
    private String imagePath;
    private List<String> specialties;
    private List<String> connectionsId;
    private List<User> myConnection = new ArrayList<>();

    public List<User> getMyConnection() {
        return myConnection;
    }
    public void addConnection (User user) {
        myConnection.add(user);
    }
    public void removeConnection (User user) {
        myConnection.remove(user);
    }

    public List<String> getConnectionsId() {
        return connectionsId;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", BirthLocation='" + BirthLocation + '\'' +
                ", field='" + field + '\'' +
                ", Workplace='" + Workplace + '\'' +
                ", specialties=" + specialties +
                ", connectionsId=" + connectionsId +
                '}';
    }


    public void setConnectionsId(List<String> connectionsId) {
        this.connectionsId = connectionsId;
    }

    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
    }

    public User(String ID, String password, String name, String birthday, String birthLocation, String field, String workplace) {
        imagePath = "image/icon/user.png";
        this.ID = ID;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        BirthLocation = birthLocation;
        this.field = field;
        Workplace = workplace;
        specialties = new ArrayList<>();
        connectionsId=new ArrayList<>();
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



    public Image getImage() {
       return new Image(LinkedIn.class.getResource(imagePath).toString());
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
