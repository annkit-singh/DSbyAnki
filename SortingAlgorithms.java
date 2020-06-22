import java.util.Arrays;
public class SelectionSort {



        public void bubbleSort(int [] array){
            for(int i=0;i<array.length-1;i++){
                for(int j=0;j<array.length-1;j++){
                    if(array[j]>array[j+1]){
                        int temp=array[j+1];
                        array[j+1]=array[j];
                        array[j]=temp;
                    }
                }
            }
        }

    
       void selectionSort(int arr[]){
           int n=arr.length;
           for(int i=0;i<n-1;i++){
               int min_idx=i;
               for(int j=i+1;j<n;j++){
                   if(arr[j]<arr[min_idx]){
                    min_idx=j;

                   }

               }
               int temp=arr[min_idx];
               arr[min_idx]=arr[i];
               arr[i]=temp;
           }
       }
       public static void merge(int array[],int l,int m,int e){
           int n1=m-l+1;
           int n2=e-m;
           int L[]=new int[n1];
           int R[]=new int[n2];
           for(int i =0;i<n1;++i){
               L[i]=array[l+i];
           }
           for(int j =0;j<n2;++j){
            R[j]=array[m+1+j];
        }
        int i=0;int j=0;
        int k=l;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
            array[k]=L[i];
            i++;
            }

            else{
                array[k]=R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            array[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            array[k]=R[j];
            i++;
            k++;
        }
       }

       public  void mergeSort(int arr[],int l,int r){
           if(l<r){
               int mid=(l+r)/2;
               mergeSort(arr,l,mid);
               mergeSort(arr,mid+1,r);
              merge(arr, l, mid, r);
           }
       }
     
      
        // Prints the array 
        void printArray(int arr[]) 
        { 
            int n = arr.length; 
            for (int i=0; i<n; ++i) 
                System.out.print(arr[i]+" "); 
            System.out.println();  
        } 

        public void bubbleSort(int array[]){
            int last_idx=array.length-1;
            for(int i=0;i<=last_idx;i++){
                for(int j=0;j<=last_idx-1;j++){
                    if(array[j]>array[j+1]){
                    int temp=array[j+1];
                    array[j+1]=array[j];
                    array[j]=temp;
                    }
                }
            }
        }


        public int  partition(int array[]){
           int  n=array.length;
           int low=0;
            int high=(n-1);
            int i=(low-1);
            int pivot=array[high];
            for(int j =low;j<=(high-1);i++){
                if(array[j]<pivot){
                    i++;
                    int temp=array[j];
                    array[j]=array[i];
                    array[i]=temp;
                }
            }
                int temp=pivot;
                pivot=array[i+1];
                array[i+1]=temp;

            return i+1;

        }

        public void quickSort (int array[],int low,int high){
            if(low<high){
                int p=partition(array);
                quickSort(array,low,p-1);
                quickSort(array,p+1,high);
            }
        }
      
        // Driver code to test above 
        public static void main(String args[]) 
        { 
            SelectionSort ob = new SelectionSort(); 
            int arr[] = {64,25,12,22,11}; 
          ob.mergeSort(arr, 0, arr.length);
           ob.printArray(arr);
        } 
    } 
    /* This code is contributed by Rajat Mishra*/