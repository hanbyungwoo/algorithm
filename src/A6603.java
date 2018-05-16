import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;


// back tracking 문제로 풀 수 있음.
// http://mygumi.tistory.com/191
public class A6603 {
	static ArrayList<Integer> list;
	static StringBuilder sb;
	static int k, cnt;
	static int arr[];
	public static void main(String args[]) throws IOException {
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		while((k=sc.nextInt()) != 0) {
			arr = new int[50];
			
			for(int i=0; i<k; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=0; i<k; i++) {
				cnt = 1;
				dfs(i, arr[i] + " ");
			}
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		while(true) {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			
//			int num = Integer.parseInt(st.nextToken());
//			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//			ArrayList<Integer> value = new ArrayList<Integer>();
//			if(num ==0) {
//				break;
//			}
//			for(int i=0; i<num; i++) {
//				value.add(Integer.parseInt(st.nextToken()));
//			}
//			list = new ArrayList<Integer>();
//			
//			
//			for(int i=0; i<6; i++) {
//				list.add(1);
//			}
//			for(int i=0; i<num-6; i++) {
//				list.add(2);
//			}
//			
//			do {
//				ArrayList<Integer> temp = new ArrayList<Integer>();
//				for(int i=0; i<num; i++) {
//					if(list.get(i) == 1) {
//						temp.add(value.get(i));
//					}
//				}
//				result.add(temp);
//			} while(nextPerm());
//			
//			for(int i=0; i<result.size(); i++) {
//				for(int j=0; j<result.get(i).size(); j++) {
//					System.out.print(result.get(i).get(j)+ " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
	}
	public static void dfs(int v, String str) {
		if(cnt == 6) {
			sb.append(str + "\n");
		} else {
			for(int i=v+1; i<k; i++) {
				cnt++;
				dfs(i, str + arr[i] + " ");
				cnt--;				
			}
		}
		
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
