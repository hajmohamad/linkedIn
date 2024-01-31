package Controller;

import Model.graph.AdjacencyMapGraph;
import Model.graph.Edge;
import Model.graph.User;

import java.util.ArrayList;
import java.util.List;

public class AdminController {
    private final AdjacencyMapGraph<User, String> Graph;
    public static AdminController adminController;

    public AdminController(){
        Graph = new AdjacencyMapGraph<>();
    }
    public static AdminController getInstance(){
        if (adminController == null){
            adminController = new AdminController();
        }
        return adminController;
    }
    public User addUser(String ID,String password, String name, String birthday, String lastname, String birthLocation, String field, String workplace){
        User user=new User(ID,password,name, birthday,lastname, birthLocation, field, workplace);
        Graph.insertVertex(user);
        return user;
    }
    public void RemoveUser(User user){
        Graph.removeVertex(user);
    }
   public void addConnection(User user1, User user2){
       Graph.insertEdge(user1,user2,user1.getID()+"-"+user2.getID());
   }
   public void removeConnection(User user1, User user2){
       Graph.removeEdge(user1.getID()+"-"+user2.getID());
   }
   public List<User> getAllUser(){
       return (List<User>) Graph.vertices();
   }
   public List<User> getAllUserConnections(User user){
        return Graph.getNeighbors(user);
   }
   public boolean hasConnection (User user1, User user2){
       return Graph.getEdge(user1, user2) != null;
   }
   public boolean login(String username, String password){
       List<User> list=getAllUser();
       for (User user:list){
           if (user.getName().equals(username) && user.getPassword().equals(password)) {
               UserController.getInstance();
               UserController.getInstance().setMainUser(user);
               return  true;
           }
       }
       return false;
   }
   public void logout(){
       UserController.getInstance().setMainUser(null);
   }

}
