import java.util.Arrays;

class SortingAlgorithms{

    // TimeComplexity - O(n^2)          #stable
    public void bubbleSort(int[] array) {               
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    // ############################################################################################################### 
    //  Time O(n^2)
    void selectionSort(int arr[]) {  
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;

                }

            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    //##################################################################################################################
//    Time Complexity  O( nlogn) 
    public static void merge(int array[], int l, int m, int r) {   //#stable
        int L[]=Arrays.copyOfRange(array, l, m); 
        int R[]=Arrays.copyOfRange(array, m, r+1);   //here we use r+1 because third arguments does not r's index
        int i = 0;                                      //e.g ar={1,2,3,4,5}  copyofRange(ar,0,2) so it returns {1,2} only 
        int j = 0;
        int k = l;
        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;     }
            else{
                array[k] = R[j];
                j++;  }
            k++;
        }
        while (i < L.length){ array[k] = L[i];  i++;   k++; }
        while (j < R.length){ array[k] = R[j];  j++;   k++; }
    }

    public void mergeSort(int arr[], int l, int r) { // here l=0 and r=array.length-1
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    //#####################################################################################################################

    public int partition(int array[],int low,int high) {
        int pivot = array[high];  //it this case we choose pivot last element or left right most element of an array
        int i=low-1;
        for (int j = low; j <high; j++) {
            if (array[j] < pivot) {
                i++;
               int var=array[j];
               array[j]=array[i];
               array[i]=var;
            }
        }
        i++;

        int temp = pivot;
        pivot = array[i];
        array[i] = temp;

        return i; // it will return the position next to the exact position of the pivot

    }

    public void quickSort(int array[], int low, int high) {//here low=0 ,high=array.length-1 Bestcase -O(nlogn) worst O(n^2) #unstable
        if (low < high) {
            int p = partition(array,low,high);
            quickSort(array, low, p - 1);   // it will sort the left part of the p  (NOTE : p is not included)
            quickSort(array, p+1 , high);
        }
    }

    // ####################################################################################################################

    public void insertionSort(int array[]){  // Best Case O(n) Worst Case O(n^2)  #stable
        for(int i=1;i<array.length;i++){
            int current=array[i];
            int j=i-1;
            while(j>=0 && array[j]>current){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=current;
        }
    }
// ##############################################################################################################################
    public static void main(String[] args) {
    SortingAlgorithms t=new SortingAlgorithms();
    int array[]={98,46,54,33,63,2,66,78,96};
    t.insertionSort(array);
    t.selectionSort(array);
    t.bubbleSort(array);

    t.mergeSort(array, 0, array.length-1);
    t.quickSort(array, 0, array.length-1);
    System.out.println(Arrays.toString(array));


    }
}