import java.awt.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr[n-1];
        int mid = 0;

        int ans = 0;

        while(right >= left){
            mid = (left + right)/2;

            int now = 0;
            int cnt = 1;

            for(int i = 1;i<n;i++){
                if(arr[i] - arr[now] >= mid){
                    now = i;
                    cnt++;
                }
            }

            if(cnt < c) right = mid -1;
            else{
                left = mid +1;
                ans = Math.max(mid, ans);
            }
            //System.out.printf("%d %d\n",left,right);
        }

        System.out.println(ans);

    }
}