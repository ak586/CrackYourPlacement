package day09.reverseWords;

class Solution {
    public void reverse(int i, int j, char arr[]){
        while(i<j){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public String reverseWords(String s) {
        s=s.trim();
        char arr[]=s.toCharArray();
        int i=0;
        int j=0;
        int n=arr.length;
    reverse(0,n-1,arr);
        while(j<n){
            while(j<n && arr[j]!=' ') j++;
            reverse(i, j-1,arr);
            i=j+1;
            ++j;
        }
        StringBuilder sb=new StringBuilder();
        i=0;
        while(i<n){
            if(arr[i]==' '){
                i++;
                while(i<n && arr[i]==' ') i++;
                sb.append(' ');
            }
            else{
                sb.append(arr[i]);
                i++;
            }
        }

        return sb.toString();
    }
}
