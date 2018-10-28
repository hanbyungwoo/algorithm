package eDailyCoding;

import java.util.Scanner;

import Kakao.P2018.Node;

public class A027_1등급사과 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        
    }
    
    static class apple {
    	int sweet;
    	int num;
    	int high;
    	apple left, right;
    	public apple(int sweet, int num) {
    		this.sweet = sweet;
    		this.num = num;
    	}
    }
    
    static class Tree {
    	apple root;
    	public void add(int x, int y, int val) {
    		if(root == null) {
    			root = new apple(x, y, val);
    		} else {
    			// 왼쪽으로 내려가야함.
    			apple temp = root;
    			while(true) {
    				if(temp.x > x) {
    					if(temp.left != null) {
    						temp = temp.left;
    					} else {
    						temp.left = new apple(x, y, val);
    						break;
    					}
    				} else {
    					// 오른쪽으로 내려가야함.
    					if(temp.right != null) {
    						temp = temp.right;
    					} else {
    						temp.right = new apple(x, y, val);
    						break;
    					}
    				}
    			}
    		}
    		
    	}
    }
    
}