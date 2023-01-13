
import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[a];
        arr[0] = 1;
        arr[1] = 2;
        
        for(int i =2;i<a-2;i++) {
        	arr[i] = arr[i-1]+arr[i-2];
        }
        
        int anum;
        int bnum = 1;
        
        if(a == 3) {
        	anum = 1;
        	anum = 1;
        }
        else {
        	anum = arr[a-4];
            bnum = arr[a-3];
        }
        
        int aans = 1;
        int bbns;
        
        while(true) {
        	if((b-anum*aans)%bnum == 0) break;
        	aans++;
        }
        System.out.println(aans);
        System.out.println((b-anum*aans)/bnum);
        
        	
    }
}
