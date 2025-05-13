package app;

public class BST extends BinTree{
    public BST(){
        super();
    }

    @Override
    public void insertNode(int node){
        BinNode newNode = new BinNode(node);

        if(this.root == null){
            this.root = newNode;
            return;
        }
        else{
            insertNode(this.root, newNode);
        }
    }

    private void insertNode(BinNode parent, BinNode newNode){
        if(parent.node > newNode.node){
            if(parent.leftChild == null){
                parent.leftChild = newNode;
            }
            else{
                insertNode(parent.leftChild, newNode); //recursive
            }
        }
        else if(parent.node < newNode.node){
            if(parent.rightChild == null){
                parent.rightChild = newNode;
            }
            else{
                insertNode(parent.rightChild, newNode);
            }
        }
        else{
            return;
        }
    }
    
    public int getHeight(BinNode node){
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild));
    }
    
    public int getBalanceFactor(BinNode target){
        if (target == null) return 0;

        int leftHeight = getHeight(target.leftChild);
        int rightHeight = getHeight(target.rightChild);

        return leftHeight - rightHeight;
    }

    public BinNode findNode(BinNode root, int key) {
        if (root == null || root.node == key) {
            return root;
        }

        if (key < root.node) {
            return findNode(root.leftChild, key);
        } else {
            return findNode(root.rightChild, key);
        }
    }
    
}
