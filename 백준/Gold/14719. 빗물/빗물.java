import java.util.*;
import java.io.*;
import java.math.*;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n][m];

        st = new StringTokenizer(br.readLine());

        for(int i = 0;i<m;i++){
            int k = Integer.parseInt(st.nextToken());

            for(int j = k-1 ;j>=0;j--){
                arr[j][i] = 1;
            }
        }

        

        int ans = 0;

        Stack<Integer> s = new Stack<>();

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(arr[i][j] == 1){
                    s.push(j);
                }
            }

            if(s.isEmpty()) continue;
            int front = s.pop();

            while(s.isEmpty()!= true){
                int k = s.pop();
                ans += Math.abs(k-front)-1;
                front = k;
            }
        }

        System.out.println(ans);




    }
}