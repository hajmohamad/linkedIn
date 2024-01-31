package Model.graph;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AdjacencyMapGraph<Integer, Integer> graph = new AdjacencyMapGraph<>();
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);
        graph.insertEdge(1, 2, 12);
        graph.insertEdge(1, 3, 13);
        System.out.println(graph.getEdge(2,1));
    }
}