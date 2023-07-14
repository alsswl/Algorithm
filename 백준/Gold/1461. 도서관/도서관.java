import java.util.*;
import java.io.*;
import java.math.*;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());


        PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());

        int[] arr = new int[n];

        for(int i =0;i<n;i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
        }

        Arrays.sort(arr);

        int ans = 0;

        int now = 0;

        while(true){
            if(arr[0] > 0) break;
            //System.out.println(arr[now]);
            q2.offer(Math.abs(arr[now]));
            now += m;
            if(now >= n || arr[now] >= 0) break;
        }

        now = n-1;



        while(true){
            if(arr[n-1] < 0) break;
            //System.out.println(arr[now]);
            q2.offer(Math.abs(arr[now]));
            now -= m;
            if(now < 0 || arr[now] < 0) break;
        }

        if(q2.isEmpty() != true) ans += q2.poll();

        while(q2.isEmpty() != true){
            ans += (q2.poll())*2;
        }

        System.out.println(ans);

    }
}