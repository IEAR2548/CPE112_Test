package app;
public abstract class AdjM {
    //protected คือสามารถเข้าถึงได้จาก class ที่สืบทอด และ class ที่อยู่ใน package เดียวกัน
    protected int[][] matrix; // matrix[i][j] = weight
    //matrix[i][j] = 0 หมายถึงไม่มีเส้นเชื่อมระหว่าง i กับ j
    protected int numEdge;

    //constructor
    //AdjM(int n) จะถูกเรียกใช้เมื่อมีการสร้างออบเจ็กต์ของคลาสลูก
    public AdjM(int n){
        this.matrix = new int[n][n];
    }

    //ต้องให้คลาสลูกมา Override และกำหนดพฤติกรรมเอง (ว่าจะทำอย่างไรเมื่อเพิ่มเส้นเชื่อม)
    public abstract void addEdge(int i, int j, int weight);

    public abstract int getWeight(int i, int j);
}
