package prob.syntax;

public class syntax_static {
	// [static 변수]
	// 메모리에 고정적으로 할당되어, 프로그램이 종료될 때 해제되는 변수
	private static int sA = 10;
	private int A = 20;
	
	// [static 메소드]
	// static 메소드는 객체의 생성없이 호출이 가능하며, 객체에서는 호출이 불가능하다.
	public static void sSum(int B) {
		System.out.println("sA + B = " + (sA + B) );
	}
	
	public static void sPrint() {
		// A는 객체가 생성된 후 메모리에 할당되는데, 
		// sPrint()는 static 메소드로 객체 생성없이 접근하는 메소드이므로
		// 할당되지 않은 변수 A에 접근할 수 없으므로 
		// static 메소드에서 static 변수가 아닌 변수를 참조할 수 없다.
		//	 System.out.println(A);		// 불가능한 호출
		System.out.println(sA);			// static 변수로 이미 메모리에 할당되어 있어서 호출 가능
	}
	
	public void Sum(int B) {
		System.out.println("A + B = " + (A + B));
	}
	
	public void Print() {
		System.out.println(A);
	}
	
	public static void main(String[] args) {
		// static 변수, 일반 변수 비교
		int sA = syntax_static.sA;				// 객체 생성하지 않아도 호출가능 (static)
		System.out.println(sA);
		syntax_static sv = new syntax_static();
		int a = sv.A;							// 객체 생성 시 메모리할당
		System.out.println(a);
		
		
		// static 메소드, 일반 메소드 비교
		syntax_static.sSum(10);					// 객체 생성하지 않아도 호출가능 (static)
		syntax_static sm = new syntax_static();
		sm.Sum(20);
	}
}
