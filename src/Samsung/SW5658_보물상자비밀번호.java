package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SW5658_보물상자비밀번호 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ca=1;
		
//		System.out.println(Integer.parseInt(ab, 16));
//		Integer.toHexString('a');
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			HashSet<Integer> set = new HashSet<Integer>();
			
			ArrayList<Character> list = new ArrayList<Character>();
			String str = br.readLine().toString();
			for(int i=0; i<str.length(); i++) {
				list.add(str.charAt(i));
			}
			
			int div = n/4;
			StringBuilder sb = new StringBuilder();
			
			while(true) {
				int cnt = 0;
				for(int i=0; i<list.size(); i=i+div) {
					sb = new StringBuilder();
					for(int j=i; j<i+div; j++) {
						sb.append(list.get(j));
//						System.out.print(list.get(j));
						
					}
					int x = Integer.parseInt(sb.toString(), 16);
					if(set.contains(x)) {
						cnt++;
					} else {
						set.add(x);	
					}
					
//					System.out.println();
				}
				if(cnt == 4) {
					break;
				} else {
					char temp = list.remove(0);
					list.add(temp);
				}
			}
			
			list.clear();
			list = new ArrayList(set);
			Collections.sort(list);
			Collections.reverse(list);
			
			System.out.println("#"+(ca++)+" "+list.get(k-1));
		}
		
	}
	
}