import java.util.Scanner;

public class Next {


        public boolean check2(int N){
            if(N==0){
                return false;
            }else{
            while(N%2==0){
                  N/=2;
                  if(N==1) return true;
                     }
                 }
        
            return false;
                }

                // checks if x is the power of two or not Opptimized --->
            
         boolean isPowerOfTwo(int x)
        {
            int r=x & (x-1);
            if(r==0)
              return true;

              return false;
         }

        //  Complexity O(K) where K is the numbers of ones

         int  onesCount(int n){
            int count=0;     
             while(n!=0){
                 count++;
                 n=n&(n-1);
                    }
            
            return count;
                 }

        // Check if the paritcular bit is set or not
                

                 boolean setorNot(int number ,int bit){
                    int p=number&(1<<bit);
                    if(p!=0)
                    return true;
                    else
                    return false;
                     
                 }

                 void findSubsets(char[] A,int N){
                     for(int i=0;i<(1<<N);i++){
                        System.out.print("[ ");
                        for(int j=0;j<N;j++){
                            int p=i& (1<<j);
                            if(p!=0)
                            System.out.print(A[j]+ " ");
                        }
                        System.out.print(" ]");
                     }
                 }


// counts the bits required to represent a number
        public long maxPowerOf2(int N){
            N=N| (N>>1);
            N=N| (N>>2);
            N=N| (N>>4);
            N=N| (N>>8);
        // where k is the  max multiple of 2  for example in case of 35 it is 32
            int k= (N+1)>>1;
            int count=0;
            while (k!=0){
                k/=2;
                count++;
            }
            return count;
        }

        public static void main(String [] args){
            Next n=new Next();
            // System.out.println("Hello");

            // boolean o=n.check2(50);
            // boolean p=n.isPowerOfTwo(64);
            Scanner sc=new Scanner(System.in);
            int m=sc.nextInt();
            long J=n.maxPowerOf2(m);
          
           

            // Math.l
            // int i=20;
           
            // char A[]={'a','b','c'};
            // n.findSubsets(A,A.length);
        //     int nu=sc.nextInt();
        //     int bit=sc.nextInt();

        //   System.out.println( n.checkIfSet(nu, bit));
      

            // int r=n.onesCount(nu);
            // System.out.println(r);
        
    
        }
    }
    
