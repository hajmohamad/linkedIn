package Controller;

import Model.graph.User;

class ScoreUser {
    private User user;
    private double score;

    public ScoreUser(User user, double score) {
        this.user = user;
        this.score = score;
    }

    public void addScore(double n) {
        this.score += n;
    }

    public User getUser() {
        return user;
    }

    public double getScore() {
        return score;
    }
}
