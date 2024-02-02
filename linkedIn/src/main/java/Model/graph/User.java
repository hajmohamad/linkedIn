package Model.graph;


import Controller.AdminController;
import com.example.linkedin.LinkedIn;
import javafx.scene.image.Image;
import javafx.scene.layout.Priority;

import java.nio.file.Paths;
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
    private List<String> tempIdArrayList;



    public List<User> getMyConnection() {
       return AdminController.getInstance().getAllUserConnections(this);
    }
    public void addConnection (User user) {
        AdminController.getInstance().addConnection(this, user);
    }
    public void removeConnection (User user) {
   AdminController.getInstance().removeConnection(this, user);
    }

    public List<String> getConnectionsId() {
        List<String> connectionsId = new ArrayList<>();
        for (User user : getMyConnection()) {
            connectionsId.add(user.getID());
        }
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
                ", connectionsId=" + getConnectionsId() +
                '}';
    }


    public void setConnectionsId(List<String> connectionsId) {
 for (String connection : connectionsId) {
     addConnection(AdminController.adminController.getUserById(connection));
 }
    }



    public void setSpecialties(List<String> specialties) {
        this.specialties = specialties;
    }

    public User(String ID, String password, String name, String birthday, String birthLocation, String field, String workplace) {
        String S=Paths.get("src/main/resources/com/example/linkedin/profile/user.png").toAbsolutePath().normalize().toString();
        imagePath= S;
        this.ID = ID;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        BirthLocation = birthLocation;
        this.field = field;
        Workplace = workplace;
        specialties = new ArrayList<>();
        tempIdArrayList =new ArrayList<>();

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
       return new Image(imagePath);
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<String> getTempIdArrayList() {
        return tempIdArrayList;
    }

    public void setTempIdArrayList(List<String> tempIdArrayList) {
        this.tempIdArrayList = tempIdArrayList;
    }
}
