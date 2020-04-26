import java.util.Queue;
import java.util.*;
import java.util.LinkedList;

class Node{
    int data;
    Node left;
    Node right;


    Node(int data){
        this.data=data;
        left=right=null;


    }


}
class BTree{
	public static Node root;

    public static void insertAtOrder(Node n,int data){
        if(root==null){
            root=new Node(data);
            return;
        }
        else{
            Queue<Node> q=new LinkedList<Node>();
            q.add(n);

            while(!q.isEmpty()){
                Node temp=q.peek();
           q.remove();
                    if(temp.left==null){
                        temp.left=new  Node(data);
                        return;
                    }
                    else{
                        q.add(temp.left);
                    }
                if(temp.right==null){
                    temp.right=new  Node(data);
                    return;
                }
                else{
                    q.add(temp.right);
                }
     

            }

        }
    }
    public static void LevelOrder(Node n){
        Queue <Node> q=new LinkedList();
        q.add(n);
        while(!q.isEmpty()){
            Node temp=q.peek();
            System.out.print(temp.data+" ");
            q.remove();
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
        }
    }
}

        public void PostTwoStack(Node root){
            if(root==null)
            return ;
            Stack <Node> s=new Stack();
            s.push(root);
            Stack <Integer> out=new Stack();
            while(!s.isEmpty()){
                Node curr=s.pop();
                out.push(curr.data);

                if(curr.left!=null){
                    s.push(curr.left);
                }
                if(curr.right!=null){
                    s.push(curr.right);
                }
            }
            while(!out.isEmpty()){
                System.out.println(out.pop()+" ");
            }

         
            
        }
public static void preOrder(Node n){
    if(n==null){
        return;
    }
    Stack <Node> s=new Stack<>();
    s.push(n);
    while(!s.isEmpty()){
        Node temp=s.pop();
        System.out.println(temp.data+" ");
        
        if(temp.right!=null)
            s.push(temp.right);
        
        if(temp.left!=null)
            s.push(temp.left);


    }

}
public static void Inorder(Node n){
    if(root==null)
    return;
    Stack<Node> s=new Stack();
    
   Node temp=n;
    while(!s.isEmpty() || temp!=null){
        if(temp!=null)
        {
            s.push(temp);
            temp=temp.left;
        }

        else{
            temp=s.pop();
            System.out.print(temp.data+" " );
            temp=temp.right;
        }
    }
}
public static boolean isLeaf(Node n){
    if(n.left==null && n.right==null)
    return true;

    else
    return false;
}

public static void postOrder(Node n){
    if(root==null)
    return;

    Stack<Node> s=new Stack();
    s.push(root);
    // Node temp=s.peek();
    while(!s.isEmpty()){
        Node curr=s.peek();


        if(isLeaf(curr)){
            System.out.print(curr.data+" ");
            s.pop();
        }
        if(curr.right!=null){
            s.push(curr.right);
            curr.right=null;
        }
        if(curr.left!=null){
            s.push(curr.left);
            curr.left=null;
        }

    }


}



void deleteKey(int data) 
{ 
    root = deleteRec(root, data); 
} 

	Node deleteRec(Node root, int data) 
	{  Node x=root;
	    Node parent =null;
	       while(x!=null)
	       {
	         if(x.data>data)
	         { parent=x;
	           x=x.left;
	         }
	         else if(x.data<data)
	         {parent=x;
	           x=x.right;
	         }
	         else
	         {
	           if(x.left==null&&x.right==null)
	           {
	            System.out.println(x.data+"y1");
	             if(parent.left==x)
	             parent.left=null;
	             else if(parent.right==x)
	             parent.right=null;
	   
	             x=null;
	   
	             break;
	           }
	           else
	           {
	             System.out.println(x.data+"y2");
	             if(x.left==null)
	             { 
	               if(parent.right==x)
	               parent.right=x.right;
	               else if(parent.left==x)
	                parent.left=x.right;
	               System.out.println(x.data+"yes");
	               x=null;
	               break;
	             }
	             else if(x.right==null)
	             {
	               if(parent.left==x)
	               parent.left=x.left;
	               else if(parent.right==x)
	               parent.right=x.left;
	               x=null;
	               break;
	             }
	             else
	             {
	               Node temp=x;
	               Node px=null;
	               temp=temp.right;
	               while(temp.left!=null)
	               { px=temp;
	                 temp=temp.left;
	               }
	               x.data=temp.data;
	               if(px.left==temp)
	               px.left=null;
	               else if(px.left==temp)
	               px.right=null;
	               temp=null;
	               break;
	             }
	           }
	         }
	       }
	     return root;
	} 
}
