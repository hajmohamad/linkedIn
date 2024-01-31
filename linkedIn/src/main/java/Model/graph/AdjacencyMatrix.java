package Model.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrix implements Graph {
    private int numVertex;
    private int numEdge = 0 ;
    private Edge [][] matrix ;
    private List <Vertex> vertices ;
    public AdjacencyMatrix () {
        numVertex = 0 ;
        vertices = new ArrayList<>() ;
        matrix = new Edge [0][0] ;
    }
    public AdjacencyMatrix (int n) {
        numVertex = n ;
        vertices = new ArrayList<>(n) ;
        matrix = new Edge [n][n] ;
    }
    public int getNumVertex() {
        return numVertex;
    }
    public int getNumEdge() {
        return numEdge;
    }
    public List<Vertex> getVertices() {
        return vertices;
    }
    public Edge[][] getMatrix() {
        return matrix;
    }
    public boolean vertexExisted (Vertex v) {
        for (Vertex vertex : vertices) {
            if (vertex.equals(v)) {
                return false ;
            }
        }
        return true ;
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
        return Collections.singleton(matrix);
    }

    @Override
    public Object getEdge(Object u, Object v) {
        int i = vertices.indexOf(u);
        int j = vertices.indexOf(v);
        return matrix[i][j];
    }

    @Override
    public Object[] endVertices(Object e) {
        Vertex[] result = new Vertex[2] ;
        boolean found = false ;
        for (int i = 0; i < numVertex ; i++) {
            for (int j = 0; j < numVertex; j++) {
                if (matrix[i][j].equals(e)) {
                    result[0] = vertices.get(i);
                    result[1] = vertices.get(j);
                    found = true;
                    break;
                }
            }
            if (found){
                break;
            }
        }
        return result;
    }

    @Override
    public Object opposite(Object v, Object e) {
        int i = vertices.indexOf(v) ;
        for (int j = 0 ; j < numVertex ; j++) {
            if (matrix[i][j].equals(e)) {
                return vertices.get(j);
            }
        }
        return null;
    }

    @Override
    public int outDegree(Object v) {
        int counter = 0 ;
        for (int i = 0 ; i < numVertex ; i++) {
            if (matrix[vertices.indexOf(v)][i] != null) {
                counter ++ ;
            }
        }
        return counter;
    }

    @Override
    public int inDegree(Object v) {
        int counter = 0 ;
        for (int i = 0 ; i < numVertex ; i++) {
            if (matrix[vertices.indexOf(v)][i] != null) {
                counter ++ ;
            }
        }
        return counter;
    }

    @Override
    public Iterable outgoingEdges(Object v) {
        List <Edge> result = new ArrayList<>() ;
        for (int i = 0 ; i < numVertex ; i++) {
            if (matrix[vertices.indexOf(v)][i] != null) {
                result.add(matrix[vertices.indexOf(v)][i]);
            }
        }
        return result;
    }

    @Override
    public Iterable incomingEdges(Object v) {
        List <Edge> result = new ArrayList<>() ;
        for (int i = 0 ; i < numVertex ; i++) {
            if (matrix[vertices.indexOf(v)][i] != null) {
                result.add(matrix[vertices.indexOf(v)][i]);
            }
        }
        return result;
    }

    @Override
    public Object insertVertex(Object x) {
        Vertex newVertex = new Vertex((User) x);
        if (! vertexExisted(newVertex)) {
            Edge[][] newMatrix = new Edge[numVertex + 1][numVertex + 1];
            for (int i = 0; i < numVertex; i++) {
                for (int j = 0; j < numVertex; j++) {
                    newMatrix[i][j] = matrix[i][j];
                }
            }
            vertices.add(newVertex);
            numVertex++;
            matrix = newMatrix;
            return newVertex;
        } else {
            return null ;
        }
    }

    @Override
    public Object insertEdge(Object u, Object v, Object x) {
        int i = vertices.indexOf(u) ;
        int j = vertices.indexOf(v) ;
        if (matrix[i][j] == null) {
            Edge edge = new Edge((Vertex) u, (Vertex) v, (String) x) ;
            matrix[i][j] = edge ;
            numEdge ++ ;
            return edge;
        } else {
            return null ;
        }
    }

    @Override
    public void removeVertex(Object v) {
        if (numVertex > 0) {
            boolean found = false;
            for (Vertex vertex : vertices) {
                if (vertex.equals(v)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                Edge[][] newMatrix = new Edge[numVertex - 1][numVertex - 1];
                int iMine = 0;
                int jMine = 0;
                for (int i = 0; i < numVertex; i++) {
                    for (int j = 0; j < numVertex; j++) {
                        if (i != vertices.indexOf(v)) {
                            if (j != vertices.indexOf(v)) {
                                newMatrix[i][j] = matrix[i - iMine][j - jMine];
                            } else {
                                jMine = 1;
                            }
                        } else {
                            iMine = 1;
                        }
                    }
                    jMine = 0;
                }
                vertices.remove(v);
                numVertex--;
                matrix = newMatrix;
            }
        }
    }

    @Override
    public void removeEdge(Object e) {
        if (numVertex > 0) {
            boolean found = false;
            for (int i = 0; i < numVertex; i++) {
                for (int j = 0; j < numVertex; j++) {
                    if (matrix[i][j].equals(e)) {
                        matrix[i][j] = null;
                        numEdge--;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
        }
    }
}
