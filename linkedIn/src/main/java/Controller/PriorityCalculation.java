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
    private static Map<Priority , Integer> myPriority = new HashMap();
    public static List<User> suggestions (User inputUser , int order) {
        if (inputUser != null) {
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
                scoreUser.addScore(birthLocationScore(user));
                scoreUser.addScore(fieldScore(user));
                scoreUser.addScore(workPlaceScore(user));
                scoreUser.addScore(specialtiesScore(user));
                bord.add(scoreUser);
            }

            List<ScoreUser> friends = goConnection(inputUser, 5); // travers on connection // عدد داخل تابع عمق جستجو رو نشون میده
            assert friends != null;
            bord.addAll(friends) ;

            bord.sort(Comparator.comparingDouble(ScoreUser::getScore));

            List<User> result = new ArrayList<>();

            result.removeAll(admin.getAllUserConnections(inputUser));

            if (bord.size() < order) {
                order = bord.size();
            }
            for (int i = 0; i < order; i++) {
                if (bord.size() > i) {
                    result.add(bord.get(bord.size()-1 - i).getUser());
                }
            }
            result.remove(inputUser) ;
            Set<User> setResult = new HashSet<>(userHaveLotConnections());
            setResult.addAll(result);
            List <User> myFinalResult = new ArrayList<>(setResult);
            return myFinalResult;
        } else {
            return null;
        }
    }
    public static void setMyPriority (Map<Priority , Integer> priorities) {
        myPriority = priorities ;
    }
    private static AdminController admin = AdminController.getInstance() ;
    private static ScoreUser nameScore(User target) {
        int n = 0 ;
        if (myPriority.get(Priority.name) != null) {
            n = myPriority.get(Priority.name);
        }
        int score = 0 ; // نمره دریافتی
        if (target.getName().equals(name)) {
            score += (500 * n) ;
        }
        ScoreUser scoreUser = new ScoreUser(target , score) ;
        return scoreUser;
    }
    private static double birthDayScore(User target) {
        int n = 0 ;
        if (myPriority.get(Priority.birthDay) != null) {
            n = myPriority.get(Priority.birthDay);
        }
        double score = 0 ; // نمره دریافتی
        if (target.getBirthday().equals(birthDay)) {
            score += (100 * n) ;
        }
        return score;
    }
    private static double birthLocationScore(User target) {
        int n = 0 ;
        if (myPriority.get(Priority.birthLocation) != null){
            n = myPriority.get(Priority.birthLocation);
        }
        double score = 0 ; // نمره دریافتی
        if (target.getBirthLocation().equals(birthLocation)) {
            score += (100 * n) ;
        }
        return score;
    }
    private static double fieldScore(User target) {
        int n = 0 ;
        if (myPriority.get(Priority.field) != null) {
            n = myPriority.get(Priority.field); // ضریب اولویت
        }
        double score = 0 ; // نمره دریافتی
        if (target.getField().equals(field)) {
            score += (100 * n) ;
        }
        return score;
    }
    private static double workPlaceScore(User target) {
        int n = 0 ;
        if (myPriority.get(Priority.workPlace) != null) {
            n = myPriority.get(Priority.workPlace); // ضریب اولویت
        }
        double score = 0 ; // نمره دریافتی
        if (target.getWorkplace().equals(workPlace)) {
            score += (100 * n) ;
        }
        return score;
    }
    private static double specialtiesScore(User target) {
        int n = 0 ;
        if (myPriority.get(Priority.specialties) != null) {
            n = myPriority.get(Priority.specialties); // ضریب اولویت
        }
        double score = 0 ; // نمره دریافتی
        for (String userSpecialty : target.getSpecialties()) {
            for (String targetSpecialty : specialties) {
                if ((userSpecialty).equals(targetSpecialty)) {
                    score += (100 * n^2);
                }
            }
        }
        return (score/2);
    }
    public static List<ScoreUser> goConnection(User person, int height) {
        List<ScoreUser> connections = new ArrayList<>();
        int n = 0 ;
        if (myPriority.get(Priority.connection) != null) {
            n = myPriority.get(Priority.connection);
        }
        if (height > 1) {
            if (person.getMyConnection().size() > 0) {
                for (User user : person.getMyConnection()) {
                    List<ScoreUser> friends = goConnection(user, height - 1);
                    connections.addAll(friends);
                    connections.add(new ScoreUser(user, 100 * (n^2)));
                }
            }
            return connections ;
        } else if (height == 1){
            List<ScoreUser> result = new ArrayList<>() ;
            for (User user : admin.getAllUserConnections(person)) {
                result.add(new ScoreUser(user , 100 * (n^2)));
            }
            return result;
        } else {
            return null ;
        }
    }
    public static List<User> userHaveLotConnections() {
        List<User> allUsers = new ArrayList<User>();
        allUsers=admin.getAllUser();
        allUsers.sort(Comparator.comparingDouble(User::getConnectNumber));
        return allUsers;

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
