
import java.io.*;
import java.util.*;



class Main {
	
	
	
	public static void main(String[] arg) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		StringTokenizer st;
        
		StringBuilder sb = new StringBuilder();
		
		
		
		int n = Integer.parseInt(br.readLine());
		
		int i;
		int j;
		
		for(i = 0;i<n;i++) {
			int cnt = 0;
			int a;
			
			int na = Integer.parseInt(br.readLine());
			int[] arr = new int[na+1];
			
			for(j = 1;j<=na;j++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				arr[a] = Integer.parseInt(st.nextToken());
				
			}
			
			
			int k;
			
			int min = arr[1];
			
			for(j = 2;j<=na;j++) {
				if(arr[j]>min) {
					cnt++;
				}
				min = Math.min(arr[j], min);
			}
			sb.append(na-cnt + "\n");
			
		}System.out.println(sb);
		}
	
	 
}

