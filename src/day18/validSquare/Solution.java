package day18.validSquare;

class Solution {
    double dist(int[] p1, int[] p2){
        double x = Math.pow(p1[0] - p2[0], 2);
        double y = Math.pow(p1[1] - p2[1], 2);
        return x  + y;
    }
    
    
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double d1 = dist(p1, p2);
        double d2 = dist(p1, p3);
        double d3 = dist(p1, p4);
        System.out.println(d1+" "+d2+" "+d3);
        if (d1 == 0 || d2 == 0 || d3 == 0)
            return false;
        // 
        
        if(d1==d2 && d3==2*d1 ) {
            // System.out.println(inside);
            // go to the other end of diagonal and check if the distance of other points are same or not
            // at last check if the distance of unchecked point is not zero
            double p4p2=dist(p4,p2);
            double p4p3=dist(p4,p3);
            return p4p2==p4p3 && dist(p2,p3)!=0;
        }
        else if(d1==d3 && d2==2*d1 ){
            double p3p4=dist(p3,p4);
            double p3p2=dist(p2,p3);
            return p3p4==p3p2 && dist(p2,p4)!=0;
        } 
        else if(d2==d3 && d1==2*d2) {
            double p2p3=dist(p2,p3);
            double p2p4=dist(p2,p4);
            return p2p3==p2p4 && dist(p3,p4)!=0;
        }
        return false;
    }
}
