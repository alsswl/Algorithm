
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	

	
	
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	while(true) {
    		String s = br.readLine();
    		if(s == null) break;
        	String[] ss = s.split(" ");
        	
        	
        	char[] sk = ss[0].toCharArray();
        	char[] kk = ss[1].toCharArray();
        	int ok = 0;
        	
        	int st = 0;
        	
        	for(int i = 0;i<sk.length;i++) {
        		 ok = 0;
        		for(int j = st;j<kk.length;j++) {
        			if(sk[i] == kk[j]) {
        				st = j+1;
        				ok = 1;
        				break;
        			}
        		}
        		
        		if(ok == 0) break;
        	}
        	if(ok == 0){
        			System.out.println("No");
        			continue;
        		}
        	else System.out.println("Yes");
    	}
    	
    	
    	
}
    
}
    


