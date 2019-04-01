package graphs;

import java.util.*;

public class ListGraph {

    int V;
    LinkedList <Integer> adjListArr[];

    ListGraph (int V) {         // Graph constructor
        this.V = V;
        adjListArr = new LinkedList[V];     // define the size of array as number of vertices

        for (int i = 0; i < V; i++) {
            adjListArr[i] = new LinkedList<>();  // Create a new list for each vertex so adjacent nodes can be stored

        }
    }

}
