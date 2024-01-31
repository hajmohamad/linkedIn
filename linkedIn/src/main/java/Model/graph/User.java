package Model.graph;

import java.util.ArrayList;
import java.util.Date;

public class User {
    // add  private variable
    private  String ID;
    private  String name;
    private  String birthday;
    private String lastname;
    private String BirthLocation;
    private String field;
    private String Workplace;
    private ArrayList<String> specialties;



    public User(String ID, String name, String birthday, String lastname, String birthLocation, String field, String workplace) {
        this.ID = ID;
        this.name = name;
        this.birthday = birthday;
        this.lastname = lastname;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public ArrayList<String> getSpecialties() {
        return specialties;
    }

    public void addSpecialties(String specialties) {
        this.specialties.add(specialties) ;
    }
    public void removeSpecialties(String special) {
        specialties.remove(special);
    }
}
