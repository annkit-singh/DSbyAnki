import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class SomeImportantcodes{
    public static void main(String[] args){
       
// INPUT TAKING THROUGH BUFFERED READER
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String lines=bf.readLine();
        String[] strs=lines.trim().split("\\s+");
        int size=Integer.parseInt(strs[0]);
        String element=bf.readLine();
        String[] str=element.trim().split("\\s+");
        int array[]=new int[size];
        for (int i = 0; i < strs.length; i++) {
                array[i] = Integer.parseInt(str[i]);
        }
 // INPUT TAKING THROUGH BUFFERED READER


//WAY TO CALCULATE THE TIME TAKEN OR EXECUTION TIME
        long starTime=System.currentTimeMillis();
            Scanner sc=new Scanner(System.in);

            // int size=sc.nextInt();
            int array[]={-2,-3,4,-1,-2,1,5,-3};

            
      
    
        System.out.println(contigousSum(array));

        long endTime=System.currentTimeMillis();
        long elapse=endTime-starTime;
        System.out.println(elapse);

//WAY TO CALCULATE THE TIME TAKEN OR EXECUTION TIME

    }
}