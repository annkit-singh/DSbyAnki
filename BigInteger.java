import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
public class Demo {
    public static void main(String [] args){
      BigInteger b1=new BigInteger("11");
      BigInteger b2=new BigInteger("4");
      BigInteger mod=b1.modPow(new BigInteger("2"),new BigInteger("23"));

      System.out.println(mod);


    //   BigInteger mod = b1.modPow(new BigInteger("2"), new BigInteger("23"));  //b1^2%23
    //   BigInteger mod = b1.mod(b2);  b1%b2
    //   BigInteger div=b1.divide(b2);
    // BigInteger multi = b1.multiply(b2);
    //   BigInteger rem=b1.remainder(b2);  b1%b2
    //   BigInteger gcd=b1.gcd(b2);   gcd(b1.b2)
    //   b1=b1.subtract(b2);
    //   b1=b1.pow(1000000);  


    //   System.out.println(multi);
        
        BigInteger b1=new BigInteger("21");
    BigInteger b2=new BigInteger("21");
   System.out.println( b1.compareTo(b2));  //b1<b2 return -1
                                           //b1>b2 return 1
                                           //b1==b2 return 0
            System.out.println(
            b1.equals(b2));


    }
    
}
