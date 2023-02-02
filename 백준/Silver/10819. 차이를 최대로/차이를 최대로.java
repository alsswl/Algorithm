
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
	static int n;
	static int[] arr2;
	static int[] arr;
	static boolean[] visit;
	static int max = 0;
	
	static void count() {
		int cnt = 0;
		
		for(int i = 0;i<n-1;i++) {
			cnt += Math.abs(arr[arr2[i+1]]-arr[arr2[i]]);
		}
		max = Math.max(max, cnt);
	}
	
	static void check(int k) {
		if(k == n) {
			count();
		}
		else {
			for(int i = 0;i<n;i++) {
				if(visit[i] == false) {
					arr2[k] = i;
					visit[i] = true;
					check(k+1);
					visit[i] = false;
				}
			}
		}
	}
	
	
	
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        arr2 = new int[n];
        
        for(int i = 0;i<n;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        check(0);
        
        
        System.out.println(max);
        
        
        
    }
}
