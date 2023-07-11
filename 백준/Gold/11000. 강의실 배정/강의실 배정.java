import java.util.*;
import java.io.*;
import java.math.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        StringTokenizer st;

        for(int i = 0;i<n;i++){
            st =  new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int room = 0;

        int[] vis = new int[n];

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });

        PriorityQueue<Integer> q = new PriorityQueue<>();

        q.offer(arr[0][1]);

        for(int i = 1;i<n;i++){
            if(arr[i][0] >= q.peek()){
                q.poll();
            }
            q.offer(arr[i][1]);
        }

        System.out.println(q.size());

    }
}