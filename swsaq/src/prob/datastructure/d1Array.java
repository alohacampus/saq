package prob.datastructure;


/*
 [�迭]
 - �迭�̶� ��ȣ(index)�� �� ��ȣ�� �����ϴ� �����͵�� �̷���� �ڷᱸ���� ���Ѵ�.
 */
public class d1Array {
	// static �迭����
	static int arr[];
	public static void main(String[] args) {
		// �迭 �ʱ�ȭ
		arr = new int[7];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		arr[5] = 6;
		arr[6] = 7;
		System.out.println("arr[7] : �迭�� ũ�� = " + arr.length);
		System.out.print(arr[0] + " ");
		System.out.print(arr[1] + " ");
		System.out.print(arr[2] + " ");
		System.out.print(arr[3] + " ");
		System.out.print(arr[4] + " ");
		System.out.print(arr[5] + " ");
		System.out.print(arr[6] + " ");
		System.out.printf("\n\n");
		
		// �迭����
		int arr2[] = new int[10];
		System.out.println("arr2[10] : �迭�� ũ�� = " + arr2.length);
		
		// �迭�ʱ�ȭ - �ݺ����̿�
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = 0;
			System.out.print(arr2[i] + " ");
		}
		System.out.printf("\n\n");
		
		
		// �迭 ����
		int arr3[] = arr2.clone();
		System.out.println("arr2[] -> arr3[] ���� clone");
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
			
		}
		
	}
}
