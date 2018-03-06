package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2133 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int d[] = new int[num+1];
		
		d[0] = 1;
		for(int i=2; i<=num; i+=2) {
			d[i] = d[i-2]*3;
			for(int j=i-4; j>=0; j--) {
				d[i] += d[j]*2;
			}
		}
		
		System.out.println(d[num]);
	}
}
