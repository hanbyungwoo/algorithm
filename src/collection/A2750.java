package collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A2750 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.valueOf(st.nextToken());
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			temp.add(Integer.valueOf(st.nextToken()));
		}
		Collections.sort(temp);
		//Arrays.sort();
		for(int i=0; i<num; i++) {
			System.out.println(temp.get(i));
		}
	}
}
