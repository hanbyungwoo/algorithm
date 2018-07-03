
public class casting {
	public static void main(String args[]) {
		 A a=new A();
		 a.draw();
		 
		 B b=new B();
		 b.draw();
		 
		 C c=new C();
		 c.draw();
		 c.set(); 
		 //C클래스의 C클래스입니다. set 매서드입니다. 출력

//		 C cc = (C)new B();
//		 cc.draw();
//		 cc.set();

		 A ab=new C();
		 ab.draw();
//		 ab.set();
//		 // ab.set에러
		 
		 // 다운캐스팅은 런타임에러를 발생시키지만
		 // 업캐스팅 후 해당 객체를 다운캐스팅 시킬 경우 가능함.
		 C cc = (C)ab;
		 cc.draw();
		 cc.set();
	}
}

class A{

public void draw(){

 System.out.println(" A번입니다");

}

}


class B extends A{

public void draw(){

System.out.println("B클래스입니다.");

}

}



class C extends B{

 public void draw(){

System.out.println("C클래스입니다");

}

 public void set(){

 System.out.println("set매서드입니다");

}
}

