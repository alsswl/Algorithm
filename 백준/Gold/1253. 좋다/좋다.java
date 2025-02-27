
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

    int ans = 0;

    for(int i = 0;i<n;i++){
      int left = 0;
      int right = n-1;

      while(left < right){
        if(left == i){
          left++;
          continue;
        }
        if(right == i){
          right--;
          continue;
        }
        if(arr[left] + arr[right] == arr[i]){
          ans++;
          break;
        }
        else if(arr[left] + arr[right] < arr[i]){
          left++;
        }
        else{
          right--;
        }
      }
    }

    System.out.println(ans);

  }
}
