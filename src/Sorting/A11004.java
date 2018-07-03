package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A11004 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		int num = Integer.parseInt(st.nextToken());
		int choice = Integer.parseInt(st.nextToken());
		int arr[] = new int[num];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<num; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a;
		}
		
		Arrays.sort(arr);
		System.out.println(arr[choice-1]);
		
	}
}