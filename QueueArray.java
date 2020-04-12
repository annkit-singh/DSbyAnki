import java.util.Scanner;
class ArrayQueue{

    private int top=0;
    private int rear=-1;
    static int size=0;
    static int capacity=10;

    public void enQ(int arr[],int data){
        if(top==capacity){
            System.out.println("Queue is full");
        }
        else
        rear++;
        arr[rear]=data;

   

    }

    public void DeQ(int arr[]) throws Exception{
        if(top>rear){
            throw new Exception("dequeue is not allowed here");
        }
        arr[top]=0;
        top++;

        
    }


    public void viiewQ(int arr[]){

        if (top==rear){
            System.out.println(arr[rear]);

        }
        else{

      for(int i=top;i<=rear;i++){
          System.out.print(" "+arr[i]);
      }
        }
    }


        public int peekQ(int arr[]){
            return arr[top];
        }
    


    public static void main(String[] args) throws Exception{

        Scanner sc=new Scanner (System.in);
        ArrayQueue aq=new ArrayQueue();
        int arra[]=new int[capacity]; 
        boolean flag=true;

        while(flag==true){
            System.out.println();
            System.out.println("1.Enqueue");
            System.out.println("2.Dequeue");
            System.out.println("3.Peek");
            System.out.println("4.Print Queue");
            System.out.println("5.Exit");
          int choice =sc.nextInt();
            switch(choice){
                case 1:
                int data=sc.nextInt();
               aq.enQ(arra, data);
                break;

                case 2:
              aq.DeQ(arra);
                break;

                case 3:
               System.out.println(aq.peekQ(arra));
                break;

                case 4:
                aq.viiewQ(arra);
                break;
                case 5:
                flag=false;
                break;

                default:
                System.out.println("Invalid Choice");
                break;
            }
        }

    }
}