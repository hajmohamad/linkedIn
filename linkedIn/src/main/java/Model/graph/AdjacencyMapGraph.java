package Model.graph;

import java.util.*;

public class AdjacencyMapGraph<Vertex, Edge> implements Graph<Vertex, Edge> {

    private Map<Vertex, VertexInfo<Vertex, Edge>> vertices;
    private Set<Edge> edges;
    private static class VertexInfo<V, E> {
        V vertex;
        Map<V, E> outgoingEdges;

        public VertexInfo(V vertex) {
            this.vertex = vertex;
            outgoingEdges = new HashMap<>();
        }

    }
    public AdjacencyMapGraph() {
        vertices = new HashMap<>();
        edges = new HashSet<>();
    }

    @Override
    public int numVertices() {
            return vertices.size();
    }

    @Override
    public Iterable<Vertex> vertices() {
        return vertices.keySet();
    }

    @Override
    public int numEdges() {
        return edges.size();
    }

    @Override
    public Iterable<Edge> edges() {
        return edges;
    }

    @Override
    public Edge getEdge(Vertex u, Vertex vertex) {
        VertexInfo<Vertex, Edge> vertexInfo = vertices.get(u);
        if (vertexInfo == null)
            return null;
        return vertexInfo.outgoingEdges.get(vertex);

    }

    @Override
    public List<Vertex> endVertices(Edge edge) {
        List<Vertex> list=new ArrayList<>();
        for (VertexInfo<Vertex, Edge> vertexInfo : vertices.values()) {
            for (Map.Entry<Vertex, Edge> entry : vertexInfo.outgoingEdges.entrySet()) {
                if (entry.getValue().equals(edge)) {
                    list.add(vertexInfo.vertex);
                    list.add(entry.getKey());
                    return list;
                }
            }
        }
        return null;
    }

    @Override
    public Vertex opposite(Vertex vertex, Edge edge) {
        VertexInfo<Vertex, Edge> vertexInfo = vertices.get(vertex);
        if (vertexInfo == null)
            return null;
        for (Map.Entry<Vertex, Edge> entry : vertexInfo.outgoingEdges.entrySet()) {
            if (entry.getValue().equals(edge)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public int outDegree(Vertex vertex) {
        VertexInfo<Vertex, Edge> vertexInfo = vertices.get(vertex);
        if (vertexInfo == null)
            return 0;
        return vertexInfo.outgoingEdges.size();
    }

    @Override
    public int inDegree(Vertex vertex) {
        int count = 0;
        for (VertexInfo<Vertex, Edge> vertexInfo : vertices.values()) {
            for (Map.Entry<Vertex, Edge> entry : vertexInfo.outgoingEdges.entrySet()) {
                if (entry.getKey().equals(vertex)) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public Collection<Edge> outgoingEdges(Vertex vertex) {
        VertexInfo<Vertex, Edge> vertexInfo = vertices.get(vertex);
        if (vertexInfo == null)
            return null;
        return vertexInfo.outgoingEdges.values();
    }

    @Override
    public Set<Edge> incomingEdges(Vertex vertex) {
        Set<Edge> incomingEdges = new HashSet<>();
        for (VertexInfo<Vertex, Edge> vertexInfo : vertices.values()) {
            for (Map.Entry<Vertex, Edge> entry : vertexInfo.outgoingEdges.entrySet()) {
                if (entry.getKey().equals(vertex)) {
                    incomingEdges.add(entry.getValue());
                }
            }
        }
        return incomingEdges;
    }

    @Override
    public Vertex insertVertex(Vertex vertex) {
        if (!vertices.containsKey(vertex)) {
            vertices.put(vertex, new VertexInfo<>(vertex));
            return vertex;
        }
        return null;
    }

    @Override
    public Edge insertEdge(Vertex u, Vertex vertex, Edge edge) {
        VertexInfo<Vertex, Edge> vertexInfo = vertices.get(u);
        if (vertexInfo == null)
            return null;

        if (vertexInfo.outgoingEdges.containsKey(vertex)) {
            return null; // Edge already exists
        }
        vertexInfo.outgoingEdges.put(vertex, edge);
        edges.add(edge);
        return edge;
    }

    @Override
    public void removeVertex(Vertex vertex) {
        VertexInfo<Vertex, Edge> vertexInfo = vertices.remove(vertex);
        if (vertexInfo != null) {
            // Remove all edges connected to this vertex
            for (Edge edge : vertexInfo.outgoingEdges.values()) {
                edges.remove(edge);
            }
            for (VertexInfo<Vertex, Edge> otherVertexInfo : vertices.values()) {
                otherVertexInfo.outgoingEdges.remove(vertex);
            }
        }
    }

    public List<Vertex> getNeighbors(Vertex vertex) {
        VertexInfo<Vertex, Edge> vertexInfo = vertices.get(vertex);
        if (vertexInfo == null)
            return null;
        return new ArrayList<>(vertexInfo.outgoingEdges.keySet());
    }

    @Override
    public void removeEdge(Edge edge) {
        edges.remove(edge);
        for (VertexInfo<Vertex, Edge> vertexInfo : vertices.values()) {
            vertexInfo.outgoingEdges.values().remove(edge);
        }
    }
}