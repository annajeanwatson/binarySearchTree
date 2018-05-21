package homework1;

import java.util.ArrayDeque;
import java.util.Queue;


public class BST implements ITree 
{
    public Node root = null;

    @Override
    public void printInOrder(Node node) 
    {
        if(node == null)
            return;
        else 
            printInOrder(node.getLC());
            System.out.println(node.getData());
            printInOrder(node.getRC());
    }

    @Override
    public void printPostOrder(Node node) {
        if(node == null)
            return;
        else
            printPostOrder(node.getLC());
            printPostOrder(node.getRC());
            System.out.println(node.getData());
    }

    @Override
    public void printPreOrder(Node node) {
        if(node == null)
            return;
        else 
            System.out.println(node.getData());
            printPreOrder(node.getLC());
            printPreOrder(node.getRC());
    }

    @Override
    public void add(Node node) 
    {
        if(root == null)
            root = node;
        else
            findNodeLocation(root, node);
    }
    
    private void findNodeLocation(
            Node currentNode, 
            Node newNode)
    {
        if(newNode.getData() <= currentNode.getData())
        {
            Node LC = currentNode.getLC();
            if(LC == null)
                currentNode.setLC(newNode);
            else    
                findNodeLocation(
                        LC, 
                        newNode);
        }
        else
        {
            Node RC = currentNode.getRC();
            if(RC == null)
                currentNode.setRC(newNode);                
            else
                findNodeLocation(
                        RC, 
                        newNode);
        }
    }
    
    @Override
    public boolean delete(int value) 
    {
        Node parent = null;
        Node currentNode = root;
        while(currentNode.getData() != value)
        {   
            parent = currentNode;
            currentNode = 
                (value < currentNode.getData()) 
                    ? currentNode.getLC() 
                    : currentNode.getRC();  
        }
        
        if(currentNode == null)
            return false;
        
        BST subBST = new BST();
        boolean isLeftChild = parent.getLC() == currentNode;
        switch(currentNode.getNumberOfChildren())
        {
            case 0:
                if(isLeftChild)
                    parent.setLC(null);
                else
                    parent.setRC(null);                    
                break;
            case 1:
                if(isLeftChild)
                {parent.setLC(
                        currentNode.getLC() == null 
                            ? currentNode.getRC()
                            : currentNode.getLC());
                }
                else
                {    parent.setRC(
                        currentNode.getLC() == null 
                            ? currentNode.getRC()
                            : currentNode.getLC());
                }
                break;
            case 2:
                
                if(isLeftChild)
                { 
                    subBST.root = currentNode.getRC();
                    Node newChild = subBST.findSmallestValue();
                    if(currentNode != newChild.getParent())
                        newChild.getParent().setLC(null);
                    parent.setLC(newChild);  
                    newChild.setLC(currentNode.getLC());
                    if(newChild != currentNode.getRC())
                        newChild.setRC(currentNode.getRC());
                }
                        
                else
                {   
                    subBST.root = currentNode.getRC();
                    Node newChild = subBST.findSmallestValue();
                    newChild.getParent().setLC(null);
                    parent.setRC(newChild); 
                }    
                
                break;
        }
        return true;
    }

    @Override
    public Node findSmallestValue() 
    {
        Node currentNode = root;
        while(currentNode.getLC() != null)
        {
            currentNode = currentNode.getLC();
        }
        return currentNode;
    }
    
    public boolean findNode(int value)
    {
        Node detectedNode = null;
        if (root == null || root.getData() == value)
            detectedNode = root;
 
        else if (root.getData() > value)
            detectedNode =  recFindNode(root.getLC(), value);
 
        else
            detectedNode =  recFindNode(root.getRC(), value);
            
        return detectedNode != null;
}
    private Node recFindNode(Node node, int value)
    {
        if (node == null || node.getData() == value)
            return node;
 
        else if (node.getData() > value)
            return recFindNode(node.getLC(), value);
 
        else
            return recFindNode(node.getRC(), value);
    }
    
    public static void printTree(Node node, String indent) 
    {
        if (node == null) 
        {
            System.out.println(indent + "null");
            return;
        }

        String newIndent;
        if (indent.equals("")) 
        {
            newIndent = "-- ";
        }
        else 
        {
            newIndent = "---" + indent;
        }
        printTree(node.getRC(), newIndent);
        System.out.println(indent + node.data);
        printTree(node.getLC(), newIndent);
        
  }
}
        

    

