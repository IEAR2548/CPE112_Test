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
        if(parent.node < newNode.node){
            if(parent.leftChild == null){
                parent.leftChild = newNode;
            }
            else{
                insertNode(parent.leftChild, newNode); //recursive
            }
        }
        else if(parent.node > newNode.node){
            if(parent.rightChild == null){
                parent.rightChild = newNode;
            }
            else{
                insertNode(parent.rightChild, newNode);
            }
        }
    }
    
}
