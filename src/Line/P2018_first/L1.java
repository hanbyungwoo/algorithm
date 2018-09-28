package Line.P2018_first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 입력예제
// 2
// AAAAAADDC
// AAASSSSSWWWWAAAAWWW
public class L1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		while(t-- > 0 ) {
			String str = br.readLine().toString();
			StringBuilder sb = new StringBuilder();
			
			char pre = str.charAt(0);
			int cnt = 0;
			// 시간복잡도 O(n) 공간복잡도 O
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) == pre) {
					cnt++;
				} else {
					sb.append(cnt);
					sb.append(pre);
					pre = str.charAt(i);
					cnt = 1;
				}
			}
			sb.append(cnt);
			sb.append(pre);
			System.out.println(sb.toString());
		}
		
	}
	
	
	
	
	
//	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//        
//        int t = Integer.parseInt(st.nextToken());
//        
//        while(t-- > 0) {
//        	char temp[] = br.readLine().toCharArray();
//        	// 시간복잡도 O(n^2)
//        	// 공간복잡도 O(n)
//        	for(int i=0; i<temp.length; i++) {
//        		int cnt=1;
//        		for(int j=i+1; j<=temp.length; j++) {
//        			if(j != temp.length && temp[i]==temp[j]) {
//        				cnt++;
//        			} else {
//        				
//        				System.out.print(cnt+""+temp[i]);
//        				i=j-1;
//        				break;
//        			}
//        		}
//        	}
//        	System.out.println();
//        }
//    }
}
