import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

 class Graphs <T>{
    Map <Long,Vertex<T> > allVerticesOfGraph;
    List <Edge<T>> allEdgesOfGraph;
    boolean isDirected;

    public Graphs(boolean isDirected){

        this.allVerticesOfGraph=new HashMap <Long,Vertex<T> >();
        this.allEdgesOfGraph=new ArrayList<Edge<T>>();
        this.isDirected=isDirected;
      }

    public void addEdge(long v1 ,long v2){
        addEdge(v1, v2,0);
    }
    public void addEdge(long v1,long v2,int weight){
        Vertex<T> vertex1=null;
        if(allVerticesOfGraph.containsKey(v1)){
            vertex1=allVerticesOfGraph.get(v1);

        }
        else
        vertex1=new Vertex<T>(v1);
        allVerticesOfGraph.put(v1, vertex1);

        Vertex<T> vertex2=null;
        if(allVerticesOfGraph.containsKey(v2)){
            vertex2=allVerticesOfGraph.get(v2);

        }
        else
        vertex2=new Vertex<T>(v2);
        allVerticesOfGraph.put(v2, vertex2);
    
        Edge<T> e=new Edge<T>(vertex1, vertex2, weight,isDirected);
        allEdgesOfGraph.add(e);
        vertex1.addAdjacentVertex(vertex2, e);
        if(!isDirected){
            vertex2.addAdjacentVertex(vertex1, e);
        }
    }

    public List <Edge<T>> getEdges(){
        return  allEdgesOfGraph;
    }
    public void readEdges(){
        for(Edge<T> e:allEdgesOfGraph){
           System.out.println( e.toString());
        }
    }
    public Set<Long> getAllVertices() {
		return allVerticesOfGraph.keySet();
		
    }
    public void addVertex(long id){
        Vertex<T> v=new Vertex<T>(id);
        if(allVerticesOfGraph.containsKey(id)){
            return;
        }
        allVerticesOfGraph.put(id, v);
        for(Edge<T> e:v.getAllconnectedEdgesOfVertex()){
            allEdgesOfGraph.add(e);
        }
    }
    public void addSingleVertex(long id){
        Vertex<T> v=new Vertex<T>(id);
        if(allVerticesOfGraph.containsKey(id)){
            return;
        }
        allVerticesOfGraph.put(id, v);
       
    }
    public Vertex<T> getVertex(long id){
        return allVerticesOfGraph.get(id);
    }

    public void setDataToVertex(long id,T data){
        if(allVerticesOfGraph.containsKey(id)){
            allVerticesOfGraph.get(id).setData(data);
        }
    }

    public static void main(String[] args){
        Graphs<String> g=new Graphs(true);
        g.addEdge(1,4);
        g.addEdge(1,6);
        g.addEdge(4,6);
        g.addEdge(3,6);
        g.addEdge(5,6);
        g.addEdge(3,5);
        g.setDataToVertex(1,"A" );
        g.setDataToVertex(4,"H" );
        g.setDataToVertex(5,"Z" );
        g.setDataToVertex(3,"P" );
        g.setDataToVertex(6,"T" );
      System.out.println(  g.getAllVertices());
      g.readEdges();
       

    }
    





















}
    class Vertex<T>{
    private  Long id;
    private  T data;
    private  List<Edge<T>> connectedEdges=new ArrayList<Edge<T>> ();
    private  List<Vertex<T>> adjacentVertices=new ArrayList<Vertex<T>> ();
    
    public Vertex(Long id){
        this.id=id;
    }
        public void setId(long id){
            this.id=id;
        }

        public Long getId(){
            return this.id;
        }
        public void setData(T data){
            this.data=data;
        }

        public T getData(){
            return this.data;
        }

        public  List<Edge<T>>  getAllconnectedEdgesOfVertex(){
            return this.connectedEdges;
        }

        public  List<Vertex<T>> getAdjacentVertices(){
            return this.adjacentVertices;
        }

        public void addAdjacentVertex(Vertex<T> v,Edge<T> e){
            adjacentVertices.add(v);
            connectedEdges.add(e);
        }

        public String toString(Vertex<T> v){
            return "ID -->"+Long.toString(v.id)  +"Data --> "+String.valueOf(v.data);
        
        }
        
        public int getDegree(Vertex<T> v){
           return  v.connectedEdges.size();
        }

@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Vertex<T> other = (Vertex<T>) obj;
    if (id != other.id)
        return false;
    return true;
}


}

class Edge<T>{
    boolean isDirected;
    Vertex<T> v1;
    Vertex<T> v2;
    long weight;

    // #4 constructors according to the requirement 

    public Edge(Vertex<T> v1,Vertex<T> v2){
        this.v1=v1;
        this.v2=v2;
    }
    public Edge(Vertex<T> v1,Vertex<T> v2,boolean isDirected){
        this.v1=v1;
        this.v2=v2;
       this.isDirected=isDirected;
    }
    public Edge(Vertex<T> v1,Vertex<T> v2,long weight){
        this.v1=v1;
        this.v2=v2;
        this.weight=weight;
    }
    public Edge(Vertex<T> v1,Vertex<T> v2,long weight,boolean isDirected){
        this.v1=v1;
        this.v2=v2;
        this.weight=weight;
        this.isDirected=isDirected;
    }

    // #getter setter method for each instance variable or we can say that for class variable
    public void setIsDirected(boolean value){
        this.isDirected=value;
    }

    public boolean getIsDirected(){
        return this.isDirected;

    }

    public void setVertex1(Vertex<T> v){
        this.v1=v;
    }
    
    public Vertex<T> getVertex1(){
       return  this.v1;
    }
    public void setVertex2(Vertex<T> v){
        this.v2=v;
    }
    
    public Vertex<T> getVertex2(){
       return  this.v2;
    }
    public void setWeight(int w){
        this.weight=w;
    }
    public long getWeight(){
        return this.weight;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((v1 == null) ? 0 : v1.hashCode());
        result = prime * result + ((v2 == null) ? 0 : v2.hashCode());
        return result;
    }

    // #this is basically the overridden methods which are useful in hashing or equalisation of the different edges

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (v1 == null) {
            if (other.v1 != null)
                return false;
        } else if (!v1.equals(other.v1))
            return false;
        if (v2 == null) {
            if (other.v2 != null)
                return false;
        } else if (!v2.equals(other.v2))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Edge [isDirected=" + isDirected + ", vertex1=" + v1.getData()
                + ", vertex2=" + v2.getData() + ", weight=" + weight + "]";
    }
}




    


    
