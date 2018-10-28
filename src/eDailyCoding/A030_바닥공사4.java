package eDailyCoding;

import java.util.Scanner;

public class A030_¹Ù´Ú°ø»ç4 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n+1];
        
        dp[1] = 2;
        dp[2] = 7;
        for(int i=3; i<=n; i++) {
        	dp[i] = (2*dp[i-1] + 3*dp[i-2]+2)%796796;
        }
        System.out.println(dp[n]%796796);
    }
    
}