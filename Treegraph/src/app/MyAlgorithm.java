package app;

import java.util.*;

public class MyAlgorithm extends Algorithm{
    public MyAlgorithm(){
        
    }
    
    //for tree
    public List<Integer> preorder(BST tree){
      List<Integer> ans = new ArrayList<>();
      preorderUtil(tree.root, ans);
      return ans;
    }

    private void preorderUtil(BinNode node, List<Integer>ans){
      if(node == null){
        return;
      }

      ans.add(node.node);
      preorderUtil(node.leftChild, ans);
      preorderUtil(node.rightChild, ans);
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

    public List<Integer> postorder(BST tree){
      List<Integer> ans = new ArrayList<>();
      postorderUtil(tree.root, ans);
      return ans;
    }

    private void postorderUtil(BinNode node, List<Integer> ans){
      if(node == null){
        return;
      }
      postorderUtil(node.leftChild, ans);
      postorderUtil(node.rightChild, ans);
      ans.add(node.node);
    }

    //for graph
    public List<Integer> dfs(GraphM graph, int startNode){
      List<Integer> result = new ArrayList<>();
      boolean[] isVisited = new boolean[graph.matrix.length];
      
      dfsUtil(graph, startNode, isVisited, result);

      return result;
    }
    public void dfsUtil(GraphM graph, int curr, boolean[] isVisited, List<Integer> result){
        isVisited[curr] = true; //Set the node to visited
        result.add(curr); //Add node into result

        for(int n = graph.matrix.length - 1; n >= 0 ; n--){
            if (graph.matrix[curr][n] == 1 && !isVisited[n]) {
                dfsUtil(graph, n, isVisited, result); //Recall func dfsUtil but start with neighbor not startnode
            } //Check neighbor has edge? and is it visited?
        } //Loop from heighest to less. Cause LIFO concept
    }

    public List<Integer> bfs(GraphL graph, int startNode){
        List<Integer> result = new ArrayList<>();
        boolean[] isVisited = new boolean[graph.adjacencyList.size()]; //Add range of arr from graph size but have to create size func in graphL
        Queue<Integer> q = new LinkedList<>();

        q.add(startNode);
        isVisited[startNode] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);

            for (Pair<Integer, Integer> edge : graph.adjacencyList.get(curr)){
                int n = edge.first; // first is from Pair<first, second> second = weight;
                if (!isVisited[n]){
                    isVisited[n] = true;
                    q.add(n);
                }
            }
        }        

        return result;
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
