import java.util.*;
import java.io.*;
import java.math.*;


public class Main {

    static char[] arr;

    static int check(int a, int b){
        int fir = a;
        int sec = b;

        while(fir<sec){
            if(arr[fir] != arr[sec]){
                return 0;
            }
            fir++;
            sec--;
        }
        return 1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String k = br.readLine();

            arr = k.toCharArray();

            int fir = 0;
            int sec = arr.length-1;

            int ans = 0;

            while(fir < sec){

                if(arr[fir] != arr[sec]){
                    if(ans != 0) {
                        ans = 2;
                        break;
                    }
                    if(arr[fir+1] == arr[sec] && check(fir+1, sec) == 1){
                        fir++;
                        ans++;
                    }
                    else if(arr[fir] == arr[sec-1] && check(fir, sec-1) == 1){
                        sec--;
                        ans++;
                    }
                    else{
                        ans =2;
                        break;
                    }
                }
                fir++;
                sec--;
            }

            System.out.println(ans);


        }
    }
}