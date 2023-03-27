import java.util.*;
import java.io.*;
import java.math.*;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] arr = new int[n][3];

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp1 = new int[n][3];//최소
        int[][] dp2 = new int[n][3];//최대

        for(int i = 0;i<3;i++){
            dp1[0][i] = arr[0][i];
            dp2[0][i] = arr[0][i];
        }

        for(int i = 1;i<n;i++){
            dp1[i][0] =  arr[i][0] + Math.min(dp1[i-1][0], dp1[i-1][1]);
            dp1[i][1] =  arr[i][1] + Math.min(dp1[i-1][0], Math.min(dp1[i-1][1], dp1[i-1][2]));
            dp1[i][2] =  arr[i][2] + Math.min(dp1[i-1][1], dp1[i-1][2]);
        }

        for(int i = 1;i<n;i++){
            dp2[i][0] =  arr[i][0] + Math.max(dp2[i-1][0], dp2[i-1][1]);
            dp2[i][1] =  arr[i][1] + Math.max(dp2[i-1][0], Math.max(dp2[i-1][1], dp2[i-1][2]));
            dp2[i][2] =  arr[i][2] + Math.max(dp2[i-1][1], dp2[i-1][2]);
        }

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i = 0;i<3;i++){
            max = Math.max(max, dp2[n-1][i]);
            min = Math.min(min, dp1[n-1][i]);
        }

        System.out.printf(max + " " + min);




    }
}