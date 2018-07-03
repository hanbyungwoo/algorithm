package woowahan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2_1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());	// 배짱이
		int dir = Integer.parseInt(st.nextToken());	// 방향
		int k = Integer.parseInt(st.nextToken());	// k번쨰
		int j = Integer.parseInt(st.nextToken());	// k + j
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=num; i++) {
			list.add(i);
		}
		
		int idx = 0;
		if(dir == 0) {	// 반시계방향
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(list.get(0));
			Collections.reverse(list);
			list.remove(list.size()-1);
			list.addAll(0, temp);
		}
		while(num > 1) {
			for(int i=0; i<k; i++) {
				++idx;
				if(idx == list.size()) idx = 0;
			}
			k+=j;
//			System.out.println(idx + " : " + list.get(idx));
			list.remove(idx);
			idx--;
			if(idx == list.size()) idx = 0;
			num--;
			
		}
		System.out.println(list.get(0));
	}
	
}
