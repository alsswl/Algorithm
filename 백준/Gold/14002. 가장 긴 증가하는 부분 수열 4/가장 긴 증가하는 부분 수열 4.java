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

        int[] dp = new int[n];

        int[] index = new int[n];

        for(int i =0 ;i<n;i++){
            dp[i] = 1;
            index[i] = i;
        }

        int max =0;
        int mind = 0;

        for(int i = 1;i<n;i++){
            for(int j = 0 ;j<i;j++){
                if(arr[i] > arr[j] && dp[j] +1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    index[i] = j;

                }
            }
            if(max < dp[i]){
                max = dp[i];
                mind = i;
            }
        }

        Stack<Integer> stack =  new Stack<>();
        stack.push(mind);

        while(true){
            int k = stack.peek();
            if(k == index[k]) break;
            stack.push(index[k]);
        }

        System.out.println(stack.size());

        while(stack.isEmpty() != true){
            int k = stack.pop();
            System.out.printf("%d ", arr[k]);
        }


    }
}