package app;

import java.util.*;

public class MainTest {
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        // BST myBst = new BST();
        // MyAlgorithm myAlg = new MyAlgorithm();
        // int nNode = sc.nextInt();
        // for(int i = 0; i < nNode; i++){
        // int temp = sc.nextInt();
        // myBst.insertNode(temp);
        // }

        // List<Integer> answers = myAlg.inorder(myBst);
        // System.out.println(answers);
        // sc.close();

        //Magic Powder
        MyAlgorithm myAlg = new MyAlgorithm();
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt()+1;
        int n = sc.nextInt();
        sc.nextLine();

        int destNode = -1;
        GraphL graphL = new GraphL(false, e, n);
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            String bond = sc.next();
            int b = sc.nextInt();

            graphL.addEdge(a, b, 1);

            if (bond.equals("=")) {
                destNode = b;
            }
        }

        sc.close();

        // เอาleaf(startNode)
        List<Integer> leaf = new ArrayList<>();
        for (int i = 0; i < graphL.numVertices; i++) {
            if (graphL.adjacencyList.containsKey(i) && graphL.adjacencyList.get(i).size() == 1) {
                leaf.add(i);
            }
        }

        PriorityQueue<Pair<Integer, Integer>> result = new PriorityQueue<>();
        for (int i = 0; i < leaf.size(); i++) {
            int minWeight = myAlg.dijkstra(graphL, leaf.get(i), destNode);
            result.add(new Pair<>(minWeight, leaf.get(i)));
        }

        System.out.println(result.peek().first + 1);

    }
}
