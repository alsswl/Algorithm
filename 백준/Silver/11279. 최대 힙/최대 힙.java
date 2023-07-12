import java.util.*;
import java.io.*;
import java.math.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<n;i++){
             int k = Integer.parseInt(br.readLine());
             if(k ==0){
                 if(q.isEmpty() == true){
                     sb.append(0).append("\n");
                 }
                 else{
                     int out = q.poll();
                     sb.append(out).append("\n");
                 }
             }
             else{
                 q.offer(k);
             }
        }

        System.out.println(sb);


    }
}