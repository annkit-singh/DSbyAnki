
import java.util.*;

class Vertice{
	String label;
	Vertice(String label){
		this.label=label;
	}
}
public class GraphList {
	Map<String ,List<String>> adjVertix=new HashMap<String ,List<String>>();
	void addVertex(String label) {
        adjVertix.putIfAbsent(label,new ArrayList<String>());
    }
	
	void addEdge(String label1,String label2) {
		
		adjVertix.get(label1).add(label2);
		adjVertix.get(label2).add(label1);
		}
	
	
	public LinkedHashSet<String > DFS(MapCheck g,String root){
		LinkedHashSet<String> visited =new LinkedHashSet<String>();
		
		Stack<String> stac=new Stack<String> ();
		stac.push(root);
		while(!stac.isEmpty()) {
			String vert=stac.pop();
			if(!visited.contains(vert)) {
				visited.add(vert);
				
				for(String st:g.adjVertix.get(vert)) {
					stac.push(st);
				}
			}
			
		}
		return visited;
		
		
	}
	public LinkedHashSet<String > BFS(MapCheck g,String root){
		LinkedHashSet<String> visited =new LinkedHashSet<String>();
		
		Queue<String> queue=new ArrayDeque<String> ();
		queue.add(root);
		visited.add(root);
		while(!queue.isEmpty()) {
			String vert=queue.poll();
		
				
				for(String st:g.adjVertix.get(vert)) {
					if(!visited.contains(st)) {
						visited.add(st);
						queue.add(st);
						
					}
				}
			}
		return visited;	
		
	}
	public void removeVertix(String label){
        adjVertix.values().stream().forEach(e->e.remove(label));
        adjVertix.remove(label);
    }

    public void removeEdge(String b,String d)
	{
        adjVertix.get(b).remove(d);
        adjVertix.get(d).remove(b);

    }
	
	public static void main(String [] args) {
	GraphList m=new GraphList();
	m.addVertex("1");
	m.addVertex("2");
	m.addVertex("3");
	m.addVertex("4");
	m.addVertex("5");
	m.addVertex("6");
	m.addVertex("7");
	m.addVertex("8");
	m.addVertex("9");
	m.addVertex("10");
	
	
	m.addEdge("1", "2");
	m.addEdge("1","4");
	m.addEdge("4", "3");
	m.addEdge("3", "10");
	m.addEdge("3","9");
	m.addEdge("2","5");
	m.addEdge("2","8");
	m.addEdge("5","7");
	m.addEdge("5","6");
	m.addEdge("5","8");
	
for(String s:	m.BFS(m, "1")) {
	System.out.print (s+" ");
}
	
//for(List<String>  li:	m.adjVertix.values()) {
//	for(String ele:li) {
//		System.out.print(ele+" ");
//	}
//	System.out.println();
//}
	
		

		


	}

}
