class StackIntro{
    final static int BOUND=4;
    static int top=-1;
    static int  length=4;


    public static int [] createNew(int a[]){
        int new_a[]=new int[length+BOUND];
        
        for(int i=0;i<length;i++){
            new_a[i]=a[i];
        }
        length+=BOUND;
        return new_a;
    }

    public int [] push(int []a,int element){
        if(top==length-1)
            a=createNew(a);
        
        a[++top]=element;
        return a;
    }

    public void pop(int []a){
        top--;

    }
    public void display(int[] a){
    if (top == -1) 
    System.out.println("Stack is Empty"); 
else 
{ 
    System.out.print("Stack: "); 
    for (int i = 0; i <= top; i++) 
        System.out.print(a[i] + " "); 
    System.out.println(); 
} }
public int peek(int arr[]){
    int element=arr[top];
    return element;

}
    


    public static void main(String[]args){

        int array[]=createNew(new int[length+BOUND]);
        StackIntro  si=new StackIntro();
        si.push(array,89);
        si.push(array,19);
        si.push(array,12);
        si.push(array,17);
        si.push(array,18);
        si.push(array,90);
        si.pop(array);
        // si.push(array,100);
        System.out.println("Peeked element "+si.peek(array));
        si.display(array);
    }

}