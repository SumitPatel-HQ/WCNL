// The Floyd-Warshall algorithm implementation looks correct. The algorithm has the expected time complexity of O(V³) where V is the number of vertices, and the space complexity is O(V²) for storing the distance matrix.

class FloydWarshall {
    final static int M = 99999;

    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        System.out.println("Running Floyd-Warshall Algorithm...");
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != M && dist[k][j] != M && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist, V);
    }

    void printSolution(int dist[][], int V) {
        System.out.println("\n----- Shortest distances between every pair of vertices -----");
        
        System.out.print("    ");
        for (int j = 0; j < V; j++) {
            System.out.printf("  %2d  ", j);
        }
        System.out.println();
        
        System.out.print("  --");
        for (int j = 0; j < V; j++) {
            System.out.print("------");
        }
        System.out.println();
        
        for (int i = 0; i < V; i++) {
            System.out.printf(" %d | ", i);
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == M)
                    System.out.print(" INF  ");
                else
                    System.out.printf(" %3d  ", dist[i][j]);
            }
            System.out.println();
        }
    }

    void printGraph(int graph[][], int V) {
        System.out.println("----- Input Graph (Adjacency Matrix) -----");
        
        System.out.print("    ");
        for (int j = 0; j < V; j++) {
            System.out.printf("  %2d  ", j);
        }
        System.out.println();
        
        System.out.print("  --");
        for (int j = 0; j < V; j++) {
            System.out.print("------");
        }
        System.out.println();
        
        for (int i = 0; i < V; i++) {
            System.out.printf(" %d | ", i);
            for (int j = 0; j < V; j++) {
                if (graph[i][j] == M)
                    System.out.print(" INF  ");
                else
                    System.out.printf(" %3d  ", graph[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 4;
        int graph[][] = {
            {0, 3, M, 5},
            {2, 0, M, 4},
            {M, 1, 0, M},
            {M, M, 2, 0}
        };

        FloydWarshall fw = new FloydWarshall();
        fw.printGraph(graph, V);
        fw.floydWarshall(graph, V);
    }
}
