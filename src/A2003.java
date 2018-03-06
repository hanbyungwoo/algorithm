import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2003 {
	public static void main(String args[]) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int num = Integer.parseInt(st.nextToken());
		 int cnt = Integer.parseInt(st.nextToken());
		 
		 int value[] = new int[num];
		 st = new StringTokenizer(br.readLine(), " ");
		 
		 for(int i=0; i<num; i++) {
			 value[i] = Integer.parseInt(st.nextToken());
		 }
		 
		 int ans = 0;
		 int l=0, r=0;
		 while(l < num && r < num) {
			 int sum = 0;
			 for(int i=l; i<=r; i++) {
				 sum += value[i];
			 }
			 if(sum == cnt) {
				 ans++;
				 r++;
			 } else if(l==r) {
				 r++;
			 } else if(sum > cnt) {
				 l++;
			 } else if(sum < cnt) {
				 r++;
			 } 
		 }
		 System.out.println(ans);
	}
	
}

