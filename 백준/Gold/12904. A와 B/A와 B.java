import java.io.*;
import java.util.*;



public class Main {

    static String BB(String k){
        char[] arr = k.toCharArray();
        char[] arr2 = new char[arr.length-1];

        for(int i = 0;i<arr.length-1;i++){
            arr2[i] = arr[arr.length -2 -i];
        }

        return new String(arr2);
    }

    static String AA(String k){
        char[] arr = k.toCharArray();
        char[] arr2 = new char[arr.length-1];

        for(int i = 0;i<arr.length-1;i++){
            arr2[i] = arr[i];
        }

        return new String(arr2);
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String fir = br.readLine();
        String sec = br.readLine();

        //String Stack 만들고 이를 이용해서 풀기
        Stack<String> s = new Stack<>();



        s.push(sec);

        while(s.isEmpty() != true){
            String now = s.pop();
            //System.out.println(now);

            char[] arr = now.toCharArray();
            if(arr.length == 0) break;

            if(arr[arr.length-1] == 'A'){
                String k= AA(now);
                s.push(k);
            }

            if(arr[arr.length-1] == 'B'){
                String k= BB(now);
                s.push(k);
            }

            //System.out.println(now);

            if(now.equals(fir)){
                System.out.println(1);
                System.exit(0);
            }


        }

        System.out.println(0);

    }
}