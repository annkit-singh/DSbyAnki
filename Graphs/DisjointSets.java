import java.util.HashMap;
import java.util.Map;

public class DisJointSets {
private Map<Long,Node> m=new HashMap<>();


class Node{
    long data;int rank;
    Node parent;
}

public void makeSet(long data){
    Node n=new Node();
    n.data=data;
    n.parent=n;
    n.rank=0;
    m.put(data, n);

}

public boolean union(long label1 ,long label2){
    Node node1=m.get(label1);
    Node node2=m.get(label2);

    Node parent1=findSet(node1);
    Node parent2=findSet(node2);

    if(parent1.data ==parent2.data){
        return false;
    }

    if(parent1.rank>=parent2.rank){
        parent1.rank= (parent1.rank==parent2.rank) ? parent1.rank+1 : parent1.rank;  
        parent2.parent=parent1;
    }
    else 
    parent1.parent=parent2;

    return false;
}

public long findSet(long data) {
    return findSet(m.get(data)).data;
}


public Node findSet(Node node){
    Node parent=node.parent;

    if(parent==node){
        return parent;
    }
    node=findSet(parent);
    return node;
}


public static void main(String [] args){
DisJointSets ds=new DisJointSets();
System.out.println("helo");
            ds.makeSet(1);
	        ds.makeSet(2);
	        ds.makeSet(3);
	        ds.makeSet(4);
	        ds.makeSet(5);
	        ds.makeSet(6);
	        ds.makeSet(7);

	        ds.union(1, 2);
	        ds.union(2, 3);
	        ds.union(4, 5);
	        ds.union(6, 7);
	        ds.union(5, 6);
	        ds.union(3, 7);

	        System.out.println(ds.findSet(1));
	        System.out.println(ds.findSet(2));
	        System.out.println(ds.findSet(3));
	        System.out.println(ds.findSet(4));
	        System.out.println(ds.findSet(5));
	        System.out.println(ds.findSet(6));
	        System.out.println(ds.findSet(7));
	    }


}