import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int last = 1;

        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int key = arr[i];

            if (dp[last - 1] < key) {
                last++;
                dp[last - 1] = key;
            } else {
                int left = 0;
                int right = last;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (dp[mid] < key) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                dp[left] = key;
            }
        }

        System.out.println(last);
    }
}