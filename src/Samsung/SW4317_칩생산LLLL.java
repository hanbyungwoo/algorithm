package Samsung;

import java.util.Scanner;
// 시간초과...
public class SW4317_칩생산LLLL {
	static int h, w, max;
	static int map[][];
	static boolean visited[][];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
//		int t = Integer.parseInt(st.nextToken());
		int t = sc.nextInt();
		while(t-- > 0) {
//			st = new StringTokenizer(br.readLine(), " ");
//			h = Integer.parseInt(st.nextToken());
//			w = Integer.parseInt(st.nextToken());
			h = sc.nextInt();
			w = sc.nextInt();
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
//				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<w; j++) {
//					map[i][j] = Integer.parseInt(st.nextToken());
					map[i][j] = sc.nextInt();
				}
			}
			
			max = 0;
			
			for(int i=0; i<h*w; i++) {
				int x = i/w;
				int y = i%w;
				if(x >= 0 && x+1 < h && y >= 0 && y+1 < w) {
					if(map[x][y]==0 && map[x+1][y+1]==0 && 
							map[x+1][y]==0 && map[x][y+1]==0) {
						if(!visited[x][y]&&!visited[x+1][y]&&!visited[x][y+1]&&!visited[x+1][y+1]) {
							visited[x][y] = visited[x+1][y] = visited[x][y+1] = visited[x+1][y+1] = true;
							dfs(i);
							visited[x][y] = visited[x+1][y] = visited[x][y+1] = visited[x+1][y+1] = false;
						}
						 
								
					}
				}
			}
			
			System.out.println("#"+ca+" "+max);
			
			ca++;
		}
	}
	
	public static void dfs(int index) {
		if(index == h*w) {
			int ans=0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(visited[i][j]) {
						ans++;
					}
				}
			}
			max = Math.max(max, ans/4);
			return;
		}
		for(int i=index+1; i<h*w; i++) {
			int x = i/w;
			int y = i%w;
			if(x >= 0 && x+1 < h && y >= 0 && y+1 < w) {
				if(map[x][y]==0 && map[x+1][y+1]==0 && 
						map[x+1][y]==0 && map[x][y+1]==0) {
					if(!visited[x][y]&&!visited[x+1][y]&&!visited[x][y+1]&&!visited[x+1][y+1]) {
						visited[x][y] = visited[x+1][y] = visited[x][y+1] = visited[x+1][y+1] = true;
						i++;
						dfs(i);
						i--;
						visited[x][y] = visited[x+1][y] = visited[x][y+1] = visited[x+1][y+1] = false;
					}
					 
							
				}
			}
			if(i==h*w-1) {
				dfs(i+1);
			}
		}
	}
	
	
	
}






