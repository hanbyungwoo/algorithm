package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW5644_¹«¼±ÃæÀü {
	static int n;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int m = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			
			int user[][] = new int[2][m+1];
			
			user[0][0] = 0;
			user[1][0] = 0;
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=1; j<=m; j++) {
					user[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int map[][] = new int[10][10];
			ap aplist[] = new ap[a];
			for(int i=0; i<a; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				aplist[i] = new ap(y-1, x-1, c, p);
			}
			int dx[] = {0,0,1,0,-1};	// ÀÌµ¿x, »ó, ¿ì, ÇÏ, ÁÂ
			int dy[] = {0,-1,0,1,0};
			
			// »ö»ó Ä¥ÇÏ±â~
			for(int i=0; i<a; i++) {
				Queue<xy> q = new LinkedList<>();
				boolean visited[][] = new boolean[10][10];
				q.add(new xy(aplist[i].x, aplist[i].y));
				int n=0;
				visited[aplist[i].x][aplist[i].y] = true;
				map[aplist[i].x][aplist[i].y] += (1<<i);
				while(n<aplist[i].c) {
					int size = q.size();
					for(int z=0; z<size; z++) {
						int x = q.peek().x;
						int y = q.peek().y;
						q.poll();
						for(int j=1; j<5; j++) {
							int nx = x+dx[j];
							int ny = y+dy[j];
							if(nx >= 0 && ny >= 0 && nx < 10 && ny < 10) {
								if(!visited[nx][ny]) {
									visited[nx][ny] = true;
									map[nx][ny] += (1<<i);
									q.add(new xy(nx, ny));
								}
							}
						}
					}
					n++;
				}
			}
			// ÃÖ´ë°ª ±¸ÇÏ±â~
			int user_max[]={0,0,0};
			int user1xy[] = {0,0};
			int user2xy[] = {9,9};
			for(int i=0; i<=m; i++) {
				// user1 ÁÂÇ¥
				user1xy[0] += dx[user[0][i]];
				user1xy[1] += dy[user[0][i]];
				// user2 ÁÂÇ¥
				user2xy[0] += dx[user[1][i]];
				user2xy[1] += dy[user[1][i]];
				
				// °ãÄ§
				if((map[user1xy[1]][user1xy[0]] & map[user2xy[1]][user2xy[0]]) > 0) {
					ArrayList<Integer> userlist1 = new ArrayList<Integer>();
					ArrayList<Integer> userlist2 = new ArrayList<Integer>();
					for (int j = 0; j < a; j++) {
						if (((1 << j) & map[user1xy[1]][user1xy[0]]) > 0) {
							userlist1.add(aplist[j].p);
						}
						if (((1 << j) & map[user2xy[1]][user2xy[0]]) > 0) {
							userlist2.add(aplist[j].p);
						}
					}
					Collections.sort(userlist1);
					Collections.sort(userlist2);
					int tempMax = 0;
					for (int j = 0; j < userlist1.size(); j++) {
						for (int k = 0; k < userlist2.size(); k++) {
							if (userlist1.get(j).equals(userlist2.get(k))) {
								tempMax = Math.max(tempMax, userlist1.get(j));
							} else {
								tempMax = Math.max(tempMax, userlist1.get(j) + userlist2.get(k));
							}
						}
					}
					user_max[2] += tempMax;
				} else {
					// ¾È°ãÄ§!!
					int num[] = { map[user1xy[1]][user1xy[0]], map[user2xy[1]][user2xy[0]] };
					
					for (int k = 0; k < 2; k++) {
						int bigNum=0;
						for (int j = a-1; j >= 0; j--) {
							if (((1 << j) & num[k]) > 0) {
								bigNum = Math.max(bigNum, aplist[j].p);
							}
						}
						user_max[k] += bigNum;
					}
					
				}
			}
			
			System.out.println("#"+ca+" "+(user_max[0]+user_max[1]+user_max[2]));
//			System.out.println("#"+ca+" "+(user_max[0]+user_max[1]));
			ca++;
		}
	}
}
class xy {
	int x, y;
	public xy(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class ap {
	int x;
	int y;
	int c;
	int p;
	public ap(int x, int y, int c, int p) {
		this.x = x;
		this.y = y;
		this.c = c;
		this.p = p;
	}
}