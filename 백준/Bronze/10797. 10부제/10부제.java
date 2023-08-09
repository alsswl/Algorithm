import java.io.*;
import java.util.*;
import java.math.*;



public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;

        for(int i = 0;i<5;i++){
            int k = Integer.parseInt(st.nextToken());
            if(k % 10 == n) cnt++;
        }

        System.out.println(cnt);


    }
}