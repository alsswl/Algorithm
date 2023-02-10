
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	int[] sosu = new int[1000001];
    	
    	sosu[1] = 1;
    	
    	for(int i = 2;i<=1000000;i++) {
    		if(sosu[i] == 0) {
    			for(int j = 2;j<=500000;j++) {
    			if(i*j <=1000000) {
    				sosu[i*j] = 1;
    			}
    			else break;
    		}
    		}
    	}
    	
    	while(true)
    	{
    		int k = Integer.parseInt(br.readLine());
    		
    		///System.out.println(k);
    		
    		if(k == 0) break;
    		
    		int does = 0;
    		
    		for(int i = 2;i<=k;i++) {
    			if(sosu[i] == 0 && sosu[k-i] == 0) {
    				sb.append(k).append(" = ").append(i).append(" + ").append(k-i).append(" \n");
    				does = 1;
    				break;
    			}
    		}
    		
    		if(does == 0) sb.append("Goldbach's conjecture is wrong.\n");
    		
    	}
    	
    	System.out.println(sb);
    	
    	}
    	
        
    }

