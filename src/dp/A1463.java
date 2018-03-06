package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1463 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int d[]=new int[num+1];
		
		d[1] = 0;
		for(int i=2; i<=num; i++) {
			d[i] = d[i-1] + 1;
			if(i%2==0 && d[i] > d[i/2] + 1) {
				d[i] = d[i/2] + 1;
			}
			if(i%3==0 && d[i] > d[i/3] + 1) {
				d[i] = d[i/3] + 1;
			}
		}
		
		System.out.println(d[num]);
	}
}
