/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

/**
 *
 * @author tharp
 */
public class Node 
{
    public int data;
    public Node lc = null;
    public Node rc = null;
    public Node parent = null;
    
    public Node(int data)
    {
        this.data = data;
    }
    
    public Node getParent()
    {
        return parent;
    }
    
    public void setParent(Node node)
    {
        this.parent = node;
    }
    
    public Node getRC()
    {
        return rc;
    }
    
    public Node getLC()
    {
        return lc;
    }
    
    public void setRC(Node node)
    {
        this.rc = node;
        if(node != null)
            node.setParent(this);
    }
    
    public void setLC(Node node)
    {
        this.lc = node;
        if(node != null)
            node.setParent(this);
    }
    
    public int getData()
    {
        return data;
    }
    
    public int getNumberOfChildren()
    {
        int children = 0;
        if(lc != null)
            children++;
        if(rc != null)
            children++;
        return children;
    }
}
