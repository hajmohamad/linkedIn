package Model.graph;
import java.util.HashMap;
import java.util.Map;

public class Vertex { // راس
    private final User element;
    private final Map<Vertex, Edge> edges;

    public Vertex(User element) {
        this.element = element;
        edges = new HashMap<>();
    }

    public Object getElement() {
        return element;
    }

    public Map<Vertex, Edge> getEdges() {
        return edges;
    }
}