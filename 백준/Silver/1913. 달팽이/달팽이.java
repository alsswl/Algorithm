
import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        int arr[][] = new int[n+1][n+1];
        
        int nowi = n/2+1;
        int nowj = n/2+1;
        int firsti = n/2+1;
        int firstj = n/2+1;
        int nowNum = 1;
        
        int nn = n/2+1;
        arr[nowi][nowj] = nowNum;
        nowNum++;
        nowi--;
        int a = 0;
        int b = 0;
        
        for(int z = 2;z<=nn;z++) {
        	
        		
            arr[nowi][nowj] = nowNum;
            nowNum++;
        	
        	
        	while(nowj<firstj+z-1) {
        		nowj++;
        		arr[nowi][nowj] = nowNum;
        		
        		nowNum++;
        	}while(nowi<firsti+z-1) {
        		nowi++;
        		arr[nowi][nowj] = nowNum;
        		
        		nowNum++;
        	}
        	
        	while(nowj>firstj-z+1) {
        		nowj--;
        		arr[nowi][nowj] = nowNum;
        		
        		nowNum++;
        	}
        	while(nowi>firsti-z+1) {
        		nowi--;
        		arr[nowi][nowj] = nowNum;
        		
        		nowNum++;
        	}
        	nowi--;
        	
        }
        
        int i;
        int j;
        
        for(i = 1;i<=n;i++) {
        	for(j = 1;j<=n;j++) {
        		if(arr[i][j] == k) {
        			a = i;
        			b = j;
        		}
        		sb.append(arr[i][j]+" ");
        	}
        	sb.append("\n");
        }
        sb.append(a+" "+b);
        System.out.println(sb);
        
       
        	
    }
}
