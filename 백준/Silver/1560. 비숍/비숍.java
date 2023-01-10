
import java.util.*;
import java.io.*;
import java.math.BigInteger;


 class Main {
	
	
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BigInteger n = new BigInteger(br.readLine());
		 
		 
		 if(n.compareTo(BigInteger.valueOf(1)) == 0) System.out.println(1);
		 else if(n.compareTo(BigInteger.valueOf(2)) == 0) System.out.println(2);
		 else System.out.println(n.multiply(BigInteger.TWO).subtract(BigInteger.TWO));
		 
		
		 }
		 
	 }


