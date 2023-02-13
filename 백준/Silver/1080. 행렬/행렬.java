
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	static class xy{
		int x;
		int y;
		xy(int x, int y){
			this.x =x;
			this.y = y;
		}
	}
	
	static int[][] corr;
	static int[][] vis;
	static int[][] arr1;
	static int[][] arr2;
	static int n;
	static int m;
	
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	
    	
    	
    	corr = new int[n][m];
    	int res = 0;
    	
    	arr1 = new int[n][m];
    	arr2 = new int[n][m];
    	
    	vis = new int[n][m];
    	
    	for(int i = 0;i<n;i++) {
    		String stt = br.readLine();
    		String[] arrS = stt.split("");
    		
    		for(int j = 0;j<m;j++) {
    			arr1[i][j] = Integer.parseInt(arrS[j]);
    		}
    		
    	}
    	
    	for(int i = 0;i<n;i++) {
    		String stt = br.readLine();
    		String[] arrS = stt.split("");
    		//System.out.println(stt);
    		
    		for(int j = 0;j<m;j++) {
    			arr2[i][j] = Integer.parseInt(arrS[j]);
    		}
    		
    	}
    	
    	int ans = 0;
    	
    	
    	//System.out.println(n-2);
    		
    		for(int i =0;i<n-2;i++) {
    			for(int j = 0;j<m-2;j++) {
    				if(arr1[i][j] != arr2[i][j]) {
    					
    					ans++;
    					for(int k = 0;k<3;k++) {
    						for(int z = 0;z<3;z++) {
    							arr1[i+k][j+z] = arr1[i+k][j+z] == 1 ? 0:1;
    						}
    					}
    					
    					/*for(int p = 0;p<n;p++) {
    		        		for(int q = 0;q<m;q++) {
    		        		
    		        			     System.out.printf("%d",arr1[p][q]);
    		        			   
    		        		}
    		        		  System.out.println();
    		        	}*/
    				}
    				}
    			}
    		
    		
    		
    		for(int i = 0;i<n;i++) {
        		for(int j = 0;j<m;j++) {
        			if(arr1[i][j] != arr2[i][j]) {
        			     System.out.println(-1);
        			     return;
        			}
        		}
        	}
    
    	
    	
    	System.out.println(ans);
    	
    	}
    	
        
    }

