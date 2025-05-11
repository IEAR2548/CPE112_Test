package app;

import java.util.*;

public class Dijkstra {
    public void dijkftra(GraphL graph, int startNode){
        int[] minDist = new int[graph.numVertices];
        List <Integer> visitedList = new ArrayList<>();
        for(int i = 0; i < graph.numVertices; i++){
            minDist[i] = 10000; //or use Integer.MAX_Value;(2^32-1) ก็คือให้เป็น infinite
        }
        minDist[startNode] = 0;
        PriorityQueue<Pair <Integer, Integer>> walker = new PriorityQueue<>();
        walker.add(new Pair<>(0, startNode)); // (cumulativeDistance, node)
                                                    //ใช้ first = weight ใน PriorityQueue เพราะมันจัดลำดับโดยดู first
                                                    //ใช้ first = ปลายทาง ใน Graph เพราะแค่อยากรู้ว่าเชื่อมไปโหนดไหน
        while(visitedList.size() != graph.numVertices && !walker.isEmpty()){
            int cumulativeDist = walker.peek().first;
            int nodeNow = walker.peek().second;  
            walker.remove();
            if(visitedList.contains(nodeNow)){
                continue; //บังคับเริ่มลูปรอบใหม่
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
        for(int i = 0; i < graph.numVertices; i++){
            System.out.println(minDist[i]);
        }
    }
}
