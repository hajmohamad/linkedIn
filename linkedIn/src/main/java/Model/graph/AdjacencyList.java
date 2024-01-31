package Model.graph;

import java.util.*;

public class AdjacencyList<Vertex, Edge>implements Graph<Vertex, Edge> {
    private Map<Vertex, List<Edge>> outgoingEdges;
    private Map<Vertex, List<Edge>> incomingEdges;
    private Map<Edge, Vertex> edgeToSource;
    private Map<Edge, Vertex> edgeToTarget;
    private Set<Vertex> vertices;
    private Set<Edge> edges;

    public AdjacencyList() {
        outgoingEdges = new HashMap<>();
        incomingEdges = new HashMap<>();
        edgeToSource = new HashMap<>();
        edgeToTarget = new HashMap<>();
        vertices = new HashSet<>();
        edges = new HashSet<>();
    }

    @Override
    public int numVertices() {
        return vertices.size();
    }

    @Override
    public Iterable<Vertex> vertices() {
        return vertices;
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
    public Edge getEdge(Vertex u, Vertex v) {
        List<Edge> outgoing = outgoingEdges.get(u);
        if (outgoing == null) {
            return null;
        }
        for (Edge e : outgoing) {
            if (edgeToTarget.get(e).equals(v)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Vertex> endVertices(Edge e) {
        List<Vertex> endVertices = new ArrayList<>();
        endVertices.add(edgeToSource.get(e));
        endVertices.add(edgeToTarget.get(e));
        return endVertices;
    }

    @Override
    public Vertex opposite(Vertex v, Edge e) {
        if (edgeToSource.get(e).equals(v)) {
            return edgeToTarget.get(e);
        } else if (edgeToTarget.get(e).equals(v)) {
            return edgeToSource.get(e);
        } else {
            return null;
        }
    }

    @Override
    public int outDegree(Vertex v) {
        List<Edge> outgoing = outgoingEdges.get(v);
        if (outgoing == null) {
            return 0;
        }
        return outgoing.size();
    }

    @Override
    public int inDegree(Vertex v) {
        List<Edge> incoming = incomingEdges.get(v);
        if (incoming == null) {
            return 0;
        }
        return incoming.size();
    }

    @Override
    public Iterable<Edge> outgoingEdges(Vertex v) {
        List<Edge> outgoing = outgoingEdges.get(v);
        if (outgoing == null) {
            return Collections.emptyList();
        }
        return outgoing;
    }

    @Override
    public Iterable<Edge> incomingEdges(Vertex v) {
        List<Edge> incoming = incomingEdges.get(v);
        if (incoming == null) {
            return Collections.emptyList();
        }
        return incoming;
    }

    @Override
    public Vertex insertVertex(Vertex x) {
        vertices.add(x);
        return x;
    }

    @Override
    public Edge insertEdge(Vertex u, Vertex v, Edge x) {
        if (!vertices.contains(u) || !vertices.contains(v)) {
            throw new IllegalArgumentException("Vertices must be in the graph");
        }
        outgoingEdges.computeIfAbsent(u, k -> new ArrayList<>()).add(x);
        incomingEdges.computeIfAbsent(v, k -> new ArrayList<>()).add(x);
        edgeToSource.put(x, u);
        edgeToTarget.put(x, v);
        edges.add(x);
        return x;
    }


    @Override
    public void removeVertex(Vertex v) {
        if (!vertices.contains(v)) {
            throw new IllegalArgumentException("Vertex must be in the graph");
        }
        // Remove all outgoing edges
        List<Edge> outgoing = outgoingEdges.get(v);
        if (outgoing != null) {
            for (Edge e : outgoing) {
                removeEdge(e);
            }
        }
        // Remove all incoming edges
        List<Edge> incoming = incomingEdges.get(v);
        if (incoming != null) {
            for (Edge e : incoming) {
                removeEdge(e);
            }
        }
        // Remove the vertex itself
        vertices.remove(v);
        outgoingEdges.remove(v);
        incomingEdges.remove(v);
    }

    @Override
    public void removeEdge(Edge e) {
        if (!edges.contains(e)) {
            throw new IllegalArgumentException("Edge must be in the graph");
        }
        Vertex u = edgeToSource.get(e);
        List<Edge> outgoing = outgoingEdges.get(u);
        outgoing.remove(e);
        if (outgoing.isEmpty()) {
            outgoingEdges.remove(u);
        }
        Vertex v = edgeToTarget.get(e);
        List<Edge> incoming = incomingEdges.get(v);
        incoming.remove(e);
        if (incoming.isEmpty()) {
            incomingEdges.remove(v);
        }

        edges.remove(e);
        edgeToSource.remove(e);
        edgeToTarget.remove(e);
    }
}