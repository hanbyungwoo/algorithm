package Line.P2018_first;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// �Է� ����
//7123 4653 10
//9288 6714 9S7RZV 30
//2619 1434 HMH2YX 39
//2588 3374 YWV0JQ 4
//6248 8626 CACAQS 27
//5099 1192 4GWQWW 19
//6508 4507 Y51234 12
//3161 2805 IQPY9F 36
//47 8930 YNYNYN 44
//751 2483 40438T 29
//3226 4983 LSPFAB 45

public class L2 {

	static int x;
	static int y;
    public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// �������⵵ O(n)
		// �ð����⵵ O(n*n)
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int storeCnt = Integer.parseInt(st.nextToken());
        
        ArrayList<Store> list = new ArrayList<Store>();
        for(int i=0; i<storeCnt; i++) {
        	// ���� �Է� �ޱ�
        	st = new StringTokenizer(br.readLine(), " ");
        	int dx = Integer.parseInt(st.nextToken());
        	int dy = Integer.parseInt(st.nextToken());
        	String str = st.nextToken().toString();
        	int couponCnt = Integer.parseInt(st.nextToken());
        	int dis = distance(x, y, dx, dy);
        	
        	list.add(new Store(dx, dy, dis, couponCnt, str));
//	        	System.out.println(list.get(i));
        }
        
        
        for(int i=0; i<list.size(); ) {
        	Store temp = list.get(i);
        	int min=-1;
        	for(int j=i+1; j<list.size(); j++) {
        		if(temp.compareTo(list.get(j)) <= 0) {	// j���� �� �۳�.
        			min = j;
        			temp = list.get(j);
        		}
        		
        	}
        	if(min == -1) {
        		list.remove(i);
        	} else {
        		list.remove(min);
        	}
        	System.out.println(temp.toString());
        }
        
        
        
        
    }
    public static int distance(int x, int y, int dx, int dy) {
    	long dis = (long)(Math.pow(dx-x, 2) + Math.pow(dy-y, 2));
    	dis = (int)Math.sqrt(dis);
    	
    	return (int) ((int)dis-dis%100);
    }
    
}
class Store implements Comparable<Store>{
	int dx;
	int dy;
	int dis;
	int coupon;
	String name;
	public Store(int dx, int dy, int dis, int coupon, String name) {
		this.dx = dx;
		this.dy = dy;
		this.dis = dis;
		this.coupon = coupon;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return String.format("%d %d %s %d", this.dx, this.dy, this.name, this.coupon);
	}
	
	
	@Override
	public int compareTo(Store o) {
		// ���� �̸� ��
		String value = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		// �Ÿ� ��
		if(this.dis > o.dis) {
			return -1;
		}
		if(this.dis < o.dis) {
			return 1;
		}
		
		
		// ������ �̸��� ���� ���� ���
		if(this.coupon < o.coupon) {	// �ڰ�ũ�� -1
			return -1;
		} 
		if(this.coupon > o.coupon) {
			return 1;
		}
		
		for(int i=0; i<name.length(); i++) {
			// ���� ���� ������
			if(value.indexOf(this.name.charAt(i)) > value.indexOf(o.name.charAt(i))) {	// �ڰ�
				return -1;
			}
			if(value.indexOf(this.name.charAt(i)) < value.indexOf(o.name.charAt(i))) {
				return 1;
			} 
		}
		
		
		// ��� ����
		return 0;
	}
}