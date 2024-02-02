package Controller;

import Model.graph.User;

import java.util.*;

public abstract class PriorityCalculation {
    private static String name ;
    private static String  birthDay ;
    private static String birthLocation ;
    private static String field ;
    private static String workPlace ;
    private static List<String> specialties ;
    private final static List<Priority> myPriority = new ArrayList<>();
    public static List<User> suggestions (User inputUser , int order) {
        if (inputUser != null) {
//            لیست اولیت ها رو بهش بده
            myPriority.add(Priority.specialties); //            اولیت تمرینی فقط نام تایین شده
            name = inputUser.getName();
            birthDay = inputUser.getBirthday();
            birthLocation = inputUser.getBirthLocation();
            field = inputUser.getField();
            workPlace = inputUser.getWorkplace();
            specialties = inputUser.getSpecialties();
            List<ScoreUser> bord = new ArrayList<>(); // مقایسه کردن ویزگی ها
            List<User> allUsers = admin.getAllUser();
            for (User user : admin.getAllUser()) {
                ScoreUser scoreUser = nameScore(user); // ساهت یک اسکور یوزر
                scoreUser.addScore(birthDayScore(user)); // افزایش امتیاز ان
                scoreUser.addScore(cityScore(user));
                scoreUser.addScore(studyFieldScore(user));
                scoreUser.addScore(workPlaceScore(user));
                scoreUser.addScore(specialtiesScore(user));
                bord.add(scoreUser);
            }

            bord.stream().sorted(); // چک کن

            List<ScoreUser> friends = goConnection(inputUser, 5); // travers on connection // عدد داخل تابع عمق جستجو رو نشون میده


            List<User> result = new ArrayList<>();

            if (bord.size() < order) {
                order = bord.size();
            }
            for (int i = 0; i < order; i++) {
                if (friends.size() > i) {
                    result.add(friends.get(i).getUser());
                }
                if (bord.size() > i) {
                    result.add(bord.get(i).getUser());
                }
            }
            result.removeAll(UserController.mainUser.getMyConnection());
            return result;
        } else {
            return null;
        }
    }
    private static AdminController admin = AdminController.getInstance() ;
    private static ScoreUser nameScore(User target) {
        int n = myPriority.indexOf(Priority.name) + 1; // ضریب اولویت
        int score = 0 ; // نمره دریافتی
        if (target.getName().equals(name)) {
            score += (10^n) ;
        }
        ScoreUser scoreUser = new ScoreUser(target , score) ;
        return scoreUser;
    }
    private static double birthDayScore(User target) {
        int n = myPriority.indexOf(Priority.birthDay) + 1; // ضریب اولویت
        double score = 0 ; // نمره دریافتی
        if (target.getBirthday().equals(birthDay)) {
            score += (10^n) ;
        }
        return score;
    }
    private static double cityScore(User target) {
        int n = myPriority.indexOf(Priority.birthLocation) + 1; // ضریب اولویت
        double score = 0 ; // نمره دریافتی
        if (target.getBirthLocation().equals(birthLocation)) {
            score += (10^n) ;
        }
        return score;
    }
    private static double studyFieldScore(User target) {
        int n = myPriority.indexOf(Priority.field) + 1; // ضریب اولویت
        double score = 0 ; // نمره دریافتی
        if (target.getField().equals(field)) {
            score += (10^n) ;
        }
        return score;
    }
    private static double workPlaceScore(User target) {
        int n = myPriority.indexOf(Priority.workPlace) + 1; // ضریب اولویت
        double score = 0 ; // نمره دریافتی
        if (target.getWorkplace().equals(workPlace)) {
            score += (10^n) ;
        }
        return score;
    }
    private static double specialtiesScore(User target) {
        int n = myPriority.indexOf(Priority.specialties) + 1; // ضریب اولویت
        double score = 0 ; // نمره دریافتی
        for (String userSpecialty : target.getSpecialties()) {
            for (String targetSpecialty : specialties) {
                if ((userSpecialty).equals(targetSpecialty)) {
                    score += (10 ^ n);
                }
            }
        }
        return (score/2);
    }
    public static List<ScoreUser> goConnection(User person, int height) {
        List<ScoreUser> connections = new ArrayList<>() ;
        int n = myPriority.indexOf(Priority.connection);
        if (height > 1) {
            if (person.getMyConnection().size() > 0) {
                for (User user : person.getMyConnection()) {
                    List<ScoreUser> friends = goConnection(user, height - 1);
                    connections.addAll(friends);
                    connections.add(new ScoreUser(user, (10^height) * 10 * n));
                }
            }
            return connections ;
        } else if (height == 1){
            List<ScoreUser> result = new ArrayList<>() ;
            for (User user : admin.getAllUserConnections(person)) {
                result.add(new ScoreUser(user , (10^height) * 10 * n));
            }
            return result;
        } else {
            return null ;
        }
    }

//    از این تابع که درصد شباهت رو بررسی میکنه هم میتونی استفاده کنی (امتیازی)
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
