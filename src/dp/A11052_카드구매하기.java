package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A11052_카드구매하기 {
	public static void main(String args[]) throws IOException {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int arr[] = new int[num+1];
			int d[] = new int[num+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=num; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1; i<=num; i++) {
				for(int j=1; j<=i; j++) {
					d[i] = max(d[i], d[i-j]+arr[j]);
				}
			}
			
			System.out.println(d[num]);
	}
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
}
