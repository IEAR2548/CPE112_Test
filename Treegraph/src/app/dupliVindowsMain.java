package app;

import java.util.*;

public class dupliVindowsMain {
    public static void main(String[] args) throws Exception {
        // goals --> preorder ออกมาแล้วได้ค่าเดิมก็พอ
        Scanner sc = new Scanner(System.in);
        BST myBst_1 = new BST();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int node = sc.nextInt();

            myBst_1.insertNode(node);
        }

        MyAlgorithm myAlg = new MyAlgorithm();
        List<Integer> duplicateProc = new ArrayList<>();
        duplicateProc = myAlg.preorder(myBst_1);

        BST myBst_2 = new BST();
        for (int i = 0; i < duplicateProc.size(); i++) {
            myBst_2.insertNode(duplicateProc.get(i));
        }

        sc.close();
        System.out.println("primalTree : " + myAlg.preorder(myBst_1));
        System.out.println("dupliTree : " + myAlg.preorder(myBst_2));
    }
}
