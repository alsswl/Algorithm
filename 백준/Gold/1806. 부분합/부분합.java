import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        int start = 0;
        int end = 0;
        int min = 1000000000;
        sum += arr[0];



        while(true){
           // System.out.printf(start + " " + end + " "+ sum + "\n");
            //System.out.println(sum);
            if(sum >= s){
                if(end - start < min){
                    min = end - start;
                    sum -= arr[start];
                    start++;

                }
                else{
                    sum -= arr[start];
                    start++;
                }

            }
            else if(end == n-1) break;
            else{

                    end++;
                    sum += arr[end];

            }
        }
        
        if(min == 1000000000)  System.out.println(0);

        else System.out.println(min+1);

    }
}