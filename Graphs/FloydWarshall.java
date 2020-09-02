import java.util.*;
import java.lang.*;
public class FloydWarshall {

    // #to introduce a new Exception  
    class NegativeWeightCycleException extends RuntimeException {

    }

    private static final int INF = 1000000;

    public int[][] allPairShortestPath(int[][] distanceMatrix) {
        
        int[][] distance=new int[distanceMatrix.length][distanceMatrix.length];
        int[][] path=new int[distanceMatrix.length][distanceMatrix.length];

        for(int i=0;i<distanceMatrix.length;i++){
            for(int j=0;j<distanceMatrix.length;j++){
                distance[i][j]=distanceMatrix[i][j];
                if(distance[i][j]!=INF  && i!=j ){
                    path[i][j]=i;           //i here is imply means the vertices from where edge is coming
                }
                else
                path[i][j]=-1;          // here -1 means that there is no path between vertices
            }
        }
        for(int k=0;k<distanceMatrix.length;k++){
            for(int i=0;i<distanceMatrix.length;i++){
                for(int j=0;j<distanceMatrix.length;j++){
                    if(distance[i][k]==INF || distance[k][j]==INF){   //indicate that there is no path between i to k  or k to j
                    continue;  }
                    if(distance[i][j]>distance[i][k]+distance[k][j]){
                        distance[i][j]=distance[i][k]+distance[k][j];
                        path[i][j]=path[k][j];          //in order to update the intermediate vertices between two vertices
                    }        
        }

    }
    }
    for(int i=0;i<distanceMatrix.length;i++){
        if(distance[i][i]<0){
            throw new NegativeWeightCycleException();
        }
    }
    printPath(path, 3, 2);
    return distance;

}

public void printPath(int [][] path,int start,int end){
    if(start<0 || end<0 || start>=path.length || end>=path.length){
        throw new IllegalArgumentException();
    }
    Deque <Integer> d=new LinkedList<>();
    d.addFirst(end);
    while(true){
        end=path[start][end];
        if(end==-1){
            return;
        }
        d.offerFirst(end);
        if(end==start){
            break;
        }
        

    }
    while(!d.isEmpty()){ 
        System.out.println(d.pollFirst()+" -->");
    }
}

    public static void main(String args[]){
        int[][] graph = {
                {0,   3,   6,   15},
                {INF, 0,  -2,   INF},
                {INF, INF, 0,   2},
                {1,   INF, INF, 0}
        };

        FloydWarshall shortestPath = new FloydWarshall();
        int[][] distance=shortestPath.allPairShortestPath(graph);
        System.out.println("Minimum Distance matrix");
        for(int i=0; i < distance.length; i++){
            for(int j=0; j < distance.length; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
    