package Controller;

import Model.graph.AdjacencyMapGraph;
import Model.graph.User;

import java.util.ArrayList;
import java.util.List;

public class AdminController {
    private final AdjacencyMapGraph<User, String> graph;
    public static AdminController adminController;

    public AdminController() {
        graph = new AdjacencyMapGraph<>();
    }

    public static AdminController getInstance() {
        if (adminController == null) {
            adminController = new AdminController();
        }
        return adminController;
    }

    public int size() {
        return graph.numVertices();
    }
    public User search (String id) {
        User result = null ;
        for(User user : graph.vertices()) {
            if (user.getID().equals(id)) {
                result = user ;
                break;
            }
        }
        return result ;
    }

    public User makeUser(String ID, String password, String name, String birthday, String birthLocation, String field, String workplace) {
        User user = new User(ID, password, name, birthday, birthLocation, field, workplace);
        return user;
    }

    public void addUser(User user) {
        graph.insertVertex(user);
    }

    public void RemoveUser(User user) {
        graph.removeVertex(user);
    }

    public void addConnection(User user1, User user2) {
        graph.insertEdge(user1, user2, user1.getID() + "-" + user2.getID());
    }

    public void removeConnection(User user1, User user2) {
        graph.removeEdge(user1.getID() + "-" + user2.getID());
    }

    public List<User> getAllUser() {
        List<User> result = new ArrayList<>();
        for (User ob : graph.vertices()) {
            result.add(ob);
        }
        return result;
    }

    public List<User> getAllUserConnections(User user) {
        return graph.getNeighbors(user);
    }

    public boolean hasConnection(User user1, User user2) {
        return graph.getEdge(user1, user2) != null;
    }

    public boolean login(String username, String password) {
        List<User> list = getAllUser();
        for (User user : list) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                UserController.getInstance();
                UserController.getInstance().setMainUser(user);
                return true;
            }
        }
        return false;
    }
    public User getUserById(String id) {
        for (User user : graph.vertices()) {
            if (user.getID().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void logout() {
        UserController.getInstance().setMainUser(null);
    }

}
