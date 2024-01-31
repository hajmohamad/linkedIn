package Controller;

import Model.graph.AdjacencyMapGraph;
import Model.graph.User;
import Model.graph.Vertex;
import com.example.linkedin.HelloApplication;

import java.util.*;

enum Priority {name , lastName , birthDay , city , studyField , workPlace , specialties , connection}

class ScoreUser {
    private User user ;
    private double score ;
    public ScoreUser(User user , double score) {
        this.user = user ;
        this.score = score ;
    }
    public void addScore (double n) {
        this.score += n ;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }
}

public class PriorityCalculation {

    AdjacencyMapGraph graph = new AdjacencyMapGraph<>() ; // برای استفاده دستی ، قابل حذف و جایگزین

    String ID ;
    String name ;
    String lastName ;
    String  birthDay ;
    String city ;
    String studyField ;
    String workPlace ;
    List<String> specialties ;
    List<User> connection ;
    List<Priority> myPriority ;
    public List<User> suggestions (User inputUser , int order) {
        List<ScoreUser> bord = new ArrayList<>() ;

        for (Object ob : graph.vertices()) {
            Vertex vertex = (Vertex) ob;
            User user = (User) vertex.getElement();

            ScoreUser scoreUser = nameScore(user) ;  // شروع محاسبه ضریب اولیت هر فرد
            scoreUser.addScore(lastNameScore(user));
            scoreUser.addScore(birthDayScore(user));
            scoreUser.addScore(cityScore(user));
            scoreUser.addScore(studyFieldScore(user));
            scoreUser.addScore(workPlaceScore(user));
            scoreUser.addScore(specialtiesScore(user));
            scoreUser.addScore(connectionScore(user));
            bord.add(scoreUser) ;
        }
        List<User> result = new ArrayList<>() ;
        bord.stream().sorted();
        for (int i = 0 ; i < order ; i++) {
            result.add(bord.get(i).getUser());
        }
        return result ;
    }

    public ScoreUser nameScore (User target) {
        int n = myPriority.indexOf(Priority.name); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getName().equals(name)) {
            score += (10^n) ;
        }
        ScoreUser scoreUser = new ScoreUser(target , score) ;
        return scoreUser;
    }
    public double lastNameScore (User target) {
        int n = myPriority.indexOf(Priority.lastName); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getLastname().equals(lastName)) {
            score += (10^n) ;
        }
        return score;
    }
    public double birthDayScore (User target) {
        int n = myPriority.indexOf(Priority.birthDay); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getBirthday().equals(birthDay)) {
            score += (10^n) ;
        }
        return score;
    }
    public double cityScore (User target) {
        int n = myPriority.indexOf(Priority.city); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getBirthLocation().equals(city)) {
            score += (10^n) ;
        }
        return score;
    }
    public double studyFieldScore (User target) {
        int n = myPriority.indexOf(Priority.studyField); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getField().equals(studyField)) {
            score += (10^n) ;
        }
        return score;
    }
    public double workPlaceScore (User target) {
        int n = myPriority.indexOf(Priority.workPlace); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getWorkplace().equals(workPlace)) {
            score += (10^n) ;
        }
        return score;
    }
    public double specialtiesScore (User target) {
        int n = myPriority.indexOf(Priority.specialties); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        for (String userSpecialty : target.getSpecialties()) {
            for (String targetSpecialty : specialties) {
                if ((userSpecialty).equals(targetSpecialty)) {
                    score += (10 ^ n);
                }
            }
        }
        return (score/2);
    }
    public double connectionScore (User target) {
        return 0;
    }
    public double Similarity (String word , String name) {
        return 0 ;
    }
}
