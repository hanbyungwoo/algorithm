package Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 입력 예제
//6
//1 3
//3 4
//6 5
//11 15
//12 17
//12 15

// 아웃풋
//3
public class L3 {
	static boolean check[];
	static ArrayList<ArrayList<Integer>> list;
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 공간복잡도 O(n)
		// 시간복잡도 O(n*n)
		
		int n = Integer.parseInt(st.nextToken());
		check = new boolean[100001];
		list = new ArrayList<>();
		for(int i=0; i<100001; i++) {
			list.add(new ArrayList<>());
		}
		
		ArrayList<Integer> number = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			list.get(one).add(two);
			list.get(two).add(one);
			if(!number.contains(one)) {
				number.add(one);
			}
			if(!number.contains(two)) {
				number.add(two);
			}
		}
		
		Collections.sort(number);
		int cnt=0;
		for(int i : number) {
			if(check[i]==false) {
				dfs(i);
				cnt++;
			}
			
		}
		
		System.out.println(cnt++);
	}
    
    public static void dfs(int x) {
    	check[x] = true;
    	for(int y : list.get(x)) {
    		if(check[y]==false) {
    			dfs(y);
    		}
    	}
    }
}