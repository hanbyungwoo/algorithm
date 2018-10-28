package eDailyCoding;

import java.util.Scanner;

public class A006_Å×µÎ¸® {
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int num = 1;
        int ans = 0;
        for(int i=1; i<=n; i++) {
        	
        	for(int j=1; j<=n; j++) {
        		if(i>1 && i<n) {
        			if(j==1) {
        				ans += num + num + n - 1;
        				num = num + n;
        				break;
        			}
        		} else {
        			ans += num;
        		}
        		num++;
        	}
        	
        }
        System.out.println(ans);
       
    }
    
}
