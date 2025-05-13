package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class survivalMain {
    public static void main(String[] args) throws Exception {
        /***********************************
         * Survival Ep.1
         ***********************************/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        GraphM graph = new GraphM(n, true);

        for (int i = 0; i < m; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            int distance = sc.nextInt();

            graph.addEdge(source, destination, distance);
        }

        MyAlgorithm myAlg = new MyAlgorithm();
        List<Integer> reach = new ArrayList<>();
        for (int i = 0; i < graph.numVertices; i++) {
            for (int j = 0; j < graph.numVertices; j++) {
                if (myAlg.floyd(graph, i, j) >= 0 && myAlg.floyd(graph, i, j) < 10000) {
                    reach.add(j);
                }
            }
            System.out.printf("From Cave" + i + ", reachable caves:\n[");
            for (int k = 0; k < reach.size(); k++) {
                System.out.print(reach.get(k));
                if (k != reach.size() - 1) {
                    System.out.printf(", ");
                }
            }
            reach.clear();
            System.out.println("]");
        }
        sc.close();

        /***********************************
         * Survival Ep.2
         ***********************************/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        GraphL graph = new GraphL(false, n, m);
        for (int i = 0; i < graph.numEdge; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.addEdge(u, v, 1);
        }

        int s = sc.nextInt(); // start
        int v = sc.nextInt(); // destination
        int z = sc.nextInt(); // start

        MyAlgorithm myAlg = new MyAlgorithm();
        if (myAlg.dijkstra(graph, s, v) >= myAlg.dijkstra(graph, z, v)) {
            System.out.println("SAFE");
        } else {
            System.out.println("TOO LATE");
        }
        sc.close();
    }
}
