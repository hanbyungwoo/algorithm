package eDailyCoding;

import java.util.Scanner;

public class A004_외줄타기 {
	
    public static void main(String args[]) {
    	int inf = 1000000000;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                a[i][j] = inf;
            }
        }
        int m = sc.nextInt();
        for (int i=0; i<m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            if (a[y][x] > z) {
            	a[x][y] = z;
                a[y][x] = z;
            }
        }
        
        int sum=0;
        for(int i=2; i<=n; i++) {
        	int min = inf;
        	for(int j=1; j<=n; j++) {
        		if(a[i][j]!=inf) {
        			min = Math.min(min, a[i][j]);
        		}
        	}
        	sum += min;
        }
        System.out.println(sum);
        
        
       
    }
    
}
