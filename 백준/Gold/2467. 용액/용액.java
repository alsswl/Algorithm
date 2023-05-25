import java.util.*;
import java.io.*;
import java.math.*;



public class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int one = 0;
        int two = n-1;

        int min = Math.abs(arr[one] + arr[two]);
        int a = arr[one];
        int b = arr[two];

        //System.out.println(min);

        while(one < two){
            int k = Math.abs(arr[one] + arr[two]);
            int l = arr[one] + arr[two];

            if(k < min){
                min = k;
                a = arr[one];
                b = arr[two];
            }
            if(l > 0) two--;
            else one++;

        }

        System.out.println(a + " " + b);



    }
}