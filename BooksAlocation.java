 class BooksAlocation {


    public boolean isValidConfiguration(long books[],long nob,long nos,long ans){
        int students=1;
        long current_pages=0;

        for(int i=0;i<nob;i++){
            if(current_pages+books[i]>ans){
                current_pages=books[i];
                students++;
                    if(students>nos)
                        return false;
                    
                 }
            else{
                current_pages+=books[i]; 
            }
        }
        return true;
    }

        public long BookBinarySearch(long books[],long nob,long nos){
            long total_pages=0;
            long s=0;
            long e=0;
            for(int i=0;i<nob;i++){
                total_pages+=books[i];
                s=Math.max(s, books[i]);
            } 
            e=total_pages;
            int finalAns=(int)s;
            while(s<=e){
                long mid=(s+e)/2;
                if(isValidConfiguration(books, nob, nos, mid)){
                    finalAns=(int)mid;
                    e=mid-1;
                }
                else
                    s=mid+1;
                
    
                }
                return finalAns;
            } 

        public static void main(String[] args){
            BooksAlocation ba= new BooksAlocation();
            long books[]={10,20,30,40};
            long n_books=4;
            long n_stud=2;
            System.out.println("answer "+ ba.BookBinarySearch(books,n_books,n_stud));
        }
    
    
}