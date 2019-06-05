package ds.saggi.in.datastructures;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GraphDisjointSets {

    private int V, E;
    private Edge edges[];
    private List<List<Integer>> adjList;

    class Edge {
        int src, dest;
    }

    public GraphDisjointSets() {

    }

    private GraphDisjointSets(int V, int E) {
        this.V = V;
        this.E = E;
        this.edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
        }

        adjList = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());
    }

    private int find(int x, int[] parent) {
        if (parent[x] == -1)
            return x;
        else
            return find(parent[x], parent);
    }

    private void union(int[] parent, int x, int y) {
        int xset = find(x, parent);
        int yset = find(y, parent);

        parent[xset] = yset;
    }

    private boolean checkIfCycle() {

        int parent[] = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = -1;

        for (int i = 0; i < E; i++) {
            int x = find(edges[i].src, parent);
            int y = find(edges[i].dest, parent);


            if (x == y) return true;

            union(parent, x, y);
        }
        return false;
    }

    class SubSet {
        int rank;
        int parent;
    }

    private int findUsingRank(int x, SubSet[] subSets) {
        if (subSets[x].parent == -1)
            return x;
        else
            return findUsingRank(subSets[x].parent, subSets);
    }

    private void unionUsingRank(SubSet[] subSets, int x, int y) {
        int xset = findUsingRank(x, subSets);
        int yset = findUsingRank(y, subSets);

        if (xset == yset) return;

        if (subSets[xset].rank < subSets[yset].rank)
            subSets[yset].parent = xset;
        if (subSets[yset].rank < subSets[xset].rank)
            subSets[xset].parent = yset;
        else {
            subSets[xset].parent = yset;
            subSets[yset].rank++;
        }
    }

    private boolean checkIfCycleUsingRank() {

        SubSet[] subSets = new SubSet[V];
        for (int i = 0; i < V; i++) {
            subSets[i] = new SubSet();
            subSets[i].parent = -1;
            subSets[i].rank = 0;
        }

        for (int i = 0; i < E; i++) {
            int x = findUsingRank(edges[i].src, subSets);
            int y = findUsingRank(edges[i].dest, subSets);

            if (x == y) return true;

            unionUsingRank(subSets, x, y);
        }

        return false;
    }

    @Test
    public void isCycle() {

        GraphDisjointSets graph = new GraphDisjointSets(3, 3);

        if (graph.E > graph.V - 1) {
            System.out.println("GraphDisjointSets.isCycle " + true);
            return;
        }

        // add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;

        // add edge 1-2
        graph.edges[1].src = 1;
        graph.edges[1].dest = 2;

        // add edge 2-0
        graph.edges[1].src = 2;
        graph.edges[1].dest = 0;


        System.out.println("GraphDisjointSets.isCycle : " + graph.checkIfCycle());
        System.out.println("GraphDisjointSets.isCycle : " + graph.checkIfCycleUsingRank());
    }

    private void addEdge(int source, int dest) {
        adjList.get(source).add(dest);
    }

    @Test
    public void testCycleUsingDFS() {
        GraphDisjointSets g = new GraphDisjointSets(4, 6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        boolean recStack[] = new boolean[g.V];
        boolean visited[] = new boolean[g.V];
        for(int i = 0;i< g.V;i++) {
            if(g.checkIfCycleUsingDFS(i, recStack, visited)) {
                System.out.println("GraphDisjointSets.testCycleUsingDFS : " + true );
                return;
            }
        }

        System.out.println("GraphDisjointSets.testCycleUsingDFS : " + false );
    }

    private boolean checkIfCycleUsingDFS(int i, boolean[] r, boolean[] v) {

        if(r[i]) return true;
        if(v[i]) return false;

        v[i] = true;
        r[i] = true;

        for(int a: adjList.get(i)) {
           if( checkIfCycleUsingDFS(a, r, v)) return true;
        }
        r[i] = false;


        return false;
    }
}
