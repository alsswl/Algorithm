import java.io.*;
import java.util.*;



public class Main {



    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[201];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0;i<n;i++){
            int a = Integer.parseInt(st.nextToken());
            arr[a+100]++;
        }
        int k = Integer.parseInt(br.readLine());

        System.out.println(arr[k+100]);

    }
}