// Time Complexity: O(E log E) where E is the number of edges
// This is because sorting the edges takes O(E log E) time and the find-union operations take O(V) time.
import java.util.*;

class KruskalMST {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class Subset {
        int parent, rank;
    }

    int V, E;
    Edge[] edges;

    KruskalMST(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge();
        }
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void union(Subset subsets[], int x, int y) {
        int rootX = find(subsets, x);
        int rootY = find(subsets, y);

        if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else if (subsets[rootX].rank > subsets[rootY].rank) {
            subsets[rootY].parent = rootX;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    void kruskalMST() {
        Edge[] result = new Edge[V];
        int e = 0, i = 0;
        for (i = 0; i < V; i++) {
            result[i] = new Edge();
        }

        Arrays.sort(edges);

        Subset[] subsets = new Subset[V];
        for (i = 0; i < V; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        i = 0;
        while (e < V - 1) {
            Edge nextEdge = edges[i++];
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("Edges in the MST:");
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;
        KruskalMST graph = new KruskalMST(V, E);

        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 10;

        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 6;

        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 5;

        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 15;

        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 4;

        graph.kruskalMST();
    }
}
