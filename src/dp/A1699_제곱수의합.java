package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1699_Á¦°ö¼öÀÇÇÕ {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int d[] = new int[num+1];
		
		for(int i=1; i<=num; i++) {
			d[i] = i;
			for(int j=1; j*j<=i; j++) {
				if(d[i] > d[i-j*j]+1) {
					d[i] = d[i-j*j]+1;
				}
			}
		}
		
		System.out.println(d[num]);
	}
}
