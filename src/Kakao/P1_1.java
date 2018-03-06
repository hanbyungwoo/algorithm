package Kakao;
// http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1_1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int arr1[] = new int [n];
		int arr2[] = new int [n];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int j=0; j<n; j++) {
			arr1[j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int j=0; j<n; j++) {
			arr2[j] = Integer.parseInt(st.nextToken());
		}
		
		String [] result = solution(arr1, arr2, n);
		for(int i=0; i<n; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static String[] solution(int arr1[], int arr2[], int n) {
		String temp[] = new String[n];
		for(int i=0; i<n; i++) {
			 
			temp[i] = convert(arr1[i] | arr2[i], n);
			 
		}
		return temp;
		
	}
	
	public static String convert(int arr, int n) {
		char value[] = Integer.toBinaryString(arr).toCharArray();
		StringBuilder sb = new StringBuilder(); 
		int size = value.length;
		for(int i=0; i<n-size; i++) {
			sb.append(" ");
		}
		
		for(int i=0; i<size; i++) {
			if(value[i] == '1') sb.append("#");
			else sb.append(" ");
		}
		return sb.toString();
	}
}
