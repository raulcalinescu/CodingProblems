package graphs;

import sun.security.provider.certpath.AdjacencyList;

import java.util.*;

public class ListGraph {

    static int V;
    static LinkedList <Integer> adjListArr[];

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

    //function to print Adj List representation of Graph

    static void printGraph (ListGraph graph) {
        for (int v = 0; v < graph.V; v ++) {
            System.out.println ("Adjacency List of Vertex " + v);
            System.out.println ("Head");
            for (Integer listNode: graph.adjListArr[v]) {
                System.out.print (" -> " + listNode);
            }
            System.out.println("\n");
        }
    }

    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        int v = sc.nextInt();
        ListGraph graph = new ListGraph(v);
        System.out.println ("Type 1 if you'd like to add an edge:");
        int add = sc.nextInt();
        System.out.println("\n");

        while (add == 1) {
            System.out.println ("Source:");
            int src = sc.nextInt();
            System.out.println("\n");

            System.out.println ("Destination:");
            int dst = sc.nextInt();
            System.out.println("\n");

            graph.addEdge(graph,src,dst);

            System.out.println ("Type 1 if you'd like to add an edge or 0 to continue:");
            add = sc.nextInt();
        }
        printGraph(graph);
    }
}
