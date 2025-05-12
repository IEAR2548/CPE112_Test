package app;

import java.util.*;

public class MyAlgorithm extends Algorithm{
    public MyAlgorithm(){
        
    }

    public List<Integer> inorder(BST tree){
        List<Integer> ans = new ArrayList<>();
        inorderUtil(tree.root, ans);
        return ans;
    }

    private void inorderUtil(BinNode node, List<Integer>ans){
        if(node == null){
            return;
        }
        
        inorderUtil(node.leftChild, ans);
        ans.add(node.node);
        inorderUtil(node.rightChild, ans);

    }

    public int dijkstra(GraphL graph, int startNode, int destNode){
        int[] minDist = new int[graph.numVertices];
        List<Integer> visitedList = new ArrayList<>();

        for(int i = 0; i < graph.numVertices; i++){
            minDist[i] = 100000;
        }
        minDist[startNode] = 0;
        PriorityQueue<Pair<Integer, Integer>> walker = new PriorityQueue<>();
        walker.add(new Pair<>(0, startNode));
        while(visitedList.size() != graph.numVertices && !walker.isEmpty()){
            int cumulativeDist = walker.peek().first;
            int nodeNow = walker.peek().second;
            walker.remove();

            if(visitedList.contains(nodeNow)){
                continue;
            }
            visitedList.add(nodeNow);
            
            for(int i = 0; i < graph.adjacencyList.get(nodeNow).size(); i++){
                int nodeNext = graph.adjacencyList.get(nodeNow).get(i).first;
                int weightNext = graph.adjacencyList.get(nodeNow).get(i).second;

                if(cumulativeDist + weightNext < minDist[nodeNext]){
                    minDist[nodeNext] = cumulativeDist + weightNext;
                    walker.add(new Pair<>(minDist[nodeNext], nodeNext));
                }
            }
        }
        
        return minDist[destNode];
    }

    public boolean warshall(GraphM graph, int startNode, int destNode){
        boolean[][] reach = new boolean[graph.numVertices][graph.numVertices];
        
        for(int i = 0; i < graph.numVertices; i++){
            for(int j = 0; j < graph.numVertices; j++){
                reach[i][j] = (i == j || graph.matrix[i][j] != 0); //graph.matrix[i][j] = weight
            }
        }

        for(int k = 0; k < graph.numVertices; k++){
            for(int i = 0; i < graph.numVertices; i++){
                for(int j = 0; j < graph.numVertices; j++){
                    reach[i][j] |= (reach[i][k] && reach[k][j]); //ถ้ามีทางจาก i ไป k และจาก k ไป j → แสดงว่ามีทางจาก i ไป j ผ่าน k
                                                                // ใช้ |=, หมายถึง "ถ้าเคย true แล้วก็ปล่อยไว้, ถ้ายัง false ก็อัปเดตเป็น true ถ้าเงื่อนไขขวาเป็นจริง"
                }
                
            }
            
        }
        return reach[startNode][destNode];
    }

    public int floyd(GraphM graph, int startNode, int destNode){
        int[][] dist = new int[graph.numVertices][graph.numVertices];

        for (int i = 0; i < graph.numVertices; i++) {
          for (int j = 0; j < graph.numVertices; j++) {
            if (i == j) {
              dist[i][j] = 0;
            } else if (graph.matrix[i][j] != 0) {
              dist[i][j] = graph.matrix[i][j];
            } else {
              dist[i][j] = 10000;
            }
          }
        }

        for (int k = 0; k < graph.numVertices; k++) {
          for (int i = 0; i < graph.numVertices; i++) {
            if (dist[i][k] == 10000)
              continue;
            for (int j = 0; j < graph.numVertices; j++) {
              if (dist[i][k] != 10000 && dist[k][j] != 10000) {
                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
              }
            }
          }
        }

        return dist[startNode][destNode] == 10000 ? -1 : dist[startNode][destNode]; //if = -1 -> cant reach
    }
}
