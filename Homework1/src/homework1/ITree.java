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
public interface ITree 
{
    public void printInOrder(Node node);
    
    public void printPostOrder(Node node);
    
    public void printPreOrder(Node node);
    
    public void add(Node node);
    
    public boolean delete(int value);
    
    public Node findSmallestValue();
    
    public boolean findNode(int value);
    
}
