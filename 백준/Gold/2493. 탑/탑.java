import java.util.*;
import java.io.*;
import java.math.*;

class xy{
    int x;
    int y;

    xy(int x, int y){
        this.x = x;
        this.y = y;
    }
}




public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();



       int k = Integer.parseInt(st.nextToken());



        Stack<xy> stack = new Stack<>();

        stack.push(new xy(k, 1));
        sb.append("0 ");

        for(int i = 1;i<n;i++){

            int s = Integer.parseInt(st.nextToken());

            while(true){
                if(stack.isEmpty()) {
                    sb.append("0 ");
                    break;
                }
                xy now = stack.peek();
                if(now.x >= s){
                    sb.append( now.y+" ");
                    break;
                }
                else stack.pop();
            }

            stack.push(new xy(s, i+1));


        }


        System.out.println(sb);
    }
}