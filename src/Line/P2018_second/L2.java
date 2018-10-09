package Line.P2018_second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int map[][];
		char map2[][];
		boolean isVisit[][][];
		
		int n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		map2 = new char[n][n];
		isVisit = new boolean[n][n][4];	// 각각의 방향정보...
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				char temp[] = st.nextToken().toCharArray();
				map[i][j] = temp[1]-'0';
				map2[i][j] = temp[0];
			}
		}
		// 들어오는 방향정보
		int dir = 2;
		int x = 0, y = 0;
		int next_dir=0;
		while(true) {
			
			
			switch(map2[x][y]) {
			case 'F' : next_dir = dir; break;
			case 'R' : next_dir = (dir+1)%4; break;
			case 'B' : next_dir = (dir+2)%4; break;
			case 'L' : next_dir = (dir+3)%4; break;
			default : break;
			}
			if(isVisit[x][y][dir] == false) {
				isVisit[x][y][dir] = true;
				if(next_dir == 0) {
					x -= map[x][y];
				}
				else if(next_dir == 2) {
					
					x += map[x][y];
					
				} else if(next_dir ==3) {
					y -= map[x][y];
				} else {
					y += map[x][y];
					
				}
				dir = next_dir;
			} else {
				break;
			}
			
		}
		System.out.println(y + " " + x);
		
	}	
}
