
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	
    	int[] sosu = new int[10001];
    	
    	sosu[1] = 1;
    	
    	for(int i = 2;i<=10000;i++) {
    		if(sosu[i] == 0) {
    			for(int j = 2;j<=5000;j++) {
    			if(i*j <=10000) {
    				sosu[i*j] = 1;
    			}
    			else break;
    		}
    		}
    	}
    	
    	int sum = 0;
    	int min = 10000;
    	
    	for(int i = n;i<=m;i++) {
    		if(sosu[i] == 0) {
    			//System.out.println(i);
    			min = Math.min(min,i);
    			sum += i;
    		}
    	}
    	
    	if(sum == 0) {
    		System.out.println(-1);
    	}
    	else {
    		System.out.println(sum);
    	    System.out.println(min);
    	}
    	
    	
    	
    	
    	
    	}
    	
        
    }

