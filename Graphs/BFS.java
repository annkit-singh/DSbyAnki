import java.util.Queue;
import java.util.*;
// This DFS is for undirected graph only
// vertex class
//BFS is implemented here by using adjacency Matric

class Vertex{
    public char label;
    public boolean visited;

    Vertex(char label){
        this.label=label;
        this.visited=false;
    }
}
class Graph{
    private final int maxVertices=20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Queue<Integer> theQueue;
    public Graph(){
        vertexList=new Vertex[maxVertices];
        adjMatrix =new int [maxVertices][maxVertices];
        vertexCount=0;
        for(int y=0;y<maxVertices;y++){
            for(int x=0;x<maxVertices;x++){
                adjMatrix[x][y]=0;
            }
        }
        theQueue=new LinkedList();

    }
    public void addVertex(char lab){
        vertexList[vertexCount++]=new Vertex(lab);
    }
    public void addEdge(int start,int end){
        adjMatrix[start][end]=1;
        adjMatrix[end][start]=1;
    }
    public void displayVertex(int v){
        System.out.print(vertexList[v].label+" ");
    }

    public int getIndexOfVertice(char label){
        for(int j=0;j<vertexCount;j++){
            if(vertexList[j].label==label)
            return j;
        }
        return -1;

    }
    // #create an edge between two vertices here label1 and label2 are the names of the vertices
    public void addEdgeByName(char label1,char label2 ){
        int start=getIndexOfVertice(label1);
        int end=getIndexOfVertice(label2);
        adjMatrix[start][end]=1;
        adjMatrix[end][start]=1;
    }
    public int getAdjUnivisited(int v){
        for(int j=0;j<vertexCount;j++)
            if(adjMatrix[v][j]==1 && vertexList[j].visited==false)
                return j;
            
        return -1;
    }
    // #Queue used in the dfs 
    public void bfs(){
        vertexList[0].visited=true;
        displayVertex(0);
        theQueue.add(0);
        int v2;

        while(!theQueue.isEmpty()){
            int v1=theQueue.remove();
           
           while((v2=getAdjUnivisited(v1))!=-1){
            vertexList[v2].visited=true;
            displayVertex(v2);
            theQueue.add(v2);
            }
                     
        }
        for(int j=0;j<vertexCount;j++){
            vertexList[j].visited=false;
        }
        

    }

    public static void main(String[]  args){
        Graph g=new Graph();
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
       g.addEdgeByName('A', 'B');
       g.addEdgeByName('A', 'F');
       g.addEdgeByName('B', 'D');
       g.addEdgeByName('E', 'B');
       g.addEdgeByName('A', 'C');
       g.addEdgeByName('D', 'F');
       System.out.println("BFS  :");
        g.bfs();
        
    }
//     Applications of BFS
// • Finding all connected components in a graph
// • Finding all nodes within one connected component
// • Finding the shortest path between two nodes
// • Testing a graph for bipartiteness

}
