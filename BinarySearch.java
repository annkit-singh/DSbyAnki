import java.util.Arrays;

import java.util.Scanner;
//This is the program to illutrate the binary search perform in //the data structure
class Searching{
    public int SearchNum(int arr[],int l,int u,int number){
       int m=(l+u)/2;
        if(number==arr[m])
            return m;
        else if(number>arr[m])
            return SearchNum(arr, m+1, u,number);
        
        else if(number<arr[m])
            return SearchNum(arr, l, m-1,number);
        else 
        return -1;
        
        }   
    public static void main(String args[]){
Scanner sc=new Scanner(System.in);
        Searching s=new Searching();
        System.out.println("Enter the size of an array :");
        int size=sc.nextInt();
        int arra[] =new int[size];
        System.out.println("Enter tthe elements of an array:");

        for (int i=0;i<size;i++){
            arra[i]=sc.nextInt();
        }

        System.out.println("Enter the number you want to search :");
        int want=sc.nextInt();
        int low=0;
        int high=arra.length-1;

        Arrays.sort(arra);
    
    if(s.SearchNum(arra,low , high, want)==-1){
        System.out.println("Number is not found sorry");
    }
    else 
    System.out.println("Number is found at Index :"+ s.SearchNum(arra, low, high, want));
}
}