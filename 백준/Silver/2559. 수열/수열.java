
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	static int[] arr ;
	static int max = Integer.MIN_VALUE;
	
	public static void add(int a, int b) {
		int nowAdd = 0;
		
		for(int i = a;i<b;i++) {
			nowAdd += arr[i];
		}
		
		max = Math.max(max,nowAdd);
	}
	
	
    public static void main(String[] args) throws IOException{
    	
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int a = 0;
        int b = m;
        
        for(;b<=n;b++) {
        	add(a,b);
        	a++;
        }
      
        System.out.println(max);
        	
    }
}
