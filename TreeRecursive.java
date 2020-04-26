import java.util.LinkedList;
import java.util.Queue;
class Node{
    int data;
    Node left;
    Node right;
 public Node (int data){
     this.data=data;
     left=right=null;
 }
}
class BTree{
    public Node root;
    public BTree(){
        root=null;

    }


   public void preOrder(Node node)
    { 
    	if (node == null){
        return;
         }
    System.out.printf("%s ", node.data);
        preOrder(node.left);
        preOrder(node.right); 
        }

    public void InOrder(Node node){
        if(node==null)
        return;
        InOrder(node.left);
        System.out.print(node.data+" ");
        InOrder(node.right);
    }

    public void postOrder(Node node){
        if(node==null)
        return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }

  public Node createNode(int dat){
        Node n=new Node(dat);
        return n;

    }

    public Node  mirrorify(Node n){
        if(n==null)
        return null;
        
        Node mirror=createNode(n.data);
        mirror.right=mirrorify(n.left);
        mirror.left=mirrorify(n.right);
       
        return mirror;

        
    }
    public static boolean isLeaf(Node n){
    	if(n.left ==null && n.right==null)
    		return true;
    	else
    		return false;

    }


public static Node deleteElement(Node n, int data){
    if(n==null)
    return n;
    if(data>n.data){
        n.right=deleteElement(n.right, data);
    }
    else if(data<n.data){
        n.left=deleteElement(n.left, data);
    }
    else{
        if(isLeaf(n)){
            return null;
        }
       else if(n.left==null){
            return n.right;
        }
        else if(n.right==null){
            return n.left;
        }
        else{
            int min=minValue(n.right);
            n.data=min;
            n.right=deleteElement(n.right, data);
        }
    }
return n;

}

public static int minValue(Node n){
    if(n.left!=null)
    return minValue(n.left);

  return n.data;
}


public Node InsertNodeBst(Node n,int value){
    Node temp=null;
    if(root==null){
        root=new Node(value);
        return root;
    }
    else if(n.data==value){
        System.out.println("This number cannot be inserted as it is always there");
        return null;
    }
    else if(n.data<value){
        if(n.right==null){
            n.right=new Node(value);
            return n.right;
        }
        temp=n.right;

    }

    else{
        if(n.left==null){
            n.left=new Node(value);
            return n.left;
        }
        temp=n.left;
    }

    return InsertNodeBst(temp, value);
}

    public int diameterOfBinaryTree(Node root) {
            int length;
            if(root==null)
                return 0;
            
            int hL=height(root.left);
            int hR=height(root.right);
            
            int dL=diameterOfBinaryTree(root.left);
              int dR=diameterOfBinaryTree(root.right);
        
            
            return Math.max(hL+hR,Math.max(dL,dR));
            
            
        }
        public int height(Node n){
            if(n==null)
                return 0;
            
            return 1 +Math.max(height(n.left),height(n.right));
        }
      }