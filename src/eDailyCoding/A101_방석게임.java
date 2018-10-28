package eDailyCoding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A101_방석게임 {
	static int n, m;
	static char map[][];
	static int ans;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        Queue<student> q = new LinkedList<student>();
        for(int i=0; i<n; i++) {
        	map[i] = sc.next().toCharArray();
        	for(int j=0; j<m; j++) {
        		if(map[i][j] == 'C') {
        			q.add(new student(i, j));
        		}
        	}
        }
        ans = 0;
        while(!q.isEmpty()) {
        	int x = q.peek().x;
        	int y = q.peek().y;
        	bfs(x, y);
        	q.poll();
        }
        
        System.out.println(ans);
        
    }
    
    public static void bfs(int x, int y) {
    	Queue<student> temp = new LinkedList<student>();
    	boolean visited[][] = new boolean[n][m];
    	temp.add(new student(x, y));
    	
    	while(!temp.isEmpty()) {
    		int size = temp.size();
    		ans++;
    		for(int i=0; i<size; i++) {
    			student info = temp.poll();
    			visited[info.x][info.y] = true;
    			for(int j=0; j<4; j++) {
    				int nx = info.x + dx[j];
    				int ny = info.y + dy[j];
    				if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
    					if(!visited[nx][ny] && map[nx][ny] != 'X') {
	    					if(map[nx][ny] == 'P') {
	    						return;
	    					}
	    					temp.add(new student(nx, ny));
    					}
    				}
    			}
    		}
    	}
    }
    
    static class student {
    	int x, y;
    	public student(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
    
}
