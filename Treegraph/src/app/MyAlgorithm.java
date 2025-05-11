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
}
