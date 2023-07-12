import java.util.*;
import java.io.*;
import java.math.*;


public class Main {

    static int[] union;

    static int find(int k){
        if(union[k] == k){
            return k;
        }
        else return union[k] = find(union[k]);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        union = new int[n+1];

        for(int i = 0;i<=n;i++){
            union[i] = i;
        }

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 1){
                if(find(b) == find(c)){
                    sb.append("YES").append("\n");
                }
                else{
                    sb.append("NO").append("\n");
                }
            }
            else{
                int first = find(b);
                int second = find(c);
                if(first < second) union[first] = second;
                else union[second] = first;
            }
        }

        System.out.println(sb);

    }
}