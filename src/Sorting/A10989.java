package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class A10989 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int arr[] = new int[num];
//		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			arr[i] = a; 
//			list.add(a);
		}
		Arrays.sort(arr);
//		Collections.sort(list);
		for(int i=0; i<num; i++) {
			bw.write(arr[i] + "\n");
//			System.out.println(arr[i]);
//			System.out.println(list.get(i));
		}
		bw.close();
		
	}
}