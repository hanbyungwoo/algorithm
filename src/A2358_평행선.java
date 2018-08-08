import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A2358_∆Ú«‡º± {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int num = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> xMap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> yMap = new HashMap<Integer, Integer>();
		
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(xMap.containsKey(x)) {
				int temp = xMap.get(x);
				xMap.put(x, temp+1);
			} else {
				xMap.put(x, 1);
			}
			
			if(yMap.containsKey(y)) {
				int temp = yMap.get(y);
				yMap.put(y, temp+1);
			} else {
				yMap.put(y, 1);
			}
			
		}
		
		int cnt = 0;
		
		for(int x : xMap.keySet()) {
			if(xMap.get(x) >= 2) {
				cnt++;
			}
		}
		for(int y : yMap.keySet()) {
			if(yMap.get(y) >= 2) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
