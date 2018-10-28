package eDailyCoding;

import java.util.Collections;
import java.util.Scanner;

public class A050_업무스케쥴 {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int day[] = new int[n+1];
        int cost[] = new int[n+1];
        int dp[] = new int[n+1];
        for(int i=1; i<=n; i++) {
        	day[i] = sc.nextInt();
        	cost[i] = sc.nextInt();
        	dp[i] = cost[i];
        }
        for(int i=2; i<=n; i++) {
        	for(int j=1; j<i; j++) {
        		if(i-j >= day[j]) {
        			dp[i] = Math.max(cost[i]+dp[j],  dp[i]);
        		}
        	}
        }
        

		int max = 0;
		for(int i=1; i<=n; i++) {
			if(i+day[i] <= n+1) {
				max = max < dp[i] ? dp[i] : max;
			}
		}
		
		
        
        System.out.println(max);
    }
	
}