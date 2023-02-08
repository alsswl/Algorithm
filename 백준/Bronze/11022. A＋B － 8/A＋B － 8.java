
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	for(int i = 1;i<=n;i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		System.out.printf("Case #%d: %d + %d = %d\n",i,a,b,a+b);
    	}
    	
    	}
    	
        
    }

