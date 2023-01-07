
import java.io.InputStreamReader;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	
	
	
	public static void main(String arg[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int i,j;
		int[][] kk = new int[4][8];
		for(i = 0;i<4;i++) {
			st = new StringTokenizer(br.readLine());
			for(j = 0;j<8;j++) {
				kk[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(i = 0;i<4;i++) {

			//가로가 만나나
			if(kk[i][2]>kk[i][4]&&kk[i][0]<kk[i][6]) {
				if(kk[i][3]>kk[i][5] &&kk[i][1]<kk[i][7]) {
					System.out.println("a");
				}
				else if(kk[i][3]==kk[i][5] && kk[i][1]==kk[i][7]) {
					System.out.println("a");
				}
				else if(kk[i][3]==kk[i][5] || kk[i][1]==kk[i][7]) {
					System.out.println("b");
				}
				else {
					System.out.println("d");
				}
			}
			
			else if(kk[i][2]==kk[i][4]||kk[i][0]==kk[i][6]) {
				if(kk[i][3]>kk[i][5] && kk[i][1]<kk[i][7]) {
					System.out.println("b");
				}
				else if(kk[i][3]==kk[i][5] ||kk[i][1]==kk[i][7]) {
					System.out.println("c");
				}
				else {
					System.out.println("d");
				}
			}
			
			else {
				System.out.println("d");
			}
				
		}
		
}

}