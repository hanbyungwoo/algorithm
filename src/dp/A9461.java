package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A9461 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testCase = Integer.parseInt(st.nextToken());
		long d[] = new long[101];
		d[1] = 1; d[2] = 1; d[3] = 1; d[4] = 2; d[5] = 2;
		for(int i=6; i<=100; i++) {
			d[i] = d[i-1] + d[i-5];
		}
		while(testCase-- > 0) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			
			System.out.println(d[num]);
			
		}

	}
}
