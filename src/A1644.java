import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A1644 {
	public static void main(String args[]) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int num = Integer.parseInt(st.nextToken());
		 boolean value[] = new boolean[num+1];
		 
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 
		 for(int i=2;i<=num;i++) {
			 if(!value[i]) {
				 list.add(i);
			 }
			 for(int j=i*2; j<=num; j+=i) {
				 value[j] = true;	// 소수 아닌 값들 true 로 변경
			 }
		 }
		 
		
		 int size = list.size();
		 int ans = 0;
		 int l=0, r=0;
		 while(l < size && r < size) {
			 int sum = 0;
			 for(int i=l; i<=r; i++) {
				 sum += list.get(i);
			 }
			 if(sum == num) {
				 ans++;
				 r++;
			 } else if(l==r) {
				 r++;
			 } else if(sum > num) {
				 l++;
			 } else if(sum < num) {
				 r++;
			 } 
		 }
		 System.out.println(ans);
	}
	
}
