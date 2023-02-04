
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	static class Xy{
		int x;
		int y;
		int nn;
		
		Xy(int x,int y,int nn){
			this.x = x;
			this.y = y;
			this.nn = nn;
		}
	}
	
	static int n;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	
	
	static int check(int x, int y, int k) {
		int mainN = arr[x][y];
		
		for(int i = x;i<x+k;i++) {
			for(int j = y;j<y+k;j++) {
				if(arr[i][j] != mainN) return 1;
			}
		}
		
		return 0;
	}
	
	
	static void mm(int x, int y, int nn) {
		
		int kk = check(x,y,nn);
		if(kk == 1) {
			 sb.append("(");
			 mm(x,y,nn/2);
			 mm(x,y+nn/2,nn/2);
			 mm(x+nn/2,y,nn/2);
			 mm(x+nn/2,y+nn/2,nn/2);
			 sb.append(")");
		}
		else {
			sb.append(arr[x][y]);
		}
    	}
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	
    	StringTokenizer st;
    	
    	arr = new int[n][n];
    	
    	for(int i = 0;i<n;i++) {
    		String nw = br.readLine();
    		String[] nwarr = nw.split("");
    		for(int j =0;j<n;j++) {
    			arr[i][j] = Integer.parseInt(nwarr[j]);
    		}
    	}
    	
    	mm(0,0,n);
    	
    	
    
    	
    	
    	System.out.println(sb);
    	
    	}
    	
        
    }

