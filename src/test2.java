import java.io.IOException;

public class test2 {
	public static void main(String[] args) throws IOException {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int num = Integer.parseInt(st.nextToken());
//		boolean val[] = new boolean[num+1];
//		
//		for(int i=1; i<=num; i++) {
//			if(num%i == 0) {
//				System.out.print(i+ " ");
//			}
//		}
//		for(int i=2; i<=num; i++) {
//			for(int j=i*i; j<=num; j=j+i) {
//				if(val[j] == false) {
//					val[j] = true;
//				}
//			}
//		}
//		for(int i=1; i<=num; i++) {
//			if(val[i]==false)
//				System.out.print(i+ " ");
//		}
		
		
		
		// 상속 테스트
//		test22 ttt = new test4();
//		ttt.print();
		abc a = new abc(1, null);
		a = new abc(2, a);
		a = new abc(3, a);
		a = new abc(4, a);
		a = new abc(5, a);
		a.printAll(a);
		
		abc b = a.reverse(a);
		b.printAll(b);
	}

}

class abc {
	int value;
	abc next;
	public abc(int value, abc next) {
		this.value = value;
		this.next = next;
	}
	
	public void printAll(abc a) {
		for(int i=0; i<5; i++) {
			System.out.print(a.value+ " ");
			a = a.next;
		}
		System.out.println();
	}
	
	public abc reverse(abc a) {
		if(a.next == null) {
			return a;
		} else {
			abc rev = reverse(a.next);
			
			while(rev.next != null) rev = rev.next;
			a.next = null;
			rev.next = a;
			
//			rev = a.next;
//			rev.next = a;
//			rev = rev.next;
//			a.next = null;
//			rev.next = a;
			return rev;
		}
	}
	
}

interface test22 {
	public void print();
}

class test3 implements test22 {
	@Override
	public void print() {
		System.out.println("test3");
	}
}

class test4 implements test22 {
	@Override
	public void print() {
		System.out.println("test4");
	}
}