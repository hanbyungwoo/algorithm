import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A10971 {
	static ArrayList<Integer> list;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		list = new ArrayList<Integer>();
		
		int [][] map = new int[num][num];
		
		for(int i=0; i<num; i++) {
			list.add(i);
		}
		
		
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<num; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		int min=9999999;
		do {
			int cost=0;
			if(list.get(0) > 0) {
				break;
			}
			// 간다
			boolean check = true;
			for(int i=1; i<num; i++) {
				if(map[list.get(i-1)][list.get(i)] == 0) {
					check = false;
					break;
				} else {
					cost += map[list.get(i-1)][list.get(i)];
				}
			}
			// 온다
			if(check && map[list.get(list.size()-1)][list.get(0)] != 0) {
				cost += map[list.get(list.size()-1)][list.get(0)];
				if(min > cost) {
					min = cost;
				}
			}
			
			
		} while(nextPerm());
		
		System.out.println(min);
	
	}
	
	static boolean nextPerm() {
		int temp = list.size() - 1;
		while(temp>0 && list.get(temp-1) >= list.get(temp)) temp--;
		if(temp<=0) return false;
		int temp2 = list.size()-1;
		while(list.get(temp2) <= list.get(temp-1)) temp2--;
		swap(temp2, temp-1);
		temp2 = list.size() - 1;
		while(temp < temp2) {
			swap(temp, temp2);
			temp++;
			temp2--;
		}
		return true;
	}

	static void swap(int a, int b) {
		int temp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, temp);
	}
}
