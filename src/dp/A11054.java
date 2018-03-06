package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A11054 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int arr[] = new int[num];
		int d[] = new int[num];
		int d2[] = new int[num];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0; i<num; i++) {
			d[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i] && d[i] < d[j] + 1) {
					d[i] = d[j] + 1;
				}
			}
		}

		for(int i=num-1; i>=0; i--) {
			d2[i] = 1;
			for(int j=num-1; j>=i; j--) {
				if(arr[j] < arr[i] && d2[i] < d2[j] + 1) {
					d2[i] = d2[j] + 1;
				}
			}
		}
		
		
		int max = 0;
		for(int i=0; i<num; i++) {
			if(d[i]+d2[i]-1 > max) {
				max = d[i]+d2[i]-1;
			}
		}
		
		
		System.out.println(max);
		
	}
}
