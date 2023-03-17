import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n-1]);

        ans[n-1] = -1;

        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n-1;i>=0;i--){

            while(true){

                if(stack.isEmpty() == true){
                    stack.push(arr[i]);
                    ans[i] = -1;
                    break;
                }
                int k = stack.peek();
                if(arr[i] < k){
                    ans[i] = k;
                    stack.push(arr[i]);
                    break;
                }
                else if(stack.isEmpty() != true) {
                    stack.pop();
                }
            }


        }

        for(int i = 0;i<n;i++){
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);


    }
}