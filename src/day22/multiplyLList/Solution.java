package day22.multiplyLList;

class GfG{
  /*You are required to complete this method */
   static long m=(long)1e9+7;
   public long multiplyTwoLists(Node l1,Node l2){
        long num1=0;
        long num2=0;
        while(l1!=null){
            int d=l1.data;
            num1=(num1*10+d)%m;
            l1=l1.next;
        }
        while(l2!=null){
            num2=(num2*10+l2.data)%m;
            l2=l2.next;
        }
        return (num1*num2)%m;
   }
}
