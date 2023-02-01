
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	


	
	
    public static void main(String[] args) throws IOException{
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	int first = Integer.parseInt(st.nextToken());
        	int second = Integer.parseInt(st.nextToken());
        	
        	BigInteger up = new BigInteger("1");
        	BigInteger down = new BigInteger("1");
        	
        	
        	for(int j = 0;j<first;j++) {
        		up = up.multiply(BigInteger.valueOf(second-j));
        	}
        	
        	for(int k = 1;k<=first;k++) {
        		down = down.multiply(BigInteger.valueOf(k));
        	}
        	
        	
        	
        	System.out.println(up.divide(down));
        }
        
    }
}
