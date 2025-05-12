package app;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // /***********************************
        // * PreTest
        // ****************************************/
        // Scanner sc = new Scanner(System.in);
        // BST myBst = new BST();
        // MyAlgorithm myAlg = new MyAlgorithm();
        // int nNode = sc.nextInt();
        // for (int i = 0; i < nNode; i++) {
        // int temp = sc.nextInt();
        // myBst.insertNode(temp);
        // }

        // List<Integer> answers = myAlg.inorder(myBst);
        // System.out.println(answers);
        // sc.close();

        // /***********************************
        // * Magic Powder
        // ****************************************/
        // MyAlgorithm myAlg = new MyAlgorithm();
        // Scanner sc = new Scanner(System.in);
        // int e = sc.nextInt() + 1;
        // int n = sc.nextInt();
        // sc.nextLine();

        // int destNode = -1;
        // GraphL graphL = new GraphL(false, e, n);
        // for (int i = 0; i < n; i++) {
        // int a = sc.nextInt();
        // String bond = sc.next();
        // int b = sc.nextInt();

        // graphL.addEdge(a, b, 1);

        // if (bond.equals("=")) {
        // destNode = b;
        // }
        // }

        // sc.close();

        // // เอาleaf(startNode)
        // List<Integer> leaf = new ArrayList<>();
        // for (int i = 0; i < graphL.numVertices; i++) {
        // if (graphL.adjacencyList.containsKey(i) && graphL.adjacencyList.get(i).size()
        // == 1) {
        // leaf.add(i);
        // }
        // }

        // PriorityQueue<Pair<Integer, Integer>> result = new PriorityQueue<>();
        // for (int i = 0; i < leaf.size(); i++) {
        // int minWeight = myAlg.dijkstra(graphL, leaf.get(i), destNode);
        // result.add(new Pair<>(minWeight, leaf.get(i)));
        // }

        // System.out.println(result.peek().first + 1);

        // /***********************************
        // * Cokrabue
        // ****************************************/
        // Scanner sc = new Scanner(System.in);
        // int susCount = sc.nextInt();
        // GraphM graph = new GraphM(susCount, false);

        // while (true) {
        // String i1 = sc.next();
        // if (i1.equals("0")) {
        // break;
        // }
        // String i2 = sc.next();

        // graph.addEdge(i1.charAt(0) - 'A', i2.charAt(0) - 'A', 1);
        // }

        // int qCount = sc.nextInt();
        // MyAlgorithm myAlg = new MyAlgorithm();
        // for (int i = 0; i < qCount; i++) {
        // String q1 = sc.next();
        // String q2 = sc.next();

        // boolean isReached = myAlg.warshall(graph, q1.charAt(0) - 'A',
        // q2.charAt(0) - 'A');
        // if (isReached == true) {
        // System.out.println("Yes");
        // }
        // if (isReached == false) {
        // System.out.println("No");
        // }
        // }
        // sc.close();

        // /***********************************
        // * Network Engineer
        // ***********************************/
        // Scanner sc = new Scanner(System.in);
        // int ns = sc.nextInt() + 1;
        // int c = sc.nextInt();

        // GraphL graph = new GraphL(false, ns, c);
        // for (int i = 0; i < c; i++) {
        // int u = sc.nextInt();
        // int v = sc.nextInt();
        // int w = sc.nextInt();

        // graph.addEdge(u, v, w);
        // }

        // MyAlgorithm myAlg = new MyAlgorithm();
        // int nQRouter = sc.nextInt();
        // List<Integer> ans = new ArrayList<>();
        // // int result = 0;

        // for (int i = 0; i < nQRouter; i++) {
        // int qStartNode = sc.nextInt();
        // List<Integer> eff = new ArrayList<>();
        // for (int j = 0; j < graph.numVertices; j++) {
        // if (myAlg.dijkstra(graph, qStartNode, j) < 10000) {
        // eff.add(myAlg.dijkstra(graph, qStartNode, j));
        // }
        // }
        // // for(int k = 0; k < eff.size(); k++){
        // // for(int x = 1; x < eff.size(); x++){
        // // if(eff.get(k) > eff.get(x)){
        // // result = eff.get(k);
        // // }

        // // }
        // // }
        // int maxEff = Collections.max(eff);
        // ans.add(maxEff);
        // }
        // for (int z = 0; z < ans.size(); z++) {
        // System.out.println(ans.get(z));
        // }

        // sc.close();

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
            // System.out.println();
            // System.out.printf("[");
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

    }
}
