
public class casting {
	public static void main(String args[]) {
		 A a=new A();
		 a.draw();
		 
		 B b=new B();
		 b.draw();
		 
		 C c=new C();
		 c.draw();
		 c.set(); 
		 //CŬ������ CŬ�����Դϴ�. set �ż����Դϴ�. ���

//		 C cc = (C)new B();
//		 cc.draw();
//		 cc.set();

		 A ab=new C();
		 ab.draw();
//		 ab.set();
//		 // ab.set����
		 
		 // �ٿ�ĳ������ ��Ÿ�ӿ����� �߻���Ű����
		 // ��ĳ���� �� �ش� ��ü�� �ٿ�ĳ���� ��ų ��� ������.
		 C cc = (C)ab;
		 cc.draw();
		 cc.set();
	}
}

class A{

public void draw(){

 System.out.println(" A���Դϴ�");

}

}


class B extends A{

public void draw(){

System.out.println("BŬ�����Դϴ�.");

}

}



class C extends B{

 public void draw(){

System.out.println("CŬ�����Դϴ�");

}

 public void set(){

 System.out.println("set�ż����Դϴ�");

}
}

