import java.util.Stack;



class Node{
    int data;
    Node left;
    Node right;
 public Node(int value){
    this.data=value;
     left=null;
     right=null;
    }
}
class BinaryTree{

   static Node root;
    public BinaryTree(){
        root=null;
    }
   public BinaryTree(int key){
       root=new Node(key);

   }
   public void preOrder(Node node)
    { if (node == null){
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

    // public void preOrderStack(Node root){
    //     if(root==null)
    //     return ;


    //     Stack <Node> stack=new Stack<>();
    //     stack.push(root);
    //     while(!stack.isEmpty()){
    //         Node temp=stack.pop();
    //         System.out.print(temp.data+" ");
    //         if(temp.right!=null){
    //             stack.push(temp.right);
    //         }
    //         if(temp.left!=null){
    //             stack.push(temp.left);
    //         }
    //     }

    public void PreStack(Node root){
        if(root==null)
        return;

        Stack<Node> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            Node temp=s.pop();
            System.out.print(temp.data+" ");

            if(temp.right!=null)
            s.push(temp.right);


            if(temp.left!=null)
            s.push(temp.left);
        }
    }

    public void InStack(Node root){
        if(root==null)
        return;

        Stack <Node> s=new Stack<>();
        Node temp=root;
       while(!s.isEmpty() || temp!=null){
           if(temp!=null){
               s.push(temp);
               temp=temp.left;
           }
           else{
               temp=s.pop();
               System.out.println(temp.data+" ");
               temp=temp.right;
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

       
public void postOneStack(Node n) {
    Stack<Node> s = new Stack<>();
    s.push(n)  ;

    while (!s.isEmpty()) {
      Node current = s.peek();

      if (current.left==null && current.right==null) {
        Node node = s.pop();
        System.out.printf( node.data+" ");
      } 
      else {

            if (current.right != null) {
            s.push(current.right);
            current.right = null;
            }

            if (current.left != null) {
            s.push(current.left);
            current.left = null;
            }
      }

    }
  }

  public  static void postAnkitStack(Node n){
      Stack <Node> s=new Stack<Node>();
      s.push(n);
      while(!s.isEmpty()){
        Node curr=s.peek();
        if(curr.left==null && curr.right==null){
            Node temp=s.pop();
            System.out.print(temp.data+" ");
        }
        else{
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

  }

    


    

  

   public static void main(String[]args){
       BinaryTree tree=new BinaryTree();
       tree.root=new Node(1);
       tree.root.left=new Node(2);
       tree.root.right=new Node(3);
       tree.root.right.left=new Node(11);
       tree.root.right.right=new Node(90);
       tree.root.left.left=new Node(4);
       tree.root.left.right=new Node(9);
    //    tree.PreStack(root);
    // tree.InOrderStack(root);
    // tree.PostStack(root);
    // tree.postOneStack(root);
    System.out.println("hello");
   postAnkitStack(root);

    //    tree.preOrderStack(root);
    //    tree.root.left.left=new Node(4);

    //    tree.preOrder(tree.root);
    //    System.out.println();
    // tree.InOrder(tree.root);
    // System.out.println();
    // tree.postOrder(tree.root);
   

   }
    
}