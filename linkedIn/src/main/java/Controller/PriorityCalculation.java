package Controller;

import Model.graph.User;

import java.util.*;

public abstract class PriorityCalculation {
    private static String name ;
    private static String lastName ;
    private static String  birthDay ;
    private static String birthLocation ;
    private static String field ;
    private static String workPlace ;
    private static List<String> specialties ;
    private static List<Priority> myPriority ;
    public static List<User> suggestions (User inputUser , int order) {
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
        bord.stream().sorted();



        List<ScoreUser> friends = goConnection(inputUser , 5) ;






        List<User> result = new ArrayList<>() ;
        for (int i = 0 ; i < order ; i++) {
            result.add(bord.get(i).getUser());
        }



        return result ;
    }
    private static ScoreUser nameScore(User target) {
        int n = myPriority.indexOf(Priority.name); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getName().equals(name)) {
            score += (10^n) ;
        }
        ScoreUser scoreUser = new ScoreUser(target , score) ;
        return scoreUser;
    }
    private static double lastNameScore(User target) {
        int n = myPriority.indexOf(Priority.lastName); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getLastname().equals(lastName)) {
            score += (10^n) ;
        }
        return score;
    }
    private static double birthDayScore(User target) {
        int n = myPriority.indexOf(Priority.birthDay); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getBirthday().equals(birthDay)) {
            score += (10^n) ;
        }
        return score;
    }
    private static double cityScore(User target) {
        int n = myPriority.indexOf(Priority.birthLocation); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getBirthLocation().equals(birthLocation)) {
            score += (10^n) ;
        }
        return score;
    }
    private static double studyFieldScore(User target) {
        int n = myPriority.indexOf(Priority.field); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getField().equals(field)) {
            score += (10^n) ;
        }
        return score;
    }
    private static double workPlaceScore(User target) {
        int n = myPriority.indexOf(Priority.workPlace); // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getWorkplace().equals(workPlace)) {
            score += (10^n) ;
        }
        return score;
    }
    private static double specialtiesScore(User target) {
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
    private static double connectionScore(User target) {
        return 0;
    }
    private static AdminController admin = new AdminController() ;
    public static List<ScoreUser> goConnection(User person, int height) {
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
    public double Similarity (String word1 , String word2) {
        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        int n = 0;
        for (char x : a) {
            for (char y : b) {
                if (x == y) {
                    n++;
                    break;
                }
            }
        }
        return n / ((a.length + b.length) / 2);
    }
}
