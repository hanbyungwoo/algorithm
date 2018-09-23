package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A11055_가장큰증가부분수열 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int arr[] = new int[num];
		int d[] = new int[num];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = arr[0];
		for(int i=0; i<num; i++) {
			d[i] = arr[i];
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i] && d[i] < d[j] + arr[i]) {
					d[i] = d[j] + arr[i];
					if(max < d[i]) {
						max = d[i];
					}
				}
			}
		}
		
		
		System.out.println(max);
		
	}
}
