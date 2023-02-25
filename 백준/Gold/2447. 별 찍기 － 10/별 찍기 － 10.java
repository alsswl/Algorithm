
import java.util.*;
import java.io.*;


class Main{
	
 public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    int cnt = 0;
    int nn = n;
    while(nn != 1) {
    	nn/=3;
    	cnt ++;
    }
    
    char[][] arr = new char[n+1][n+1];

    
    arr[1][1] = '*';
    
    int i,j;
    int k;
    
    for(i= 0;i<cnt;i++) {
    	for(j =1 ;j<=Math.pow(3, i);j++) {
    		
    		for(k = 1;k<=Math.pow(3, i);k++) {
    			
    			arr[(int) (j +Math.pow(3, i))][k] = arr[j][k] ;
    			arr[(int) (j +2*Math.pow(3, i))][k] = arr[j][k] ;
    			arr[j][(int) (k+Math.pow(3, i))] = arr[j][k] ;
    			arr[j][(int) (k+(Math.pow(3, i)*2))] = arr[j][k] ;
    			arr[(int) (j +Math.pow(3, i))][(int) (k+Math.pow(3, i)*2)] = arr[j][k] ;
    			arr[(int) (j +Math.pow(3, i)*2)][(int) (k+Math.pow(3, i))] = arr[j][k] ;
    			arr[(int) (j +Math.pow(3, i)*2)][(int) (k+Math.pow(3, i)*2)] = arr[j][k] ;
    		}
    	}
    }
    
    for(i = 1;i<=n;i++) {
    	for(j = 1;j<=n;j++) {
    		if(arr[i][j] == '*') {
    		sb.append('*');}
    		else {
    			sb.append(' ');;
    		}
    	}
    	sb.append('\n');
    }
    System.out.println(sb);
   
    	
    }
 }    

