{\rtf1\ansi\deff0\nouicompat{\fonttbl{\f0\fnil\fcharset0 Calibri;}}
{\*\generator Riched20 10.0.18362}\viewkind4\uc1 
\pard\sa200\sl276\slmult1\f0\fs22\lang9 import java.util.ArrayList;\par
import java.util.HashMap;\par
import java.util.List;\par
import java.util.Map;\par
\par
\par
import java.util.*;\par
\par
 class Graphs <T>\{\par
    Map <Long,Vertex<T> > allVerticesOfGraph;\par
    List <Edge<T>> allEdgesOfGraph;\par
    boolean isDirected;\par
\par
    public Graphs(boolean isDirected)\{\par
\par
        this.allVerticesOfGraph=new HashMap <Long,Vertex<T> >();\par
        this.allEdgesOfGraph=new ArrayList<Edge<T>>();\par
        this.isDirected=isDirected;\par
      \}\par
\par
    public void addEdge(long v1 ,long v2)\{\par
        addEdge(v1, v2,0);\par
    \}\par
    public void addEdge(long v1,long v2,int weight)\{\par
        Vertex<T> vertex1=null;\par
        if(allVerticesOfGraph.containsKey(v1))\{\par
            vertex1=allVerticesOfGraph.get(v1);\par
\par
        \}\par
        else\par
        vertex1=new Vertex<T>(v1);\par
        allVerticesOfGraph.put(v1, vertex1);\par
\par
        Vertex<T> vertex2=null;\par
        if(allVerticesOfGraph.containsKey(v2))\{\par
            vertex2=allVerticesOfGraph.get(v2);\par
\par
        \}\par
        else\par
        vertex2=new Vertex<T>(v2);\par
        allVerticesOfGraph.put(v2, vertex2);\par
    \par
        Edge<T> e=new Edge<T>(vertex1, vertex2, weight,isDirected);\par
        allEdgesOfGraph.add(e);\par
        vertex1.addAdjacentVertex(vertex2, e);\par
        if(!isDirected)\{\par
            vertex2.addAdjacentVertex(vertex1, e);\par
        \}\par
    \}\par
\par
    public List <Edge<T>> getEdges()\{\par
        return  allEdgesOfGraph;\par
    \}\par
    public void readEdges()\{\par
        for(Edge<T> e:allEdgesOfGraph)\{\par
           System.out.println( e.toString());\par
        \}\par
    \}\par
    public Set<Long> getAllVerticesSet() \{\par
\tab\tab return allVerticesOfGraph.keySet();\par
\tab\tab\par
    \}\par
    public Collection<Vertex<T>> getAllVertexCollection()\{\par
        return allVerticesOfGraph.values();\par
    \}\par
    public void addVertex(long id)\{\par
        Vertex<T> v=new Vertex<T>(id);\par
        if(allVerticesOfGraph.containsKey(id))\{\par
            return;\par
        \}\par
        allVerticesOfGraph.put(id, v);\par
        for(Edge<T> e:v.getAllconnectedEdgesOfVertex())\{\par
            allEdgesOfGraph.add(e);\par
        \}\par
    \}\par
    public void addSingleVertex(long id)\{\par
        Vertex<T> v=new Vertex<T>(id);\par
        if(allVerticesOfGraph.containsKey(id))\{\par
            return;\par
        \}\par
        allVerticesOfGraph.put(id, v);\par
       \par
    \}\par
    public Vertex<T> getVertex(long id)\{\par
        return allVerticesOfGraph.get(id);\par
    \}\par
\par
    public void setDataToVertex(long id,T data)\{\par
        if(allVerticesOfGraph.containsKey(id))\{\par
            allVerticesOfGraph.get(id).setData(data);\par
        \}\}\par
        @Override\par
        public String toString()\{\par
            StringBuffer buffer = new StringBuffer();\par
            for(Edge<T> edge : getEdges())\{\par
                buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());\par
                buffer.append("\\n");\par
            \}\par
            return buffer.toString();\par
        \}\par
    \par
\par
\}\par
    class Vertex<T>\{\par
    private  Long id;\par
    private  T data;\par
    private  List<Edge<T>> connectedEdges=new ArrayList<Edge<T>> ();\par
    private  List<Vertex<T>> adjacentVertices=new ArrayList<Vertex<T>> ();\par
    \par
    public Vertex(Long id)\{\par
        this.id=id;\par
    \}\par
        public void setId(long id)\{\par
            this.id=id;\par
        \}\par
\par
        public Long getId()\{\par
            return this.id;\par
        \}\par
        public void setData(T data)\{\par
            this.data=data;\par
        \}\par
\par
        public T getData()\{\par
            return this.data;\par
        \}\par
\par
        public  List<Edge<T>>  getAllconnectedEdgesOfVertex()\{\par
            return this.connectedEdges;\par
        \}\par
\par
        public  List<Vertex<T>> getAdjacentVertices()\{\par
            return this.adjacentVertices;\par
        \}\par
\par
        public void addAdjacentVertex(Vertex<T> v,Edge<T> e)\{\par
            adjacentVertices.add(v);\par
            connectedEdges.add(e);\par
        \}\par
\par
        public String toString(Vertex<T> v)\{\par
            return "ID -->"+Long.toString(v.id)  +"Data --> "+String.valueOf(v.data);\par
        \par
        \}\par
        \par
        public int getDegree(Vertex<T> v)\{\par
           return  v.connectedEdges.size();\par
        \}\par
\par
@Override\par
public int hashCode() \{\par
    final int prime = 31;\par
    int result = 1;\par
    result = prime * result + (int) (id ^ (id >>> 32));\par
    return result;\par
\}\par
\par
@Override\par
public boolean equals(Object obj) \{\par
    if (this == obj)\par
        return true;\par
    if (obj == null)\par
        return false;\par
    if (getClass() != obj.getClass())\par
        return false;\par
    Vertex<T> other = (Vertex<T>) obj;\par
    if (id != other.id)\par
        return false;\par
    return true;\par
\}\par
\par
\par
\}\par
\par
class Edge<T>\{\par
    boolean isDirected;\par
    Vertex<T> v1;\par
    Vertex<T> v2;\par
    long weight;\par
\par
    // #4 constructors according to the requirement \par
\par
    public Edge(Vertex<T> v1,Vertex<T> v2)\{\par
        this.v1=v1;\par
        this.v2=v2;\par
    \}\par
    public Edge(Vertex<T> v1,Vertex<T> v2,boolean isDirected)\{\par
        this.v1=v1;\par
        this.v2=v2;\par
       this.isDirected=isDirected;\par
    \}\par
    public Edge(Vertex<T> v1,Vertex<T> v2,long weight)\{\par
        this.v1=v1;\par
        this.v2=v2;\par
        this.weight=weight;\par
    \}\par
    public Edge(Vertex<T> v1,Vertex<T> v2,long weight,boolean isDirected)\{\par
        this.v1=v1;\par
        this.v2=v2;\par
        this.weight=weight;\par
        this.isDirected=isDirected;\par
    \}\par
\par
    // #getter setter method for each instance variable or we can say that for class variable\par
    public void setIsDirected(boolean value)\{\par
        this.isDirected=value;\par
    \}\par
\par
    public boolean getIsDirected()\{\par
        return this.isDirected;\par
\par
    \}\par
\par
    public void setVertex1(Vertex<T> v)\{\par
        this.v1=v;\par
    \}\par
    \par
    public Vertex<T> getVertex1()\{\par
       return  this.v1;\par
    \}\par
    public void setVertex2(Vertex<T> v)\{\par
        this.v2=v;\par
    \}\par
    \par
    public Vertex<T> getVertex2()\{\par
       return  this.v2;\par
    \}\par
    public void setWeight(int w)\{\par
        this.weight=w;\par
    \}\par
    public long getWeight()\{\par
        return this.weight;\par
    \}\par
    @Override\par
    public int hashCode() \{\par
        final int prime = 31;\par
        int result = 1;\par
        result = prime * result + ((v1 == null) ? 0 : v1.hashCode());\par
        result = prime * result + ((v2 == null) ? 0 : v2.hashCode());\par
        return result;\par
    \}\par
\par
    // #this is basically the overridden methods which are useful in hashing or equalisation of the different edges\par
\par
    @Override\par
    public boolean equals(Object obj) \{\par
        if (this == obj)\par
            return true;\par
        if (obj == null)\par
            return false;\par
        if (getClass() != obj.getClass())\par
            return false;\par
        Edge other = (Edge) obj;\par
        if (v1 == null) \{\par
            if (other.v1 != null)\par
                return false;\par
        \} else if (!v1.equals(other.v1))\par
            return false;\par
        if (v2 == null) \{\par
            if (other.v2 != null)\par
                return false;\par
        \} else if (!v2.equals(other.v2))\par
            return false;\par
        return true;\par
    \}\par
\par
    @Override\par
    public String toString() \{\par
        return "Edge [id_vertex1 "+v1.getId()+", isDirected=" + isDirected + ", vertex1_data=" + v1.getData()\par
                + "  ,id_vertex1  "+v2.getId()+", vertex2_data=" + v2.getData() + ", weight=" + weight + "]";\par
    \}\par
\}\par
 class DisJointSet \{\par
    private Map<Long,Node> m=new HashMap<>();\par
    \par
    \par
    class Node\{\par
        long data;int rank;\par
        Node parent;\par
    \}\par
    \par
    public void makeSet(long data)\{\par
        Node n=new Node();\par
        n.data=data;\par
        n.parent=n;\par
        n.rank=0;\par
        m.put(data, n);\par
    \par
    \}\par
    \par
    public boolean union(long label1 ,long label2)\{\par
        Node node1=m.get(label1);\par
        Node node2=m.get(label2);\par
    \par
        Node parent1=findSet(node1);\par
        Node parent2=findSet(node2);\par
    \par
        if(parent1.data ==parent2.data)\{\par
            return false;\par
        \}\par
    \par
        if(parent1.rank>=parent2.rank)\{\par
            parent1.rank= (parent1.rank==parent2.rank) ? parent1.rank+1 : parent1.rank;  \par
            parent2.parent=parent1;\par
        \}\par
        else \par
        parent1.parent=parent2;\par
    \par
        return false;\par
    \}\par
\par
    // #findSet is basically used to find the parent of the Node or Set \par
    \par
    public long findSet(long data) \{\par
        return findSet(m.get(data)).data;\par
    \}\par
    \par
    \par
    public Node findSet(Node node)\{\par
        Node parent=node.parent;\par
    \par
        if(parent==node)\{\par
            return parent;\par
        \}\par
        node=findSet(parent);\par
        return node;\par
    \}\par
\}\par
class KruskalMST \{\par
    /**\par
     * Comparator to sort edges by weight in non decreasing order\par
     */\par
    public class EdgeComparator implements Comparator<Edge<Integer>> \{\par
        @Override\par
        public int compare(Edge<Integer> edge1, Edge<Integer> edge2) \{\par
            if (edge1.getWeight() <= edge2.getWeight()) \{\par
                return -1;\par
            \} else \{\par
                return 1;\par
                \par
            \}\par
        \}\par
    \}\par
\par
    public List<Edge<Integer>> getMST(Graphs<Integer> graph) \{\par
        List<Edge<Integer>> allEdges = graph.getEdges();\par
        EdgeComparator edgeComparator = new EdgeComparator();\par
\par
        //sort all edges in non decreasing order\par
        Collections.sort(allEdges, edgeComparator);\par
        DisJointSet disjointSet = new DisJointSet();\par
\par
        //create as many disjoint sets as the total vertices\par
        for (Vertex<Integer> vertex : graph.getAllVertexCollection()) \{\par
            disjointSet.makeSet(vertex.getId());\par
        \}\par
\par
        List<Edge<Integer>> resultEdge = new ArrayList<Edge<Integer>>();\par
\par
        for (Edge<Integer> edge : allEdges) \{\par
            //get the sets of two vertices of the edge\par
            long root1 = disjointSet.findSet(edge.getVertex1().getId());\par
            long root2 = disjointSet.findSet(edge.getVertex2().getId());\par
\par
            //check if the vertices are in same set or different set\par
            //if verties are in same set then ignore the edge\par
            if (root1 == root2) \{\par
                continue;\par
            \} else \{\par
                //if vertices are in different set then add the edge to result and union these two sets into one\par
                resultEdge.add(edge);\par
                disjointSet.union(edge.getVertex1().getId(), edge.getVertex2().getId());\par
            \}\par
\par
        \}\par
        return resultEdge;\par
    \}\par
\par
  \par
\par
    public static void main(String args[]) \{\par
        Graphs<Integer> graph = new Graphs<Integer>(false);\par
        graph.addEdge(1, 2, 4);\par
        graph.addEdge(1, 3, 1);\par
        graph.addEdge(2, 5, 1);\par
        graph.addEdge(2, 6, 3);\par
        graph.addEdge(2, 4, 2);\par
        graph.addEdge(6, 5, 2);\par
        graph.addEdge(6, 4, 3);\par
        graph.addEdge(4, 7, 2);\par
        graph.addEdge(3, 4, 5);\par
        graph.addEdge(3, 7, 8);\par
        KruskalMST mst = new KruskalMST();\par
        List<Edge<Integer>> result = mst.getMST(graph);\par
        for (Edge<Integer> edge : result) \{\par
            System.out.println(edge.getVertex1().getId() + " " + edge.getVertex2().getId());\par
        \}\par
    \}\par
\}\par
    \par
\par
\par
    \par
}
 