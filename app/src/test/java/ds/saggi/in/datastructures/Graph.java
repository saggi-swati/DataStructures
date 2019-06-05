package ds.saggi.in.datastructures;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    private int V = 4;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    public Graph() {
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    private void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // prints BFS traversal from a given source s
    private void BFS(int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer n : adj[s]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    @Test
    public void testBFS() {
        Graph g = new Graph();

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.BFS(2);
    }

    @Test
    public void testDFS() {
        Graph g = new Graph();


        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(3, 1);

        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");
        boolean visited[] = new boolean[V];
        DFS(g, visited, 2, 1);

    }

    private void DFS(Graph g, boolean[] visited, int src, int dest) {
        if (src == dest) return;
        visited[src] = true;
        System.out.print(src + " ");

        for (Integer n : g.adj[src]) {
            if (!visited[n]) {
                visited[n] = true;
                DFS(g, visited, n, dest);
            }
        }
    }

    // Not confirmed.
    @Test
    public void testDfsUsingStack() {
        Graph g = new Graph();


        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(3, 1);

        Stack<Integer> s = new Stack<>();
        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");
        boolean visited[] = new boolean[V];

        int src = 2;
        visited[2] = true;

        s.push(src);

        while(!s.isEmpty()) {
            int v = -1;
            for (Integer i : g.adj[s.peek()]) {
                if(!visited[i]){
                    v = i;
                    break;
                }
            }
            if(v == -1){
                s.pop();
            } else {
                visited[v] = true;
                System.out.print(v + " ");
                s.push(v);
            }
        }
        System.out.println("Graph.testDfsUsingStack" + s);
    }
}