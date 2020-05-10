import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Map.Entry;

class Node{
    int data;
    int hd;
    Node  right;
    Node left;

    Node(int data){
        this.data=data;
        this.hd=Integer.MAX_VALUE;
        left=right=null;
    }
}
class TreeDemo{
    static Node root;
    public TreeDemo(){
        root=null;
    }

    public static void topView(Node root){
        class Queuej{
            Node node;
            int hd;
           public Queuej(Node n,int h){
                node =n ;
                hd=h;
            }
        }
            Queue<Queuej> q=new LinkedList<Queuej>();
            Map<Integer ,Node> m=new TreeMap<>();
            if(root==null)
            return;
            else
            q.add(new Queuej(root,0));
            while(!q.isEmpty()){
                Queuej tempQ=q.poll();
                if(!m.containsKey(tempQ.hd))
                m.put(tempQ.hd,tempQ.node);
               if(tempQ.node.left!=null)
               q.add(new Queuej(tempQ.node.left, tempQ.hd-1));
            if(tempQ.node.right!=null)
            q.add(new Queuej(tempQ.node.right, tempQ.hd+1));
            }
            for(Entry<Integer,Node> p:m.entrySet())
            System.out.print(p.getValue().data+" ");

        }
    public static void bottomView(Node root){
        if(root==null)
        return;

        Queue <Node> q=new LinkedList<Node>();
        Map <Integer,Node> m=new TreeMap<Integer,Node>();
        int hd=0;
        root.hd=hd;
        q.add(root);
      
        while(!q.isEmpty()){
            Node temp=q.remove();
            hd=temp.hd;
            m.put(hd, temp);


            if(temp.left!=null){
                temp.left.hd=hd-1;
                q.add(temp.left);
            }

            if(temp.right!=null){
                temp.right.hd=hd+1;
                q.add(temp.right);
            }
        }

        Set s=m.entrySet();
        Iterator<Map.Entry<Integer,Node>> i=s.iterator();
        while(i.hasNext()){
            Map.Entry<Integer,Node> mp=i.next();
            System.out.println(mp.getValue().data+" ");
        }

        
    }
   public static void printLeftView(Node root){
       if(root==null)
       return;
       class Queuev{
           Node n;
           int vd;

           Queuev(Node n,int vd){
               this.n=n;
               this.vd=vd;
           }
        }
           Queue <Queuev> q=new LinkedList<Queuev>();
           Map<Integer,Integer> m=new TreeMap();
           int vd=0;

           q.add(new Queuev(root,vd));
           while(!q.isEmpty()){
               Queuev temp=q.remove();

               if(!m.containsKey(temp.vd)){
               m.put(temp.vd,temp.n.data);
               }

               if(temp.n.right!=null)
               q.add(new Queuev(temp.n.right, temp.vd+1));
               if(temp.n.left!=null)
                   q.add(new Queuev(temp.n.left, temp.vd+1));
               
           }
           Set s=m.entrySet();
           Iterator<Entry <Integer,Integer>> i=s.iterator();
           while(i.hasNext()){
               Entry <Integer,Integer> e=i.next();
               System.out.println(e.getValue()+" ");

           }

       }

       public static void leftView(Node root){
        if(root==null)
        return;

        Queue <Node> q=new LinkedList<Node>();
        Map <Integer,Node> m=new TreeMap<Integer,Node>();
        int hd=0;
        root.hd=hd;
        q.add(root);
      
        while(!q.isEmpty()){
            Node temp=q.remove();
            hd=temp.hd;
            if(!m.containsKey(hd))
            m.put(hd, temp);

            if(temp.right!=null){
                temp.right.hd=hd+1;
                q.add(temp.right);
            }


            if(temp.left!=null){
                temp.left.hd=hd+1;
                q.add(temp.left);
            }

          
        }

        Set s=m.entrySet();
        Iterator<Map.Entry<Integer,Node>> i=s.iterator();
        while(i.hasNext()){
            Map.Entry<Integer,Node> mp=i.next();
            System.out.println(mp.getValue().data+" ");
        }

        
    }
   



    public static void main(String[]  args){
        TreeDemo td =new TreeDemo();
        root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        
         System.out.println("Operation");
      leftView(root);
    //    topView(root);
    //     t opwView2(root);
            // bottomView(root);
            // printTopView(root);

    }

}