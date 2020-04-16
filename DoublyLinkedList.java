import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node previous;

    public Node(int data){
        this.data=data;

    }
}

class DoublyLinkedList{

    Node head=null;
    int size=0;

    public void insertAtFirst(int val){
        Node n;
        n=new Node(val);
        
        if(head==null)
            head=n;

        else{
        n.next=head;
        head.previous=n;
        head=n;
        }
		size++;
    }
    public void insertAtLast(int data){
        Node n;
        n=new Node(data);
        
        if(head==null)
            head=n;
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
           temp.next=n;
           n.previous=temp;
        }
        size++;

    }

    public void DeleteFirst(){
         if(size==1)
        {
            head=null;
        }
        else{
            head.next.previous=null;
            head=head.next;
            
        }
        size--;
    }
    
    public boolean isDempty(){
        if(head==null)
        return true;

        else
        return false;
    }

    public void printReverseDoubly(){
        Node temp=head;

        if(isDempty()){
            System.out.println("Linked List is empty");
        }
        else if(size==1){
            System.out.print(head.data+ " ");
        }

        else{
           
            while(temp.next!=null){
                temp=temp.next;
            }
            System.out.print(temp.data);
            while(temp.previous!=null){
                temp=temp.previous;
                System.out.print(" "+temp.data);
            }
        }

       
        }


        public void swaptheDataInPair(){

            if(isDempty()){
                System.out.println("Linked liist is empty");
            }

           else if (size%2==0){
            Node temp=head;
            for (temp=temp.next;    temp.next!=null;  temp=temp.next.next){

            
            // Node temp=head.next;
            int reserve=temp.data;
            temp.data= temp.previous.data;
            temp.previous.data=reserve;

        }
        int reserve=temp.data;
        temp.data= temp.previous.data;
        temp.previous.data=reserve;

        }
        else{
            Node temp=head;
            for (temp=temp.next;    temp!=null;  temp=temp.next.next){

            
            // Node temp=head.next;
            int reserve=temp.data;
            temp.data= temp.previous.data;
            temp.previous.data=reserve;

        }


        }
    }
        

        public void printDoubly(){
            Node temp=head;
            if(isDempty()){
                System.out.println("Linked List is empty");
            }
            else if(size==1){
                System.out.print(head.data+" ");
            }
    
            else{
               System.out.print(" "+temp.data);
                while(temp.next!=null){
                    temp=temp.next;
                    System.out.print(" "+temp.data);
                }

        }
    }
    

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        DoublyLinkedList d=new DoublyLinkedList();
        boolean flag=true;
        while(flag==true){
            System.out.println();

            System.out.println("1.Insert at First ");
            System.out.println("2.Delete First");
            System.out.println("3.Print");
            System.out.println("4.Reverse Print");
            System.out.println("5.Exit");
            System.out.println("6.Swap the data in pairs");
            System.out.println("7.Insert at Last ");
            System.out.println();
            System.out.println(" Enter the choice  :");

            int choice =sc.nextInt();
           
            switch(choice){
                case 1:
                int data=sc.nextInt();
                d.insertAtFirst(data);
                break;

                case 2:
                d.DeleteFirst();
                break;

                case 3:
                d.printDoubly();
                break;

                case 4:
                d.printReverseDoubly();
                break;


                case 5:
                flag=false;
                break;
                
                case 6:
                d.swaptheDataInPair();
                d.printDoubly();
                break;

                case 7:
                int val=sc.nextInt();
                d.insertAtLast(val);


                default:
                System.out.println("Invalid Choice");
                break;
            }
        }
    }
}

//         DoublyLinkedList dl=new DoublyLinkedList();

//         dl.insertAtFirst(10);
//        dl.insertAtLast(20);
//        dl.insertAtLast(24);
//        dl.insertAtLast(22);
       
//         // dl.swaptheData();
//         dl.printDoubly();
//     }

// }