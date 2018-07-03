package woowahan;

import java.util.Scanner;

public class P2_3 {
	public static void main(String[] args) {
		try(Scanner s = new Scanner(System.in)) {
			// A
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();
			// B
			int x3 = s.nextInt();
			int y3 = s.nextInt();
			int x4 = s.nextInt();
			int y4 = s.nextInt();
			// C
			int x5 = s.nextInt();
			int y5 = s.nextInt();
			int x6 = s.nextInt();
			int y6 = s.nextInt();
			
			Square A = new Square(x1, y1, x2, y2);
			Square B = new Square(x3, y3, x4, y4);
			Square C = new Square(x5, y5, x6, y6);
			
			int AB = value(area(A, B));
			int AC = value(area(A, C));
			int BC = area3(A, B, C);
//			System.out.println(AB);
//			System.out.println(AC);
//			System.out.println(BC);
			int aArea = value(A);
			System.out.println(aArea - AB - AC + BC);
			
		}
  }
	public static int value(Square x) {
		if(x == null) return 0;
		else return (x.x2-x.x1) * (x.y2-x.y1);
	}
	
	public static int area3(Square x, Square y, Square z) {
		Square temp = area(y, z);
		if(temp != null) {
			Square ans = area(x, temp);
			return value(ans);
		} else {
			return 0;
		}
	}
	
	public static Square area(Square x, Square y) {
		Square newThing;
		
		Square left;
		Square right;
		
		int l, r, u, d;
		
		int disX=0;
		int disY=0;

		if(x.x2 > y.x2) {
			left = y;
			right = x;
		} else {
			left = x;
			right = y;
		}
		
		if(left.x2 >= right.x1) {
			// Æ÷ÇÔµÊ.
			disX = left.x2 - right.x1;
			r = left.x2;
			l = right.x1;
			if(left.x1 >= right.x1) {
				disX = left.x2-left.x1;
				r = left.x2;
				l = left.x1;
			}
		} else {
			// Æ÷ÇÔ¾ÈµÊ.
			return null;
		}
		
		Square up;
		Square down;
		if(x.y2 > y.y2) {
			up = x;
			down = y;
		} else {
			up = y;
			down = x;
		}
		
		if(down.y2 >= up.y1) {
			disY = down.y2 - up.y1;
			u = down.y2;
			d = up.y1;
			if(down.y1 >= up.y1) {
				disY = down.y2-down.y1;
				u = down.y2;
				d = down.y1;
			}
		} else {
			return null;
		}
		
		newThing = new Square(right.x1, up.y1, left.x2, down.y2);
		newThing = new Square(l, d, r, u);
		return newThing;
//		return disX*disY;
	}
	
}

class Square {
	int x1;
	int y1;
	int x2;
	int y2;
	
	public Square(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
}

