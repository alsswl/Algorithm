
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int nn = String.valueOf(n).length();
    	int mn = String.valueOf(m).length();
    	
    	
    	
    	if(nn != mn) System.out.println(0);
    	
    
    	else {
    		int i;
    		int cnt = 0;
    		
    		for(i = 0;i<=nn-1;i++) {
    			if(String.valueOf(n).charAt(i) == String.valueOf(m).charAt(i) ) {
    				if(String.valueOf(n).charAt(i) == '8') cnt++;
    			}
    			else break;
    		}
    		
    		System.out.println(cnt);
    	
    	
    	}
    	
    	
}
    
}
    


