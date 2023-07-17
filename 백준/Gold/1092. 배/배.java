import java.util.*;
import java.io.*;
import java.math.*;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());



       LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0;i<m;i++){
           int k =Integer.parseInt(st.nextToken());
           if(k > arr[n-1]){
               System.out.println(-1);
               System.exit(0);
           }
           list.add(k);
        }

        Collections.sort(list);



        int ans = 0;

        while(list.size() != 0){
            ans++;

            for(int i = n-1;i>=0;i--){
                int now = arr[i];

                if(now < list.get(0)) break;

                for(int j = list.size()-1;j>=0;j--){
                    if(list.get(j) <= now){
                        list.remove(j);
                        break;
                    }
                }

                if(list.size() == 0) break;

            }
        }

        System.out.println(ans);




    }
}