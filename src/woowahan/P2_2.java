package woowahan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2_2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		// x좌표 작은 값부터 나옴.
		ArrayList<Pair> list = new ArrayList<Pair>();
		ArrayList<Pair> answer = new ArrayList<Pair>();
		
		int minX=Integer.MAX_VALUE;
		int maxX=Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new Pair(x, true, y, true));
			if(minX > x) {
				minX = x;
			}
			if(maxX < y) {
				maxX = y;
			}
		}
		
		answer.add(new Pair(Integer.MIN_VALUE, false, minX, false));
		answer.add(new Pair(maxX, false, Integer.MAX_VALUE, false));
		
		// 소수점으로 중간 값 비교
		int dp[] = new int[maxX+1];
		// 좌표 값으로 비교
		int dp2[] = new int[maxX+1];

		for(int i=minX; i<maxX; i++) {
			for(int j=0; j<list.size(); j++) {
				Pair temp = list.get(j);
				double scope = i+0.5;
				if(temp.x < scope && scope < temp.y) {
					dp[i]++;
				}
			}
		}
		////////////////////////////////
		for(int i=0; i<list.size(); i++) {
			for(int j=list.get(i).x; j<=list.get(i).y; j++) {
				dp2[j]++;
			}
		}
				
		for(int i=minX; i<maxX; i++) {
			if(dp[i]%2 == 0) {
				boolean left, right;
				if(dp[i] == 0) {
					left = false;
					right = false;
				} else {
					left = true;
					right = true;
				}
				int cnt=i;
				for(int j=i+1; j<=maxX; j++) {
					if(dp[j]%2!=0) {
						if(dp[j-1] == 0) {
							right = false;
						} else {
							right = true;
						}
						cnt++;
						break;
					} else {
						cnt++;
					}
				}
				
				answer.add(new Pair(i,left,cnt,right));
			}
			if(dp2[i]%2==0) {
			}
		}
		Collections.sort(answer);
		
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i).toString());
		}
	}
	
}

class Pair implements Comparable<Pair> {
	int x;
	boolean isX;
	int y;
	boolean isY;
	
	public Pair(int x, boolean isX, int y, boolean isY) {
		this.x = x;
		this.isX = isX;
		this.y = y;
		this.isY = isY;
	}
	@Override
	public String toString() {
		char l;
		char r;
		if(this.isX) {
			l = '[';
		} else {
			l = '(';
		}
		if(this.isY) {
			r = ']';
		} else {
			r = ')';
		}
		if(this.x == Integer.MIN_VALUE) {
			return String.format("%c-, %d%c", l, this.y, r);
		} else if(this.y == Integer.MAX_VALUE) {
			return String.format("%c%d, +%c", l, this.x, r);
		} else {
			return String.format("%c%d, %d%c", l, this.x, this.y, r);
		}
		
	}
	
	@Override
	public int compareTo(Pair o) {
		if(o.x > x) {
			return -1;
		} else {
			return 1;
		}
		
	}
	
}