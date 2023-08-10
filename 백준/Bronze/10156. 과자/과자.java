import java.io.*;
import java.util.*;
import java.math.*;



public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(k - n*m >= 0) System.out.println(0);
        else System.out.println(n*m-k);
    }
}