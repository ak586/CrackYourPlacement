package day23.predecessorAndSuccessor;

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Solution {
    
    

static void findPre(Node root, int key){
    if(root==null) return ;
    if(root.data>=key)
      findPre(root.left, key);
    else{
        if(pre==null) pre=root;
        else{
            if(pre.data<root.data) pre=root;
        }
        findPre(root.right, key);
    }
}

static void findSuc(Node root, int key){
    if(root==null) return ;
    if(root.data<=key) findSuc(root.right, key);
    else{
        if(suc==null) suc=root;
        else{
            if(suc.data>root.data) suc=root;
        }
        findSuc(root.left, key);
    }
}

public static void findPreSuc(Node root, int key)
{
    findPre(root, key);
    findSuc(root, key);
    
    /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
       static Node pre=null,suc=null
       You need to update these both.
       And the data inside these classes will be printed automatically by the driver code. 
    */
}
}
