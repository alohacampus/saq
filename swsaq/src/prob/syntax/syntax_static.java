package prob.syntax;

public class syntax_static {
	// [static ����]
	// �޸𸮿� ���������� �Ҵ�Ǿ�, ���α׷��� ����� �� �����Ǵ� ����
	private static int sA = 10;
	private int A = 20;
	
	// [static �޼ҵ�]
	// static �޼ҵ�� ��ü�� �������� ȣ���� �����ϸ�, ��ü������ ȣ���� �Ұ����ϴ�.
	public static void sSum(int B) {
		System.out.println("sA + B = " + (sA + B) );
	}
	
	public static void sPrint() {
		// A�� ��ü�� ������ �� �޸𸮿� �Ҵ�Ǵµ�, 
		// sPrint()�� static �޼ҵ�� ��ü �������� �����ϴ� �޼ҵ��̹Ƿ�
		// �Ҵ���� ���� ���� A�� ������ �� �����Ƿ� 
		// static �޼ҵ忡�� static ������ �ƴ� ������ ������ �� ����.
		//	 System.out.println(A);		// �Ұ����� ȣ��
		System.out.println(sA);			// static ������ �̹� �޸𸮿� �Ҵ�Ǿ� �־ ȣ�� ����
	}
	
	public void Sum(int B) {
		System.out.println("A + B = " + (A + B));
	}
	
	public void Print() {
		System.out.println(A);
	}
	
	public static void main(String[] args) {
		// static ����, �Ϲ� ���� ��
		int sA = syntax_static.sA;				// ��ü �������� �ʾƵ� ȣ�Ⱑ�� (static)
		System.out.println(sA);
		syntax_static sv = new syntax_static();
		int a = sv.A;							// ��ü ���� �� �޸��Ҵ�
		System.out.println(a);
		
		
		// static �޼ҵ�, �Ϲ� �޼ҵ� ��
		syntax_static.sSum(10);					// ��ü �������� �ʾƵ� ȣ�Ⱑ�� (static)
		syntax_static sm = new syntax_static();
		sm.Sum(20);
	}
}
