package Controller;

import Model.graph.User;

import java.util.*;

enum Priority {name , lastName , birthDay , birthLocation, field, workPlace , specialties , connection}

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
    public double getScore() {
        return score;
    }
}

public class PriorityCalculation {
    String name ;
    String lastName ;
    String  birthDay ;
    String birthLocation ;
    String field ;
    String workPlace ;
    List<String> specialties ;
    List<Priority> myPriority ;
    public List<User> suggestions (User inputUser , int order) {
        name= inputUser.getName() ;
        lastName= inputUser.getLastname() ;
        birthDay= inputUser.getBirthday();
        birthLocation= inputUser.getBirthLocation();
        field= inputUser.getField() ;
        workPlace= inputUser.getWorkplace();
        specialties = inputUser.getSpecialties();
        List<ScoreUser> bord = new ArrayList<>() ;

        for (User user : admin.getAllUser()) {
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
        List<ScoreUser> friends = goConnection(inputUser , 5) ;
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
        int n = myPriority.indexOf(Priority.birthLocation); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getBirthLocation().equals(birthLocation)) {
            score += (10^n) ;
        }
        return score;
    }
    public double studyFieldScore (User target) {
        int n = myPriority.indexOf(Priority.field); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getField().equals(field)) {
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
    AdminController admin = new AdminController() ;
    public List<ScoreUser> goConnection (User person , int height) {
        List<ScoreUser> connections = new ArrayList<>() ;
        if (height > 1) {
            for (User user : admin.getAllUserConnections(person)) {
                List <ScoreUser> friends = goConnection(user , height -1) ;
                connections.addAll(friends) ;
                connections.add(new ScoreUser(user , height));
            }
            return connections ;
        } else if (height == 1){
            List<ScoreUser> result = new ArrayList<>() ;
            for (User user : admin.getAllUserConnections(person)) {
                result.add(new ScoreUser(user , height));
            }
            return result;
        } else {
            return null ;
        }
    }
    public double Similarity (String word , String name) {
        return 0 ;
    }
}
