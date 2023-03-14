import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int[] arr;
    static int[] ho = {1,2,3,5,7,9};
    static int[] pp;
    static int[] ans;
    static int ansn = 0;
    static int n;
    static StringBuilder sb = new StringBuilder();


    // 1은 맨 앞에 오면 안된다.
    //2는 맨 앞만 올 수 있다.

    static void pick(int k){
        if(k == n){
            check();
        }
        else{
            for(int i = 0;i<6;i++){
                pp[k] = i;
                pick(k+1);
            }
        }
    }

    static void check(){
       // System.out.println(11);
        int now = 0;

        for(int i = 0;i<n;i++){
            now = 0;

            for(int j = 0;j<=i;j++){
                now += ho[pp[i-j]]*Math.pow(10,j);
            }

           // System.out.println(now);
            if(!so(now)) return;
        }

        System.out.println(now);
      ///  sb.append(now).append("\n");
    }

    static boolean so(int k){
        if(k == 2) return true;
        if(k == 1) return false;
        for(int i = 2;i*i<=k;i++){
            if(k%i == 0) return false;
        }
        return true;
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        pp = new int[n];
        
        pick(0);

       // System.out.println(sb);

    }
}