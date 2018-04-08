package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A11727 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		long d[] = new long[num+1];

		d[1] = 1;
		if(num>=2) {
			d[2] = 3;
		}
		for(int i=3; i<=num; i++) {
			d[i] = (d[i-1] + 2*d[i-2])%10007;
		}
				
		
		System.out.println(d[num]%10007);
		
	}
}
