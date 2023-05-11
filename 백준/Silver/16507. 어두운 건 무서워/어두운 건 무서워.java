import java.util.*;
import java.io.*;
import java.math.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];

        int[][] sum = new int[n+1][m+1];



        for(int i = 1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1;j<=m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                sum[i][j] = sum[i][j-1] + arr[i][j];
            }
        }

        for(int i = 0;i < k ;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int cnt = 0;


            for(int p = a;p<=c;p++){
                cnt += sum[p][d] - sum[p][b-1];
            }

            System.out.println(cnt/((Math.abs(a-c)+1)*(Math.abs(b-d)+1)));
        }


    }
}