
import java.util.*;
import java.io.*;


class Main{
	
 public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr1 = new int[n];
    int[] arr2 = new int[n];
    int[] arr3 = new int[n];
    int[] arr4 = new int[n];
    
    for(int i = 0;i<n;i++) {
    	int a = Integer.parseInt(st.nextToken());
    	arr1[i] = a;
    	

    }
    st = new StringTokenizer(br.readLine());
    
    for(int i = 0;i<n;i++) {
    	int a = Integer.parseInt(st.nextToken());
    	arr2[i] = a;
    	
    }
    
      Arrays.sort(arr1);
      Arrays.sort(arr2);
    
   
    
    int cnt = 0;

   
    
    for(int i = 0;i<n;i++) {
    	    	cnt+= (arr1[i]*arr2[n-i-1]);
    }
   
    System.out.println(cnt);

 }

 }    

