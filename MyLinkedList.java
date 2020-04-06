import java.util.Scanner;
class Node
{
	private int data;
	private Node next;

	public Node(){
		data=0;
		next=null;

	}

	public Node(int data,Node n){
		data=data;
		next=n;
	}
	public void setData(int d){
		data=d;
	}
	public void setNext(Node n){
		next=n;
	}
	public int getData(){
		return data;

	}
	public Node getNext(){
		return next;
	}
}

class LinkedList
{

	private int size;
	private Node start;

	public LinkedList(){
		size=0;
		start=null;

	}


	
	public int getListSize(){
		return size;
	}

		

	public void insertAtFirst(int val){
		Node n;
		n=new Node();
		n.setData(val);
		n.setNext(start);
		start=n;
		size++;
	}


	public void insertAtLast(int val)
	{
		Node t,n;
		n=new Node();
		n.setData(val);
		t=start;
		if(t==null){
			start=n;
					}
		else
			while(t.getNext()!=null){
				t=t.getNext();
				t.setNext(n);
			}
			
			size++;
	}

	public void insertAtPos(int val,int pos)
	{ 
		if(pos==1)
			insertAtFirst(val);
		else if(pos==size+1)
			insertAtLast(val);
		else if(pos>1 && pos<=size)
		{
			Node t,n;
			n=new Node();
			n.setData(val);
			t=start;
			for(int i=1;i<pos-1;i++){
				t=t.getNext();

				n.setNext(t.getNext());
				t.setNext(n);
				size++;
			}
		}
		else
		System.out.println("Not Possible insertion at this point");
	}

	public void deleteFirst()
	{

		if(start==null){
			System.out.println("Your list ia already Empty");
			}

		else{
			start=start.getNext();
			size--;
				}
	}

public void deleteLast()
{	
	if (start==null){
	System.out.println("List is already empty");
	}
	else if (size==1){
		start=null;
		size--;
		}
	else{
		Node t;
		t=start;
		for(int i=1;i<size-1;i++)
			t=t.getNext();
		t.setNext(null);
		size--;
		}
}


public void deleteAtPos(int pos)
	{
		if (start==null)
			System.out.println("List is alraedy empty");

		
		else if(pos<1 || pos>size)
			System.out.println("Invalid Deletion");



		else if(pos==1)
			deleteFirst();

		else if(pos==size)
			deleteLast();

		else
			{
				Node t,t1;
			t=start;
			for(int i=1;i<pos-1;i++)
				t=t.getNext();
				t1=t.getNext();
				t.setNext(t1.getNext());
				size--;
			}
	}
public boolean isEmpty()
	{
		if(start==null)
			return true;
		else
			return false;
	}


public void viewList()
	{

		Node t;
		if(isEmpty())
			System.out.println("List is empty");
		else{
			t=start;
			for(int i=1;i<=size;i++){
				System.out.print(" "+t.getData());
				t=t.getNext();						}
			}
	System.out.println();		
	}
	

	
}
class Test{

	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		LinkedList list=new LinkedList();
		boolean flag=true;
		int pos,val;
		
		while(flag)
	{
	System.out.println("\n");			
	System.out.println("1.Insert at start");
	System.out.println("2.Insert at end");
	System.out.println("3.Insert at pos");
	System.out.println("4.Delete at start");
	System.out.println("5.Delete at end");
	System.out.println("6.Delete at positon");
	System.out.println("7.View List");
	System.out.println("8.Size");
	System.out.println("9.Exit");
	int choice=sc.nextInt();
	
	switch(choice)
	{
	case 1:						
		System.out.println("Enter value");
		 	val=sc.nextInt();
			list.insertAtFirst(val);
			break;
	case 2:
			System.out.println("Enter value");
			val=sc.nextInt();
			list.insertAtLast(val);
			break;
	case 3:
		System.out.println("Enter value and position");
		val=sc.nextInt();
		pos=sc.nextInt();
		list.insertAtPos(val,pos);
		break;

	case 4:
		list.deleteFirst();
		break;

	case 5:
		list.deleteLast();
		break;
	case 6:	
		System.out.println("Enter position");
		pos=sc.nextInt();
		list.deleteAtPos(pos);
		break;

	case 7:
		System.out.println("Your List is :");
		list.viewList();
			break;

	case 8:
		System.out.println(list.getListSize());
		break;


	case 9:
		flag=false ;
		break;

	default:
		System.out.println("Invalid choice");
		}
	}

}
}