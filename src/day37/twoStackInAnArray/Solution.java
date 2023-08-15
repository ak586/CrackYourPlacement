package day37.twoStackInAnArray;

class twoStacks
{
    int arr[];
    int size;
    int top1, top2;
    twoStacks()
    {
        size = 100; 
        arr = new int[100]; 
        top1 = -1; 
        top2 = size;
    }
    
    void push1(int x)
    {
        arr[top1+1]=x;
        top1++;
    }
    //Function to push an integer into the stack2.
    void push2(int x)
    {
       arr[top2-1]=x;
       top2--;
    }
    //Function to remove an element from top of the stack1.
    int pop1()
    {
        if(top1==-1) return -1;
        else{
            int ans=arr[top1];
            top1--;
            return ans;
        }
    }
    //Function to remove an element from top of the stack2.
    int pop2()
    {
        if(top2==size){
            return -1;
        }
        else{
        int ans=arr[top2];
        top2++;
        return ans;
        }
    }
}