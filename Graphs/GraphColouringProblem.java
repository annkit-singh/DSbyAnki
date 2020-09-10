 class GraphColoringProblem{

      //graph[v][i] represents here the adjacent row for example for 0th 
    // it will check 1st row for i to 3
      //if we look at the steps here then in some cases it
      // is reduced in a paricular case for even the first comparison 
    public boolean isSafe(int [][]graph,int color[],int c,int v){
        for(int i=0;i<graph.length;i++){
            if(graph[v][i]==1 && c==color[i]){  //c here is color to  be inserted it is here either 1,2,3
                return false;                      //v here is position of the nodes since here we have two nodes so v is 0,1,2,3
            }
        }
        return true;
    }

boolean  graphMainColor(int [][]graph,int v,int m,int color[]){  // m here is total colors here m is 3
    if(v==graph.length){ 
   return true;
    }
    for(int c=1;c<=m;c++){
        if(isSafe(graph, color, c, v)){
            color[v]=c;
    
        if(graphMainColor(graph, v+1, m, color))
        return true;

        color[v]=0;
        }
    
    }
    return false;
}

    public void graphColoringProblem(int [][] graph,int m){
        int color[]=new int[graph.length];

        if(!graphMainColor(graph, 0, m, color)){
            System.out.println("Solution doesn't exits");
        }
        else{
            printMatrix(color);
            
        }


    }

    public void printMatrix(int color[]){
        for(int i:color){
            System.out.print(i+  " ");
        }

    }

    public static void main(String [] args){
    GraphColoringProblem de=new GraphColoringProblem();
        int graph[][] = { 
            { 0, 1, 1, 1 }, 
            { 1, 0, 1, 0 }, 
            { 1, 1, 0, 1 }, 
            { 1, 0, 1, 0 }, 
        }; 
        int m = 3; // Number of colors 
       de.graphColoringProblem(graph, m);
    }

    
}