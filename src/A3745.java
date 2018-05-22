import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A3745 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// LIS
		
		String temp = "";
		while((temp = br.readLine()) != null) {
			temp = temp.trim();
			if(temp == "" || temp.length() == 0) {
				break;
			}
			StringTokenizer st = new StringTokenizer(temp);
			
			
			int N = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			st = new StringTokenizer(br.readLine().trim());
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				
			}
			
			for(int num : arr) {
				if(list.size() == 0 || num > list.get(list.size()-1)) {
					list.add(num);
				} else {
					int i=0;
					int j = list.size() - 1;
					
					while( i < j ) {
						int mid = (i+j) / 2;
						if(list.get(mid) < num) {
							i = mid+1;
						} else {
							j = mid;
						}
					}
					list.set(j, num);
				}
			}
			
			
			System.out.println(list.size());
		}		
		br.close();
	}
}