package app;

import java.util.*;

public class balVindowsMain {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BST myBst = new BST();

        // สร้างBSTก่อน
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int node = sc.nextInt();

            myBst.insertNode(node);
        }

        // ถามไรตอบได้วะฮาฮ่า
        int nq = sc.nextInt();
        for (int i = 0; i < nq; i++) {
            int q = sc.nextInt();
            BinNode target = myBst.findNode(myBst.root, q);
            // System.out.printf("Node " + target.node + " : Balance Factor = " +
            // myBst.getBalanceFactor(target));
            if (target != null) {
                System.out.printf("Node %d : Balance Factor = %d\n", target.node, myBst.getBalanceFactor(target));
            } else {
                System.out.println("Node " + q + " not found.");
            }
        }

        sc.close();
    }
}
