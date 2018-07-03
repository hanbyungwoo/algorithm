package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A11652 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int num = Integer.parseInt(st.nextToken());
		long arr[] = new long[num];
		
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			arr[i] = a;
		}
		
		Arrays.sort(arr);
		
		int cnt=1;
		int temp=1;
		long ans=arr[0];
		
		for(int i=1; i<num; i++) {
			if(arr[i-1] == arr[i]) {
				cnt++;
			} else {
				cnt = 1;
			}
			
			if(temp < cnt) {
				temp = cnt;
				ans = arr[i];
			}
		}
		
		System.out.println(ans);
		
	}
}