package day29.minDistanceBetweenTwoNodes;

class Solution {

    // returns  distance of  LCA from the root
    public int lcaDistance(Node root, int a, int b, int d){
        if(root==null) return -1;
        if(root.data==a || root.data==b){
            return d;
        }
        int lf=lcaDistance(root.left, a,b, d+1);
        int rt=lcaDistance(root.right, a,b, d+1);
        if(lf!=-1 && rt!=-1) return d;
        if(lf==-1) return rt;
        else return lf;
    }
    
    // distance of a node from root
    public int search(Node root, int x, int d){
        if(root==null) return -1;
        if(root.data==x) return d;
        int lf=search(root.left, x, d+1);
        int rf=search(root.right, x, d+1);
        if(lf!=-1) return lf;
        else return rf;
    }
    
    int findDist(Node root, int a, int b) {
        int lca=lcaDistance(root, a,b, 0);
        int da=search(root, a,0);
        int db=search(root, b,0);
        return da+db-2*lca;
    }
}
