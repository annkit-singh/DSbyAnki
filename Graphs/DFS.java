import java.util.Stack;
// This DFS is for undirected graph only
// vertex class 
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
    private Stack<Integer> theStack;

    public Graph(){
        vertexList=new Vertex[maxVertices];
        adjMatrix =new int [maxVertices][maxVertices];
        vertexCount=0;
        for(int y=0;y<maxVertices;y++){
            for(int x=0;x<maxVertices;x++){
                adjMatrix[x][y]=0;
            }
        }
        theStack=new Stack<Integer>();
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

    // #stack used in the dfs 
    public void dfs(){
        vertexList[0].visited=true;
        displayVertex(0);
        theStack.push(0);

        while(!theStack.isEmpty()){
            int v=getAdjUnivisited(theStack.peek());
            if(v==-1)
                theStack.pop();
            else{
            vertexList[v].visited=true;
            displayVertex(v);
            theStack.push(v);
            }
                     
        }
        for(int j=0;j<vertexCount;j++){
            vertexList[j].visited=false;
        }
        

    }
    // #gives the vertice which is unvisited 
    public int getAdjUnivisited(int v){
        for(int j=0;j<vertexCount;j++)
            if(adjMatrix[v][j]==1 && vertexList[j].visited==false)
                return j;
            
        return -1;
    }

    public static void main(String []args){
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
        g.dfs();
        
    }
//     Applications of DFS
// • Topological sorting
// • Finding connected components
// • Finding articulation points (cut vertices) of the graph
// • Finding strongly connected components
// • Solving puzzles such as mazes

}