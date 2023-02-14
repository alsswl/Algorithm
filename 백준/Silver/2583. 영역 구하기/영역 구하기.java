
import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
	
	
    public static void main(String[] args) throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	
    	List<Integer> list = new ArrayList<>();
    	
    	int[][] arr = new int[k][4];
    	
    	int[][] box = new int[n][m];
    	
    	for(int i = 0;i<k;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0;j<4;j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i = 0;i<k;i++) {
    		
    		for(int z = arr[i][0] ;z<arr[i][2];z++) {
    			for(int q = arr[i][1];q<arr[i][3];q++) {
    				box[q][z] = 1;
    			}
    		}
    			
    	
    	}
    	
    	
    	
    	int ans = 0;
    	Stack<Integer> stackX = new Stack<>();
    	Stack<Integer> stackY = new Stack<>();
    	for(int i =0;i<n;i++) {
    		for(int j =0;j<m;j++) {
    			
    			if(box[i][j] == 0) {
    				ans++;
    				int w = 0;
    				stackX.push(i);
    				stackY.push(j);
    				
    			    box[i][j] = 2;
    			    w++;
    				while(stackX.isEmpty() != true) {
    					
    					int x = stackX.pop();
    					int y = stackY.pop();
    			
    					
    					
    					if(x-1>=0) {
    						if(box[x-1][y] == 0) {
    							w++;
    							stackX.push(x-1);
    						    stackY.push(y);
    						    box[x-1][y] = 2;
    						}
    						
    					}
    					if(y-1>=0) {
    						if(box[x][y-1] == 0) {
    							w++;
    							stackX.push(x);
    						stackY.push(y-1);
    						box[x][y-1] = 2;
    						}
    						
    					}
    					if(x+1<n) {
    						if(box[x+1][y] == 0) {
    							w++;
    							stackX.push(x+1);
    						stackY.push(y);
    						box[x+1][y] = 2;
    						}
    						
    					}
    					if(y+1<m) {
    						if(box[x][y+1] == 0) {
    							w++;
    							stackX.push(x);
    						stackY.push(y+1);
    						box[x][y+1] = 2;
    						}
    						
    					}
    				}
    				
    				list.add(w);
          		}
    			
    			
    			
    			
    		}
    	}
    	
    	
    	
    	Collections.sort(list);
    	System.out.println(ans);
    	
    	for(int i = 0;i<list.size();i++) {
    		System.out.printf("%d ",list.get(i));
    	}
    	}
    	
        
    }

