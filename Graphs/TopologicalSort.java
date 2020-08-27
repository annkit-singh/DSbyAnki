
import java.util.*;

class Vertice{
	String label;
	Vertice(String label){
		this.label=label;
	}
}
public class MapCheck {
	Map<String ,List<String>> adjVertix=new HashMap<String ,List<String>>();
	void addVertex(String label) {
        adjVertix.putIfAbsent(label,new LinkedList<String>());
    }
	
	void addEdge(String label1,String label2) {
		
		adjVertix.get(label1).add(label2);
//		adjVertix.get(label2).add(label1);
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
    
    
//    main Topological Function
	public Deque<String> topSort(	Map<String ,List<String>> adjVertix){
		Deque<String> dq=new ArrayDeque<String>();
		Set <String> visited =new HashSet<String>();
		
		for(Map.Entry<String ,List<String>> en:adjVertix.entrySet()) {
			if(visited.contains(en.getKey() ))
					continue;
				
			else
				visited.add(en.getKey());
						for(String s:	adjVertix.get(en.getKey())){
						if(visited.contains(s))
							continue;
													
						else
						topSortUtil(dq,visited,s,adjVertix);
						}
			
				dq.offerFirst(en.getKey());
			}
		return dq;
	}
	
	public void topSortUtil(Deque<String> dq,Set <String> visited,String s,Map<String ,List<String>> mp) {
		visited.add(s);
				for(String u:mp.get(s)) {
					if(visited.contains(u))
						continue;
					
					else {
						topSortUtil(dq,visited, u,mp);
						
					}
						
			
				}
				dq.offerFirst(s);
	}
		
		
	
		
		
		
		
	
	
	public static void main(String [] args) {
	MapCheck m=new MapCheck();
	m.addVertex("A");
	m.addVertex("B");
	m.addVertex("C");
	m.addVertex("D");
	m.addVertex("E");
	
	
	
	m.addEdge("A", "B");
	m.addEdge("A","C");
	m.addEdge("B", "D");
	m.addEdge("C", "D");
	m.addEdge("D","E");

	System.out.println("This is the implementation  throught the linkedList");
System.out.println(	  m.topSort(m.adjVertix));
	
//for(String s:	m.BFS(m, "1")) {
//	System.out.print (s+" ");
//}
	
//for(List<String>  li:	m.adjVertix.values()) {
//	for(String ele:li) {
//		System.out.print(ele+" ");
//	}
//	System.out.println();
//}
	
		
		
		


	}

}