package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A9095 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testCase = Integer.parseInt(st.nextToken());
		
		while(testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			int goal = Integer.parseInt(st.nextToken());
			
			int ans = go(0, 0, goal);
			System.out.println(ans);
		}
	}
	
	public static int go(int count, int sum, int goal) {
		if(sum > goal) return 0;
		if(sum == goal) return 1;
		int now = 0;
		for(int i=1; i<=3; i++) {
			now += go(count+1, sum+i, goal);
		}
		return now;
	}
}
