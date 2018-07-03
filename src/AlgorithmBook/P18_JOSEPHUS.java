package AlgorithmBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P18_JOSEPHUS {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int num = Integer.parseInt(st.nextToken());
		int seq = Integer.parseInt(st.nextToken());
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=num; i++) {
			list.add(i);
		}
		
		int idx = 0;
		
		while(num > 2) {
			System.out.println(idx + " : " + list.get(idx));
			list.remove(idx);
			if(idx == list.size()) idx = 0;
			num--;
			
			
			for(int i=0; i<seq-1; i++) {
				++idx;
				if(idx == list.size()) idx = 0;
			}
			seq += 1;
		}
		
		System.out.println(list.get(0) + " " + list.get(1));
		
	}
}
