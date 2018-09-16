package Kakao.P2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class P1_5_길찾기게임 {
	public static void main(String args[]) {
		solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
	}
	
	public static int[][] solution(int[][] nodeinfo) {
        int answer[][];
        
        int size = nodeinfo.length;
        int nodeinfoSeq[][] = new int[size][3];
        for(int i=0; i<size; i++) {
        	nodeinfoSeq[i][0] = nodeinfo[i][0];
        	nodeinfoSeq[i][1] = nodeinfo[i][1];
        	nodeinfoSeq[i][2] = i+1;
        }
        sortArray(nodeinfoSeq);
        
        Tree t = new Tree();
		for(int i=0; i<size; i++) {
			t.add(nodeinfoSeq[i][0], nodeinfoSeq[i][1], nodeinfoSeq[i][2]);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		t.preorder(t.root, list);
		answer = new int[2][list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[0][i] = list.get(i);
		}
		System.out.println();
		list = new ArrayList<Integer>();
		t.postorder(t.root, list);
		for(int i=0; i<list.size(); i++) {
			answer[1][i] = list.get(i);
		}
		
        return answer;
    }
	
	public static void sortArray(int[][] data) { 
		Arrays.sort(data, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				if( ((Comparable<Integer>)arr1[1]).compareTo(arr2[1]) < 0 )
					return 1;
				else if( ((Comparable<Integer>)arr1[1]).compareTo(arr2[1]) > 0 )
					return -1;
				else 
					return 0;
			}
		});
	}
	
	
}

class Node {
	int x, y;
	int val;
	Node left, right;
	public Node(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
}

class Tree {
	Node root;
	public void add(int x, int y, int val) {
		if(root == null) {
			root = new Node(x, y, val);
		} else {
			// 왼쪽으로 내려가야함.
			Node temp = root;
			while(true) {
				if(temp.x > x) {
					if(temp.left != null) {
						temp = temp.left;
					} else {
						temp.left = new Node(x, y, val);
						break;
					}
				} else {
					// 오른쪽으로 내려가야함.
					if(temp.right != null) {
						temp = temp.right;
					} else {
						temp.right = new Node(x, y, val);
						break;
					}
				}
			}
		}
		
	}
	
	public void preorder(Node root, ArrayList<Integer> list) {
		list.add(root.val);
		System.out.print(root.val);
		if(root.left!=null) preorder(root.left, list);
		if(root.right!=null) preorder(root.right, list);
	}
	
	public void postorder(Node root, ArrayList<Integer> list) {
		if(root.left!=null) postorder(root.left, list);
		if(root.right!=null) postorder(root.right, list);
		list.add(root.val);
		System.out.print(root.val);
	}
}