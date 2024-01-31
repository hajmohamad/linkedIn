package Model.graph;

import java.util.List;
import java.util.Set;

public interface Graph<Vertex, Edge> {
    int numVertices();
    Iterable<Vertex> vertices();
    int numEdges();
    Iterable<Edge> edges();
    Edge getEdge(Vertex u, Vertex v);
    List<Vertex> endVertices(Edge e);
    Vertex opposite(Vertex v, Edge e);
    int outDegree(Vertex v);
    int inDegree(Vertex v);
    Iterable<Edge> outgoingEdges(Vertex v);
    Iterable<Edge> incomingEdges(Vertex v);
    Vertex insertVertex(Vertex x);
    Edge insertEdge(Vertex u, Vertex v, Edge x);
    void removeVertex(Vertex v);
    void removeEdge(Edge e);
}
