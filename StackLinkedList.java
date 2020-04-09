class MyStack{
    MyLinkedList<Integer> mll=new MyLinkedList<Integer>();
     public void push(int data){
         mll.AddAtFirst(data);
 
     }
 
     public void pop() throws Exception{
         if (mll.head==null) {
             throw new Exception("Pop is not allowed in empty stack");
         }
         else{
             mll.deleteAtlast();
         }
 
 
         }
 
     public int peek() throws Exception{
         if (mll.head==null) {
             throw new Exception("Peeking is not allowed in empty stack");
         }
         
            return mll.getlast();
         
 
     }
     public void print(){
         mll.display();
     }
     }
     class WeTest{
         public static void main(String args[]) throws Exception{
             MyStack ms=new MyStack();
             ms.push(56);
             ms.push(46);
             ms.push(78);
             ms.push(67);
             
             ms.pop();
             ms.pop();
             ms.print();
             System.out.println();
             System.out.println("Here is ur peeked  "+ms.peek());
 
         }
         }
     