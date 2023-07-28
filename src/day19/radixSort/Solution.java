package day19.radixSort;

class Solution
{
    static void radixSort(int arr[], int n) 
    { 
       int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
            max=Math.max(max, arr[i]);
        int count=(int)Math.log10(max)+1;
      ArrayList<Integer>[] temp= new ArrayList[10];
       int base=1;
        for(int j=0; j<count; j++){
            
            for(int i=0; i<n; i++){
                int index=(arr[i]/base)%10;
                // System.out.println(arr[i]+" "+index);
                if(temp[index]==null) temp[index]=new ArrayList<>();
                temp[index].add(arr[i]);
            }
             int k=0;
            for(ArrayList<Integer>a:temp){
                if(a!=null){
                   for(int x: a)
                    arr[k++]=x;
                    a.clear();
                }
            }
        // System.out.println(Arrays.toString(arr));
         base=base*10;
        }
    } 
}
