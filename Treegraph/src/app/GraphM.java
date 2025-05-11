package app;

public class GraphM extends AdjM{
    int numVertices;
    boolean isDirected;

    //constructor
    public GraphM(int n, boolean isDirected){
        super(n); //เรียกใช้ constructor ของคลาส AdjM เพื่อสร้างเมทริกซ์ n x n
        this.isDirected = isDirected;
        this.numVertices = n;
    }

    @Override //@Override คือ annotation ในภาษา Java ที่ใช้บอกคอมไพเลอร์ว่า: เมทอดนี้เป็นการ เขียนทับ (override) เมทอดที่มีอยู่ใน คลาสแม่ (superclass) หรือ interface
    public void addEdge(int i, int j, int weight){
        this.matrix[i][j] = weight; //************************************* */
        if(!isDirected){
            this.matrix[j][i] = weight;
        }
    }

    @Override //
    public int getWeight(int i, int j){
        return this.matrix[i][j];
    }
}
