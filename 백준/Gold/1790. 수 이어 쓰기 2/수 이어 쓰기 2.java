
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	int[] lastNum = {0,9,99,999,9999,99999,999999,9999999,99999999,999999999};
    	
    	int kk = n;
    	long allLen = 0;
    	long nine = 9;
    	
    	for(int i = 1;i<=10;i++) {
    		if(kk-nine>=0) {
    			kk -= nine;
    			allLen+=(long)i*(long)nine;
    			
    		}
    		else {
    			allLen+=(long)i*(long)kk;
    			break;
    		}
    		nine *= 10;
    	}
    	
       //System.out.println(allLen);
    	
    	if(allLen<(long)k) {
    		System.out.println(-1);
    		return;
    	}
   
    	
    	long nowLen = 9;
    	
    	int i;
    	
    	for(i = 1;i<=13;i++) {
    		
    		if(k - nowLen*i>0) {
    			k -= nowLen*i;
    			//System.out.println(k);
    		}
    		
    		else break;
    		
    		nowLen *= 10;
    	}
    	
    	//System.out.println(i);
    	int na = k%i;
    	if (na == 0) na = i;
    	na--;
    	
    	k = k%i == 0 ? k/i : k/i+1;
    	//System.out.println(na);
    	
    	
    	long ansNum = k+lastNum[i-1];
    	
    	//System.out.println(ansNum);
    	
    	System.out.println(String.valueOf(ansNum).charAt(na));
    	
    	}
    	
        
    }

