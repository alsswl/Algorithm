
import java.util.*;
import java.io.*;


class pair {
		long num;
		long count;
		pair(long a, long i) {
			num = a;
			count = i;
		}
	}
public class Main {

	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 
		 int a = Integer.parseInt(st.nextToken());
		 int b = Integer.parseInt(st.nextToken());
		 
		 Stack<pair> stack1 = new Stack<>();
		 Stack<pair> stack2 = new Stack<>();
		 
		 stack1.push(new pair(a,0));
		 
		 while(stack1.isEmpty()!=true || stack2.isEmpty()!=true) {
		 
		 while(stack1.isEmpty() != true) {
			 pair now = stack1.pop();
			 
			 if(now.num*2<b)
			 stack2.push(new pair(now.num*2,now.count+1));
			 if(now.num*2==b) {
				 System.out.println(now.count+2);
				 return;
			 }
			 if(now.num*10+1<b)
			 stack2.push(new pair(now.num*10+1,now.count+1));
			 if(now.num*10+1==b) {
				 System.out.println(now.count+2);
				 return;
			 }
		 }
		 
		 while(stack2.isEmpty() != true) {
			 pair now = stack2.pop();
			 
			 if(now.num*2<=b)
			 stack1.push(new pair(now.num*2,now.count+1));
			 if(now.num*2==b) {
				 System.out.println(now.count+2);
				 return;
			 }
			 if(now.num*10+1<=b)
			 stack1.push(new pair(now.num*10+1,now.count+1));
			 if(now.num*10+1==b) {
				 System.out.println(now.count+2);
				 return;
			 }
		 }
		 
		 }
		 
		 System.out.println(-1);
		 
	 }

}
