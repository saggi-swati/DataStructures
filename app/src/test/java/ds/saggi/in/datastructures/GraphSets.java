package ds.saggi.in.datastructures;

import java.util.HashSet;

public class GraphSets {

    static class Graph {
        int v;
        HashSet<Integer>[] adj;

    }

    static Graph createGraph(int v) {
        Graph graph = new Graph();
        graph.v = v;
        graph.adj = new HashSet[v];
        for (int i = 0; i < v; i++) {
            graph.adj[i] = new HashSet<>();
        }

        return graph;
    }

    static void addEdge(Graph g, int src, int dest) {
        g.adj[src].add(dest);
        g.adj[dest].add(src);   // Only for undirected graph.
    }

    static void printGraph(Graph g) {
        for (int i = 0; i < g.v; i++) {
            System.out.print("Adjacency list of vertex " + i + " : ");
            for(int n : g.adj[i]) {
                System.out.print( n  + " ");
            }
            System.out.println();
        }
    }

    static void searchEdge(Graph g, int src, int dest) {
        if( src >= g.v || dest >= g.v ) {
            System.out.println("Vertices out of bound");
            return;
        }

        for(int n : g.adj[src]) {
            if( n == dest) {
                System.out.println("Edge found from " + src + " to " + dest);
                return;
            }
        }
        System.out.println("No edge present from " + src + " to " + dest);

    }

    public static void main(String[] args) {
        Graph g = createGraph(5);

        addEdge(g, 0, 1);
        addEdge(g, 0, 4);
        addEdge(g, 1, 2);
        addEdge(g, 1, 3);
        addEdge(g, 1, 4);
        addEdge(g, 2, 3);
        addEdge(g, 3, 4);

        printGraph(g);

        searchEdge(g, 1, 4);

        searchEdge(g, 1, 6);
    }
}
