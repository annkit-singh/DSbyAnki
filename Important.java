import java.util.Scanner;


class Test{

    public static int contigousSum(int arr[]){

        int n=arr.length;
        int max_end=0;
        int max_so_far=arr[0];
      

        for(int i=0;i<n;i++){
           max_end=max_end+arr[i];
            if(max_end>max_so_far)
            max_so_far=max_end;
            if(max_end<0)
            max_end=0;
            
        }
        return max_so_far;
    }
    
    public static void main(String[] args){
        int array[]={-2,-3,-1,-2,-3};
      
	
        System.out.println(contigousSum(array));


  
    }
}



        