package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2579 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int arr[] = new int[num+1];
		int d[] = new int[num+1];
		
		
		for(int i=1; i<=num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(num==1) {
			System.out.println(arr[1]);
			return;
		}
		d[1] = arr[1];
		d[2] = arr[1]+arr[2];
		
		for(int i=3; i<=num; i++) {
			d[i] = Math.max(d[i-3]+arr[i]+arr[i-1], d[i-2]+arr[i]);
		}
		
		System.out.println(d[num]);
	}
	
}
