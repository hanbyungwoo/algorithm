package eDailyCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A003_성적표계산하기 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int arr[] = new int[3];
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[0] += a;
			arr[1] += b;
			arr[2] += c;
			
			System.out.println(a + " " + b + " " + c + " " + (a+b+c));
		}
		System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + (arr[0]+arr[1]+arr[2]));
		
	}
}
