
import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());

    long[] sum = new long[a+1];
    long[] num = new long[b+1];

    for(int i = 1;i<=a;i++){
      sum[i] = ((sum[i-1] + Integer.parseInt(st.nextToken())) % b);
      num[(int)sum[i]]+=1;
    }

    long ans = num[0];

    for(int i = 0;i<=b;i++){
      long k = num[i];
      ans += (k)*(k-1)/2;
    }
    System.out.println(ans);
  }
}
