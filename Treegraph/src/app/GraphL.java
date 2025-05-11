package app;
import java.util.*;

public class GraphL extends AdjL{
    boolean isDirected;
    int numVertices;
    int numEdge;
    
    public GraphL(boolean isDirected, int numVertices, int numEdge){
        super();
        this.isDirected = isDirected;
        this.numVertices = numVertices;
        this.numEdge = numEdge;
    }

    // @Override
    // public void addVertex(int ver){
    //     this.adjacencyList.putIfAbsent(ver, new ArrayList<>());
    // }

    @Override
    public void addEdge(int src, int dest, int weight){
        this.adjacencyList.putIfAbsent(src, new ArrayList<>());
        this.adjacencyList.get(src).add(new Pair<>(dest, weight));
        if(!isDirected){
            this.adjacencyList.putIfAbsent(dest, new ArrayList<>());
            this.adjacencyList.get(dest).add(new Pair<>(src, weight));
        }
    }
}
