import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class A10546_배부른마라토너 {


	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0; i<n; i++) {
			String temp = br.readLine().toString();
			if(map.containsKey(temp)) {
				map.put(temp, map.get(temp)+1);				
			} else {
				map.put(temp, 1);
			}
			
		}
		
		for(int i=0; i<n-1; i++) {
			String temp = br.readLine().toString();
			map.put(temp, map.get(temp)-1);				
		}
		
		for(String key : map.keySet()) {
			if(map.get(key)==1) {
				System.out.println(key);
				return;
			}
		}
	}
	
}