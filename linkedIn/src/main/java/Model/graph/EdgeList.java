package Model.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EdgeList implements Graph{
    private int numVertex = 0;
    private int numEdge = 0 ;
    private LinkedList<Vertex> vertices ;
    private LinkedList<Edge> edges ;
    public LinkedList<Vertex> getVertices() {
        return vertices;
    }
    public LinkedList<Edge> getEdges() {
        return edges;
    }

    @Override
    public int numVertices() {
        return numVertex;
    }

    @Override
    public Iterable vertices() {
        return vertices;
    }

    @Override
    public int numEdges() {
        return numEdge;
    }

    @Override
    public Iterable edges() {
        return edges;
    }

    @Override
    public Object getEdge(Object u, Object v) {
        for (Object ob : edges()) {
            Edge edge = (Edge) ob;
            if (edge.getEndpoints()[0].equals(u)) {
                if (edge.getEndpoints()[1].equals(v)) {
                    return edge ;
                }
            }
            if (edge.getEndpoints()[0].equals(v)) {
                if (edge.getEndpoints()[1].equals(u)) {
                    return edge ;
                }
            }
        }
        return null;
    }

    @Override
    public Object[] endVertices(Object e) {
        Vertex [] result = ((Edge) e).getEndpoints();
        return result;
    }

    @Override
    public Object opposite(Object v, Object e) {
        Edge edge = (Edge) e;
        Vertex vertex0 = edge.getEndpoints()[0] ;
        Vertex vertex1 = edge.getEndpoints()[1] ;
        if (vertex0.equals(v)){
            return vertex0 ;
        } else if (vertex1.equals(v)) {
            return vertex1 ;
        } else {
            return null;
        }
    }

    @Override
    public int outDegree(Object v) {
        List <Edge> result = new ArrayList<>() ;
        for (Object ob : edges()) {
            Edge edge = (Edge) ob;
            if (edge.getEndpoints()[0].equals(v)) {
                result.add(edge);
            } else if (edge.getEndpoints()[1].equals(v)) {
                result.add(edge);
            }
        }
        return result.size();
    }

    @Override
    public int inDegree(Object v) {
        List <Edge> result = new ArrayList<>() ;
        for (Object ob : edges()) {
            Edge edge = (Edge) ob;
            if (edge.getEndpoints()[0].equals(v)) {
                result.add(edge);
            } else if (edge.getEndpoints()[1].equals(v)) {
                result.add(edge);
            }
        }
        return result.size();
    }

    @Override
    public Iterable outgoingEdges(Object v) {
        List <Edge> result = new ArrayList<>() ;
        for (Object ob : edges()) {
            Edge edge = (Edge) ob;
            if (edge.getEndpoints()[0].equals(v)) {
                result.add(edge);
            } else if (edge.getEndpoints()[1].equals(v)) {
                result.add(edge);
            }
        }
        return result;
    }

    @Override
    public Iterable incomingEdges(Object v) {
        List <Edge> result = new ArrayList<>() ;
        for (Object ob : edges()) {
            Edge edge = (Edge) ob;
            if (edge.getEndpoints()[0].equals(v)) {
                result.add(edge);
            } else if (edge.getEndpoints()[1].equals(v)) {
                result.add(edge);
            }
        }
        return result;
    }

    @Override
    public Object insertVertex(Object x) {
        Vertex vertex = new Vertex((User) x) ;
        vertices.add(vertex) ;
        numVertex ++ ;
        return null;
    }

    @Override
    public Object insertEdge(Object u, Object v, Object x) {
        Edge edge = new Edge((Vertex) u, (Vertex) v, (String) x) ;
        edges.add(edge);
        numEdge ++ ;
        return null;
    }

    @Override
    public void removeVertex(Object v) {
        if  (vertices.remove(v)) {
            numVertex -- ;
        }
    }

    @Override
    public void removeEdge(Object e) {
        if(edges.remove(e)) {
            numEdge -- ;
        }
    }
}
