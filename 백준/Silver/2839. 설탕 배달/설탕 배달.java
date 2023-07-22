import java.util.*;
import java.io.*;
import java.math.*;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int k = n/5;


        for(int i = k;i>=0;i--){
            if((n-i*5) % 3 == 0){
                int cnt = i;
                cnt += (n-i*5)/3;
                System.out.println(cnt);
                System.exit(0);
            }
        }

        System.out.println(-1);


    }
}