package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1912_¿¬¼ÓÇÕ {
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
		
		d[0] = arr[0];
		for(int i=1; i<num; i++) {
			if(arr[i] < arr[i]+d[i-1]) {
				d[i] = arr[i]+d[i-1];
			} else {
				d[i] = arr[i];
			}
		}
		int max = d[0];
		for(int i=1; i<num; i++) {
			if(max < d[i]) {
				max = d[i];
			}
		}
		
		System.out.println(max);
	}
}
