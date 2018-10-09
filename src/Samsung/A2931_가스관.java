package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//http://montonblog.tistory.com/46
public class A2931_가스관 {
	static int r, c, bit;
	static char map[][];
	static boolean isVisit[][];
	static int dx[] = {-1,0,1,0};	// 상 우 하 좌
	static int dy[] = {0,1,0,-1};
	public static void main(String args[]) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r+1][c+1];
		isVisit = new boolean[r+1][c+1];
		for(int i=1; i<=r; i++) {
			map[i] = (" "+br.readLine().toString()).toCharArray();
		}
		for(int i=1; i<=r; i++) {
			for(int j=1; j<=c; j++) {
				if(map[i][j] != '.' && !isVisit[i][j]) dfs(i, j, 5);
			}
		}
		
		int flag = 0;
		for(int i=1; i<=r; i++) {
			for(int j=1; j<=c; j++) {
				if(map[i][j] =='.' && isVisit[i][j]) {
					System.out.print(i + " " + j + " ");
					flag = 1;
					break;
				}
			}
			if(flag>0) break;
		}
		// 비트 1 2 4 8 (상 우 하 좌)
		if(bit==5) System.out.println("|");
		if(bit==10) System.out.println("-");
		if(bit==15) System.out.println("+");
		if(bit==9) System.out.println("1");
		if(bit==12) System.out.println("2");
		if(bit==6) System.out.println("3");
		if(bit==3) System.out.println("4");
	}
	
	public static void dfs(int x, int y, int n) {
		if(x<=0 || x>r || y<=0 || y>c || map[x][y]=='M' || map[x][y]=='Z') return;
		if(isVisit[x][y]&&map[x][y]!='.') return;
		
		if(n!=5 && map[x][y]=='.') bit |= (1<<n);
		
		isVisit[x][y] = true;
		if(map[x][y]=='.') return;
		
		for(int i=0; i<4; i++) {
			if(checkDir(x, y, i)) {
				dfs(x+dx[i], y+dy[i], i);
			}
		}
	}
	
	public static boolean checkDir(int x, int y, int n) {
		// 0 상 
		// 1 우
		// 2 하
		// 3 좌
		if(map[x][y] == '|') if(n==0 || n==2) return true;
		if(map[x][y] == '-') if(n==1 || n==3) return true;
		if(map[x][y] == '+') return true;
		if(map[x][y] == '1') if(n==1 || n==2) return true;
		if(map[x][y] == '2') if(n==0 || n==1) return true;
		if(map[x][y] == '3') if(n==0 || n==3) return true;
		if(map[x][y] == '4') if(n==2 || n==3) return true;
		return false;
		
	}
}