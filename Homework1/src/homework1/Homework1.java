/*
 * Anna Watson
 * CSCI232 - Program 1
 * May 21, 2018
 * This program initalizes a Binary Search Tree and allows for addition and deletion of nodes
 * from a user interface. Additionally, the program allows for the user to print the tree in order,
 * postorder, postorder, and to resembemble a tree.
 */
package homework1;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * main driver class
 * controls import of file and user interface
 */
public class Homework1 {

    public static void main(String[] args)
    {
            BST BST = new BST();
            try
            {
                Scanner fileInput = new Scanner(new File("input.txt"));
                while(fileInput.hasNextLine())
                {
                    String line = fileInput.nextLine();
                    String words[] = line.split(",");
                    for(int i=0; i < words.length; i++)
                    {
                        BST.add(new Node(Integer.parseInt(words[i])));
                    }
                }
            }
             catch (Exception e) 
            {
                System.out.println("File not found.");
            }
                int input = 0;
                String indent = " ";
                while(input != -1){
                Scanner scanner = new Scanner( System.in );
                System.out.println("What would you like to do?");
                System.out.println("Press 1 to add item");
                System.out.println("Press 2 to delete item");
                System.out.println("Press 3 to print tree");
                System.out.println("Press 4 to print in order");
                System.out.println("Press 5 to print postorder");
                System.out.println("Press 6 to print preorder");
                System.out.println("Press 7 to check node");
                System.out.println("Press -1 to exit");
                input = scanner.nextInt();
                
            
                switch(input){

                    case 1:
                        System.out.println("Please enter a number to add.");
                        Scanner scanner1 = new Scanner(System.in);
                        int number = scanner1.nextInt();
                        Node node = new Node(number);
                        BST.add(node);
                        BST.printTree(BST.root, indent);
                        
                        break;
                    case 2:

                        System.out.println("Please enter a number to delete.");
                        Scanner scanner2 = new Scanner(System.in);
                        int number1 = scanner2.nextInt();
                        BST.delete(number1);
                        BST.printTree(BST.root, indent);
                        
                        break;
                       
                    case 3: 

                        BST.printTree(BST.root, indent);                  
                        break;
                        
                    case 4:
                        System.out.println("");
                        BST.printInOrder(BST.root);  
                        System.out.println("");
                        break;
                        
                    case 5:
                        System.out.println("");
                        BST.printPostOrder(BST.root);
                        System.out.println("");
                        break;                        
                        
                    case 6:
                        System.out.println("");
                        BST.printPreOrder(BST.root);
                        System.out.println("");
                        break;                        
                        
                    case 7:
                        System.out.println("Please enter a number to find.");
                        Scanner scanner3 = new Scanner(System.in);
                        int number2 = scanner3.nextInt();               
                        boolean x = BST.findNode(number2);
                        System.out.println(x);
                        break;
                        
                    case -1:
                        input = -1;
                        break;
                }
            }
    }
}
 