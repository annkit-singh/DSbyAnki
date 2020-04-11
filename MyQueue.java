import java.util.Scanner;

class Node<E> {
    E data;
    Node<E> next;

    public Node(E data){
        this.data=data;
        next=null;


    }
    
}


class MyQueue{

    MyLinkedList ll=new MyLinkedList();


  private Node rear,head;


  public void enqueue(int data){
    Node n=new Node(data);
      if(head==null){
         head=rear=n;
      }
         else{
         rear.next=n;
         rear=rear.next;
      }
      }


      public void dequeue(){

        if (head==null)
            System.out.println("List is empty Dequeue is not allowed at all");
        // else if(head==rear){
        //      head=null;
        //      rear=null;
        //  }
        else {
            Node temp;
            temp=head.next;
          head.next=null;
          head=temp;
        }
       
    }
      public void displayQ(){
         if(head==null){
             System.out.println("Queue is empty");
         }
         else{
         Node temp;
         temp=head;
         System.out.print(" "+temp.data);

         while(temp!=rear){
             temp=temp.next;
             System.out.print(" "+temp.data);
         }
        }
        
      }

      public int peek(){
          return (int)head.data;
      }
      


    public static void main(String[] args){
        java.util.Scanner sc=new Scanner(System.in);
        MyQueue mq=new MyQueue();

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
                mq.enqueue(data);
                break;

                case 2:
                mq.dequeue();
                break;

                case 3:
                mq.peek();
                break;

                case 4:
                mq.displayQ();
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
    
