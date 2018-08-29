package Kakao.P2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = {4, 1, 3, 2};
		solution(arr);
		
	}
	
	public static boolean solution(int [] arr) {
		boolean answer = true;
		
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			if(i+1 != arr[i]) {
				answer = false;
				break;
			}
		}
		
		return answer;
	}
	
	
}
