
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
    public static void main(String[] args) throws IOException{
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        BigInteger up = new BigInteger("1");
        
        BigInteger down = new BigInteger("1");
       
        for(int i = 0;i<m;i++) {
        	up = up.multiply(BigInteger.valueOf(n-i));
        }
        
        for(int i = 1;i<=m;i++) {
        	down = down.multiply(BigInteger.valueOf(i));
        }
                                    
        
       
        System.out.println(up.divide(down));
      
        	
    }
}
