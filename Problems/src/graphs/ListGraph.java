package graphs;

import java.util.*;

public class ListGraph {

    public static int V;
    public static LinkedList <Integer> adjListArr[];

    ListGraph (int V) {         // Graph constructor
        this.V = V;
        adjListArr = new LinkedList[V];     // define the size of array as number of vertices

        for (int i = 0; i < V; i++) {
            adjListArr[i] = new LinkedList<>();  // Create a new list for each vertex so adjacent nodes can be stored

        }
    }
        //add an edge to an undirected / bi-directed graph
    static void addEdge (ListGraph graph, int source, int destination) {
        adjListArr[source].add(destination);  // for di-graph: add edge from source to destination

        adjListArr[destination].add(source); // for bi directed or undirected graph: add edge from dest to source too
    }

}
