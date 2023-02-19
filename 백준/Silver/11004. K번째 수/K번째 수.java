
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	

	
	
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	
    	int[] arr = new int[n];
    	
    	for(int i = 0;i<n;i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	
    	System.out.println(arr[m-1]);
}
    
}
    


