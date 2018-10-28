package eDailyCoding;

import java.util.HashMap;
import java.util.Scanner;

public class A005_ÁöÇý·Î¿î¼Ö·Î¸ó¿Õ {
	
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int woman = sc.nextInt();
        int point = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<point; i++) {
        	int wo = sc.nextInt();
        	int baby = sc.nextInt();
        	map.put(baby, wo);
        }
        int ans=0;
        for(int n : map.keySet()) {
        	ans++;
        }
        System.out.println(ans);
       
    }
    
}
