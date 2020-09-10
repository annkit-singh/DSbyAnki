 class GraphColouringClass {

    
   
//Naive Approach
    public boolean isSafe(int graph[][],int colour[]){
        for(int i=0;i<graph.length;i++){
            for(int j=i+1;j<graph.length;j++){
                if(graph[i][j]==1 && colour[j]==colour[i])
                    return false;
                }
            }
        return true;
    }

    boolean GraphColouring(int graph[][],int m,int i,int []colour){    
        if(i==graph.length){
           if( isSafe(graph, colour)){
               printMatrix(colour);
               return true;
           }
           return false;

        }

        for(int j=1;j<=m;j++){
            colour[i]=j;

           if( GraphColouring(graph, m, i+1, colour)){
               return true;
           }
           colour[i]=0;

 
        }
        return false;

    }

    public void printMatrix(int colour[]){
        for(int i:colour){
            System.out.print(i+" ");
        }
    }
    public static void main(String [] args){
        GraphColouringClass g=new GraphColouringClass();
       int  graph[][] = { 
            { 0, 1, 1, 1 }, 
            { 1, 0, 1, 0 }, 
            { 1, 1, 0, 1 }, 
            { 1, 0, 1, 0 }, 
        }; 
        int m = 3; 
        int color[] =new int [4]; 
        for (int i = 0; i < 4; i++) 
            color[i] = 0; 
      
           
        if (!g.GraphColouring(graph, m, 0, color)  )
            System.out.println("Solution does not exist"); 
        // else
        // System.out.println("Yes It is possible");
        System.out.println("Steps needed "+step);

      
        
    }
    
}